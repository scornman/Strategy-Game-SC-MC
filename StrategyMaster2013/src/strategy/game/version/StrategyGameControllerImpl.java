/**
 * 
 */
package strategy.game.version;

import java.util.Collection;
import java.util.Map;

import strategy.common.PlayerColor;
import strategy.common.StrategyException;
import strategy.game.StrategyGameController;
import strategy.game.common.Location;
import strategy.game.common.MoveResult;
import strategy.game.common.MoveResultStatus;
import strategy.game.common.Piece;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.common.PieceType;

/**
 * @author Madalyn
 * 
 */
public class StrategyGameControllerImpl implements StrategyGameController {
	private final Collection<ValidateConfigurationBehavior> configValidators;
	private final Collection<ValidateMoveBehavior> moveValidators;
	private final TurnUpdateBehavior turnUpdateBehavior;
	private final BattleBehavior battleBehavior;
	private final GameResultBehavior gameResultBehavior;
	private final Board gameBoard;
	private boolean gameStarted;
	private PlayerColor currentColor;

	/**
	 * @throws StrategyException
	 * 
	 */
	public StrategyGameControllerImpl(
			Collection<ValidateConfigurationBehavior> configValidators,
			Collection<ValidateMoveBehavior> moveValidators,
			TurnUpdateBehavior turnUpdateBehavior,
			BattleBehavior battleBehavior,
			GameResultBehavior gameResultBehavior, Board gameBoard)
			throws StrategyException {
		// TODO Auto-generated constructor stub
		this.configValidators = configValidators;
		this.moveValidators = moveValidators;
		this.turnUpdateBehavior = turnUpdateBehavior;
		this.battleBehavior = battleBehavior;
		this.gameResultBehavior = gameResultBehavior;
		this.gameBoard = gameBoard;
		gameStarted = false;
		currentColor = PlayerColor.RED; // TODO:every game starts with red. if
										// this changes change this

		// Ensure that the starting piece configurations are valid before
		// proceeding
		for (ValidateConfigurationBehavior configValidator : configValidators) {
			if (!(configValidator.isConfigurationValid())) {
				throw new StrategyException("Invalid Starting Configuration");
			}
		}
	}

	@Override
	public void startGame() throws StrategyException {
		if (!gameStarted) {
			gameStarted = true;
		} else {
			throw new StrategyException("The game has already been started.");
		}

	}

	@Override
	public MoveResult move(PieceType piece, Location from, Location to)
			throws StrategyException {

		if (piece == null || from == null || to == null) {
			throw new StrategyException(
					"You must enter valid parameters to move.");
		}

		if (!gameStarted) {
			throw new StrategyException(
					"Cannot move before the game is started.");
		}
		
		for(ValidateMoveBehavior moveValidator : moveValidators){
			if(!(moveValidator.isMoveValid(piece, from, to, currentColor))){
				throw new StrategyException("That move is not valid.");
			}
		}

		PieceLocationDescriptor battleWinner;

		// get the winner
		if (battleBehavior.isBattle(from, to)) {
			battleWinner = battleBehavior.getBattleWinner(from, to);
			// update the board
			gameBoard.updateBattlePositions(from, to, battleWinner);
		} else {
			battleWinner = null;
			// update the board
			gameBoard.updatePositions(from, to);
		}

		// check the game status
		MoveResultStatus gameStatus = gameResultBehavior.getGameStatus();
		MoveResult result = new MoveResult(gameStatus, battleWinner);
		// update whose turn it is
		currentColor = turnUpdateBehavior.updateTurn(currentColor);

		return result;
	}

	@Override
	public Piece getPieceAt(Location location) {
		final Piece piece = gameBoard.getPieceAt(location);
		return piece;
	}

}
