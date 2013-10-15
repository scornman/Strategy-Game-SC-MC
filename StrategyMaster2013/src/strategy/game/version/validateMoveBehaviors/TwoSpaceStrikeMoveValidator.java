package strategy.game.version.validateMoveBehaviors;

import strategy.common.PlayerColor;
import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.PieceType;
import strategy.game.version.Board;
import strategy.game.version.ValidateMoveBehavior;

public class TwoSpaceStrikeMoveValidator implements ValidateMoveBehavior {
	
	private final Board gameBoard;

	public TwoSpaceStrikeMoveValidator(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) throws StrategyException {
		try {
			if (gameBoard.getPieceAt(to) == null) {
				return false;
			}
			if (from.distanceTo(to) > 2) {
				return false;
			}
		} catch(StrategyException e) {
			return false;
		}
		return true;
	}

}
