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

import java.util.HashMap;
import java.util.Map;

import strategy.common.PlayerColor;
import strategy.game.common.Location;
import strategy.game.common.PieceType;
import strategy.game.version.ValidateMoveBehavior;

/**
 * Move validator that implements the move repetition rule.
 * 
 * @author scornman
 * 
 */
public class MoveRepetitionRuleValidator implements ValidateMoveBehavior {

	// Stores the last move made for each player
	private Map<PlayerColor, MoveHistoryEntry> lastMoveMap;
	// Stores the second-to-last move made for each player.
	private Map<PlayerColor, MoveHistoryEntry> secondToLastMoveMap;

	public MoveRepetitionRuleValidator() {
		lastMoveMap = new HashMap<PlayerColor, MoveHistoryEntry>();
		secondToLastMoveMap = new HashMap<PlayerColor, MoveHistoryEntry>();
	}

	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) {
		boolean isValid;
		// Create the new move history entry to add
		MoveHistoryEntry currentMove = new MoveHistoryEntry(piece, from, to);
		// If the current player has already made at least 2 moves.
		if (secondToLastMoveMap.containsKey(currentColor)) {
			MoveHistoryEntry lastMove = lastMoveMap.get(currentColor);
			MoveHistoryEntry secondToLastMove = secondToLastMoveMap
					.get(currentColor);
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

		updateMoveHistories(currentMove, currentColor);

		return isValid;
	}

	/**
	 * Updates the move history maps to store records of the current move and
	 * the last move.
	 * 
	 * @param currentMove
	 *            the current move.
	 * @param currentColor
	 *            the color of the player whose turn it is.
	 */
	private void updateMoveHistories(MoveHistoryEntry currentMove,
			PlayerColor currentColor) {
		// If this is not the first move.
		if (lastMoveMap.containsKey(currentColor)) {
			secondToLastMoveMap
					.put(currentColor, lastMoveMap.get(currentColor));
			lastMoveMap.put(currentColor, currentMove);
		} else {
			lastMoveMap.put(currentColor, currentMove);
		}
	}
}
