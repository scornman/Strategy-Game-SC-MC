/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package strategy.game.version.gamma;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import strategy.game.*;
import strategy.common.*;
import strategy.game.common.*;

/**
 * Test cases for testing the BetaStrategyGameController class and the overall
 * functionality of the Beta Strategy Game.
 * 
 * @author scornman
 * @author Madalyn
 * @version Sep 15, 2013
 * 
 */
public class GammaStrategyGameControllerTest {

	/**
	 * The factory that the test cases will use to produce
	 * StrategyGameController objects.
	 */
	private StrategyGameFactory factory;

	/**
	 * The initial piece configurations that the factory method uses to create
	 * the controller. These will be set up with a default configuration before
	 * each test. Each test can then modify them, if desired, before creating
	 * the controller.
	 */
	private Collection<PieceLocationDescriptor> startingRedConfig;
	private Collection<PieceLocationDescriptor> startingBlueConfig;

	/**
	 * Setup method that runs before each test. It sets up sample valid starting
	 * piece configurations for both players, which can be modified and/or used
	 * to create a BetaStrategyGameController.
	 */
	@Before
	public void setUp() {
		factory = StrategyGameFactory.getInstance();
		startingRedConfig = setupValidRedConfiguration();
		startingBlueConfig = setupValidBlueConfiguration();
	}

	/**
	 * Helper method that sets up a valid starting configuration for red pieces
	 * that test cases can use.
	 * 
	 * @return the collection of red pieces and their corresponding starting
	 *         locations.
	 */
	private Collection<PieceLocationDescriptor> setupValidRedConfiguration() {
		// Set up the starting configuration for the red pieces
		Collection<PieceLocationDescriptor> redConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> redPieces = new ArrayList<Piece>();
		ArrayList<Location> redLocations = new ArrayList<Location>();
		// Red flag
		redPieces.add(new Piece(PieceType.FLAG, PlayerColor.RED));
		redLocations.add(new Location2D(0, 0));
		// Red marshal
		redPieces.add(new Piece(PieceType.MARSHAL, PlayerColor.RED));
		redLocations.add(new Location2D(1, 0));
		// Red colonels
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(2, 0));
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(3, 0));
		// Red captains
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(4, 0));
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(5, 0));
		// Red lieutenants
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(0, 1));
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 1));
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(2, 1));
		// Red sergeants
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(3, 1));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(4, 1));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(5, 1));
		// Combine the pieces with their locations
		for (int i = 0; i < redPieces.size(); i++) {
			Piece iPiece = redPieces.get(i);
			Location iLocation = redLocations.get(i);
			redConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		return redConfiguration;
	}

	/**
	 * Helper method that sets up a valid starting configuration for blue pieces
	 * that test cases can use.
	 * 
	 * @return the collection of red pieces and their corresponding starting
	 *         locations.
	 */
	private Collection<PieceLocationDescriptor> setupValidBlueConfiguration() {
		// Set up the starting configuration for the blue pieces
		Collection<PieceLocationDescriptor> blueConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> bluePieces = new ArrayList<Piece>();
		ArrayList<Location> blueLocations = new ArrayList<Location>();
		// Blue flag
		bluePieces.add(new Piece(PieceType.FLAG, PlayerColor.BLUE));
		blueLocations.add(new Location2D(0, 5));
		// Blue marshal
		bluePieces.add(new Piece(PieceType.MARSHAL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(1, 5));
		// Blue colonels
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(2, 5));
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(3, 5));
		// Blue captains
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 5));
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 5));
		// Blue lieutenants
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(0, 4));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(1, 4));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(2, 4));
		// Blue sergeants
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(3, 4));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 4));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 4));
		// Combine the pieces with their locations
		for (int i = 0; i < bluePieces.size(); i++) {
			Piece iPiece = bluePieces.get(i);
			Location iLocation = blueLocations.get(i);
			blueConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		return blueConfiguration;
	}

	/**
	 * Helper method for modifying a starting configuration so that one of the
	 * pieces is moved to a different location.
	 * 
	 * @param configuration
	 *            the collection of pieces and their corresponding locations to
	 *            modify.
	 * @param piece
	 *            the piece to move from one location to another.
	 * @param oldLocation
	 *            the original location of the piece.
	 * @param newLocation
	 *            the new location for the piece to be moved to.
	 */
	private void movePieceToNewStartLocation(
			Collection<PieceLocationDescriptor> configuration, Piece piece,
			Location oldLocation, Location newLocation) {
		PieceLocationDescriptor oldPLD = new PieceLocationDescriptor(piece,
				oldLocation);
		PieceLocationDescriptor newPLD = new PieceLocationDescriptor(piece,
				newLocation);
		configuration.remove(oldPLD);
		configuration.add(newPLD);
	}

	/**
	 * Helper method for modifying a starting configuration so that one of the
	 * pieces is replaced with another piece in the same location.
	 * 
	 * @param configuration
	 *            the collection of pieces and their corresponding locations to
	 *            modify.
	 * @param oldPiece
	 *            the piece to replace with a new piece.
	 * @param newPiece
	 *            the new piece to replace to old piece.
	 * @param location
	 *            the location of the piece.
	 */
	private void replacePieceInStartConfiguration(
			Collection<PieceLocationDescriptor> configuration, Piece oldPiece,
			Piece newPiece, Location location) {
		PieceLocationDescriptor oldPLD = new PieceLocationDescriptor(oldPiece,
				location);
		PieceLocationDescriptor newPLD = new PieceLocationDescriptor(newPiece,
				location);
		configuration.remove(oldPLD);
		configuration.add(newPLD);
	}

	/**
	 * Helper method for modifying a starting configuration so that two of the
	 * pieces belonging to one color switch places.
	 * 
	 * @param color
	 *            the color of the pieces to swap.
	 * @param location1
	 *            the original location of one of the pieces.
	 * @param location2
	 *            the original location of one of the pieces.
	 */
	private void swapTwoPiecesInStartConfiguration(PlayerColor color,
			Location location1, Location location2) {
		Piece piece1 = getPieceAtStartingLocation(location1);
		Piece piece2 = getPieceAtStartingLocation(location2);
		Collection<PieceLocationDescriptor> configuration;
		if (color == PlayerColor.RED) {
			configuration = startingRedConfig;
		} else {
			configuration = startingBlueConfig;
		}
		replacePieceInStartConfiguration(configuration, piece1, piece2,
				location1);
		replacePieceInStartConfiguration(configuration, piece2, piece1,
				location2);
	}

	/**
	 * Retrieves the piece at a given position in a starting configuration.
	 * 
	 * @param startLocation
	 *            the location for which to find a piece.
	 * @return the piece at the given position in the starting configuration.
	 */
	private Piece getPieceAtStartingLocation(Location startLocation) {
		Piece pieceAtLoc = null;
		for (PieceLocationDescriptor pld : startingRedConfig) {
			if (startLocation.equals(pld.getLocation())) {
				pieceAtLoc = pld.getPiece();
			}
		}
		for (PieceLocationDescriptor pld : startingBlueConfig) {
			if (startLocation.equals(pld.getLocation())) {
				pieceAtLoc = pld.getPiece();
			}
		}
		return pieceAtLoc;
	}

	/**
	 * Tests that the factory method makeBetaStrategyGame from the
	 * StrategyGameFactory class successfully creates a new
	 * BetaStrategyGameController when given valid piece configurations. This
	 * will therefore also exercise and test the constructor for
	 * BetaStrategyGameController.
	 * 
	 * @throws StrategyException
	 *             if the factory method is given an invalid configuration for
	 *             either side.
	 */
	@Test
	public void testFactoryMethodCreatesGameWhenGivenValidConfigurations()
			throws StrategyException {
		factory.makeGammaStrategyGame(startingRedConfig, startingBlueConfig);
		assertTrue(true);
	}

	/**
	 * Tests that the factory method makeBetaStrategyGame fails with a
	 * StrategyException if two pieces in the starting configuration have the
	 * same location.
	 * 
	 * @throws StrategyException
	 *             if the factory method is given an invalid configuration for
	 *             either side. This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testControllerCreationFailsWhenConfigurationContainsRedFlagAndMarshalAtSameLocation()
			throws StrategyException {
		Piece redMarshall = new Piece(PieceType.MARSHAL, PlayerColor.RED);
		Location oldMarshallLocation = new Location2D(1, 0);
		Location newMarshallLocation = new Location2D(0, 0);
		movePieceToNewStartLocation(startingRedConfig, redMarshall,
				oldMarshallLocation, newMarshallLocation);

		// Create the controller
		factory.makeBetaStrategyGame(startingRedConfig, startingBlueConfig);
	}

	/**
	 * Tests that the factory method makeBetaStrategyGame fails with a
	 * StrategyException if two pieces in the starting configuration have the
	 * same location.
	 * 
	 * @throws StrategyException
	 *             if the factory method is given an invalid configuration for
	 *             either side. This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testControllerCreationFailsWhenConfigurationContainsBlueCaptainAndColonelAtSameLocation()
			throws StrategyException {
		Piece blueColonel = new Piece(PieceType.COLONEL, PlayerColor.BLUE);
		Location oldColonelLocation = new Location2D(2, 5);
		Location newColonelLocation = new Location2D(4, 5);
		movePieceToNewStartLocation(startingBlueConfig, blueColonel,
				oldColonelLocation, newColonelLocation);

		// Create the controller
		factory.makeBetaStrategyGame(startingRedConfig, startingBlueConfig);
	}

	/**
	 * Tests that the factory method makeBetaStrategyGame fails with a
	 * StrategyException if a red piece is not in a valid location in the
	 * starting configuration.
	 * 
	 * @throws StrategyException
	 *             if the factory method is given an invalid configuration for
	 *             either side. This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testControllerCreationFailsWhenRedPieceAtInvalidLocation()
			throws StrategyException {
		Piece pieceToChange = new Piece(PieceType.LIEUTENANT, PlayerColor.RED);
		Location oldLocation = new Location2D(1, 1);
		Location newLocation = new Location2D(5, 3);
		movePieceToNewStartLocation(startingRedConfig, pieceToChange,
				oldLocation, newLocation);

		// Create the controller
		factory.makeBetaStrategyGame(startingRedConfig, startingBlueConfig);
	}

	/**
	 * Tests that the factory method makeBetaStrategyGame fails with a
	 * StrategyException if a blue piece is not in a valid location in the
	 * starting configuration.
	 * 
	 * @throws StrategyException
	 *             if the factory method is given an invalid configuration for
	 *             either side. This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testControllerCreationFailsWhenBluePieceAtInvalidLocation()
			throws StrategyException {
		Piece pieceToChange = new Piece(PieceType.SERGEANT, PlayerColor.BLUE);
		Location oldLocation = new Location2D(5, 4);
		Location newLocation = new Location2D(2, 1);
		movePieceToNewStartLocation(startingBlueConfig, pieceToChange,
				oldLocation, newLocation);

		// Create the controller
		factory.makeBetaStrategyGame(startingRedConfig, startingBlueConfig);
	}

	/**
	 * Tests that the factory method makeBetaStrategyGame fails with a
	 * StrategyException if the starting configuration does not contain the
	 * correct number of red pieces.
	 * 
	 * @throws StrategyException
	 *             if the factory method is given an invalid configuration for
	 *             either side. This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testControllerCreationFailsWhenWrongNumberOfRedPieces()
			throws StrategyException {
		Piece pieceToRemove = new Piece(PieceType.SERGEANT, PlayerColor.RED);
		Location location = new Location2D(4, 1);
		PieceLocationDescriptor pldToRemove = new PieceLocationDescriptor(
				pieceToRemove, location);
		assertTrue(startingRedConfig.remove(pldToRemove));

		// Create the controller
		factory.makeBetaStrategyGame(startingRedConfig, startingBlueConfig);
	}

	/**
	 * Tests that the factory method makeBetaStrategyGame fails with a
	 * StrategyException if the starting configuration does not contain the
	 * correct number of blue pieces.
	 * 
	 * @throws StrategyException
	 *             if the factory method is given an invalid configuration for
	 *             either side. This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testControllerCreationFailsWhenWrongNumberOfBluePieces()
			throws StrategyException {
		Piece pieceToRemove = new Piece(PieceType.MARSHAL, PlayerColor.BLUE);
		Location location = new Location2D(1, 5);
		PieceLocationDescriptor pldToRemove = new PieceLocationDescriptor(
				pieceToRemove, location);
		assertTrue(startingBlueConfig.remove(pldToRemove));

		// Create the controller
		factory.makeBetaStrategyGame(startingRedConfig, startingBlueConfig);
	}

	/**
	 * Tests that the factory method makeBetaStrategyGame fails with a
	 * StrategyException if the starting configuration does not contain the
	 * correct number of each type of red piece.
	 * 
	 * @throws StrategyException
	 *             if the factory method is given an invalid configuration for
	 *             either side. This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testControllerCreationFailsWhenWrongRedPieceTypes()
			throws StrategyException {
		Piece pieceToReplace = new Piece(PieceType.LIEUTENANT, PlayerColor.RED);
		Piece replacementPiece = new Piece(PieceType.COLONEL, PlayerColor.RED);
		Location pieceLocation = new Location2D(2, 1);
		replacePieceInStartConfiguration(startingRedConfig, pieceToReplace,
				replacementPiece, pieceLocation);

		// Create the controller
		factory.makeBetaStrategyGame(startingRedConfig, startingBlueConfig);
	}

	/**
	 * Tests that the factory method makeBetaStrategyGame fails with a
	 * StrategyException if the starting configuration does not contain the
	 * correct number of each type of blue piece.
	 * 
	 * @throws StrategyException
	 *             if the factory method is given an invalid configuration for
	 *             either side. This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testControllerCreationFailsWhenWrongBluePieceTypes()
			throws StrategyException {
		Piece pieceToReplace = new Piece(PieceType.CAPTAIN, PlayerColor.BLUE);
		Piece replacementPiece = new Piece(PieceType.MAJOR, PlayerColor.BLUE);
		Location pieceLocation = new Location2D(3, 5);
		replacePieceInStartConfiguration(startingBlueConfig, pieceToReplace,
				replacementPiece, pieceLocation);

		// Create the controller
		factory.makeBetaStrategyGame(startingRedConfig, startingBlueConfig);
	}

	/**
	 * Tests Piece getPieceAt(Location location); bluePieces.add(new
	 * Piece(PieceType.FLAG, PlayerColor.BLUE)); blueLocations.add(new
	 * Location2D(0, 5));
	 * 
	 * getPieceAt(new Location(0,5)) should return Piece(PieceType.FLAG,
	 * PlayerColor.BLUE);
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void getPieceAtLocationShouldReturnBlueFlag()
			throws StrategyException {
		StrategyGameController ctrlr = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		Piece piece = new Piece(PieceType.FLAG, PlayerColor.BLUE);

		assertEquals(piece, ctrlr.getPieceAt(new Location2D(0, 5)));
	}

	/**
	 * Tests Piece getPieceAt(Location location);
	 * 
	 * getPieceAt(new Location(1,0)) should return Piece(PieceType.MARSHAL,
	 * PlayerColor.RED);
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void getPieceAtLocationShouldReturnRedMarshal()
			throws StrategyException {
		StrategyGameController ctrlr = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		Piece piece = new Piece(PieceType.MARSHAL, PlayerColor.RED);

		assertEquals(piece, ctrlr.getPieceAt(new Location2D(1, 0)));
	}

	/**
	 * getPieceAt returns null if there is no piece at the specified location.
	 * 
	 * getPiece at (3,3) should be null (there is no piece currently on (3,3))
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void getPieceAtLocationShouldReturnNullIfNoPiecePresent()
			throws StrategyException {
		StrategyGameController ctrlr = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		assertEquals(null, ctrlr.getPieceAt(new Location2D(3, 3)));
	}

	/**
	 * getPieceAt should throw an error if the location does not exist on the
	 * board
	 * 
	 * get Piece at (6,7) should throw an exception
	 * 
	 * @throws StrategyException
	 */
	@Test(expected = StrategyRuntimeException.class)
	public void getPieceAtLocationNotOnBoardShouldThrowException()
			throws StrategyException {
		StrategyGameController ctrlr = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		ctrlr.getPieceAt(new Location2D(6, 7));
	}

	/**
	 * getPieceAt y-coordinate location shouldn't be negative
	 * 
	 * @throws StrategyException
	 */
	@Test(expected = StrategyRuntimeException.class)
	public void getPieceAtCannotHaveANegativeYCoordinate()
			throws StrategyException {
		StrategyGameController ctrlr = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		ctrlr.getPieceAt(new Location2D(0, -1));
	}

	/**
	 * getPieceAt x-coordinate location shouldn't be negative
	 * 
	 * @throws StrategyException
	 */
	@Test(expected = StrategyRuntimeException.class)
	public void getPieceAtCannotHaveANegativeXCoordinate()
			throws StrategyException {
		StrategyGameController ctrlr = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		ctrlr.getPieceAt(new Location2D(-1, 0));
	}

	/**
	 * getPieceAt x-coordinate and y-coordinate location shouldn't be negative
	 * 
	 * @throws StrategyException
	 */
	@Test(expected = StrategyRuntimeException.class)
	public void getPieceAtCannotHaveNegativeCoordinates()
			throws StrategyException {
		StrategyGameController ctrlr = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		ctrlr.getPieceAt(new Location2D(-1, -1));
	}

	/**
	 * getPieceAt x-coordinate and y-coordinate location shouldn't be negative
	 * 
	 * @throws StrategyException
	 */
	@Test(expected = StrategyRuntimeException.class)
	public void getPieceAtCannotHaveANegativeXCoordinateAndATooLargeYCoordinate()
			throws StrategyException {
		StrategyGameController ctrlr = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		ctrlr.getPieceAt(new Location2D(-1, 10));
	}

	/**
	 * Tests that the startGame method throws an error if the game has already
	 * started.
	 * 
	 * @throws StrategyException
	 */
	@Test(expected = StrategyException.class)
	public void testStartGameThrowsExceptionIfGameAlreadyStarted()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		// Start the game.
		controller.startGame();
		// Attempt to start the game again after the game has already started.
		controller.startGame();
	}

	/**
	 * Tests that the move method throws an error if the game has not yet
	 * started.
	 * 
	 * @throws StrategyException
	 *             if the move method is called before the game is started. This
	 *             is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testMoveThrowsExceptionIfGameNotYetStarted()
			throws StrategyException {
		// Create the controller
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		// Create the piece to attempt to move.
		PieceType typeToMove = PieceType.CAPTAIN;
		Location fromLocation = new Location2D(1, 1);
		Location toLocation = new Location2D(1, 2);
		// Attempt to move before the game has been started.
		controller.move(typeToMove, fromLocation, toLocation);
	}

	/**
	 * Tests that the move method throws an error if the location to move from
	 * contains no piece.
	 * 
	 * @throws StrategyException
	 *             if one of the arguments passed to the move method is invalid.
	 *             This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testMoveThrowsExceptionIfNoPieceAtFromLocation()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();
		Location fromLocation = new Location2D(3, 3);
		Location toLocation = new Location2D(3, 4);
		controller.move(PieceType.COLONEL, fromLocation, toLocation);
	}

	/**
	 * Should throw an error if piece tries to move to a diagonal location Tests
	 * that the move method throws an error if the location to move from is
	 * null.
	 * 
	 * @throws StrategyException
	 *             if one of the arguments passed to the move method is invalid.
	 *             This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testMoveThrowsExceptionIfFromLocationIsNull()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();
		Location fromLocation = null;
		Location toLocation = new Location2D(1, 2);
		controller.move(PieceType.LIEUTENANT, fromLocation, toLocation);
	}

	/**
	 * Tests that the move method throws an error if the location to move to is
	 * null.
	 * 
	 * @throws StrategyException
	 *             if one of the arguments passed to the move method is invalid.
	 *             This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testMoveThrowsExceptionIfToLocationIsNull()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();
		Location fromLocation = new Location2D(1, 1);
		Location toLocation = null;
		controller.move(PieceType.LIEUTENANT, fromLocation, toLocation);
	}

	/**
	 * Tests that the move method throws an error if the piece type is null.
	 * 
	 * @throws StrategyException
	 *             if one of the arguments passed to the move method is invalid.
	 *             This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testMoveThrowsExceptionIfPieceTypeIsNull()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();
		Location fromLocation = new Location2D(1, 1);
		Location toLocation = new Location2D(1, 2);
		controller.move(null, fromLocation, toLocation);
	}

	/**
	 * Tests that the move method throws an error if the from location does not
	 * contain the specified piece type.
	 * 
	 * @throws StrategyException
	 *             if one of the arguments passed to the move method is invalid.
	 *             This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testMoveThrowsExceptionIfFromLocationHasWrongPieceType()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();
		Location fromLocation = new Location2D(1, 1);
		Location toLocation = new Location2D(1, 2);
		// Piece type in this location should be LIEUTENANT
		controller.move(PieceType.MARSHAL, fromLocation, toLocation);
	}

	/**
	 * Tests that the move method throws an error if the red player does not
	 * move first.
	 * 
	 * @throws StrategyException
	 *             if one of the arguments passed to the move method is invalid.
	 *             This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testMoveThrowsExceptionIfBlueMovesFirst()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();
		// Attempt to move a blue piece when red should have the first turn.
		Location fromLocation = new Location2D(0, 4);
		Location toLocation = new Location2D(0, 3);
		controller.move(PieceType.LIEUTENANT, fromLocation, toLocation);
	}

	/**
	 * Tests that the move method throws an error if the red player moves, and
	 * then moves again when it should be the blue player's turn.
	 * 
	 * @throws StrategyException
	 *             if one of the arguments passed to the move method is invalid.
	 *             This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testMoveThrowsExceptionIfRedMakesFirstTwoMoves()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();
		Location firstFromLocation = new Location2D(0, 1);
		Location firstToLocation = new Location2D(0, 2);
		Location secondFromLocation = new Location2D(5, 1);
		Location secondToLocation = new Location2D(5, 2);
		// Make a valid move for red.
		controller.move(PieceType.LIEUTENANT, firstFromLocation,
				firstToLocation);
		// Attempt to move a red piece again.
		controller.move(PieceType.SERGEANT, secondFromLocation,
				secondToLocation);
	}

	/**
	 * Tests that the move method throws an error if the red player moves, then
	 * the blue player moves, and then the blue player attempts to move a second
	 * time in a row.
	 * 
	 * @throws StrategyException
	 *             if one of the arguments passed to the move method is invalid.
	 *             This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testMoveThrowsExceptionIfBlueMovesTwiceInARow()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();
		Location firstFromLocation = new Location2D(0, 1);
		Location firstToLocation = new Location2D(0, 2);
		Location secondFromLocation = new Location2D(0, 4);
		Location secondToLocation = new Location2D(0, 3);
		Location thirdFromLocation = new Location2D(3, 4);
		Location thirdToLocation = new Location2D(3, 3);
		// Make a valid move for red.
		controller.move(PieceType.LIEUTENANT, firstFromLocation,
				firstToLocation);
		// Then blue moves
		controller.move(PieceType.LIEUTENANT, secondFromLocation,
				secondToLocation);
		// Now blue tries to move again
		controller.move(PieceType.SERGEANT, thirdFromLocation, thirdToLocation);
	}

	/**
	 * Tests that the move method throws an error if it attempts to move the
	 * flag, which should not be able to move.
	 * 
	 * @throws StrategyException
	 *             if one of the arguments passed to the move method is invalid.
	 *             This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testMoveThrowsExceptionIfMovingFlag() throws StrategyException {
		// Before setting up the board, switch the flag to the front row, so
		// that is has room to attempt to move.
		Piece flagPiece = new Piece(PieceType.FLAG, PlayerColor.RED);
		Location flagLocation = new Location2D(0, 0);
		Piece lieutenantPiece = new Piece(PieceType.LIEUTENANT, PlayerColor.RED);
		Location lieutenantLocation = new Location2D(0, 1);
		movePieceToNewStartLocation(startingRedConfig, flagPiece, flagLocation,
				lieutenantLocation);
		movePieceToNewStartLocation(startingRedConfig, lieutenantPiece,
				lieutenantLocation, flagLocation);
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();

		// Attempt to move the flag.
		controller.move(PieceType.FLAG, lieutenantLocation,
				new Location2D(0, 2));
	}

	/**
	 * Tests that the move method throws an error if a red piece tries to move
	 * to a location containing another red piece.
	 * 
	 * @throws StrategyException
	 *             if one of the arguments passed to the move method is invalid.
	 *             This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testMoveThrowsExceptionIfRedPieceMovesToOtherRedPiece()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();
		// Attempt to move red marshal to location containing red lieutenant.
		Location fromLocation = new Location2D(1, 0);
		Location toLocation = new Location2D(1, 1);
		controller.move(PieceType.MARSHAL, fromLocation, toLocation);
	}

	/**
	 * Tests that the move method throws an error if a blue piece tries to move
	 * to a location containing another blue piece.
	 * 
	 * @throws StrategyException
	 *             if one of the arguments passed to the move method is invalid.
	 *             This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testMoveThrowsExceptionIfBluePieceMovesToOtherBluePiece()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();
		// First, make a valid move for red.
		Location redFromLocation = new Location2D(5, 1);
		Location redToLocation = new Location2D(5, 2);
		controller.move(PieceType.SERGEANT, redFromLocation, redToLocation);
		// Attempt to move blue marshal to location containing blue lieutenant.
		Location blueFromLocation = new Location2D(1, 5);
		Location blueToLocation = new Location2D(1, 4);
		controller.move(PieceType.MARSHAL, blueFromLocation, blueToLocation);
	}

	/**
	 * Tests that the move method successfully changes the location of the piece
	 * that is moved.
	 * 
	 * @throws StrategyException
	 *             if one of the arguments passed to the move method is invalid.
	 */
	@Test
	public void testMoveSuccessfullyMovesPieceToDestinationOnValidMoveToBlankSpace()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();
		Location fromLocation = new Location2D(4, 1);
		Location toLocation = new Location2D(4, 2);
		// Get the piece at the from location
		Piece movingPiece = new Piece(PieceType.SERGEANT, PlayerColor.RED);
		// Make a valid move to an empty space
		controller.move(PieceType.SERGEANT, fromLocation, toLocation);
		// Check that the piece is now at the to location
		assertEquals(movingPiece, controller.getPieceAt(toLocation));
		// Check that the from location is now empty
		assertNull(controller.getPieceAt(fromLocation));
	}

	/**
	 * Should throw an error if piece tries to move to location not next to it
	 * 
	 * @throws StrategyException
	 */
	@Test(expected = StrategyException.class)
	public void throwExceptionIfPieceTriesToMoveToDiagonalLocation()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();
		Location fromLocation = new Location2D(1, 1);
		Location toLocation = new Location2D(3, 5);
		controller.move(PieceType.LIEUTENANT, fromLocation, toLocation);
	}

	/**
	 * Should throw an error if piece tries to move to far in the x location
	 * 
	 * @throws StrategyException
	 */
	@Test(expected = StrategyException.class)
	public void throwExceptionIfPieceTriesToMoveTooManySpacesX()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();
		Location fromLocation = new Location2D(1, 1);
		Location toLocation = new Location2D(3, 1);
		controller.move(PieceType.LIEUTENANT, fromLocation, toLocation);
	}

	/**
	 * Should throw an error if piece tries to move to far in the y location
	 * 
	 * @throws StrategyException
	 */
	@Test(expected = StrategyException.class)
	public void throwExceptionIfPieceTriesToMoveTooManySpacesY()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();
		Location fromLocation = new Location2D(1, 1);
		Location toLocation = new Location2D(1, 3);
		controller.move(PieceType.LIEUTENANT, fromLocation, toLocation);
	}

	/**
	 * Should be valid if piece tries to move one space X
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void pieceTriesToMoveOneSpacesX() throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();

		// First, move red piece up, so that it can move sideways on the next
		// turn.
		Location fromLocation1 = new Location2D(1, 1);
		Location toLocation1 = new Location2D(1, 2);
		controller.move(PieceType.LIEUTENANT, fromLocation1, toLocation1);
		// Next, move a blue piece to be valid.
		Location fromLocation2 = new Location2D(0, 4);
		Location toLocation2 = new Location2D(0, 3);
		controller.move(PieceType.LIEUTENANT, fromLocation2, toLocation2);
		// Finally, move the red piece to the side.
		Location fromLocation3 = new Location2D(1, 2);
		Location toLocation3 = new Location2D(2, 2);
		controller.move(PieceType.LIEUTENANT, fromLocation3, toLocation3);
		assertTrue(true);
	}

	/**
	 * Should be valid if piece tries to move one space Y
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void pieceTriesToMoveOneSpacesY() throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();
		Location fromLocation = new Location2D(1, 1);
		Location toLocation = new Location2D(1, 2);
		controller.move(PieceType.LIEUTENANT, fromLocation, toLocation);
		assertTrue(true);
	}

	/**
	 * tests that game ends in draw after 6 complete moves if no winner/battles
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void gameEndsInDrawAfterSixMovesWithNoBattles()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();

		Location blueOneFromLocation = new Location2D(0, 4);
		Location blueOneToLocation = new Location2D(0, 3);
		Location blueTwoFromLocation = new Location2D(1, 4);
		Location blueTwoToLocation = new Location2D(1, 3);
		Location blueThreeFromLocation = new Location2D(2, 4);
		Location blueThreeToLocation = new Location2D(2, 3);
		Location blueFourFromLocation = new Location2D(3, 4);
		Location blueFourToLocation = new Location2D(3, 3);
		Location blueFiveFromLocation = new Location2D(4, 4);
		Location blueFiveToLocation = new Location2D(4, 3);
		Location blueSixFromLocation = new Location2D(5, 4);
		Location blueSixToLocation = new Location2D(5, 3);

		Location redOneFromLocation = new Location2D(0, 1);
		Location redOneToLocation = new Location2D(0, 2);
		Location redTwoFromLocation = new Location2D(1, 1);
		Location redTwoToLocation = new Location2D(1, 2);
		Location redThreeFromLocation = new Location2D(2, 1);
		Location redThreeToLocation = new Location2D(2, 2);
		Location redFourFromLocation = new Location2D(3, 1);
		Location redFourToLocation = new Location2D(3, 2);
		Location redFiveFromLocation = new Location2D(4, 1);
		Location redFiveToLocation = new Location2D(4, 2);
		Location redSixFromLocation = new Location2D(5, 1);
		Location redSixToLocation = new Location2D(5, 2);

		// Make a valid moves to an empty spaces
		controller.move(PieceType.LIEUTENANT, redOneFromLocation,
				redOneToLocation);
		controller.move(PieceType.LIEUTENANT, blueOneFromLocation,
				blueOneToLocation);
		controller.move(PieceType.LIEUTENANT, redTwoFromLocation,
				redTwoToLocation);
		controller.move(PieceType.LIEUTENANT, blueTwoFromLocation,
				blueTwoToLocation);
		controller.move(PieceType.LIEUTENANT, redThreeFromLocation,
				redThreeToLocation);
		controller.move(PieceType.LIEUTENANT, blueThreeFromLocation,
				blueThreeToLocation);
		controller.move(PieceType.SERGEANT, redFourFromLocation,
				redFourToLocation);
		controller.move(PieceType.SERGEANT, blueFourFromLocation,
				blueFourToLocation);
		controller.move(PieceType.SERGEANT, redFiveFromLocation,
				redFiveToLocation);
		controller.move(PieceType.SERGEANT, blueFiveFromLocation,
				blueFiveToLocation);
		controller.move(PieceType.SERGEANT, redSixFromLocation,
				redSixToLocation);
		MoveResult result = controller.move(PieceType.SERGEANT,
				blueSixFromLocation, blueSixToLocation);

		// check that the game status is DRAW/game ends
		assertEquals(MoveResultStatus.DRAW, result.getStatus());
	}

	/**
	 * tests that game ends in draw after 6 complete moves if no winner/battles
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void gameEndsInDrawAfterSixMovesWithABattleOnLastMove()
			throws StrategyException {
		// Swap red marshall into front row
		swapTwoPiecesInStartConfiguration(PlayerColor.RED,
				new Location2D(1, 0), new Location2D(3, 1));
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();

		Location blueOneFromLocation = new Location2D(0, 4);
		Location blueOneToLocation = new Location2D(0, 3);
		Location blueTwoFromLocation = new Location2D(1, 4);
		Location blueTwoToLocation = new Location2D(1, 3);
		Location blueThreeFromLocation = new Location2D(2, 4);
		Location blueThreeToLocation = new Location2D(2, 3);
		Location blueFourFromLocation = new Location2D(3, 4);
		Location blueFourToLocation = new Location2D(3, 3);
		Location blueFiveFromLocation = new Location2D(3, 3);
		Location blueFiveToLocation = new Location2D(3, 2);
		Location blueSixFromLocation = new Location2D(3, 2);
		Location blueSixToLocation = new Location2D(3, 1);

		Location redOneFromLocation = new Location2D(0, 1);
		Location redOneToLocation = new Location2D(0, 2);
		Location redTwoFromLocation = new Location2D(1, 1);
		Location redTwoToLocation = new Location2D(1, 2);
		Location redThreeFromLocation = new Location2D(2, 1);
		Location redThreeToLocation = new Location2D(2, 2);
		Location redFourFromLocation = new Location2D(2, 2);
		Location redFourToLocation = new Location2D(2, 1);
		Location redFiveFromLocation = new Location2D(4, 1);
		Location redFiveToLocation = new Location2D(4, 2);
		Location redSixFromLocation = new Location2D(5, 1);
		Location redSixToLocation = new Location2D(5, 2);

		// Make a valid moves to an empty spaces
		controller.move(PieceType.LIEUTENANT, redOneFromLocation,
				redOneToLocation);
		controller.move(PieceType.LIEUTENANT, blueOneFromLocation,
				blueOneToLocation);
		controller.move(PieceType.LIEUTENANT, redTwoFromLocation,
				redTwoToLocation);
		controller.move(PieceType.LIEUTENANT, blueTwoFromLocation,
				blueTwoToLocation);
		controller.move(PieceType.LIEUTENANT, redThreeFromLocation,
				redThreeToLocation);
		controller.move(PieceType.LIEUTENANT, blueThreeFromLocation,
				blueThreeToLocation);
		controller.move(PieceType.LIEUTENANT, redFourFromLocation,
				redFourToLocation);
		controller.move(PieceType.SERGEANT, blueFourFromLocation,
				blueFourToLocation);
		controller.move(PieceType.SERGEANT, redFiveFromLocation,
				redFiveToLocation);
		controller.move(PieceType.SERGEANT, blueFiveFromLocation,
				blueFiveToLocation);
		controller.move(PieceType.SERGEANT, redSixFromLocation,
				redSixToLocation);
		MoveResult result = controller.move(PieceType.SERGEANT,
				blueSixFromLocation, blueSixToLocation);

		// check that the game status is DRAW/game ends
		assertEquals(MoveResultStatus.DRAW, result.getStatus());
		assertEquals(new PieceLocationDescriptor(new Piece(PieceType.MARSHAL,
				PlayerColor.RED), new Location2D(3, 2)),
				result.getBattleWinner());
	}

	/**
	 * tests that game ends in RED_WINS after red captures the blue flag
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void gameEndsInRedWinsAfterRedCapturesBlueFlag()
			throws StrategyException {

		swapTwoPiecesInStartConfiguration(PlayerColor.BLUE,
				new Location2D(0, 5), new Location2D(0, 4));

		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();

		// move red lt
		// move random blue piece
		// move red lt
		// move random blue piece
		// capture flag
		controller.move(PieceType.LIEUTENANT, new Location2D(0, 1),
				new Location2D(0, 2));
		controller.move(PieceType.SERGEANT, new Location2D(3, 4),
				new Location2D(3, 3));
		controller.move(PieceType.LIEUTENANT, new Location2D(0, 2),
				new Location2D(0, 3));
		controller.move(PieceType.SERGEANT, new Location2D(3, 3),
				new Location2D(3, 2));
		MoveResult result = controller.move(PieceType.LIEUTENANT,
				new Location2D(0, 3), new Location2D(0, 4));
		// check that the game status is RED_WINS/game ends
		assertEquals(MoveResultStatus.RED_WINS, result.getStatus());
	}

	/**
	 * tests that game ends in BLUE_WINS after blue captures the red flag
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void gameEndsInBlueWinsAfterBlueCapturesRedFlag()
			throws StrategyException {

		swapTwoPiecesInStartConfiguration(PlayerColor.RED,
				new Location2D(0, 0), new Location2D(0, 1));

		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();

		// move random red piece
		// move blue lt
		// move random red piece
		// move blue lt
		// move random red piece
		// capture flag
		controller.move(PieceType.LIEUTENANT, new Location2D(1, 1),
				new Location2D(1, 2));
		controller.move(PieceType.LIEUTENANT, new Location2D(0, 4),
				new Location2D(0, 3));
		controller.move(PieceType.SERGEANT, new Location2D(3, 1),
				new Location2D(3, 2));
		controller.move(PieceType.LIEUTENANT, new Location2D(0, 3),
				new Location2D(0, 2));
		controller.move(PieceType.SERGEANT, new Location2D(3, 2),
				new Location2D(3, 3));
		MoveResult result = controller.move(PieceType.LIEUTENANT,
				new Location2D(0, 2), new Location2D(0, 1));
		// check that the game status is BLUE_WINS/game ends
		assertEquals(MoveResultStatus.BLUE_WINS, result.getStatus());
	}

	/**
	 * Tests that there is null battle winner when two pieces of the same type
	 * attack each other
	 * 
	 */
	@Test
	public void sargentAttaksSargentResultsInNullBattleWinner()
			throws StrategyException {
		// move red sargent
		// move blue sargent
		// red attacks blue sargent
		// null battle winner
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();

		controller.move(PieceType.SERGEANT, new Location2D(5, 1),
				new Location2D(5, 2));
		controller.move(PieceType.SERGEANT, new Location2D(5, 4),
				new Location2D(5, 3));
		MoveResult result = controller.move(PieceType.SERGEANT, new Location2D(
				5, 2), new Location2D(5, 3));
		// check that the game status is OK
		assertEquals(MoveResultStatus.OK, result.getStatus());
		assertNull(result.getBattleWinner());
		assertNull(controller.getPieceAt(new Location2D(5, 2)));
		assertNull(controller.getPieceAt(new Location2D(5, 3)));
	}

	/**
	 * Tests that the move method returns a move result containing a null
	 * battleWinner if a piece moves to an empty location.
	 */
	@Test
	public void testMoveToEmptySpaceProducesNullBattleWinner()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();
		Location fromLocation = new Location2D(4, 1);
		Location toLocation = new Location2D(4, 2);
		MoveResult result = controller.move(PieceType.SERGEANT, fromLocation,
				toLocation);
		PieceLocationDescriptor winner = result.getBattleWinner();
		assertNull(winner);
		// Check that the board has properly updated to reflect the move.
		Piece movedPiece = new Piece(PieceType.SERGEANT, PlayerColor.RED);
		assertEquals(movedPiece, controller.getPieceAt(toLocation));
		assertEquals(null, controller.getPieceAt(fromLocation));
	}

	/**
	 * Tests that the move method returns a move result containing an OK status
	 * if a piece moves to an empty location.
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void testMoveToEmptySpaceProducesOkStatus() throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();
		Location fromLocation = new Location2D(4, 1);
		Location toLocation = new Location2D(4, 2);
		MoveResult result = controller.move(PieceType.SERGEANT, fromLocation,
				toLocation);
		MoveResultStatus status = result.getStatus();
		assertEquals(MoveResultStatus.OK, status);
		// Check that the board has properly updated to reflect the move.
		Piece movedPiece = new Piece(PieceType.SERGEANT, PlayerColor.RED);
		assertEquals(movedPiece, controller.getPieceAt(toLocation));
		assertEquals(null, controller.getPieceAt(fromLocation));
	}

	/**
	 * Tests that the a red lieutenant should win when it attacks a blue
	 * sergeant.
	 */
	@Test
	public void testAttackingRedLieutenantShouldDefeatBlueSergeant()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();

		Location attackerLocation = new Location2D(3, 2);
		Location defenderLocation = new Location2D(3, 3);
		Piece attackPiece = new Piece(PieceType.LIEUTENANT, PlayerColor.RED);

		// Perform the sequence of moves that will lead to the battle.
		controller.move(PieceType.LIEUTENANT, new Location2D(2, 1),
				new Location2D(2, 2));
		controller.move(PieceType.SERGEANT, new Location2D(3, 4),
				defenderLocation);
		controller.move(PieceType.LIEUTENANT, new Location2D(2, 2),
				attackerLocation);
		controller.move(PieceType.LIEUTENANT, new Location2D(0, 4),
				new Location2D(0, 3));
		// Make the attack

		MoveResult result = controller.move(PieceType.LIEUTENANT,
				attackerLocation, defenderLocation);
		// Check that the game does not end.
		MoveResultStatus status = result.getStatus();
		assertEquals(MoveResultStatus.OK, status);
		// Check that the red lieutenant wins and takes the place of the blue
		// sergeant.
		PieceLocationDescriptor winner = result.getBattleWinner();
		assertEquals(
				new PieceLocationDescriptor(attackPiece, defenderLocation),
				winner);
		// Check that the board has properly updated to reflect the post-battle
		// state.
		assertEquals(attackPiece, controller.getPieceAt(defenderLocation));
		assertEquals(null, controller.getPieceAt(attackerLocation));
	}

	/**
	 * Tests that the a blue sergeant should lose when it attacks a red
	 * lieutenant.
	 */
	@Test
	public void testAttackingBlueSergeantShouldLoseToRedLieutenant()
			throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();

		Location attackerLocation = new Location2D(3, 3);
		Location defenderLocation = new Location2D(3, 2);
		Piece defendPiece = new Piece(PieceType.LIEUTENANT, PlayerColor.RED);

		// Perform the sequence of moves that will lead to the battle.
		controller.move(PieceType.LIEUTENANT, new Location2D(2, 1),
				new Location2D(2, 2));
		controller.move(PieceType.SERGEANT, new Location2D(3, 4),
				new Location2D(3, 3));
		controller.move(PieceType.LIEUTENANT, new Location2D(2, 2),
				new Location2D(3, 2));
		// Make the attack
		MoveResult result = controller.move(PieceType.SERGEANT,
				attackerLocation, defenderLocation);
		// Check that the game does not end.
		MoveResultStatus status = result.getStatus();
		assertEquals(MoveResultStatus.OK, status);
		// Check that the red lieutenant wins and takes the place of the blue
		// sergeant.
		PieceLocationDescriptor winner = result.getBattleWinner();
		assertEquals(
				new PieceLocationDescriptor(defendPiece, attackerLocation),
				winner);
		// Check that the board has properly updated to reflect the post-battle
		// state.
		assertEquals(defendPiece, controller.getPieceAt(attackerLocation));
		assertEquals(null, controller.getPieceAt(defenderLocation));
	}

	/**
	 * tests that game can be restarted after a draw.
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void gameCanBeRestartedAfterDraw() throws StrategyException {
		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();

		Location blueOneFromLocation = new Location2D(0, 4);
		Location blueOneToLocation = new Location2D(0, 3);
		Location blueTwoFromLocation = new Location2D(1, 4);
		Location blueTwoToLocation = new Location2D(1, 3);
		Location blueThreeFromLocation = new Location2D(2, 4);
		Location blueThreeToLocation = new Location2D(2, 3);
		Location blueFourFromLocation = new Location2D(3, 4);
		Location blueFourToLocation = new Location2D(3, 3);
		Location blueFiveFromLocation = new Location2D(4, 4);
		Location blueFiveToLocation = new Location2D(4, 3);
		Location blueSixFromLocation = new Location2D(5, 4);
		Location blueSixToLocation = new Location2D(5, 3);

		Location redOneFromLocation = new Location2D(0, 1);
		Location redOneToLocation = new Location2D(0, 2);
		Location redTwoFromLocation = new Location2D(1, 1);
		Location redTwoToLocation = new Location2D(1, 2);
		Location redThreeFromLocation = new Location2D(2, 1);
		Location redThreeToLocation = new Location2D(2, 2);
		Location redFourFromLocation = new Location2D(3, 1);
		Location redFourToLocation = new Location2D(3, 2);
		Location redFiveFromLocation = new Location2D(4, 1);
		Location redFiveToLocation = new Location2D(4, 2);
		Location redSixFromLocation = new Location2D(5, 1);
		Location redSixToLocation = new Location2D(5, 2);

		// Make a valid moves to an empty spaces
		controller.move(PieceType.LIEUTENANT, redOneFromLocation,
				redOneToLocation);
		controller.move(PieceType.LIEUTENANT, blueOneFromLocation,
				blueOneToLocation);
		controller.move(PieceType.LIEUTENANT, redTwoFromLocation,
				redTwoToLocation);
		controller.move(PieceType.LIEUTENANT, blueTwoFromLocation,
				blueTwoToLocation);
		controller.move(PieceType.LIEUTENANT, redThreeFromLocation,
				redThreeToLocation);
		controller.move(PieceType.LIEUTENANT, blueThreeFromLocation,
				blueThreeToLocation);
		controller.move(PieceType.SERGEANT, redFourFromLocation,
				redFourToLocation);
		controller.move(PieceType.SERGEANT, blueFourFromLocation,
				blueFourToLocation);
		controller.move(PieceType.SERGEANT, redFiveFromLocation,
				redFiveToLocation);
		controller.move(PieceType.SERGEANT, blueFiveFromLocation,
				blueFiveToLocation);
		controller.move(PieceType.SERGEANT, redSixFromLocation,
				redSixToLocation);
		controller.move(PieceType.SERGEANT, blueSixFromLocation,
				blueSixToLocation);

		// Game now ends in a draw. A new game can now be started.
		controller.startGame();
		assertTrue(true);
	}

	/**
	 * tests that game can be restarted after a draw.
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void gameCanBeRestartedAfterRedWins() throws StrategyException {

		swapTwoPiecesInStartConfiguration(PlayerColor.BLUE,
				new Location2D(0, 5), new Location2D(0, 4));

		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();

		// move red lt
		// move random blue piece
		// move red lt
		// move random blue piece
		// capture flag
		controller.move(PieceType.LIEUTENANT, new Location2D(0, 1),
				new Location2D(0, 2));
		controller.move(PieceType.SERGEANT, new Location2D(3, 4),
				new Location2D(3, 3));
		controller.move(PieceType.LIEUTENANT, new Location2D(0, 2),
				new Location2D(0, 3));
		controller.move(PieceType.SERGEANT, new Location2D(3, 3),
				new Location2D(3, 2));
		controller.move(PieceType.LIEUTENANT, new Location2D(0, 3),
				new Location2D(0, 4));

		// Game now ends in a red win. A new game can now be started.
		controller.startGame();
		// Make sure that the board configuration has been reset.
		assertEquals(new Piece(PieceType.LIEUTENANT, PlayerColor.RED),
				controller.getPieceAt(new Location2D(0, 1)));
	}

	/**
	 * tests that game can be restarted after a draw.
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void gameCanBeRestartedAfterBlueWins() throws StrategyException {

		swapTwoPiecesInStartConfiguration(PlayerColor.RED,
				new Location2D(0, 0), new Location2D(0, 1));

		StrategyGameController controller = factory.makeBetaStrategyGame(
				startingRedConfig, startingBlueConfig);
		controller.startGame();

		// move random red piece
		// move blue lt
		// move random red piece
		// move blue lt
		// move random red piece
		// capture flag
		controller.move(PieceType.LIEUTENANT, new Location2D(1, 1),
				new Location2D(1, 2));
		controller.move(PieceType.LIEUTENANT, new Location2D(0, 4),
				new Location2D(0, 3));
		controller.move(PieceType.SERGEANT, new Location2D(3, 1),
				new Location2D(3, 2));
		controller.move(PieceType.LIEUTENANT, new Location2D(0, 3),
				new Location2D(0, 2));
		controller.move(PieceType.SERGEANT, new Location2D(3, 2),
				new Location2D(3, 3));
		controller.move(PieceType.LIEUTENANT, new Location2D(0, 2),
				new Location2D(0, 1));

		// Game now ends in a blue win. A new game can now be started.
		controller.startGame();
		// Make sure that the board configuration has been reset.
		assertEquals(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE),
				controller.getPieceAt(new Location2D(0, 4)));
		assertTrue(true);
	}
}
