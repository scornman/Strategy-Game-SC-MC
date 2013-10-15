/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package strategy.game.version.validateMoveBehaviors;

import java.util.ArrayList;
import java.util.List;

import strategy.common.PlayerColor;
import strategy.common.StrategyException;
import strategy.common.StrategyRuntimeException;
import strategy.game.common.Coordinate;
import strategy.game.common.Location;
import strategy.game.common.Location2D;
import strategy.game.common.PieceType;
import strategy.game.version.Board;
import strategy.game.version.ValidateMoveBehavior;

/**
 *  A validateMoveBehavior that deals with pieces that can move
 *  more than one space at a time, namely, the Scout
 * 
 * @author scornman
 * @author Madalyn
 * @version Oct 7, 2013
 * 
 */
public class SeveralSpacesInOneDirectionMoveValidator implements
		ValidateMoveBehavior {
	private final Board gameBoard;

	/**
	 * Constructor for SeveralSpacesInOneDirectionMoveValidator
	 * 
	 * @param gameBoard
	 *            must take-in game board to determine if moving over spaces
	 *            with pieces on them & violating rules
	 */
	public SeveralSpacesInOneDirectionMoveValidator(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) {

		// if only moving one space in a single direction, the move is
		// automatically valid.
		try {
			if (from.distanceTo(to) == 1) {
				return true;
			}
		} catch (StrategyRuntimeException e) {
			return false;
		}

		// moving more than one space, special functionality
		final Coordinate changingCoordinate = getChangingCoordinate(from, to);

		// if null throw exception, otherwise call other method with correct
		// params
		if (changingCoordinate == null) {
			return false;
		}

		return (isMovingNotOverOtherPieces(from, to, changingCoordinate));
	}

	/**
	 * Makes sure the piece [Scout or 1st Lt] is trying to move somewhere in the same line
	 * Check that either the x coords are the same or the y coords are the same
	 * 
	 * @param from
	 *            starting piece location
	 * @param to
	 *            ending location piece is moving to
	 * @return Coordinate that is changing if moving in the same line (to get
	 *         direction of movement) otherwise return null for an error
	 */
	private Coordinate getChangingCoordinate(Location from, Location to) {
		// if x coords are the same, then is moving in the y direction
		if (from.getCoordinate(Coordinate.X_COORDINATE) == to
				.getCoordinate(Coordinate.X_COORDINATE)) {
			return Coordinate.Y_COORDINATE;
			// if y coords are the same, then is moving in the x direction
		} else if (from.getCoordinate(Coordinate.Y_COORDINATE) == to
				.getCoordinate(Coordinate.Y_COORDINATE)) {
			return Coordinate.X_COORDINATE;
			// otherwise, is moving to an invalid location
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param from
	 * @param to
	 * @param changingCoordinate
	 * @return
	 */
	private boolean isMovingNotOverOtherPieces(Location from, Location to,
			Coordinate changingCoordinate) {
		final List<Location> coordinatePairs = new ArrayList<Location>();
		final int endCoordinate = to.getCoordinate(changingCoordinate);
		final int startCoordinate = from.getCoordinate(changingCoordinate);
		int lowCoordinate;
		int highCoordinate;

		if (endCoordinate > startCoordinate) {
			highCoordinate = endCoordinate;
			lowCoordinate = startCoordinate + 1;
		} else {
			highCoordinate = startCoordinate - 1;
			lowCoordinate = endCoordinate;
		}

		if (changingCoordinate == Coordinate.Y_COORDINATE) {
			for (int i = lowCoordinate+1; i <= highCoordinate; i++) {
				coordinatePairs.add(new Location2D(from
						.getCoordinate(Coordinate.X_COORDINATE), i));
			}
		} else {
			for (int i = lowCoordinate+1; i <= highCoordinate; i++) {
				coordinatePairs.add(new Location2D(i, from
						.getCoordinate(Coordinate.Y_COORDINATE)));
			}
		}

		for (int i = 0; i < coordinatePairs.size(); i++) {
			try {
				if (gameBoard.getPieceAt(coordinatePairs.get(i)) != null) {
					return false;
				}
				// if the piece tries to move over an invalid space on the board
				// (choke point)
			} catch (StrategyException e) {
				return false;
			}
		}

		return true;
	}

}
