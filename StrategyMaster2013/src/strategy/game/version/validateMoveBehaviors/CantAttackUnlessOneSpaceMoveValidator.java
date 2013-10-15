package strategy.game.version.validateMoveBehaviors;

import strategy.common.PlayerColor;
import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.PieceType;
import strategy.game.version.Board;
import strategy.game.version.ValidateMoveBehavior;

public class CantAttackUnlessOneSpaceMoveValidator implements ValidateMoveBehavior {

	private final Board gameBoard;

	public CantAttackUnlessOneSpaceMoveValidator(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) throws StrategyException {
		try {
			// Move is valid if the moving piece is either moving one space, or
			// is not attacking. The piece may not both move more than one space
			// and attack.
			return (gameBoard.getPieceAt(to) == null)
					|| (from.distanceTo(to) == 1);
		} catch (StrategyException e) {
			return false;
		}
	}

}
