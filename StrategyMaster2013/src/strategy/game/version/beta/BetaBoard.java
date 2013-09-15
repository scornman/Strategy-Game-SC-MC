package strategy.game.version.beta;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import strategy.common.*;
import strategy.game.*;
import strategy.game.common.*;

public class BetaBoard {

	final private int BOARD_SIZE_X = 6;
	final private int BOARD_SIZE_Y = 6;

	private Map<Location, Piece> pieceMap;

	/**
	 * TODO helper function for setting up the gameBoard sets a board to all
	 * pieces at all locations null then implements the pieces in the
	 * redConfiguration and blueConfiguration to fill the board Loops through
	 * based on BOARD_SIZE_X and BOARD_SIZE_Y
	 * 
	 * @param redConfiguration
	 * @param blueConfiguration
	 * @return
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

	public Piece getPieceAt(Location location) {
		// if location is not on the board, throw exception
		if (!(isValidLocation(location))) {
			throw new StrategyRuntimeException(
					"That location does not exist on the board.");
		}
		return pieceMap.get(location);
	}

	public void putPiece(Location location, Piece piece) {
		pieceMap.put(location, piece);
	}

	public String checkValidMove(PieceType piece, Location from, Location to) {
		String errorMessage = checkValidMoveFrom(piece, from);
		if (errorMessage == null) {
			errorMessage = checkValidMoveTo(piece, from, to);
		}
		return errorMessage;
	}

	private String checkValidMoveFrom(PieceType piece, Location from) {
		// Get the piece from the from location that is attempting to move.
		Piece movingPiece = pieceMap.get(from);
		String errorMessage;

		// If there is no piece at the from location, throw exception.
		if (pieceMap.get(from) == null) {
			errorMessage = "No piece to move at this location";
			return errorMessage;
		}

		// If there is no piece at the from location
		if (pieceMap.get(from) == null) {
			errorMessage = "No piece to move at this location.";
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

}
