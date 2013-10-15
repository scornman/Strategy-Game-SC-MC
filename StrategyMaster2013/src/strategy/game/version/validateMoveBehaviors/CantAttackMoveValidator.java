package strategy.game.version.validateMoveBehaviors;

import strategy.common.PlayerColor;
import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.PieceType;
import strategy.game.version.Board;
import strategy.game.version.ValidateMoveBehavior;

public class CantAttackMoveValidator implements ValidateMoveBehavior {
	
	private final Board gameBoard;

	public CantAttackMoveValidator(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) throws StrategyException {
		try {
			return gameBoard.getPieceAt(to) == null;
		} catch(StrategyException e) {
			return false;
		}
	}

}
