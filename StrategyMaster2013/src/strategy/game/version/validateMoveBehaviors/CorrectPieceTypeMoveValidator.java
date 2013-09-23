/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

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
 * @version 9/22/13
 * 
 */
public class CorrectPieceTypeMoveValidator implements ValidateMoveBehavior {

	Board gameBoard;

	/**
	 * Creates a new CorrectPieceTypeMoveValidator object.
	 * 
	 * @param board
	 *            the board.
	 */
	public CorrectPieceTypeMoveValidator(Board board) {
		gameBoard = board;
	}

	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) {
		Piece movingPiece = gameBoard.getPieceAt(from);
		return (piece == movingPiece.getType());
	}

}
