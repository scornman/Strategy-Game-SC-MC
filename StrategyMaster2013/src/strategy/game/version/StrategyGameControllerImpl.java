/**
 * 
 */
package strategy.game.version;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import strategy.common.StrategyException;
import strategy.game.StrategyGameController;
import strategy.game.common.Location;
import strategy.game.common.MoveResult;
import strategy.game.common.Piece;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.common.PieceType;

/**
 * @author Madalyn
 *
 */
public class StrategyGameControllerImpl implements StrategyGameController{
	private final Collection<ValidateConfigurationBehavior> configValidators;
	private final Collection<ValidateMoveBehavior> moveValidators;
	private final TurnUpdateBehavior turnUpdateBehavior;
	private final BattleBehavior battleBehavior;
	private final GameResultBehavior gameResultBehavior;
	private final Board gameBoard;
	private boolean gameStarted;
	
	/**
	 *  
	 */
	public StrategyGameControllerImpl(	Collection<ValidateConfigurationBehavior> configValidators,
										Collection<ValidateMoveBehavior> moveValidators,
										TurnUpdateBehavior turnUpdateBehavior,
										BattleBehavior battleBehavior,
										GameResultBehavior gameResultBehavior,
										Board gameBoard,
										Map<Location, Piece> pieceMap	) {
		// TODO Auto-generated constructor stub
		this.configValidators = configValidators;
		this.moveValidators = moveValidators;
		this.turnUpdateBehavior = turnUpdateBehavior;
		this.battleBehavior = battleBehavior;
		this.gameResultBehavior = gameResultBehavior;
		this.gameBoard = gameBoard;
		gameStarted = false;
		
	}

	@Override
	public void startGame() throws StrategyException {
		if(!gameStarted){
			gameStarted = true;
		}else{
			throw new StrategyException("The game has already been started.");
		}
		
	}

	@Override
	public MoveResult move(PieceType piece, Location from, Location to)
			throws StrategyException {

		for(ValidateMoveBehavior moveValidator : moveValidators){
			if(!moveValidator.isMoveValid(piece, from, to)){
				throw new StrategyException("That move is not valid.");
			}
		}
		
		return null;
	}

	@Override
	public Piece getPieceAt(Location location) {
		final Piece piece = gameBoard.getPieceAt(location);
		return piece;
	}

}
