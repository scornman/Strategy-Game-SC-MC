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
import strategy.game.version.Board;
import strategy.game.version.ValidateMoveBehavior;

public class MovingOnTurnMoveValidator implements ValidateMoveBehavior{
	private Board gameBoard;
	
	public MovingOnTurnMoveValidator(Board gameBoard) {
		// TODO Auto-generated constructor stub
		this.gameBoard = gameBoard;
	}

	/**
	 * move is valid only if it is the player's turn
	 */
	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) {
		PlayerColor pieceColor = gameBoard.getPieceAt(from).getOwner();
		
		if(pieceColor != currentColor){
			return false;
		}
		return true;
	}

}
