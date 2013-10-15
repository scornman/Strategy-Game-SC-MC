/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package strategy.game.version.validateConfigurationBehaviors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import strategy.common.PlayerColor;
import strategy.game.common.Piece;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.common.PieceType;
import strategy.game.version.ValidateConfigurationBehavior;

/**
 * Configuration validator that checks whether the starting configurations of
 * the red and blue players both contain the correct number of each type of
 * piece.
 * 
 * @author scornman
 * @version 9/22/13
 * 
 */
public class EpsilonPieceDistributionConfigValidator implements
		ValidateConfigurationBehavior {

	Collection<PieceLocationDescriptor> redConfiguration;
	Collection<PieceLocationDescriptor> blueConfiguration;

	/**
	 * Creates a new EpsilonPieceDistributionConfigValidator object.
	 * 
	 * @param redConfig
	 *            the starting configuration of red pieces to validate.
	 * @param blueConfig
	 *            the starting configuration of blue pieces to validate.
	 */
	public EpsilonPieceDistributionConfigValidator(
			Collection<PieceLocationDescriptor> redConfig,
			Collection<PieceLocationDescriptor> blueConfig) {
		redConfiguration = redConfig;
		blueConfiguration = blueConfig;
	}

	/**
	 * Returns true if the starting configurations of the red and blue players
	 * both contain the correct number of each type of piece, false otherwise.
	 */
	@Override
	public boolean isConfigurationValid() {
		return doesRedConfigContainCorrectPieces()
				&& doesBlueConfigContainCorrectPieces();
	}

	/**
	 * Checks whether the red configuration contains the correct number of each
	 * type of piece.
	 * 
	 * @return true if the red configuration contains the correct number of each
	 *         type of piece, false otherwise.
	 */
	private boolean doesRedConfigContainCorrectPieces() {
		// First, extract the Piece objects from the PieceLocationDescriptor
		// objects.
		final Collection<Piece> redPieces = new ArrayList<Piece>();
		for (PieceLocationDescriptor iPieceLocationDescriptor : redConfiguration) {
			redPieces.add(iPieceLocationDescriptor.getPiece());
		}

		// Ensure that the configuration has 2 flag pieces.
		if (!containsTwoFlags(redPieces, PlayerColor.RED)) {
			return false;
		}

		// Get the expected pieces.
		final Collection<Piece> correctRedPieces = getCorrectRedPieces();

		// Ensure that the configuration has the correct number of each type
		// of piece, with one piece replaced.
		return containSamePiecesExceptOne(redPieces, correctRedPieces);
	}

	/**
	 * Checks whether the blue configuration contains the correct number of each
	 * type of piece.
	 * 
	 * @return true if the blue configuration contains the correct number of
	 *         each type of piece, false otherwise.
	 */
	private boolean doesBlueConfigContainCorrectPieces() {
		// First, extract the Piece objects from the PieceLocationDescriptor
		// objects.
		final Collection<Piece> bluePieces = new ArrayList<Piece>();
		for (PieceLocationDescriptor iPieceLocationDescriptor : blueConfiguration) {
			bluePieces.add(iPieceLocationDescriptor.getPiece());
		}

		// Ensure that the configuration has 2 flag pieces.
		if (!containsTwoFlags(bluePieces, PlayerColor.BLUE)) {
			return false;
		}

		// Get the expected pieces.
		final Collection<Piece> correctBluePieces = getCorrectBluePieces();

		// Ensure that the configuration has the correct number of each type
		// of piece, with one piece replaced.
		return containSamePiecesExceptOne(bluePieces, correctBluePieces);
	}

	/**
	 * Private helper method that constructs the expected list of pieces in the
	 * red configuration, in no particular order. Used to verify that a given
	 * initial board configuration is valid.
	 * 
	 * @return a collection containing all of the pieces that the red player
	 *         should begin the game with.
	 */
	private static Collection<Piece> getCorrectRedPieces() {
		final Collection<Piece> pieces = new ArrayList<Piece>();
		pieces.add(new Piece(PieceType.SPY, PlayerColor.RED));
		pieces.add(new Piece(PieceType.SCOUT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.SCOUT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.SCOUT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.SCOUT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.SCOUT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.SCOUT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.SCOUT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.SCOUT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.MINER, PlayerColor.RED));
		pieces.add(new Piece(PieceType.MINER, PlayerColor.RED));
		pieces.add(new Piece(PieceType.MINER, PlayerColor.RED));
		pieces.add(new Piece(PieceType.MINER, PlayerColor.RED));
		pieces.add(new Piece(PieceType.MINER, PlayerColor.RED));
		pieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.SERGEANT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.FIRST_LIEUTENANT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.FIRST_LIEUTENANT, PlayerColor.RED));
		pieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		pieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		pieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		pieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.RED));
		pieces.add(new Piece(PieceType.MAJOR, PlayerColor.RED));
		pieces.add(new Piece(PieceType.MAJOR, PlayerColor.RED));
		pieces.add(new Piece(PieceType.MAJOR, PlayerColor.RED));
		pieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		pieces.add(new Piece(PieceType.COLONEL, PlayerColor.RED));
		pieces.add(new Piece(PieceType.GENERAL, PlayerColor.RED));
		pieces.add(new Piece(PieceType.MARSHAL, PlayerColor.RED));
		pieces.add(new Piece(PieceType.BOMB, PlayerColor.RED));
		pieces.add(new Piece(PieceType.BOMB, PlayerColor.RED));
		pieces.add(new Piece(PieceType.BOMB, PlayerColor.RED));
		pieces.add(new Piece(PieceType.BOMB, PlayerColor.RED));
		pieces.add(new Piece(PieceType.BOMB, PlayerColor.RED));
		pieces.add(new Piece(PieceType.BOMB, PlayerColor.RED));
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
	private static Collection<Piece> getCorrectBluePieces() {
		final Collection<Piece> pieces = new ArrayList<Piece>();
		pieces.add(new Piece(PieceType.SPY, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.SCOUT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.SCOUT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.SCOUT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.SCOUT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.SCOUT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.SCOUT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.SCOUT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.SCOUT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.MINER, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.MINER, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.MINER, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.MINER, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.MINER, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.SERGEANT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.LIEUTENANT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.FIRST_LIEUTENANT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.FIRST_LIEUTENANT, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.CAPTAIN, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.MAJOR, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.MAJOR, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.MAJOR, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.COLONEL, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.GENERAL, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.MARSHAL, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.BOMB, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.BOMB, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.BOMB, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.BOMB, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.BOMB, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.BOMB, PlayerColor.BLUE));
		pieces.add(new Piece(PieceType.FLAG, PlayerColor.BLUE));
		return pieces;
	}

	/**
	 * Determines whether the given set of pieces contains two flags of the
	 * appropriate color.
	 * 
	 * @param configuration
	 *            the set of pieces to examine.
	 * @param color
	 *            the color corresponding to this configuration.
	 * @return true if the configuration contains exactly two flags, false
	 *         otherwise.
	 */
	private boolean containsTwoFlags(Collection<Piece> configuration,
			PlayerColor color) {
		// Copy the pieces to a new list so that the old piece collection is not
		// modified.
		final List<Piece> pieces = new ArrayList<Piece>();
		for (Piece iPiece : configuration) {
			pieces.add(iPiece);
		}

		// Create a flag object to search for
		final Piece flagPiece = new Piece(PieceType.FLAG, color);

		// Find the first flag and remove it
		if (pieces.contains(flagPiece)) {
			pieces.remove(flagPiece);
		} else {
			// There are no flags
			return false;
		}

		// Ensure that there is at least 1 remaining flag
		if(pieces.contains(flagPiece)) {
			// Remove the flag
			pieces.remove(flagPiece);
			// There must now be no flags left
			return !pieces.contains(flagPiece);
		} else {
			// There was only 1 flag total
			return false;
		}
	}

	/**
	 * Helper method that checks whether two collections of pieces contain the
	 * same number of each piece, with the exception of one difference. The two
	 * collections must still contain the same total number of pieces.
	 * 
	 * @param pieces1
	 *            the first list of pieces to compare.
	 * @param pieces2
	 *            the second list of pieces to compare.
	 * @return true if the
	 */
	private static boolean containSamePiecesExceptOne(
			Collection<Piece> pieces1, Collection<Piece> pieces2) {

		// Keeps track of whether the one allowable difference between the
		// configurations has been found.
		boolean differenceFound = false;

		// Ensure that the two collections have the correct number of pieces.
		if (pieces1.size() != pieces2.size()) {
			return false;
		}

		// Copy the pieces to new lists so that the old piece collections are
		// not modified.
		final List<Piece> p1 = new ArrayList<Piece>();
		final List<Piece> p2 = new ArrayList<Piece>();
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
			} else if (!differenceFound) {
				// This is the one difference.
				differenceFound = true;
			} else {
				// There are at least two difference, which is not allowed.
				return false;
			}
		}

		if (!differenceFound) {
			// The lists must not be exactly the same.
			return false;
		} else {
			// At the end, if all items in the first list except one have found
			// matches in the second list, and the two lists are the same size,
			// the lists must contain the same pieces except for one.
			return true;
		}

	}

}
