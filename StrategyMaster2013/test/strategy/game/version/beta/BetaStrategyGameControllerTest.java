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
	 * Tests Piece getPieceAt(Location location);
	 * bluePieces.add(new Piece(PieceType.FLAG, PlayerColor.BLUE));
	 * blueLocations.add(new Location2D(0, 5));
	 * 
	 * getPieceAt(new Location(0,5)) should return Piece(PieceType.FLAG, PlayerColor.BLUE);
	 * @throws StrategyException 
	 */
	@Test
	public void getPieceAtLocationShouldReturnBlueFlag() throws StrategyException{
		StrategyGameController ctrlr = factory.makeBetaStrategyGame(startingRedConfig, startingBlueConfig);
		Piece piece = new Piece(PieceType.FLAG, PlayerColor.BLUE);
		
		assertEquals(piece, ctrlr.getPieceAt(new Location2D(0,5)));
	}
	
	/**
	 * Tests Piece getPieceAt(Location location);
	 * 
	 * getPieceAt(new Location(1,0)) should return Piece(PieceType.MARSHAL, PlayerColor.RED);
	 * @throws StrategyException 
	 */
	@Test
	public void getPieceAtLocationShouldReturnRedMarshal() throws StrategyException{
		StrategyGameController ctrlr = factory.makeBetaStrategyGame(startingRedConfig, startingBlueConfig);
		Piece piece = new Piece(PieceType.MARSHAL, PlayerColor.RED);
		
		assertEquals(piece, ctrlr.getPieceAt(new Location2D(1,0)));
	}
	
	/**
	 * getPieceAt returns null if there is no piece at the specified location.
	 * 
	 * getPiece at (3,3) should be null
	 * (there is no piece currently on (3,3))
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void getPieceAtLocationShouldReturnNullIfNoPiecePresent() throws StrategyException{
		StrategyGameController ctrlr = factory.makeBetaStrategyGame(startingRedConfig, startingBlueConfig);
		assertEquals(null, ctrlr.getPieceAt(new Location2D(3,3)));
	}
	
	/**
	 * getPieceAt should throw an error if the location does not exist on the board
	 * 
	 * get Piece at (6,7) should throw an exception
	 * @throws StrategyException
	 */
	@Test
	public void getPieceAtLocationNotOnBoardShouldThrowException() throws StrategyException{
		StrategyGameController ctrlr = factory.makeBetaStrategyGame(startingRedConfig, startingBlueConfig);
		ctrlr.getPieceAt(new Location2D(6,7));
	}
	
	//@TODO: this shouldn't be null! what do we do?
	@Test
	public void getPieceAtLocationNotOnBoardShouldReturnNull() throws StrategyException{
		StrategyGameController ctrlr = factory.makeBetaStrategyGame(startingRedConfig, startingBlueConfig);
		assertEquals(null, ctrlr.getPieceAt(new Location2D(6,7)));
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
}
