/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package strategy.game.version.gameResultBehaviors;

import strategy.common.PlayerColor;
import strategy.game.common.MoveResultStatus;
import strategy.game.common.Piece;
import strategy.game.common.PieceType;
import strategy.game.version.Board;
import strategy.game.version.GameResultBehavior;

/**
 * Implementation of the game result behavior that includes end game conditions
 * for the flags being captured or nobody having legal moves.
 * 
 * @author Madalyn
 * @author scornman
 * @version 9/22/13
 * 
 */
public class StatusGameResultBehavior implements GameResultBehavior {
	private final Board gameBoard;

	/**
	 * Creates a new StatusGameResultBehavior object.
	 * 
	 * @param gameBoard
	 *            the board for the game
	 */
	public StatusGameResultBehavior(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	/**
	 * Determine the result of the battle. only wins if the flag is captured
	 * 
	 * @return the battle result.
	 */
	@Override
	public MoveResultStatus getGameStatus() {
		MoveResultStatus status = null;

		// if the blue flag is gone, red wins
		if (!gameBoard
				.containsPiece(new Piece(PieceType.FLAG, PlayerColor.BLUE))) {
			status = MoveResultStatus.RED_WINS;

			// if the red flag is gone, blue wins
		} else if (!gameBoard.containsPiece(new Piece(PieceType.FLAG,
				PlayerColor.RED))) {
			status = MoveResultStatus.BLUE_WINS;

			// no winner
		} else {
			for (PieceType type : PieceType.values()) {
				// if there is a piece type besides flag on the board,
				// the game isn't over yet
				if (type != PieceType.FLAG) {
					if (gameBoard
							.containsPiece(new Piece(type, PlayerColor.RED))
							|| gameBoard.containsPiece(new Piece(type,
									PlayerColor.BLUE))) {
						return MoveResultStatus.OK;
					}
				}
			}
			// if there are only flags on the board, it's a draw
			status = MoveResultStatus.DRAW;
		}

		return status;
	}
}
