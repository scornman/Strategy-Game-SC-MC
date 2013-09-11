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
import strategy.game.common.Piece;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.common.PieceType;

/**
 * Implements the game core for the Beta Strategy version.
 * 
 * @author scornman
 * @version Sep 11, 2013
 * 
 */
public class BetaStrategyGameController implements StrategyGameController {

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
		if (!configurationsValid(redConfiguration, blueConfiguration)) {
			throw new StrategyException("Invalid Starting Configuration");
		}
	}

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
			if (xCoord >= 0 && xCoord <= 1 && yCoord >= 0 && yCoord <= 5) {
				return true;
			} else {
				return false;
			}
		case BLUE:
			if (xCoord >= 4 && xCoord <= 5 && yCoord >= 0 && yCoord <= 5) {
				return true;
			} else {
				return false;
			}
		default:
			return false;
		}

	}

	@Override
	public void startGame() throws StrategyException {
		// TODO Auto-generated method stub

	}

	@Override
	public MoveResult move(PieceType piece, Location from, Location to)
			throws StrategyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Piece getPieceAt(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

}
