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

import java.util.Map;

import strategy.common.StrategyRuntimeException;
import strategy.game.common.Location;
import strategy.game.common.Piece;
import strategy.game.common.PieceLocationDescriptor;

/**
 * The game board that keeps track of all of the pieces and their locations.
 * 
 * @author scornman
 * @author Madalyn
 * @version 9/22/13
 * 
 */
public class Board {
	private final Map<Location, Piece> pieceMap;

	/**
	 * Constructor for Board
	 * 
	 * @param pieceMap
	 *            locations of all pieces
	 */
	public Board(Map<Location, Piece> pieceMap) {
		this.pieceMap = pieceMap;
	}

	/**
	 * Returns the piece at the specified location on the board.
	 * 
	 * @param location
	 *            the location to check
	 * @return the piece at the specified location.
	 */
	public Piece getPieceAt(Location location) {
		// if location is not on the board, throw exception
		if (!(isValidLocation(location))) {
			throw new StrategyRuntimeException(
					"That location does not exist on the board.");
		}
		return pieceMap.get(location);
	}

	/**
	 * Put a piece onto the board at a specific location.
	 * 
	 * @param location
	 *            the location to add the piece.
	 * @param piece
	 *            the piece to add.
	 */
	public void putPiece(Location location, Piece piece) {
		pieceMap.put(location, piece);
	}

	/**
	 * Determine whether the given location is a valid location that exists on
	 * the board.
	 * 
	 * @param location
	 *            the location to check for validity.
	 * @return true if the location is a valid location on the board, to which
	 *         pieces may move; false otherwise.
	 */
	public boolean isValidLocation(Location location) {
		return pieceMap.containsKey(location);
	}

	/**
	 * Updates the positions of pieces on the board after a battle.
	 * 
	 * @param attackLocation
	 *            the location of the attacking piece before the battle.
	 * @param defendLocation
	 *            the location of the defending piece before the battle.
	 * @param battleWinner
	 *            the winner of the battle and its new location.
	 */
	public void updateBattlePositions(Location attackLocation,
			Location defendLocation, PieceLocationDescriptor battleWinner) {

		putPiece(attackLocation, null);
		putPiece(defendLocation, null);

		// If there is a winner that survived the battle
		if (battleWinner != null) {
			final Location moveLocation = battleWinner.getLocation();
			putPiece(moveLocation, battleWinner.getPiece());
		}
	}

	/**
	 * Updates the positions of pieces on the board on move
	 * 
	 * @param from
	 *            the location of the piece before the move.
	 * @param to
	 *            the location the piece wants to move to.
	 */
	public void updatePositions(Location from, Location to) {
		final Piece piece = getPieceAt(from);

		putPiece(from, null);
		putPiece(to, piece);
	}

	/**
	 * does the board contain a piece
	 * 
	 * @param piece
	 *            to see if in board
	 * @return boolean true if piece in board, else false
	 */
	public boolean containsPiece(Piece piece) {
		return pieceMap.containsValue(piece);
	}
}
