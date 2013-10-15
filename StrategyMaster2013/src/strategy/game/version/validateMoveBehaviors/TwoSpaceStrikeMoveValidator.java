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

public class TwoSpaceStrikeMoveValidator implements ValidateMoveBehavior {
	
	private final Board gameBoard;

	public TwoSpaceStrikeMoveValidator(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) {
		try {
			//allowed to move one space, this is just a normal move
			if (from.distanceTo(to) == 1) {
				return true;
			}
			//cannot move to an empty space if moving more than one space
			if (gameBoard.getPieceAt(to) == null) {
				return false;
			}
			//cannot move more than 2 spaces at a time
			if (from.distanceTo(to) > 2) {
				return false;
			}
		} catch(StrategyException e) {
			return false;
		}
		return true;
	}

}
