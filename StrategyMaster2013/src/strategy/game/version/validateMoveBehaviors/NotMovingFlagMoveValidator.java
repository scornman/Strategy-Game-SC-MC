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
import strategy.game.common.Location;
import strategy.game.common.PieceType;
import strategy.game.version.ValidateMoveBehavior;

/**
 * Class for NotMovingFlagMoveValidator
 * doesn't allow player to move unmoveable flag
 * @author Madalyn
 * @version 9/22/13
 *
 */
public class NotMovingFlagMoveValidator implements ValidateMoveBehavior {

	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) {
		// TODO Auto-generated method stub
		if (piece == PieceType.FLAG) {
			return false;
		}
		return true;
	}

}
