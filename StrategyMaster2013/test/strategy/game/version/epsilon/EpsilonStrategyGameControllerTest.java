/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package strategy.game.version.epsilon;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import strategy.game.*;
import strategy.common.*;
import strategy.game.common.*;

/**
 * Test cases for testing the EpsilonStrategyGameController class and the overall
 * functionality of the Epsilon Strategy Game.
 * 
 * @author scornman
 * @author Madalyn
 * @version Sep 15, 2013
 * 
 */
public class EpsilonStrategyGameControllerTest {

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
	 * The observers for the strategy game.
	 */
	private Collection<StrategyGameObserver> observers;

	/**
	 * Constants for easy access to locations
	 */
	private final Location loc00 = new Location2D(0, 0);
	private final Location loc01 = new Location2D(0, 1);
	private final Location loc02 = new Location2D(0, 2);
	private final Location loc03 = new Location2D(0, 3);
	private final Location loc04 = new Location2D(0, 4);
	private final Location loc05 = new Location2D(0, 5);
	private final Location loc06 = new Location2D(0, 6);
	private final Location loc07 = new Location2D(0, 7);
	private final Location loc08 = new Location2D(0, 8);
	private final Location loc09 = new Location2D(0, 9);
	private final Location loc10 = new Location2D(1, 0);
	private final Location loc11 = new Location2D(1, 1);
	private final Location loc12 = new Location2D(1, 2);
	private final Location loc13 = new Location2D(1, 3);
	private final Location loc14 = new Location2D(1, 4);
	private final Location loc15 = new Location2D(1, 5);
	private final Location loc16 = new Location2D(1, 6);
	private final Location loc17 = new Location2D(1, 7);
	private final Location loc18 = new Location2D(1, 8);
	private final Location loc19 = new Location2D(1, 9);
	private final Location loc20 = new Location2D(2, 0);
	private final Location loc21 = new Location2D(2, 1);
	private final Location loc22 = new Location2D(2, 2);
	private final Location loc23 = new Location2D(2, 3);
	private final Location loc24 = new Location2D(2, 4);
	private final Location loc25 = new Location2D(2, 5);
	private final Location loc26 = new Location2D(2, 6);
	private final Location loc27 = new Location2D(2, 7);
	private final Location loc28 = new Location2D(2, 8);
	private final Location loc29 = new Location2D(2, 9);
	private final Location loc30 = new Location2D(3, 0);
	private final Location loc31 = new Location2D(3, 1);
	private final Location loc32 = new Location2D(3, 2);
	private final Location loc33 = new Location2D(3, 3);
	private final Location loc34 = new Location2D(3, 4);
	private final Location loc35 = new Location2D(3, 5);
	private final Location loc36 = new Location2D(3, 6);
	private final Location loc37 = new Location2D(3, 7);
	private final Location loc38 = new Location2D(3, 8);
	private final Location loc39 = new Location2D(3, 9);
	private final Location loc40 = new Location2D(4, 0);
	private final Location loc41 = new Location2D(4, 1);
	private final Location loc42 = new Location2D(4, 2);
	private final Location loc43 = new Location2D(4, 3);
	private final Location loc44 = new Location2D(4, 4);
	private final Location loc45 = new Location2D(4, 5);
	private final Location loc46 = new Location2D(4, 6);
	private final Location loc47 = new Location2D(4, 7);
	private final Location loc48 = new Location2D(4, 8);
	private final Location loc49 = new Location2D(4, 9);
	private final Location loc50 = new Location2D(5, 0);
	private final Location loc51 = new Location2D(5, 1);
	private final Location loc52 = new Location2D(5, 2);
	private final Location loc53 = new Location2D(5, 3);
	private final Location loc54 = new Location2D(5, 4);
	private final Location loc55 = new Location2D(5, 5);
	private final Location loc56 = new Location2D(5, 6);
	private final Location loc57 = new Location2D(5, 7);
	private final Location loc58 = new Location2D(5, 8);
	private final Location loc59 = new Location2D(5, 9);
	private final Location loc60 = new Location2D(6, 0);
	private final Location loc61 = new Location2D(6, 1);
	private final Location loc62 = new Location2D(6, 2);
	private final Location loc63 = new Location2D(6, 3);
	private final Location loc64 = new Location2D(6, 4);
	private final Location loc65 = new Location2D(6, 5);
	private final Location loc66 = new Location2D(6, 6);
	private final Location loc67 = new Location2D(6, 7);
	private final Location loc68 = new Location2D(6, 8);
	private final Location loc69 = new Location2D(6, 9);
	private final Location loc70 = new Location2D(7, 0);
	private final Location loc71 = new Location2D(7, 1);
	private final Location loc72 = new Location2D(7, 2);
	private final Location loc73 = new Location2D(7, 3);
	private final Location loc74 = new Location2D(7, 4);
	private final Location loc75 = new Location2D(7, 5);
	private final Location loc76 = new Location2D(7, 6);
	private final Location loc77 = new Location2D(7, 7);
	private final Location loc78 = new Location2D(7, 8);
	private final Location loc79 = new Location2D(7, 9);
	private final Location loc80 = new Location2D(8, 0);
	private final Location loc81 = new Location2D(8, 1);
	private final Location loc82 = new Location2D(8, 2);
	private final Location loc83 = new Location2D(8, 3);
	private final Location loc84 = new Location2D(8, 4);
	private final Location loc85 = new Location2D(8, 5);
	private final Location loc86 = new Location2D(8, 6);
	private final Location loc87 = new Location2D(8, 7);
	private final Location loc88 = new Location2D(8, 8);
	private final Location loc89 = new Location2D(8, 9);
	private final Location loc90 = new Location2D(9, 0);
	private final Location loc91 = new Location2D(9, 1);
	private final Location loc92 = new Location2D(9, 2);
	private final Location loc93 = new Location2D(9, 3);
	private final Location loc94 = new Location2D(9, 4);
	private final Location loc95 = new Location2D(9, 5);
	private final Location loc96 = new Location2D(9, 6);
	private final Location loc97 = new Location2D(9, 7);
	private final Location loc98 = new Location2D(9, 8);
	private final Location loc99 = new Location2D(9, 9);

	/**
	 * Setup method that runs before each test. It sets up sample valid starting
	 * piece configurations for both players, which can be modified and/or used
	 * to create a EpsilonStrategyGameController.
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
		// Red flag (1)
		redPieces.add(new Piece(PieceType.FLAG, PlayerColor.RED));
		redLocations.add(loc83);
		redPieces.add(new Piece(PieceType.FLAG, PlayerColor.RED));
		redLocations.add(loc82);
		// Red Bombs (6)
		redPieces.add(new Piece(PieceType.BOMB, PlayerColor.RED));
		redLocations.add(loc93);
		redPieces.add(new Piece(PieceType.BOMB, PlayerColor.RED));
		redLocations.add(loc20);
		redPieces.add(new Piece(PieceType.BOMB, PlayerColor.RED));
		redLocations.add(loc30);
		redPieces.add(new Piece(PieceType.BOMB, PlayerColor.RED));
		redLocations.add(loc40);
		redPieces.add(new Piece(PieceType.BOMB, PlayerColor.RED));
		redLocations.add(loc50);
		redPieces.add(new Piece(PieceType.BOMB, PlayerColor.RED));
		redLocations.add(loc60);
		// Red Marshal (1)
		redPieces.add(new Piece(PieceType.MARSHAL, PlayerColor.RED));
		redLocations.add(loc03);
		// Red General
		redPieces.add(new Piece(PieceType.GENERAL, PlayerColor.RED));
		redLocations.add(loc23);
		// Red Colonels
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(loc33);
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(loc63);
		// Red Majors
		redPieces.add(new Piece(PieceType.MAJOR, PlayerColor.RED));
		redLocations.add(loc21);
		redPieces.add(new Piece(PieceType.MAJOR, PlayerColor.RED));
		redLocations.add(loc73);
		redPieces.add(new Piece(PieceType.MAJOR, PlayerColor.RED));
		redLocations.add(loc72);
		// Red Captains
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(loc81);
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(loc91);
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(loc92);
		// Red Lieutenants
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(loc71);
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(loc70);
		// Red First Lieutenants
		redPieces.add(new Piece(PieceType.FIRST_LIEUTENANT, PlayerColor.RED));
		redLocations.add(loc80);
		redPieces.add(new Piece(PieceType.FIRST_LIEUTENANT, PlayerColor.RED));
		redLocations.add(loc90);
		// Red Sergeants
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(loc51);
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(loc52);
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(loc61);
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(loc62);
		// Red Miners (5)
		redPieces.add(new Piece(PieceType.MINER, PlayerColor.RED));
		redLocations.add(loc53);
		redPieces.add(new Piece(PieceType.MINER, PlayerColor.RED));
		redLocations.add(loc31);
		redPieces.add(new Piece(PieceType.MINER, PlayerColor.RED));
		redLocations.add(loc32);
		redPieces.add(new Piece(PieceType.MINER, PlayerColor.RED));
		redLocations.add(loc41);
		redPieces.add(new Piece(PieceType.MINER, PlayerColor.RED));
		redLocations.add(loc42);
		// Red Scouts (8)
		redPieces.add(new Piece(PieceType.SCOUT, PlayerColor.RED));
		redLocations.add(loc43);
		redPieces.add(new Piece(PieceType.SCOUT, PlayerColor.RED));
		redLocations.add(loc00);
		redPieces.add(new Piece(PieceType.SCOUT, PlayerColor.RED));
		redLocations.add(loc01);
		redPieces.add(new Piece(PieceType.SCOUT, PlayerColor.RED));
		redLocations.add(loc02);
		redPieces.add(new Piece(PieceType.SCOUT, PlayerColor.RED));
		redLocations.add(loc10);
		redPieces.add(new Piece(PieceType.SCOUT, PlayerColor.RED));
		redLocations.add(loc11);
		redPieces.add(new Piece(PieceType.SCOUT, PlayerColor.RED));
		redLocations.add(loc12);
		redPieces.add(new Piece(PieceType.SCOUT, PlayerColor.RED));
		redLocations.add(loc22);
		// Red Spy (1)
		redPieces.add(new Piece(PieceType.SPY, PlayerColor.RED));
		redLocations.add(loc13);

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

		// Blue flags (2)
		bluePieces.add(new Piece(PieceType.FLAG, PlayerColor.BLUE));
		blueLocations.add(loc46);
		bluePieces.add(new Piece(PieceType.FLAG, PlayerColor.BLUE));
		blueLocations.add(loc47);
		// Blue Bombs (6)
		bluePieces.add(new Piece(PieceType.BOMB, PlayerColor.BLUE));
		blueLocations.add(loc56);
		bluePieces.add(new Piece(PieceType.BOMB, PlayerColor.BLUE));
		blueLocations.add(loc29);
		bluePieces.add(new Piece(PieceType.BOMB, PlayerColor.BLUE));
		blueLocations.add(loc39);
		bluePieces.add(new Piece(PieceType.BOMB, PlayerColor.BLUE));
		blueLocations.add(loc49);
		bluePieces.add(new Piece(PieceType.BOMB, PlayerColor.BLUE));
		blueLocations.add(loc59);
		bluePieces.add(new Piece(PieceType.BOMB, PlayerColor.BLUE));
		blueLocations.add(loc69);
		// Blue Marshal (1)
		bluePieces.add(new Piece(PieceType.MARSHAL, PlayerColor.BLUE));
		blueLocations.add(loc16);
		// Blue General
		bluePieces.add(new Piece(PieceType.GENERAL, PlayerColor.BLUE));
		blueLocations.add(loc26);
		// Blue Colonels
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(loc36);
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(loc66);
		// Blue Majors
		bluePieces.add(new Piece(PieceType.MAJOR, PlayerColor.BLUE));
		blueLocations.add(loc28);
		bluePieces.add(new Piece(PieceType.MAJOR, PlayerColor.BLUE));
		blueLocations.add(loc76);
		bluePieces.add(new Piece(PieceType.MAJOR, PlayerColor.BLUE));
		blueLocations.add(loc77);
		// Blue Captains
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(loc87);
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(loc88);
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(loc97);
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(loc98);
		// Blue Lieutenants
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(loc78);
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(loc79);
		// Blue First Lieutenants
		bluePieces.add(new Piece(PieceType.FIRST_LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(loc89);
		bluePieces.add(new Piece(PieceType.FIRST_LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(loc99);
		// Blue Sergeants
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(loc57);
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(loc58);
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(loc67);
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(loc68);
		// Blue Miners (4)
		bluePieces.add(new Piece(PieceType.MINER, PlayerColor.BLUE));
		blueLocations.add(loc96);
		bluePieces.add(new Piece(PieceType.MINER, PlayerColor.BLUE));
		blueLocations.add(loc37);
		bluePieces.add(new Piece(PieceType.MINER, PlayerColor.BLUE));
		blueLocations.add(loc38);
		bluePieces.add(new Piece(PieceType.MINER, PlayerColor.BLUE));
		blueLocations.add(loc48);
		// Blue Scouts (8)
		bluePieces.add(new Piece(PieceType.SCOUT, PlayerColor.BLUE));
		blueLocations.add(loc86);
		bluePieces.add(new Piece(PieceType.SCOUT, PlayerColor.BLUE));
		blueLocations.add(loc07);
		bluePieces.add(new Piece(PieceType.SCOUT, PlayerColor.BLUE));
		blueLocations.add(loc08);
		bluePieces.add(new Piece(PieceType.SCOUT, PlayerColor.BLUE));
		blueLocations.add(loc09);
		bluePieces.add(new Piece(PieceType.SCOUT, PlayerColor.BLUE));
		blueLocations.add(loc17);
		bluePieces.add(new Piece(PieceType.SCOUT, PlayerColor.BLUE));
		blueLocations.add(loc18);
		bluePieces.add(new Piece(PieceType.SCOUT, PlayerColor.BLUE));
		blueLocations.add(loc19);
		bluePieces.add(new Piece(PieceType.SCOUT, PlayerColor.BLUE));
		blueLocations.add(loc27);
		// Blue Spy (1)
		bluePieces.add(new Piece(PieceType.SPY, PlayerColor.BLUE));
		blueLocations.add(loc06);

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

	/*************************************************************
	 * Begin Tests
	 ************************************************************* 
	 */

	/**
	 * Tests that the factory method makeEpsilonStrategy from the
	 * StrategyGameFactory class successfully creates a new
	 * EpsilonStrategyGameController when given valid piece configurations. This
	 * will therefore also exercise and test the constructor for
	 * StrategyGameControllerImpl.
	 * 
	 * @throws StrategyException
	 *             if the factory method is given an invalid configuration for
	 *             either side.
	 */
	@Test
	public void testFactoryMethodCreatesGameWhenGivenValidConfigurations()
			throws StrategyException {
		factory.makeEpsilonStrategy(startingRedConfig, startingBlueConfig, observers);
		assertTrue(true);
	}

	/**
	 * Tests that the factory method makeEpsilonStrategy fails with a
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
		Location oldMarshallLocation = new Location2D(0, 3);
		Location newMarshallLocation = new Location2D(8, 3);
		movePieceToNewStartLocation(startingRedConfig, redMarshall,
				oldMarshallLocation, newMarshallLocation);

		// Create the controller
		factory.makeEpsilonStrategy(startingRedConfig, startingBlueConfig, observers);
	}

	/**
	 * Tests that the factory method makeEpsilonStrategy fails with a
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
		Location oldColonelLocation = new Location2D(3, 6);
		Location newColonelLocation = new Location2D(8, 7);
		movePieceToNewStartLocation(startingBlueConfig, blueColonel,
				oldColonelLocation, newColonelLocation);

		// Create the controller
		factory.makeEpsilonStrategy(startingRedConfig, startingBlueConfig, observers);
	}

	/**
	 * Tests that the factory method makeEpsilonStrategy fails with a
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
		Location oldLocation = new Location2D(7, 8);
		Location newLocation = new Location2D(5, 4);
		movePieceToNewStartLocation(startingRedConfig, pieceToChange,
				oldLocation, newLocation);

		// Create the controller
		factory.makeEpsilonStrategy(startingRedConfig, startingBlueConfig, observers);
	}

	/**
	 * Tests that the factory method makeEpsilonStrategy fails with a
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
		Location oldLocation = new Location2D(5, 7);
		Location newLocation = new Location2D(2, 1);
		movePieceToNewStartLocation(startingBlueConfig, pieceToChange,
				oldLocation, newLocation);

		// Create the controller
		factory.makeEpsilonStrategy(startingRedConfig, startingBlueConfig, observers);
	}

	/**
	 * Tests that the factory method makeEpsilonStrategy fails with a
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
		Location location = new Location2D(5, 1);
		PieceLocationDescriptor pldToRemove = new PieceLocationDescriptor(
				pieceToRemove, location);
		assertTrue(startingRedConfig.remove(pldToRemove));

		// Create the controller
		factory.makeEpsilonStrategy(startingRedConfig, startingBlueConfig, observers);
	}

	/**
	 * Tests that the factory method makeEpsilonStrategy fails with a
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
		Location location = new Location2D(1, 6);
		PieceLocationDescriptor pldToRemove = new PieceLocationDescriptor(
				pieceToRemove, location);
		assertTrue(startingBlueConfig.remove(pldToRemove));

		// Create the controller
		factory.makeEpsilonStrategy(startingRedConfig, startingBlueConfig, observers);
	}

	/**
	 * Tests that the factory method makeEpsilonStrategy fails with a
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
		Location pieceLocation = new Location2D(7, 0);
		replacePieceInStartConfiguration(startingRedConfig, pieceToReplace,
				replacementPiece, pieceLocation);

		// Create the controller
		factory.makeEpsilonStrategy(startingRedConfig, startingBlueConfig, observers);
	}

	/**
	 * Tests that the factory method makeEpsilonStrategy fails with a
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
		Location pieceLocation = new Location2D(9, 8);
		replacePieceInStartConfiguration(startingBlueConfig, pieceToReplace,
				replacementPiece, pieceLocation);

		// Create the controller
		factory.makeEpsilonStrategy(startingRedConfig, startingBlueConfig, observers);
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
		StrategyGameController ctrlr = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		Piece piece = new Piece(PieceType.FLAG, PlayerColor.BLUE);

		assertEquals(piece, ctrlr.getPieceAt(new Location2D(4, 6)));
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
		StrategyGameController ctrlr = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		Piece piece = new Piece(PieceType.MARSHAL, PlayerColor.RED);

		assertEquals(piece, ctrlr.getPieceAt(new Location2D(0, 3)));
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
		StrategyGameController ctrlr = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		assertEquals(null, ctrlr.getPieceAt(new Location2D(4, 4)));
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
		StrategyGameController ctrlr = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		ctrlr.getPieceAt(new Location2D(11, 10));
	}

	/**
	 * getPieceAt y-coordinate location shouldn't be negative
	 * 
	 * @throws StrategyException
	 */
	@Test(expected = StrategyRuntimeException.class)
	public void getPieceAtCannotHaveANegativeYCoordinate()
			throws StrategyException {
		StrategyGameController ctrlr = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
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
		StrategyGameController ctrlr = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
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
		StrategyGameController ctrlr = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
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
		StrategyGameController ctrlr = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
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
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
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
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		// Create the piece to attempt to move.
		PieceType typeToMove = PieceType.MINER;
		Location fromLocation = new Location2D(5, 3);
		Location toLocation = new Location2D(5, 4);
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
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		Location fromLocation = new Location2D(4, 4);
		Location toLocation = new Location2D(4, 5);
		controller.move(PieceType.COLONEL, fromLocation, toLocation);
	}

	/**
	 * Tests that the move method throws an error if the location to move from
	 * is null.
	 * 
	 * @throws StrategyException
	 *             if one of the arguments passed to the move method is invalid.
	 *             This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testMoveThrowsExceptionIfFromLocationIsNull()
			throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		Location fromLocation = null;
		Location toLocation = new Location2D(0, 4);
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
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		Location fromLocation = new Location2D(1, 3);
		Location toLocation = null;
		controller.move(PieceType.SPY, fromLocation, toLocation);
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
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		Location fromLocation = new Location2D(5, 3);
		Location toLocation = new Location2D(5, 4);
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
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		Location fromLocation = new Location2D(5, 3);
		Location toLocation = new Location2D(5, 4);
		// Piece type in this location should be MINER
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
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		// Attempt to move a blue piece when red should have the first turn.
		Location fromLocation = new Location2D(1, 6);
		Location toLocation = new Location2D(1, 5);
		controller.move(PieceType.MARSHAL, fromLocation, toLocation);
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
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		Location firstFromLocation = new Location2D(5, 3);
		Location firstToLocation = new Location2D(5, 4);
		Location secondFromLocation = new Location2D(0, 3);
		Location secondToLocation = new Location2D(0, 4);
		// Make a valid move for red.
		controller.move(PieceType.MINER, firstFromLocation, firstToLocation);
		// Attempt to move a red piece again.
		controller
				.move(PieceType.MARSHAL, secondFromLocation, secondToLocation);
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
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		Location firstFromLocation = new Location2D(5, 3);
		Location firstToLocation = new Location2D(5, 4);
		Location secondFromLocation = new Location2D(9, 6);
		Location secondToLocation = new Location2D(9, 5);
		Location thirdFromLocation = new Location2D(0, 6);
		Location thirdToLocation = new Location2D(0, 5);
		// Make a valid move for red.
		controller.move(PieceType.MINER, firstFromLocation, firstToLocation);
		// Then blue moves
		controller.move(PieceType.MINER, secondFromLocation, secondToLocation);
		// Now blue tries to move again
		controller.move(PieceType.SPY, thirdFromLocation, thirdToLocation);
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
		Location flagLocation = new Location2D(8, 3);
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();

		// Attempt to move the flag.
		controller.move(PieceType.FLAG, flagLocation, new Location2D(8, 4));
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
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		// Attempt to move red sergeant to location containing red miner.
		Location fromLocation = new Location2D(5, 2);
		Location toLocation = new Location2D(4, 2);
		controller.move(PieceType.SERGEANT, fromLocation, toLocation);
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
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		// First, make a valid move for red.
		Location redFromLocation = new Location2D(5, 3);
		Location redToLocation = new Location2D(5, 4);
		controller.move(PieceType.MINER, redFromLocation, redToLocation);
		// Attempt to move blue general to location containing blue colonel.
		Location blueFromLocation = new Location2D(2, 6);
		Location blueToLocation = new Location2D(3, 6);
		controller.move(PieceType.GENERAL, blueFromLocation, blueToLocation);
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
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		Location fromLocation = new Location2D(0, 3);
		Location toLocation = new Location2D(0, 4);
		// Get the piece at the from location
		Piece movingPiece = new Piece(PieceType.MARSHAL, PlayerColor.RED);
		// Make a valid move to an empty space
		controller.move(PieceType.MARSHAL, fromLocation, toLocation);
		// Check that the piece is now at the to location
		assertEquals(movingPiece, controller.getPieceAt(toLocation));
		// Check that the from location is now empty
		assertNull(controller.getPieceAt(fromLocation));
	}

	/**
	 * Should throw an error if a piece that is not a scout tries to move to
	 * location not next to it
	 * 
	 * @throws StrategyException
	 */
	@Test(expected = StrategyException.class)
	public void throwExceptionIfPieceTriesToMoveToDiagonalLocation()
			throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		Location fromLocation = new Location2D(0, 3);
		Location toLocation = new Location2D(9, 5);
		controller.move(PieceType.MARSHAL, fromLocation, toLocation);
	}

	/**
	 * Should throw an error if piece tries to move to far in the x location
	 * 
	 * @throws StrategyException
	 */
	@Test(expected = StrategyException.class)
	public void throwExceptionIfPieceTriesToMoveTooManySpacesX()
			throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		Location fromLocation = new Location2D(5, 3);
		Location toLocation = new Location2D(3, 3);
		controller.move(PieceType.MINER, fromLocation, toLocation);
	}

	/**
	 * Should throw an error if piece tries to move to far in the y location
	 * 
	 * @throws StrategyException
	 */
	@Test(expected = StrategyException.class)
	public void throwExceptionIfPieceTriesToMoveTooManySpacesY()
			throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		Location fromLocation = new Location2D(5, 3);
		Location toLocation = new Location2D(5, 5);
		controller.move(PieceType.MINER, fromLocation, toLocation);
	}

	/**
	 * Should be valid if piece tries to move one space X
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void pieceTriesToMoveOneSpacesX() throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();

		// First, move red piece up, so that it can move sideways on the next
		// turn.
		Location fromLocation1 = new Location2D(1, 3);
		Location toLocation1 = new Location2D(1, 4);
		controller.move(PieceType.SPY, fromLocation1, toLocation1);
		// Next, move a blue piece to be valid.
		Location fromLocation2 = new Location2D(9, 6);
		Location toLocation2 = new Location2D(9, 5);
		controller.move(PieceType.MINER, fromLocation2, toLocation2);
		// Finally, move the red piece to the side.
		Location fromLocation3 = new Location2D(1, 4);
		Location toLocation3 = new Location2D(0, 4);
		controller.move(PieceType.SPY, fromLocation3, toLocation3);
		assertTrue(true);
	}

	/**
	 * Should be valid if piece tries to move one space Y
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void pieceTriesToMoveOneSpacesY() throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		Location fromLocation = new Location2D(1, 3);
		Location toLocation = new Location2D(1, 4);
		controller.move(PieceType.SPY, fromLocation, toLocation);
		assertTrue(true);
	}

	/**
	 * tests that game ends in RED_WINS after red captures the blue flag
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void gameEndsInRedWinsAfterRedCapturesBlueFlag()
			throws StrategyException {

		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();

		// move red scout
		// move random blue piece
		// move red scout
		// move random blue piece
		// capture flag
		controller.move(PieceType.SCOUT, loc43, loc44);
		controller.move(PieceType.MARSHAL, loc16, loc15);
		controller.move(PieceType.SCOUT, loc44, loc45);
		controller.move(PieceType.MINER, loc96, loc95);
		MoveResult result = controller.move(PieceType.SCOUT, loc45, loc46);
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

		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();

		// move random red piece
		// move blue scout
		// move random red piece
		// move blue scout
		// move random red piece
		// capture flag
		controller.move(PieceType.MARSHAL, loc03, loc04);
		controller.move(PieceType.SCOUT, loc86, loc85);
		controller.move(PieceType.MARSHAL, loc04, loc14);
		controller.move(PieceType.SCOUT, loc85, loc84);
		controller.move(PieceType.MARSHAL, loc14, loc04);
		MoveResult result = controller.move(PieceType.SCOUT, loc84, loc83);
		// check that the game status is BLUE_WINS/game ends
		assertEquals(MoveResultStatus.BLUE_WINS, result.getStatus());
	}

	/**
	 * Tests that there is null battle winner when two pieces of the same type
	 * attack each other
	 * 
	 */
	@Test
	public void marshalAttaksMarshalResultsInNullBattleWinner()
			throws StrategyException {

		swapTwoPiecesInStartConfiguration(PlayerColor.BLUE, loc16, loc06);
		// move red marshal
		// move blue marshal
		// red attacks blue marshal
		// null battle winner
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();

		controller.move(PieceType.MARSHAL, loc03, loc04);
		controller.move(PieceType.MARSHAL, loc06, loc05);
		MoveResult result = controller.move(PieceType.MARSHAL, loc04, loc05);
		// check that the game status is OK
		assertEquals(MoveResultStatus.OK, result.getStatus());
		assertNull(result.getBattleWinner());
		assertNull(controller.getPieceAt(loc04));
		assertNull(controller.getPieceAt(loc05));
	}

	/**
	 * Tests that the move method returns a move result containing a null
	 * battleWinner if a piece moves to an empty location.
	 */
	@Test
	public void testMoveToEmptySpaceProducesNullBattleWinner()
			throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		Location fromLocation = loc53;
		Location toLocation = loc54;

		MoveResult result = controller.move(PieceType.MINER, fromLocation,
				toLocation);
		PieceLocationDescriptor winner = result.getBattleWinner();
		assertNull(winner);
		// Check that the board has properly updated to reflect the move.
		Piece movedPiece = new Piece(PieceType.MINER, PlayerColor.RED);
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
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		Location fromLocation = loc53;
		Location toLocation = loc54;

		MoveResult result = controller.move(PieceType.MINER, fromLocation,
				toLocation);
		MoveResultStatus status = result.getStatus();
		assertEquals(MoveResultStatus.OK, status);
		// Check that the board has properly updated to reflect the move.
		Piece movedPiece = new Piece(PieceType.MINER, PlayerColor.RED);
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
		swapTwoPiecesInStartConfiguration(PlayerColor.RED, loc70, loc53);
		swapTwoPiecesInStartConfiguration(PlayerColor.BLUE, loc57, loc56);

		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();

		Location attackerLocation = loc54;
		Location defenderLocation = loc55;
		Piece attackPiece = new Piece(PieceType.LIEUTENANT, PlayerColor.RED);

		// Perform the sequence of moves that will lead to the battle.
		controller.move(PieceType.LIEUTENANT, loc53, loc54);
		controller.move(PieceType.SERGEANT, loc56, loc55);

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
		swapTwoPiecesInStartConfiguration(PlayerColor.RED, loc70, loc53);
		swapTwoPiecesInStartConfiguration(PlayerColor.BLUE, loc57, loc56);

		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();

		Location attackerLocation = loc55;
		Location defenderLocation = loc54;
		Piece defendPiece = new Piece(PieceType.LIEUTENANT, PlayerColor.RED);

		// Perform the sequence of moves that will lead to the battle.
		controller.move(PieceType.LIEUTENANT, loc53, loc54);
		controller.move(PieceType.SERGEANT, loc56, loc55);
		controller.move(PieceType.MARSHAL, loc03, loc04); // unrelated red move

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
	 * If all the pieces are off the board except the two flags then the game
	 is
	 * a draw
	 *
	 * @throws StrategyException
	 */
	 @Test
	 public void gameEndsInDrawWhenOnlyTwoFlagsLeftOnBoard()
	 throws StrategyException {
		TestStrategyGameFactory testFactory = new TestStrategyGameFactory();
		StrategyGameController controller = testFactory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		
		// Change the board to remove all but the flags & 2 marshals
		testFactory.clearBoard();
		testFactory.putPieceOnBoard(loc00, new Piece(PieceType.FLAG,
				PlayerColor.RED));
		testFactory.putPieceOnBoard(loc09, new Piece(PieceType.FLAG,
				PlayerColor.BLUE));
		testFactory.putPieceOnBoard(loc54, new Piece(PieceType.MARSHAL,
				PlayerColor.RED));
		testFactory.putPieceOnBoard(loc55, new Piece(PieceType.MARSHAL,
				PlayerColor.BLUE));
		
		// red marshal attacks blue marshal, the last blue piece.
		MoveResult result = controller.move(PieceType.MARSHAL, loc54, loc55);
				
		//check that the game status is DRAW/game ends
		assertEquals(MoveResultStatus.DRAW, result.getStatus());
	 }

	/**
	 * Tests that the move repetition rule is properly implemented, by having
	 * the red player immediately move a piece from one position to a second
	 * position, back to the first position, and then to the second position
	 * again.
	 * 
	 * @throws StrategyException
	 *             if an invalid move is made. This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testImmediateRedMoveRepetition() throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		PieceType movingPiece = PieceType.MARSHAL;
		Location location1 = loc03;
		Location location2 = loc04;

		// Move the red piece back and forth while the blue pieces do other
		// things.
		controller.move(movingPiece, location1, location2);
		controller.move(PieceType.MINER, loc96, loc95);
		controller.move(movingPiece, location2, location1);
		controller.move(PieceType.MINER, loc95, loc85);
		// This move is invalid
		controller.move(movingPiece, location1, location2);
		assertTrue(true);
	}

	/**
	 * Tests that the move repetition rule is properly implemented, by having
	 * the blue player move a piece from one position to a second position, back
	 * to the first position, and then to the second position again, after
	 * moving other pieces first.
	 * 
	 * @throws StrategyException
	 *             if an invalid move is made. This is the expected behavior.
	 */
	@Test(expected = StrategyException.class)
	public void testBlueMoveRepetitionAfterOtherMoves()
			throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		PieceType movingPiece = PieceType.MARSHAL;
		Location location1 = loc16;
		Location location2 = loc15;
		// Make a few unimportant moves
		controller.move(PieceType.MINER, loc53, loc54);
		controller.move(PieceType.SCOUT, loc86, loc85);
		controller.move(PieceType.MINER, loc54, loc44);

		// Move the blue piece back and forth while the blue pieces do other
		// things.
		controller.move(movingPiece, location1, location2);
		controller.move(PieceType.SERGEANT, loc52, loc53);
		controller.move(movingPiece, location2, location1);
		controller.move(PieceType.SERGEANT, loc53, loc54);

		// This move is invalid
		controller.move(movingPiece, location1, location2);
		assertTrue(true);
	}

	/**
	 * Test that you cannot move onto a choke point (which are synonymous with
	 * invalid locations)
	 * 
	 * @throws StrategyException
	 *             invalid move should throw an exception
	 */
	@Test(expected = StrategyException.class)
	public void cannotMovePieceOntoAChokePoint() throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		PieceType movingPiece = PieceType.COLONEL;
		Location location1 = loc33;
		Location location2 = loc34; // this is the choke point

		// this move is invalid move
		controller.move(movingPiece, location1, location2);
		assertTrue(true);
	}

	/**
	 * Test that you cannot move a choke point (which are synonymous with
	 * invalid locations)
	 * 
	 * @throws StrategyException
	 *             invalid move should throw an exception
	 */
	@Test(expected = StrategyException.class)
	public void cannotMoveAChokePoint() throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		PieceType movingPiece = PieceType.CHOKE_POINT;
		Location location1 = new Location2D(2, 4); // this is the choke point
		Location location2 = new Location2D(1, 4);

		// this move is invalid move
		controller.move(movingPiece, location1, location2);
		assertTrue(true);
	}

	/**
	 * Tests that red wins if blue cannot make a legal move, because the only
	 * remaining blue piece is the flag, but red can make a legal move.
	 * 
	 * @throws StrategyException
	 *             if an invalid move is made.
	 */
	@Test
	public void testRedWinsIfBlueHasOnlyFlagLeft() throws StrategyException {
		TestStrategyGameFactory testFactory = new TestStrategyGameFactory();
		StrategyGameController controller = testFactory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();

		// Change the board to remove all but 4 pieces.
		testFactory.clearBoard();
		testFactory.putPieceOnBoard(loc00, new Piece(PieceType.FLAG,
				PlayerColor.RED));
		testFactory.putPieceOnBoard(loc09, new Piece(PieceType.FLAG,
				PlayerColor.BLUE));
		testFactory.putPieceOnBoard(loc94, new Piece(PieceType.MARSHAL,
				PlayerColor.RED));
		testFactory.putPieceOnBoard(loc95, new Piece(PieceType.LIEUTENANT,
				PlayerColor.BLUE));

		// red marshal attacks blue marshal, the last blue piece.
		MoveResult result = controller.move(PieceType.MARSHAL, loc94, loc95);

		// check that the game status is RED_WINS/game ends
		assertEquals(MoveResultStatus.RED_WINS, result.getStatus());
	}

	/**
	 * Tests that blue wins if red cannot make a move without violating the move
	 * repetition rule.
	 * 
	 * @throws StrategyException
	 *             if an invalid move is made.
	 */
	@Test
	public void testBlueWinsIfRedCantMoveWithoutRepetition()
			throws StrategyException {
		TestStrategyGameFactory testFactory = new TestStrategyGameFactory();
		StrategyGameController controller = testFactory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();

		// Change the board to remove all but 4 pieces.
		testFactory.clearBoard();
		testFactory.putPieceOnBoard(loc10, new Piece(PieceType.FLAG,
				PlayerColor.RED));
		testFactory.putPieceOnBoard(loc09, new Piece(PieceType.FLAG,
				PlayerColor.BLUE));
		testFactory.putPieceOnBoard(loc00, new Piece(PieceType.MARSHAL,
				PlayerColor.RED));
		testFactory.putPieceOnBoard(loc95, new Piece(PieceType.GENERAL,
				PlayerColor.BLUE));

		controller.move(PieceType.MARSHAL, loc00, loc01);// red moves forward
															// out of corner.
		controller.move(PieceType.GENERAL, loc95, loc94);// blue
		// red moves back into corner, next to the flag. The only way out would
		// be to move forward, but that would violate the move repetition rule,
		// so blue wins.
		MoveResult result = controller.move(PieceType.MARSHAL, loc01, loc00);

		// check that the game status is BLUE_WINS/game ends
		assertEquals(MoveResultStatus.BLUE_WINS, result.getStatus());
	}

	/**
	 * Tests that an attempt to move a bomb throws a StrategyException.
	 * 
	 * @throws StrategyException
	 */
	@Test(expected = StrategyException.class)
	public void testBombCannotMove() throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		// Attempt to move a red bomb
		controller.move(PieceType.BOMB, loc93, loc94);
		assertTrue(true);
	}

	/**
	 * Tests that an attacking marshal is defeated by a defending bomb, which
	 * then does not move as a result of the battle.
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void testMarshalLosesToBomb() throws StrategyException {
		// Line up the marshal with the bomb
		swapTwoPiecesInStartConfiguration(PlayerColor.RED, loc03, loc53);
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		// red
		controller.move(PieceType.MARSHAL, loc53, loc54);
		// blue
		controller.move(PieceType.SPY, loc06, loc05);
		// red
		controller.move(PieceType.MARSHAL, loc54, loc55);
		// blue
		controller.move(PieceType.SPY, loc05, loc04);

		// red attacks
		MoveResult result = controller.move(PieceType.MARSHAL, loc55, loc56);
		assertEquals(new PieceLocationDescriptor(new Piece(PieceType.BOMB,
				PlayerColor.BLUE), loc56), result.getBattleWinner());
	}

	/**
	 * Tests that an attacking sergeant is defeated by a defending bomb, which
	 * then does not move as a result of the battle.
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void testSergeantLosesToBomb() throws StrategyException {
		// Line up the sergeant with the bomb
		swapTwoPiecesInStartConfiguration(PlayerColor.RED, loc62, loc53);
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		// red
		controller.move(PieceType.SERGEANT, loc53, loc54);
		// blue
		controller.move(PieceType.SPY, loc06, loc05);
		// red
		controller.move(PieceType.SERGEANT, loc54, loc55);
		// blue
		controller.move(PieceType.SPY, loc05, loc04);

		// red attacks
		MoveResult result = controller.move(PieceType.SERGEANT, loc55, loc56);
		assertEquals(new PieceLocationDescriptor(new Piece(PieceType.BOMB,
				PlayerColor.BLUE), loc56), result.getBattleWinner());
	}

	/**
	 * Tests that an attacking miner defeats a defending bomb and takes its
	 * position.
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void testMinerDefeatsBomb() throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		// red
		controller.move(PieceType.MINER, loc53, loc54);
		// blue
		controller.move(PieceType.SPY, loc06, loc05);
		// red
		controller.move(PieceType.MINER, loc54, loc55);
		// blue
		controller.move(PieceType.SPY, loc05, loc04);

		// red attacks
		MoveResult result = controller.move(PieceType.MINER, loc55, loc56);
		assertEquals(new PieceLocationDescriptor(new Piece(PieceType.MINER,
				PlayerColor.RED), loc56), result.getBattleWinner());
	}

	/**
	 * Tests that an attacking red marshall defeats a defending blue spy and
	 * takes its position.
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void testAttackingRedMarshalDefeatsBlueSpy()
			throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		// red
		controller.move(PieceType.MARSHAL, loc03, loc04);
		// blue
		controller.move(PieceType.SPY, loc06, loc05);

		// red attacks
		MoveResult result = controller.move(PieceType.MARSHAL, loc04, loc05);
		assertEquals(new PieceLocationDescriptor(new Piece(PieceType.MARSHAL,
				PlayerColor.RED), loc05), result.getBattleWinner());
	}

	/**
	 * Tests that an attacking red spy defeats a defending blue marshal and
	 * takes its position.
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void testAttackingRedSpyDefeatsBlueMarshal()
			throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		// red
		controller.move(PieceType.SPY, loc13, loc14);
		// blue
		controller.move(PieceType.MARSHAL, loc16, loc15);

		// red attacks
		MoveResult result = controller.move(PieceType.SPY, loc14, loc15);
		assertEquals(new PieceLocationDescriptor(new Piece(PieceType.SPY,
				PlayerColor.RED), loc15), result.getBattleWinner());
	}

	/**
	 * Tests that there is no battle winner when a blue spy attacks a red spy.
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void testNoWinnerInSpyVsSpy() throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		// red
		controller.move(PieceType.SPY, loc13, loc14);
		// blue
		controller.move(PieceType.SPY, loc06, loc05);
		// red
		controller.move(PieceType.SPY, loc14, loc15);

		// blue attacks
		MoveResult result = controller.move(PieceType.SPY, loc05, loc15);
		assertEquals(null, result.getBattleWinner());
	}

	/**
	 * Test that a red scout can move two spaces in one turn
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void redScoutCanMoveTwoSpacesInOneTurn() throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();

		controller.move(PieceType.SCOUT, loc43, loc45);
		assertTrue(true);
	}

	/**
	 * Test that a blue scout can move two spaces in one turn
	 * 
	 * @throws StrategyException
	 */
	@Test
	public void blueScoutCanMoveTwoSpacesInOneTurn() throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();

		controller.move(PieceType.MINER, loc53, loc54);
		controller.move(PieceType.SCOUT, loc86, loc84);
		assertTrue(true);
	}

	/**
	 * test that a red scout cannot move onto a piece when attempting to move
	 * more than one space
	 * 
	 * @throws StrategyException
	 */
	@Test(expected = StrategyException.class)
	public void redScoutCannotMoveOntoPlayerWhenMovingMoreThanOneSpace()
			throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();

		controller.move(PieceType.SCOUT, loc43, loc46);
		assertTrue(true);
	}

	/**
	 * test that a blue scout cannot move onto a piece when attempting to move
	 * more than one space
	 * 
	 * @throws StrategyException
	 */
	@Test(expected = StrategyException.class)
	public void blueScoutCannotMoveOverPieceToValidEmptyLocation()
			throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();

		controller.move(PieceType.MINER, loc53, loc54);
		controller.move(PieceType.SCOUT, loc86, loc83);
		assertTrue(true);
	}

	/**
	 * makes sure scout cannot move a valid number of spaces more than one that
	 * is onto a chokepoint
	 * 
	 * @throws StrategyException
	 */
	@Test(expected = StrategyException.class)
	public void testRedScoutCannotMoveMoreThanOneSpaceOntoAChokepoint()
			throws StrategyException {
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();

		controller.move(PieceType.SCOUT, loc43, loc44);
		controller.move(PieceType.MARSHAL, loc16, loc15); // move random blue
															// piece
		controller.move(PieceType.SCOUT, loc44, loc64);
		assertTrue(true);
	}
	
	/**
	 * Make sure a first lt and lt are both defeated when a first lt attacks a lt
	 * when moving one space to attack
	 */
	@Test
	public void firstLtAttacksLtBothRemovedInStandardStrikeMove() throws StrategyException{
		swapTwoPiecesInStartConfiguration(PlayerColor.RED, loc80, loc53);//first lt -red
		swapTwoPiecesInStartConfiguration(PlayerColor.BLUE, loc79, loc56);//lt -blue
		
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		
		controller.move(PieceType.FIRST_LIEUTENANT, loc53, loc54); //move red first lt
		controller.move(PieceType.LIEUTENANT, loc56, loc55); //move blue lt.
		MoveResult result = controller.move(PieceType.FIRST_LIEUTENANT, loc54, loc55); //strike with red first lt.
		// Check that there is no battle winner
		assertNull(result.getBattleWinner());
		//Check there is no piece at the first lt's location
		assertNull(controller.getPieceAt(loc55));
		//Check there is no piece at the lt's location
		assertNull(controller.getPieceAt(loc54));
	}
	
	/**
	 * Make sure a first lt and lt are both defeated when a first lt attacks a lt
	 * when moving two spaces
	 */
	@Test
	public void firstLtAttacksLtBothRemovedInMoveTwoSpacesStrike() throws StrategyException{
		swapTwoPiecesInStartConfiguration(PlayerColor.RED, loc70, loc53);
		swapTwoPiecesInStartConfiguration(PlayerColor.BLUE, loc89, loc56);
		
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		
		controller.move(PieceType.LIEUTENANT, loc53, loc54); //move red lt
		MoveResult result = controller.move(PieceType.FIRST_LIEUTENANT, loc56, loc54); //strike with blue first lt.
	
		// Check that there is no battle winner
		assertNull(result.getBattleWinner());
		//Check there is no piece at the first lt's location
		assertNull(controller.getPieceAt(loc56));
		//Check there is no piece at the lt's location
		assertNull(controller.getPieceAt(loc53));
	}
	
	/**
	 * Makes sure a first lt cannot move 2 spaces to an empty space
	 */
	@Test(expected = StrategyException.class)
	public void firstLtMovesTwoSpacesToEmptySpaceIsNotAllowed() throws StrategyException{
		swapTwoPiecesInStartConfiguration(PlayerColor.RED, loc80, loc53);
		
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		
		//move red first lt. 2 spaces without attacking illegally
		controller.move(PieceType.FIRST_LIEUTENANT, loc53, loc55); 
		
		assertTrue(true);
	}
	
	/**
	 * Make sure a first lt cannot attack a piece two spaces away if there
	 * is a player in between the to & from locations
	 */
	@Test(expected = StrategyException.class)
	public void firstLtCannotMoveTwoSpacesToAttackIfAnotherPlayerIsInTheWay() throws StrategyException{
		swapTwoPiecesInStartConfiguration(PlayerColor.BLUE, loc89, loc47);
		
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		
		controller.move(PieceType.SCOUT, loc43, loc45); //move red scout up two
		controller.move(PieceType.FIRST_LIEUTENANT, loc47, loc45); //move blue first lt. two to attack scout
		
		assertTrue(true);
	}
	
	/**
	 * Makes sure a first lt wins if it attacks a miner two spaces away 
	 * & moves to the location of the miner and the miner is removed from the board
	 */
	@Test
	public void blueFirstLtStrikesRedMinerByMovingTwoSpaces() throws StrategyException{
		swapTwoPiecesInStartConfiguration(PlayerColor.BLUE, loc89, loc56);
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		
		controller.move(PieceType.MINER, loc53, loc54); //move red miner
		MoveResult result = controller.move(PieceType.FIRST_LIEUTENANT, loc56, loc54); //strike with blue first lt.
	
		// Check that the blue first lieutenant wins and takes the place 
		// of the red miner.
		assertEquals(new PieceLocationDescriptor(new Piece(PieceType.FIRST_LIEUTENANT,
				PlayerColor.BLUE), loc54), result.getBattleWinner());
		
		// Check that the game does not end.
		MoveResultStatus status = result.getStatus();
		assertEquals(MoveResultStatus.OK, status);
				
		// Check that the board has properly updated to reflect the post-battle
		// state.
		assertEquals(new Piece(PieceType.FIRST_LIEUTENANT,
				PlayerColor.BLUE), controller.getPieceAt(loc54));
		assertNull(controller.getPieceAt(loc56));

	}
	
	/**
	 * Makes sure the first lt loses if it attacks a marshal two spaces away
	 * Make sure the marshal's location stays the same & the first lt 
	 * is removed from the board
	 */
	@Test
	public void blueFirstLtAttacksRedMarshalAndLoses() throws StrategyException{
		swapTwoPiecesInStartConfiguration(PlayerColor.BLUE, loc89, loc06);
		
		StrategyGameController controller = factory.makeEpsilonStrategy(
				startingRedConfig, startingBlueConfig, observers);
		controller.startGame();
		
		controller.move(PieceType.MARSHAL, loc03, loc04);
		MoveResult result = controller.move(PieceType.FIRST_LIEUTENANT, loc06, loc04);
		
		// Check that the red marshal wins and but DOES NOT take the place 
		assertEquals(new PieceLocationDescriptor(new Piece(PieceType.MARSHAL,
						PlayerColor.RED), loc04), result.getBattleWinner());
	}

}
