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
	 * Setup method that runs before each test.
	 */
	@Before
	public void setUp() {
		factory = StrategyGameFactory.getInstance();
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
		StrategyGameController controller = setupValidBetaStrategyGameController();
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
		// Set up the starting configuration for the red pieces
		Collection<PieceLocationDescriptor> redConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> redPieces = new ArrayList<Piece>();
		ArrayList<Location> redLocations = new ArrayList<Location>();
		// Red flag
		redPieces.add(new Piece(PieceType.FLAG, PlayerColor.RED));
		redLocations.add(new Location2D(0, 0));
		// Red marshal
		// THIS IS THE LOCATION THAT IS INVALID
		redPieces.add(new Piece(PieceType.MARSHAL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 0));
		// Red colonels
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 2));
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 3));
		// Red captains
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(0, 4));
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(0, 5));
		// Red lieutenants
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 0));
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 1));
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 2));
		// Red sergeants
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 3));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 4));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 5));
		// Combine the pieces with their locations
		for (int i = 0; i < redPieces.size(); i++) {
			Piece iPiece = redPieces.get(i);
			Location iLocation = redLocations.get(i);
			redConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		// Set up the starting configuration for the blue pieces
		Collection<PieceLocationDescriptor> blueConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> bluePieces = new ArrayList<Piece>();
		ArrayList<Location> blueLocations = new ArrayList<Location>();
		// Blue flag
		bluePieces.add(new Piece(PieceType.FLAG, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 0));
		// Blue marshal
		bluePieces.add(new Piece(PieceType.MARSHAL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 1));
		// Blue colonels
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 2));
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 3));
		// Blue captains
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 4));
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 5));
		// Blue lieutenants
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 0));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 1));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 2));
		// Blue sergeants
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 3));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 4));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 5));
		// Combine the pieces with their locations
		for (int i = 0; i < bluePieces.size(); i++) {
			Piece iPiece = bluePieces.get(i);
			Location iLocation = blueLocations.get(i);
			blueConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		// Create the controller
		factory.makeBetaStrategyGame(redConfiguration, blueConfiguration);
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
		// Set up the starting configuration for the red pieces
		Collection<PieceLocationDescriptor> redConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> redPieces = new ArrayList<Piece>();
		ArrayList<Location> redLocations = new ArrayList<Location>();
		// Red flag
		redPieces.add(new Piece(PieceType.FLAG, PlayerColor.RED));
		redLocations.add(new Location2D(0, 0));
		// Red marshal
		redPieces.add(new Piece(PieceType.MARSHAL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 1));
		// Red colonels
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 2));
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 3));
		// Red captains
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(0, 4));
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(0, 5));
		// Red lieutenants
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 0));
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 1));
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 2));
		// Red sergeants
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 3));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 4));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 5));
		// Combine the pieces with their locations
		for (int i = 0; i < redPieces.size(); i++) {
			Piece iPiece = redPieces.get(i);
			Location iLocation = redLocations.get(i);
			redConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		// Set up the starting configuration for the blue pieces
		Collection<PieceLocationDescriptor> blueConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> bluePieces = new ArrayList<Piece>();
		ArrayList<Location> blueLocations = new ArrayList<Location>();
		// Blue flag
		bluePieces.add(new Piece(PieceType.FLAG, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 0));
		// Blue marshal
		bluePieces.add(new Piece(PieceType.MARSHAL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 1));
		// Blue colonels
		// THIS IS THE LOCATION THAT IS INVALID
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 4));
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 3));
		// Blue captains
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 4));
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 5));
		// Blue lieutenants
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 0));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 1));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 2));
		// Blue sergeants
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 3));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 4));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 5));
		// Combine the pieces with their locations
		for (int i = 0; i < bluePieces.size(); i++) {
			Piece iPiece = bluePieces.get(i);
			Location iLocation = blueLocations.get(i);
			blueConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		// Create the controller
		factory.makeBetaStrategyGame(redConfiguration, blueConfiguration);
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
		// Set up the starting configuration for the red pieces
		Collection<PieceLocationDescriptor> redConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> redPieces = new ArrayList<Piece>();
		ArrayList<Location> redLocations = new ArrayList<Location>();
		// Red flag
		redPieces.add(new Piece(PieceType.FLAG, PlayerColor.RED));
		redLocations.add(new Location2D(0, 0));
		// Red marshal
		redPieces.add(new Piece(PieceType.MARSHAL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 1));
		// Red colonels
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 2));
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 3));
		// Red captains
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(0, 4));
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(0, 5));
		// Red lieutenants
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 0));
		// THIS IS THE LOCATION THAT IS INVALID
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(3, 5));
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 2));
		// Red sergeants
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 3));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 4));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 5));
		// Combine the pieces with their locations
		for (int i = 0; i < redPieces.size(); i++) {
			Piece iPiece = redPieces.get(i);
			Location iLocation = redLocations.get(i);
			redConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		// Set up the starting configuration for the blue pieces
		Collection<PieceLocationDescriptor> blueConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> bluePieces = new ArrayList<Piece>();
		ArrayList<Location> blueLocations = new ArrayList<Location>();
		// Blue flag
		bluePieces.add(new Piece(PieceType.FLAG, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 0));
		// Blue marshal
		bluePieces.add(new Piece(PieceType.MARSHAL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 1));
		// Blue colonels
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 2));
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 3));
		// Blue captains
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 4));
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 5));
		// Blue lieutenants
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 0));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 1));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 2));
		// Blue sergeants
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 3));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 4));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 5));
		// Combine the pieces with their locations
		for (int i = 0; i < bluePieces.size(); i++) {
			Piece iPiece = bluePieces.get(i);
			Location iLocation = blueLocations.get(i);
			blueConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		// Create the controller
		factory.makeBetaStrategyGame(redConfiguration, blueConfiguration);
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
		// Set up the starting configuration for the red pieces
		Collection<PieceLocationDescriptor> redConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> redPieces = new ArrayList<Piece>();
		ArrayList<Location> redLocations = new ArrayList<Location>();
		// Red flag
		redPieces.add(new Piece(PieceType.FLAG, PlayerColor.RED));
		redLocations.add(new Location2D(0, 0));
		// Red marshal
		redPieces.add(new Piece(PieceType.MARSHAL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 1));
		// Red colonels
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 2));
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 3));
		// Red captains
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(0, 4));
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(0, 5));
		// Red lieutenants
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 0));
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 1));
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 2));
		// Red sergeants
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 3));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 4));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 5));
		// Combine the pieces with their locations
		for (int i = 0; i < redPieces.size(); i++) {
			Piece iPiece = redPieces.get(i);
			Location iLocation = redLocations.get(i);
			redConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		// Set up the starting configuration for the blue pieces
		Collection<PieceLocationDescriptor> blueConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> bluePieces = new ArrayList<Piece>();
		ArrayList<Location> blueLocations = new ArrayList<Location>();
		// Blue flag
		bluePieces.add(new Piece(PieceType.FLAG, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 0));
		// Blue marshal
		bluePieces.add(new Piece(PieceType.MARSHAL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 1));
		// Blue colonels
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 2));
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 3));
		// Blue captains
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 4));
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 5));
		// Blue lieutenants
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 0));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 1));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 2));
		// Blue sergeants
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 3));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 4));
		// THIS IS THE LOCATION THAT IS INVALID
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(1, 2));
		// Combine the pieces with their locations
		for (int i = 0; i < bluePieces.size(); i++) {
			Piece iPiece = bluePieces.get(i);
			Location iLocation = blueLocations.get(i);
			blueConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		// Create the controller
		factory.makeBetaStrategyGame(redConfiguration, blueConfiguration);
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
		// Set up the starting configuration for the red pieces
		Collection<PieceLocationDescriptor> redConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> redPieces = new ArrayList<Piece>();
		ArrayList<Location> redLocations = new ArrayList<Location>();
		// Red flag
		redPieces.add(new Piece(PieceType.FLAG, PlayerColor.RED));
		redLocations.add(new Location2D(0, 0));
		// Red marshal
		redPieces.add(new Piece(PieceType.MARSHAL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 1));
		// Red colonels
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 2));
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 3));
		// Red captains
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(0, 4));
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(0, 5));
		// Red lieutenants
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 0));
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 1));
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 2));
		// Red sergeants
		// THIS SHOULD FAIL BECAUSE THERE ARE NOT ENOUGH RED SERGEANTS
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 3));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 5));
		// Combine the pieces with their locations
		for (int i = 0; i < redPieces.size(); i++) {
			Piece iPiece = redPieces.get(i);
			Location iLocation = redLocations.get(i);
			redConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		// Set up the starting configuration for the blue pieces
		Collection<PieceLocationDescriptor> blueConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> bluePieces = new ArrayList<Piece>();
		ArrayList<Location> blueLocations = new ArrayList<Location>();
		// Blue flag
		bluePieces.add(new Piece(PieceType.FLAG, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 0));
		// Blue marshal
		bluePieces.add(new Piece(PieceType.MARSHAL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 1));
		// Blue colonels
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 2));
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 3));
		// Blue captains
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 4));
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 5));
		// Blue lieutenants
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 0));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 1));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 2));
		// Blue sergeants
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 3));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 4));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 5));
		// Combine the pieces with their locations
		for (int i = 0; i < bluePieces.size(); i++) {
			Piece iPiece = bluePieces.get(i);
			Location iLocation = blueLocations.get(i);
			blueConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		// Create the controller
		factory.makeBetaStrategyGame(redConfiguration, blueConfiguration);
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
		// Set up the starting configuration for the red pieces
		Collection<PieceLocationDescriptor> redConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> redPieces = new ArrayList<Piece>();
		ArrayList<Location> redLocations = new ArrayList<Location>();
		// Red flag
		redPieces.add(new Piece(PieceType.FLAG, PlayerColor.RED));
		redLocations.add(new Location2D(0, 0));
		// Red marshal
		redPieces.add(new Piece(PieceType.MARSHAL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 1));
		// Red colonels
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 2));
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 3));
		// Red captains
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(0, 4));
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(0, 5));
		// Red lieutenants
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 0));
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 1));
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 2));
		// Red sergeants
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 3));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 4));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 5));
		// Combine the pieces with their locations
		for (int i = 0; i < redPieces.size(); i++) {
			Piece iPiece = redPieces.get(i);
			Location iLocation = redLocations.get(i);
			redConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		// Set up the starting configuration for the blue pieces
		Collection<PieceLocationDescriptor> blueConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> bluePieces = new ArrayList<Piece>();
		ArrayList<Location> blueLocations = new ArrayList<Location>();
		// Blue flag
		bluePieces.add(new Piece(PieceType.FLAG, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 0));
		// THIS SHOULD FAIL BECAUSE THERE IS NO BLUE MARSHALL
		// Blue colonels
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 2));
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 3));
		// Blue captains
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 4));
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 5));
		// Blue lieutenants
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 0));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 1));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 2));
		// Blue sergeants
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 3));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 4));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 5));
		// Combine the pieces with their locations
		for (int i = 0; i < bluePieces.size(); i++) {
			Piece iPiece = bluePieces.get(i);
			Location iLocation = blueLocations.get(i);
			blueConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		// Create the controller
		factory.makeBetaStrategyGame(redConfiguration, blueConfiguration);
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
		// Set up the starting configuration for the red pieces
		Collection<PieceLocationDescriptor> redConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> redPieces = new ArrayList<Piece>();
		ArrayList<Location> redLocations = new ArrayList<Location>();
		// Red flag
		redPieces.add(new Piece(PieceType.FLAG, PlayerColor.RED));
		redLocations.add(new Location2D(0, 0));
		// Red marshal
		redPieces.add(new Piece(PieceType.MARSHAL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 1));
		// Red colonels
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 2));
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 3));
		// Red captains
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(0, 4));
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(0, 5));
		// Red lieutenants
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 0));
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 1));
		// THIS SHOULD FAIL BECAUSE THERE IS 1 FEWER RED LIEUTENANT AND 1 MORE
		// RED COLONEL THAN EXPECTED.
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(1, 2));
		// Red sergeants
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 3));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 4));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 5));
		// Combine the pieces with their locations
		for (int i = 0; i < redPieces.size(); i++) {
			Piece iPiece = redPieces.get(i);
			Location iLocation = redLocations.get(i);
			redConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		// Set up the starting configuration for the blue pieces
		Collection<PieceLocationDescriptor> blueConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> bluePieces = new ArrayList<Piece>();
		ArrayList<Location> blueLocations = new ArrayList<Location>();
		// Blue flag
		bluePieces.add(new Piece(PieceType.FLAG, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 0));
		// Blue marshal
		bluePieces.add(new Piece(PieceType.MARSHAL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 1));
		// Blue colonels
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 2));
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 3));
		// Blue captains
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 4));
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 5));
		// Blue lieutenants
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 0));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 1));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 2));
		// Blue sergeants
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 3));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 4));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 5));
		// Combine the pieces with their locations
		for (int i = 0; i < bluePieces.size(); i++) {
			Piece iPiece = bluePieces.get(i);
			Location iLocation = blueLocations.get(i);
			blueConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		// Create the controller
		factory.makeBetaStrategyGame(redConfiguration, blueConfiguration);
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
		// Set up the starting configuration for the red pieces
		Collection<PieceLocationDescriptor> redConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> redPieces = new ArrayList<Piece>();
		ArrayList<Location> redLocations = new ArrayList<Location>();
		// Red flag
		redPieces.add(new Piece(PieceType.FLAG, PlayerColor.RED));
		redLocations.add(new Location2D(0, 0));
		// Red marshal
		redPieces.add(new Piece(PieceType.MARSHAL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 1));
		// Red colonels
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 2));
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 3));
		// Red captains
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(0, 4));
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(0, 5));
		// Red lieutenants
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 0));
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 1));
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 2));
		// Red sergeants
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 3));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 4));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 5));
		// Combine the pieces with their locations
		for (int i = 0; i < redPieces.size(); i++) {
			Piece iPiece = redPieces.get(i);
			Location iLocation = redLocations.get(i);
			redConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		// Set up the starting configuration for the blue pieces
		Collection<PieceLocationDescriptor> blueConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> bluePieces = new ArrayList<Piece>();
		ArrayList<Location> blueLocations = new ArrayList<Location>();
		// Blue flag
		bluePieces.add(new Piece(PieceType.FLAG, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 0));
		// Blue marshal
		bluePieces.add(new Piece(PieceType.MARSHAL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 1));
		// Blue colonels
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 2));
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 3));
		// Blue captains
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 4));
		// THIS SHOULD FAIL BECAUSE THERE IS 1 FEWER RED CAPTAIN AND 1 MORE
		// RED MAJOR THAN EXPECTED.
		bluePieces.add(new Piece(PieceType.MAJOR, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 5));
		// Blue lieutenants
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 0));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 1));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 2));
		// Blue sergeants
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 3));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 4));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 5));
		// Combine the pieces with their locations
		for (int i = 0; i < bluePieces.size(); i++) {
			Piece iPiece = bluePieces.get(i);
			Location iLocation = blueLocations.get(i);
			blueConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		// Create the controller
		factory.makeBetaStrategyGame(redConfiguration, blueConfiguration);
	}

	/**
	 * Helper function for setting up a game controller with a fixed, valid
	 * starting configuration
	 * 
	 * @return the new BetaStrategyGameController
	 * @throws StrategyException
	 *             if the controller is not properly set up.
	 */
	public StrategyGameController setupValidBetaStrategyGameController()
			throws StrategyException {
		// Set up the starting configuration for the red pieces
		Collection<PieceLocationDescriptor> redConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> redPieces = new ArrayList<Piece>();
		ArrayList<Location> redLocations = new ArrayList<Location>();
		// Red flag
		redPieces.add(new Piece(PieceType.FLAG, PlayerColor.RED));
		redLocations.add(new Location2D(0, 0));
		// Red marshal
		redPieces.add(new Piece(PieceType.MARSHAL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 1));
		// Red colonels
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 2));
		redPieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		redLocations.add(new Location2D(0, 3));
		// Red captains
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(0, 4));
		redPieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		redLocations.add(new Location2D(0, 5));
		// Red lieutenants
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 0));
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 1));
		redPieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 2));
		// Red sergeants
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 3));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 4));
		redPieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		redLocations.add(new Location2D(1, 5));
		// Combine the pieces with their locations
		for (int i = 0; i < redPieces.size(); i++) {
			Piece iPiece = redPieces.get(i);
			Location iLocation = redLocations.get(i);
			redConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		// Set up the starting configuration for the blue pieces
		Collection<PieceLocationDescriptor> blueConfiguration = new ArrayList<PieceLocationDescriptor>();
		ArrayList<Piece> bluePieces = new ArrayList<Piece>();
		ArrayList<Location> blueLocations = new ArrayList<Location>();
		// Blue flag
		bluePieces.add(new Piece(PieceType.FLAG, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 0));
		// Blue marshal
		bluePieces.add(new Piece(PieceType.MARSHAL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 1));
		// Blue colonels
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 2));
		bluePieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 3));
		// Blue captains
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 4));
		bluePieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		blueLocations.add(new Location2D(5, 5));
		// Blue lieutenants
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 0));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 1));
		bluePieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 2));
		// Blue sergeants
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 3));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 4));
		bluePieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		blueLocations.add(new Location2D(4, 5));
		// Combine the pieces with their locations
		for (int i = 0; i < bluePieces.size(); i++) {
			Piece iPiece = bluePieces.get(i);
			Location iLocation = blueLocations.get(i);
			blueConfiguration
					.add(new PieceLocationDescriptor(iPiece, iLocation));
		}

		// Create the controller
		StrategyGameController controller = factory.makeBetaStrategyGame(
				redConfiguration, blueConfiguration);
		return controller;
	}

}
