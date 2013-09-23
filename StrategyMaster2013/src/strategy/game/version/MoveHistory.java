/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package strategy.game.version;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import strategy.common.PlayerColor;
import strategy.game.common.Location;
import strategy.game.common.PieceType;

/**
 * Stores the history of all past valid moves in a game of Strategy.
 * 
 * @author scornman
 * @version 9/22/13
 * 
 */
public class MoveHistory {

	Map<PlayerColor, List<MoveHistoryEntry>> historyMap;

	/**
	 * Creates a new move history
	 */
	public MoveHistory() {
		historyMap = new HashMap<PlayerColor, List<MoveHistoryEntry>>();
	}

	/**
	 * Adds an entry to the history to record a move.
	 * 
	 * @param piece
	 *            the type of piece that was moved.
	 * @param from
	 *            the location to move from.
	 * @param to
	 *            the location to move to.
	 * @param currentColor
	 *            the color of the player whose turn it is.
	 */
	public void addEntry(PieceType piece, Location from, Location to,
			PlayerColor currentColor) {
		final MoveHistoryEntry newEntry = new MoveHistoryEntry(piece, from, to);

		List<MoveHistoryEntry> currentColorHistory = historyMap
				.get(currentColor);
		if(currentColorHistory != null) {
			currentColorHistory.add(newEntry);
		} else {
			currentColorHistory = new ArrayList<MoveHistoryEntry>();
			currentColorHistory.add(newEntry);
			historyMap.put(currentColor, currentColorHistory);
		}
		
	}

	/**
	 * Access the most recent move made by the given player.
	 * 
	 * @param currentColor
	 *            the color of the player to find the last move for.
	 * @return a history entry for the most recent move made by the player.
	 */
	public MoveHistoryEntry getLastMove(PlayerColor currentColor) {
		final List<MoveHistoryEntry> currentColorHistory = historyMap
				.get(currentColor);
		if (currentColorHistory == null || currentColorHistory.size() < 1) {
			return null;
		} else {
			return currentColorHistory.get(currentColorHistory.size() - 1);
		}
	}

	/**
	 * Access the second most recent move made by the given player.
	 * 
	 * @param currentColor
	 *            the color of the player to find the second to last move for.
	 * @return a history entry for the second most recent move made by the
	 *         player.
	 */
	public MoveHistoryEntry getSecondToLastMove(PlayerColor currentColor) {
		final List<MoveHistoryEntry> currentColorHistory = historyMap
				.get(currentColor);
		if (currentColorHistory == null || currentColorHistory.size() < 2) {
			return null;
		} else {
			return currentColorHistory.get(currentColorHistory.size() - 2);
		}
	}
}
