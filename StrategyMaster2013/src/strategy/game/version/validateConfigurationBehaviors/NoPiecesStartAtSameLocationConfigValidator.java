package strategy.game.version.validateConfigurationBehaviors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import strategy.common.PlayerColor;
import strategy.game.common.Coordinate;
import strategy.game.common.Location;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.version.ValidateConfigurationBehavior;

/**
 * Configuration validator that checks whether any pieces in the starting
 * configurations start in the same locations on the board.
 * 
 * @author scornman
 * 
 */
public class NoPiecesStartAtSameLocationConfigValidator implements
		ValidateConfigurationBehavior {

	// Uses a single collection for all pieces, independent of color, so that
	// this will work for games involving different colors of pieces.
	Collection<PieceLocationDescriptor> totalConfiguration;

	/**
	 * Creates a new GammaStartLocationsConfigValidator object.
	 * 
	 * @param totalConfig
	 *            the starting configuration of all pieces to validate.
	 */
	public NoPiecesStartAtSameLocationConfigValidator(
			Collection<PieceLocationDescriptor> totalConfig) {
		totalConfiguration = totalConfig;
	}

	@Override
	public boolean isConfigurationValid() {
		// List of all locations already occupied. Used to ensure that two
		// pieces never start in the same location.
		final List<Location> alreadyOccupiedLocations = new ArrayList<Location>();

		for (PieceLocationDescriptor iPLC : totalConfiguration) {
			Location pieceLocation = iPLC.getLocation();

			// Ensure that no two pieces are in the same location.
			if (alreadyOccupiedLocations.contains(pieceLocation)) {
				return false;
			}
			// Add this new location to the occupied locations list.
			alreadyOccupiedLocations.add(pieceLocation);
		}
		
		return true;
	}

}
