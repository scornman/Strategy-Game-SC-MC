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
 * @version Sep 11, 2013
 * 
 */
public class BetaStrategyGameControllerTest {

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
		new BetaStrategyGameController(startingRedConfig, startingBlueConfig);
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
	 */
	@Test
	public void testMoveSuccessfullyMovesPieceToDestinationOnValidMove() {

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
	// TODO: UNCOMMENT TEST AND FIX!!!
	// @Test
	// public void pieceTriesToMoveOneSpacesX() throws StrategyException {
	// StrategyGameController controller = factory.makeBetaStrategyGame(
	// startingRedConfig, startingBlueConfig);
	// controller.startGame();
	// Location fromLocation = new Location2D(1, 1);
	// Location toLocation = new Location2D(2, 1);
	// controller.move(PieceType.LIEUTENANT, fromLocation, toLocation);
	// assertTrue(true);
	// }

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

}
