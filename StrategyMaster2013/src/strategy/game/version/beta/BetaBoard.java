/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package strategy.game.version.beta;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import strategy.common.*;
import strategy.game.common.*;

/**
 * Class that manages the configuration of pieces for the Beta Strategy game.
 * 
 * @author scornman
 * @version Sep 14, 2013
 * 
 */
public class BetaBoard {

	final private int BOARD_SIZE_X = 6;
	final private int BOARD_SIZE_Y = 6;

	private Map<Location, Piece> pieceMap;

	/**
	 * Creates a new board with pieces according to the supplied piece
	 * configurations. It sets up a board with null pieces at all locations
	 * within the board size, then adds the pieces specified in redConfiguration
	 * and blueConfiguration to the board.
	 * 
	 * @param redConfiguration
	 *            the collection of red pieces and their starting locations on
	 *            the board.
	 * @param blueConfiguration
	 *            the collection of blue pieces and their starting locations on
	 *            the board.
	 */
	public BetaBoard(Collection<PieceLocationDescriptor> redConfiguration,
			Collection<PieceLocationDescriptor> blueConfiguration) {
		pieceMap = new HashMap<Location, Piece>();

		for (int i = 0; i < BOARD_SIZE_X; i++) {
			for (int j = 0; j < BOARD_SIZE_Y; j++) {
				pieceMap.put(new Location2D(i, j), null);
			}
		}

		for (PieceLocationDescriptor red : redConfiguration) {
			Location redLocation = red.getLocation();
			Piece redPiece = red.getPiece();

			pieceMap.put(redLocation, redPiece);
		}

		for (PieceLocationDescriptor blue : blueConfiguration) {
			Location blueLocation = blue.getLocation();
			Piece bluePiece = blue.getPiece();

			pieceMap.put(blueLocation, bluePiece);
		}
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
	 * Checks that it is a valid move to move a piece of the specified type from
	 * the given from location on the board to the given to location on the
	 * board.
	 * 
	 * @param piece
	 *            the type of the piece to move.
	 * @param from
	 *            the location at which the piece begins the move.
	 * @param to
	 *            the location at which the piece ends the move.
	 * @return an error message string if the move is invalid. If the move is
	 *         valid, return null.
	 */
	public String checkValidMove(PieceType piece, Location from, Location to) {
		String errorMessage = checkValidMoveFrom(piece, from);
		if (errorMessage == null) {
			errorMessage = checkValidMoveTo(piece, from, to);
		}
		return errorMessage;
	}

	/**
	 * Checks that it is a valid move to move a piece of the specified type from
	 * the given from location on the board.
	 * 
	 * @param piece
	 *            the type of the piece to move.
	 * @param from
	 *            the location at which the piece begins the move.
	 * @return an error message string if the move is invalid. If the move is
	 *         valid, return null.
	 */
	private String checkValidMoveFrom(PieceType piece, Location from) {
		// Get the piece from the from location that is attempting to move.
		Piece movingPiece = pieceMap.get(from);
		String errorMessage;

		// If there is no piece at the from location, throw exception.
		if (pieceMap.get(from) == null) {
			errorMessage = "No piece to move at this location";
			return errorMessage;
		}

		// If the piece at the from location does not match the supplied piece
		// type, throw exception.
		if (movingPiece.getType() != piece) {
			errorMessage = "Piece type to move does not match piece at location to move from.";
			return errorMessage;
		}

		// The flag should not be able to move.
		if (movingPiece.getType() == PieceType.FLAG) {
			errorMessage = "You cannot move the flag.";
			return errorMessage;
		}

		return null;
	}

	/**
	 * Checks that it is a valid move to move a piece of the specified type to
	 * the given to location on the board.
	 * 
	 * @param piece
	 *            the type of the piece to move.
	 * @param from
	 *            the location at which the piece begins the move.
	 * @param to
	 *            the location at which the piece ends the move.
	 * @return an error message string if the move is invalid. If the move is
	 *         valid, return null.
	 */
	private String checkValidMoveTo(PieceType piece, Location from, Location to) {
		// Get the piece from the to location that is attempting to move.
		Piece pieceAtToLocation = pieceMap.get(to);
		Piece movingPiece = pieceMap.get(from);
		String errorMessage;

		// If there is a piece at the destination location
		if (pieceAtToLocation != null) {
			// A piece may not move onto a location containing another piece of
			// the same color/owner.
			if (movingPiece.getOwner() == pieceAtToLocation.getOwner()) {
				errorMessage = "You cannot move to a location containing a piece of the same color.";
				return errorMessage;
			}
		}

		try {
			if (from.distanceTo(to) != 1) {
				errorMessage = "Cannot move to a non-adjacent space.";
				return errorMessage;
			}
		} catch (StrategyRuntimeException e) {
			errorMessage = "Cannot move to a non-adjacent space.";
			return errorMessage;
		}

		return null;

	}

	/**
	 * Determine whether the given location is a valid location on the board.
	 * 
	 * @param location
	 *            the location to check for validity.
	 * @return true if the location is a valid location on the board, to which
	 *         pieces may move; false otherwise.
	 */
	public boolean isValidLocation(Location location) {
		int x_coordinate = location.getCoordinate(Coordinate.X_COORDINATE);
		int y_coordinate = location.getCoordinate(Coordinate.Y_COORDINATE);

		if (x_coordinate < BOARD_SIZE_X && y_coordinate < BOARD_SIZE_Y
				&& x_coordinate >= 0 && y_coordinate >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public void updateBattlePositions(Location attackLocation, Location defendLocation,
			PieceLocationDescriptor battleWinner) {
		
	}

}
