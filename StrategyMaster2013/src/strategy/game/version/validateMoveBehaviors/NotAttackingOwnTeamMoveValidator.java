package strategy.game.version.validateMoveBehaviors;

import strategy.common.PlayerColor;
import strategy.game.common.Location;
import strategy.game.common.Piece;
import strategy.game.common.PieceType;
import strategy.game.version.Board;
import strategy.game.version.ValidateMoveBehavior;

public class NotAttackingOwnTeamMoveValidator implements ValidateMoveBehavior {
	private final Board gameBoard;

	public NotAttackingOwnTeamMoveValidator(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	/**
	 * makes sure that the piece the player is attacking is not its own team
	 */
	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) {
		final Piece attackingPiece = gameBoard.getPieceAt(from);
		final Piece defendingPiece = gameBoard.getPieceAt(to);

		if (attackingPiece != null) {
			if (defendingPiece == null) {
				return true;
			}
			final PlayerColor attackColor = attackingPiece.getOwner();
			final PlayerColor defendColor = defendingPiece.getOwner();
			return (attackColor != defendColor);
		} else {
			return false;
		}
	}
}
