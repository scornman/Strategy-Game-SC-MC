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

import java.util.ArrayList;
import java.util.Collection;

import strategy.common.PlayerColor;
import strategy.common.StrategyException;
import strategy.game.StrategyGameController;
import strategy.game.common.Coordinate;
import strategy.game.common.Location;
import strategy.game.common.MoveResult;
import strategy.game.common.MoveResultStatus;
import strategy.game.common.Piece;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.common.PieceType;

/**
 * Implements the game core for the Beta Strategy version.
 * 
 * @author scornman
 * @author Madalyn
 * @version Sep 11, 2013
 * 
 */
public class BetaStrategyGameController implements StrategyGameController {

	private boolean gameStarted;
	private PlayerColor currentTurnColor;
	final private BetaBoard gameBoard;
	final private int NUMBER_OF_COMPLETE_MOVES = 6;
	final private int NUMBER_OF_PLAYERS = 2;
	final private int NUMBER_OF_TURNS = NUMBER_OF_COMPLETE_MOVES
			* NUMBER_OF_PLAYERS;
	private int turnsCounter;

	/**
	 * Creates a new BetaStrategyGameController with the board configuration
	 * given by the supplied PieceLocationDescriptor collections.
	 * 
	 * @param redConfiguration
	 *            the pieces and corresponding locations for the red player at
	 *            the start of the game.
	 * @param blueConfiguration
	 *            the pieces and corresponding locations for the blue player at
	 *            the start of the game.
	 * @throws StrategyException
	 *             if either of the supplied configurations is invalid.
	 */
	public BetaStrategyGameController(
			Collection<PieceLocationDescriptor> redConfiguration,
			Collection<PieceLocationDescriptor> blueConfiguration)
			throws StrategyException {
		// Check that the given starting configurations are valid.
		if (!configurationsValid(redConfiguration, blueConfiguration)) {
			throw new StrategyException("Invalid Starting Configuration");
		}

		// The game has not yet been started
		gameStarted = false;

		// set up the board with the given configurations
		gameBoard = new BetaBoard(redConfiguration, blueConfiguration);

		// Start as red's turn
		currentTurnColor = PlayerColor.RED;

		turnsCounter = 0;
	}

	@Override
	public void startGame() throws StrategyException {
		if (gameStarted) {
			throw new StrategyException(
					"Cannot start game when a game is already in progress.");
		} else {
			gameStarted = true;
		}
	}

	@Override
	public MoveResult move(PieceType piece, Location from, Location to)
			throws StrategyException {

		// Check whether the move is a legal move.
		String errorMessage = checkLegalMove(piece, from, to);
		if (errorMessage != null) {
			throw new StrategyException(errorMessage);
		}

		// Get the piece from the from location that is attempting to move.
		Piece movingPiece = gameBoard.getPieceAt(from);
		// Get the piece, if any, from the to location.
		Piece targetPiece = gameBoard.getPieceAt(to);
		
		// Advance the turn counter to the next turn
		endTurn();

		// if it is the (12th) move, game status set to draw
		if (turnsCounter == NUMBER_OF_TURNS) {
			return new MoveResult(MoveResultStatus.DRAW, null);
			
		} else {
			
			if (targetPiece == null){
				// For a move into an empty space, change the location of the piece
				// to the destination.
				gameBoard.putPiece(to, movingPiece);
				gameBoard.putPiece(from, null);
				return new MoveResult(MoveResultStatus.OK, null);
				
			} else if (targetPiece.getOwner() == PlayerColor.BLUE) {
				//TODO: Remove Fake
				return new MoveResult(MoveResultStatus.RED_WINS, new PieceLocationDescriptor(movingPiece, to));
				
			} else if (targetPiece.getOwner() == PlayerColor.RED){
				//TODO: Remove Fake
				return new MoveResult(MoveResultStatus.BLUE_WINS, new PieceLocationDescriptor(movingPiece, to));
				
			} else {
				throw new StrategyException("Not a valid piece move");
			}
		}
	}

	/**
	 * Checks that it is legal to move a piece of the specified type from the
	 * given from location to the given to location.
	 * 
	 * @param piece
	 *            the type of the piece to move.
	 * @param from
	 *            the location at which the piece begins the move.
	 * @param to
	 *            the location at which the piece ends the move.
	 * @return an error message string if the move is not legal. If the move is
	 *         legal, return null.
	 */
	private String checkLegalMove(PieceType piece, Location from, Location to) {
		// Create a string to store the error message in case the move is
		// invalid.
		String errorMessage = null;

		// Check that none of the arguments are null.
		if (piece == null || from == null || to == null) {
			errorMessage = "Arguments to the move method must not be null.";
			return errorMessage;
		}

		// Make sure that the game has been started first
		if (!gameStarted) {
			errorMessage = "Cannot make a move before the game has started.";
			return errorMessage;
		}

		// Get the piece from the from location that is attempting to move.
		Piece movingPiece = gameBoard.getPieceAt(from);

		// Check whether the move is a valid move on the board.
		errorMessage = gameBoard.checkValidMove(piece, from, to);
		if (errorMessage != null) {
			return errorMessage;
		}

		// A piece that is not the color whose turn it is cannot move.
		if (movingPiece.getOwner() != currentTurnColor) {
			errorMessage = "You cannot move when it is not you turn.";
			return errorMessage;
		}

		return null;
	}

	/**
	 * Ends one player's turn and increments the turn counter.
	 */
	private void endTurn() {
		// Upon completion of move, change the color of the current turn.
		if (currentTurnColor == PlayerColor.RED) {
			currentTurnColor = PlayerColor.BLUE;
		} else {
			currentTurnColor = PlayerColor.RED;
		}

		turnsCounter++;
	}

	@Override
	public Piece getPieceAt(Location location) {
		Piece piece = gameBoard.getPieceAt(location);
		return piece;
	}

	// Private Helper methods for the constructor

	/**
	 * Determines whether the supplied initial piece configurations are valid.
	 * 
	 * @param redConfiguration
	 *            the pieces and corresponding locations for the red player at
	 *            the start of the game.
	 * @param blueConfigurationthe
	 *            pieces and corresponding locations for the blue player at the
	 *            start of the game.
	 * @return true if the configurations of the red and blue pieces are valid,
	 *         false otherwise.
	 */
	private boolean configurationsValid(
			Collection<PieceLocationDescriptor> redConfiguration,
			Collection<PieceLocationDescriptor> blueConfiguration) {

		// Check that the two configurations contain the correct numbers of each
		// piece type.
		if (!configurationsContainCorrectPieces(redConfiguration,
				blueConfiguration)) {
			return false;
		}

		// List of all locations already occupied. Used to ensure that two
		// pieces never start in the same location.
		ArrayList<Location> alreadyOccupiedLocations = new ArrayList<Location>();

		// Check that the starting configuration is valid for red pieces.
		for (PieceLocationDescriptor iRedPLC : redConfiguration) {
			Location iRedLocation = iRedPLC.getLocation();
			// Each piece must be in a valid starting location for red.
			if (!isValidStartingLocation(iRedLocation, PlayerColor.RED)) {
				return false;
			}
			// Ensure that no two pieces are in the same location.
			if (alreadyOccupiedLocations.contains(iRedLocation)) {
				return false;
			}
			// Add this new location to the occupied locations list.
			alreadyOccupiedLocations.add(iRedLocation);
		}

		// Check that the starting configuration is valid for blue pieces.
		for (PieceLocationDescriptor iBluePLC : blueConfiguration) {
			Location iBlueLocation = iBluePLC.getLocation();
			// Each piece must be in a valid starting location for blue.
			if (!isValidStartingLocation(iBlueLocation, PlayerColor.BLUE)) {
				return false;
			}
			// Ensure that no two pieces are in the same location.
			if (alreadyOccupiedLocations.contains(iBlueLocation)) {
				return false;
			}
			// Add this new location to the occupied locations list.
			alreadyOccupiedLocations.add(iBlueLocation);
		}

		// If none of the pieces are in invalid locations, return true.
		return true;
	}

	/**
	 * Check whether or not the given initial piece configurations contain the
	 * correct pieces for each side.
	 * 
	 * @param redConfiguration
	 *            the initial configuration of red pieces.
	 * @param blueConfiguration
	 *            the initial configuration of blue pieces.
	 * @return true if both configurations contain the correct piece types,
	 *         false otherwise.
	 */
	private boolean configurationsContainCorrectPieces(
			Collection<PieceLocationDescriptor> redConfiguration,
			Collection<PieceLocationDescriptor> blueConfiguration) {
		// First, extract the Piece objects from the PieceLocationDescriptor
		// objects.
		Collection<Piece> redPieces = new ArrayList<Piece>();
		for (PieceLocationDescriptor iPieceLocationDescriptor : redConfiguration) {
			redPieces.add(iPieceLocationDescriptor.getPiece());
		}
		Collection<Piece> bluePieces = new ArrayList<Piece>();
		for (PieceLocationDescriptor iPieceLocationDescriptor : blueConfiguration) {
			bluePieces.add(iPieceLocationDescriptor.getPiece());
		}

		// Get the expected pieces.
		Collection<Piece> correctRedPieces = getCorrectRedPieces();
		Collection<Piece> correctBluePieces = getCorrectBluePieces();

		// Ensure that the configurations have the correct number of each type
		// of piece.
		if (!containSamePieces(redPieces, correctRedPieces)) {
			return false;
		}
		if (!containSamePieces(bluePieces, correctBluePieces)) {
			return false;
		}

		return true;

	}

	/**
	 * Private helper method that constructs the expected list of pieces in the
	 * red configuration, in no particular order. Used to verify that a given
	 * initial board configuration is valid.
	 * 
	 * @return a collection containing all of the pieces that the red player
	 *         should begin the game with.
	 */
	private Collection<Piece> getCorrectRedPieces() {
		Collection<Piece> pieces = new ArrayList<Piece>();
		pieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		pieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		pieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		pieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		pieces.add(new Piece(PieceType.MARSHAL, PlayerColor.RED));
		pieces.add(new Piece(PieceType.FLAG, PlayerColor.RED));
		return pieces;
	}

	/**
	 * Private helper method that constructs the expected list of pieces in the
	 * blue configuration, in no particular order. Used to verify that a given
	 * initial board configuration is valid.
	 * 
	 * @return a collection containing all of the pieces that the blue player
	 *         should begin the game with.
	 */
	private Collection<Piece> getCorrectBluePieces() {
		Collection<Piece> pieces = new ArrayList<Piece>();
		pieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.MARSHAL, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.FLAG, PlayerColor.BLUE));
		return pieces;
	}

	/**
	 * Helper method that checks whether two collections of pieces contain the
	 * same number of each piece.
	 * 
	 * @param pieces1
	 *            the first list of pieces to compare.
	 * @param pieces2
	 *            the second list of pieces to compare.
	 * @return true if the
	 */
	private boolean containSamePieces(Collection<Piece> pieces1,
			Collection<Piece> pieces2) {
		// Ensure that the two collections have the correct number of pieces.
		if (pieces1.size() != pieces2.size()) {
			return false;
		}

		// Copy the pieces to new lists so that the old piece collections are
		// not modified.
		ArrayList<Piece> p1 = new ArrayList<Piece>();
		ArrayList<Piece> p2 = new ArrayList<Piece>();
		for (Piece iPiece : pieces1) {
			p1.add(iPiece);
		}
		for (Piece iPiece : pieces2) {
			p2.add(iPiece);
		}

		// For each piece in the first list, remove an identical piece from the
		// second list.
		for (Piece iPiece : p1) {
			if (p2.contains(iPiece)) {
				p2.remove(iPiece);
			} else {
				return false;
			}
		}

		// At the end, if all items in the first list have found matches in the
		// second list, and the two lists are the same size, the lists must
		// contain the same pieces.
		return true;
	}

	/**
	 * Determines whether a given location is a valid starting location for a
	 * piece of the specified color.
	 * 
	 * @param startLocation
	 *            the location whose validity should be determined.
	 * @param color
	 *            the color of the piece attempting to start in this location.
	 * @return true if the given location is a valid starting location for a
	 *         piece of the specified color, false otherwise.
	 */
	private boolean isValidStartingLocation(Location startLocation,
			PlayerColor color) {
		int xCoord = startLocation.getCoordinate(Coordinate.X_COORDINATE);
		int yCoord = startLocation.getCoordinate(Coordinate.Y_COORDINATE);
		switch (color) {
		case RED:
			if (xCoord >= 0 && xCoord <= 5 && yCoord >= 0 && yCoord <= 1) {
				return true;
			} else {
				return false;
			}
		case BLUE:
			if (xCoord >= 0 && xCoord <= 5 && yCoord >= 4 && yCoord <= 5) {
				return true;
			} else {
				return false;
			}
		default:
			return false;
		}

	}

}
