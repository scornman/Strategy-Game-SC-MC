package strategy.game.version.validateConfigurationBehaviors;

import java.util.Collection;

import strategy.common.PlayerColor;
import strategy.game.common.Coordinate;
import strategy.game.common.Location;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.version.ValidateConfigurationBehavior;

/**
 * Configuration validator that checks whether the pieces in the red and blue
 * starting configurations are all in valid starting locations for their
 * respective colors.
 * 
 * @author scornman
 * 
 */
public class GammaStartLocationsConfigValidator implements
		ValidateConfigurationBehavior {

	Collection<PieceLocationDescriptor> redConfiguration;
	Collection<PieceLocationDescriptor> blueConfiguration;

	/**
	 * Creates a new GammaStartLocationsConfigValidator object.
	 * 
	 * @param redConfig
	 *            the starting configuration of red pieces to validate.
	 * @param blueConfig
	 *            the starting configuration of blue pieces to validate.
	 */
	public GammaStartLocationsConfigValidator(
			Collection<PieceLocationDescriptor> redConfig,
			Collection<PieceLocationDescriptor> blueConfig) {
		redConfiguration = redConfig;
		blueConfiguration = blueConfig;
	}

	@Override
	public boolean isConfigurationValid() {
		return areRedPiecesInValidLocations()
				&& areBluePiecesInValidLocations();
	}

	/**
	 * Determines whether the pieces in the starting red configuration are in
	 * valid starting locations for red.
	 * 
	 * @return true if the pieces in the starting red configuration are in valid
	 *         starting locations for red, false otherwise.
	 */
	private boolean areRedPiecesInValidLocations() {
		for (PieceLocationDescriptor iRedPLC : redConfiguration) {
			Location iRedLocation = iRedPLC.getLocation();
			// Each piece must be in a valid starting location for red.
			if (!isValidStartingLocation(iRedLocation, PlayerColor.RED)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Determines whether the pieces in the starting blue configuration are in
	 * valid starting locations for blue.
	 * 
	 * @return true if the pieces in the starting blue configuration are in
	 *         valid starting locations for blue, false otherwise.
	 */
	private boolean areBluePiecesInValidLocations() {
		// Check that the starting configuration is valid for blue pieces.
		for (PieceLocationDescriptor iBluePLC : blueConfiguration) {
			Location iBlueLocation = iBluePLC.getLocation();
			// Each piece must be in a valid starting location for blue.
			if (!isValidStartingLocation(iBlueLocation, PlayerColor.BLUE)) {
				return false;
			}
		}
		
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
		final int xCoord = startLocation.getCoordinate(Coordinate.X_COORDINATE);
		final int yCoord = startLocation.getCoordinate(Coordinate.Y_COORDINATE);
		switch (color) {
		case RED:
			return (xCoord >= 0 && xCoord <= 5 && yCoord >= 0 && yCoord <= 1);
		case BLUE:
			return (xCoord >= 0 && xCoord <= 5 && yCoord >= 4 && yCoord <= 5);
		default:
			return false;
		}

	}

}
