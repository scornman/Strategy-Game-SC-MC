/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package strategy.game.version.turnUpdateBehaviors;

import strategy.common.PlayerColor;

import strategy.game.version.TurnUpdateBehavior;

/**
 * implmentation of the TurnUpdate via AlternateTeamTurnBehavior
 * @author Madalyn
 * @version 9/22/13
 *
 */
public class AlternateTeamTurnBehavior implements TurnUpdateBehavior{

	@Override
	public PlayerColor updateTurn(PlayerColor currentColor) {		
		if (currentColor == PlayerColor.RED){
			currentColor = PlayerColor.BLUE;
		}else{
			currentColor = PlayerColor.RED;
		}
		return currentColor;
	}

}
