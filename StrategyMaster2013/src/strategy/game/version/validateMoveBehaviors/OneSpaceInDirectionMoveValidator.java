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
import strategy.common.StrategyRuntimeException;
import strategy.game.common.Location;
import strategy.game.common.PieceType;
import strategy.game.version.ValidateMoveBehavior;

/**
 * Class OneSpaceInDirectionMoveValidator
 * piece cannot move more than one space at a time
 * @author Madalyn
 * @version 9/22/13
 *
 */
public class OneSpaceInDirectionMoveValidator implements ValidateMoveBehavior {

	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) {
		try {
			if (from.distanceTo(to) != 1) {
				return false;
			}
		} catch (StrategyRuntimeException e) {
			return false;
		}

		return true;
	}

}
