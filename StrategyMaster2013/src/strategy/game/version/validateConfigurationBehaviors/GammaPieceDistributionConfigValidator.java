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
 * 
 */
public class GammaPieceDistributionConfigValidator implements
		ValidateConfigurationBehavior {

	Collection<PieceLocationDescriptor> redConfiguration;
	Collection<PieceLocationDescriptor> blueConfiguration;

	/**
	 * Creates a new GammaPieceDistributionConfigValidator object.
	 * 
	 * @param redConfig
	 *            the starting configuration of red pieces to validate.
	 * @param blueConfig
	 *            the starting configuration of blue pieces to validate.
	 */
	public GammaPieceDistributionConfigValidator(
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

		// Get the expected pieces.
		final Collection<Piece> correctRedPieces = getCorrectRedPieces();

		// Ensure that the configuration has the correct number of each type
		// of piece.
		return containSamePieces(redPieces, correctRedPieces);
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

		// Get the expected pieces.
		final Collection<Piece> correctBluePieces = getCorrectBluePieces();

		// Ensure that the configuration has the correct number of each type
		// of piece.
		return containSamePieces(bluePieces, correctBluePieces);
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
		final Collection<Piece> pieces = new ArrayList<Piece>();
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
		final Collection<Piece> pieces = new ArrayList<Piece>();
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
			} else {
				return false;
			}
		}

		// At the end, if all items in the first list have found matches in the
		// second list, and the two lists are the same size, the lists must
		// contain the same pieces.
		return true;
	}

}
