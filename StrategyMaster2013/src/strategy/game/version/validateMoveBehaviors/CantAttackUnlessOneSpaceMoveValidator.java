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

import strategy.common.PlayerColor;
import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.PieceType;
import strategy.game.version.Board;
import strategy.game.version.ValidateMoveBehavior;

/**
 * A class, specifically for the piece type of Scout
 * that makes sure a piece cannot make an attack when moving
 * move than one space.  With this class, if a piece is moving
 * multiple spaces, it cannot end on a space with a piece
 * 
 * @author Madalyn
 * @version 10/15/13
 *
 */
public class CantAttackUnlessOneSpaceMoveValidator implements ValidateMoveBehavior {

	private final Board gameBoard;

	/**
	 * The constructor for the CantAttackUnlessOneSpaceMoveValidator class
	 * @param gameBoard
	 */
	public CantAttackUnlessOneSpaceMoveValidator(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) {
		try {
			// Move is valid if the moving piece is either moving one space, or
			// is not attacking. The piece may not both move more than one space
			// and attack.
			return (gameBoard.getPieceAt(to) == null)
					|| (from.distanceTo(to) == 1);
		} catch (StrategyException e) {
			return false;
		}
	}

}
