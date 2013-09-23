package strategy.game.version.validateMoveBehaviors;

import strategy.common.PlayerColor;
import strategy.game.common.Location;
import strategy.game.common.Piece;
import strategy.game.common.PieceType;
import strategy.game.version.Board;
import strategy.game.version.ValidateMoveBehavior;

/**
 * Move validator that checks that the pieceType to move matches the piece at
 * the from location on the board.
 * 
 * @author scornman
 * 
 */
public class CorrectPieceTypeMoveValidator implements ValidateMoveBehavior {

	Board gameBoard;
	
	/**
	 * Creates a new CorrectPieceTypeMoveValidator object.
	 * 
	 * @param gameBoard
	 *            the board.
	 */
	public CorrectPieceTypeMoveValidator(Board board) {
		gameBoard = board;
	}

	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) {
		final Piece movingPiece = gameBoard.getPieceAt(from);
		return(piece == movingPiece.getType());
	}

}
