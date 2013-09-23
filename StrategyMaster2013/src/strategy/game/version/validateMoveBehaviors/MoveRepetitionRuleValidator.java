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
import strategy.game.common.PieceType;
import strategy.game.version.MoveHistory;
import strategy.game.version.MoveHistoryEntry;
import strategy.game.version.ValidateMoveBehavior;

/**
 * Move validator that implements the move repetition rule.
 * 
 * @author scornman
 * @version 9/22/13
 * 
 */
public class MoveRepetitionRuleValidator implements ValidateMoveBehavior {

	final MoveHistory moveHistory;

	/**
	 * Creates a new MoveRepetitionRuleValidator object.
	 * 
	 * @param moveHistory
	 *            the history of all past moves in the current game.
	 */
	public MoveRepetitionRuleValidator(MoveHistory moveHistory) {
		this.moveHistory = moveHistory;
	}

	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) {
		boolean isValid;
		// Create the new move history entry to add
		final MoveHistoryEntry currentMove = new MoveHistoryEntry(piece, from,
				to);
		final MoveHistoryEntry secondToLastMove = moveHistory
				.getSecondToLastMove(currentColor);
		final MoveHistoryEntry lastMove = moveHistory.getLastMove(currentColor);
		// If the current player has already made at least 2 moves.
		if (moveHistory.getSecondToLastMove(currentColor) != null) {
			// If this move is the reverse of the last move and the same as the
			// second to last move
			if (currentMove.isOppositeMove(lastMove)
					&& currentMove.isSameMove(secondToLastMove)) {
				isValid = false;
			} else {
				isValid = true;
			}
		} else {
			// If the current player has not yet made 2 complete moves, then the
			// move repetition rule cannot apply.
			isValid = true;
		}

		return isValid;
	}

}
