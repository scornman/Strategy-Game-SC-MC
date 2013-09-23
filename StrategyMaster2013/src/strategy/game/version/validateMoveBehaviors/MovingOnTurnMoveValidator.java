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
 * Class MovingOnTurnMoveValidator
 * make sure player only moves when it's their turn
 * @author Madalyn
 * @version 9/22/13
 *
 */
public class MovingOnTurnMoveValidator implements ValidateMoveBehavior{
	private final Board gameBoard;
	
	/**
	 * Constructor for MovingOnTurnMoveValidator
	 * @param gameBoard for all pieces
	 */
	public MovingOnTurnMoveValidator(Board gameBoard) {
		// TODO Auto-generated constructor stub
		this.gameBoard = gameBoard;
	}

	/**
	 * move is valid only if it is the player's turn
	 * @throws StrategyException if one of the locations given is not a valid location on the board.
	 */
	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) throws StrategyException {
		final PlayerColor pieceColor = gameBoard.getPieceAt(from).getOwner();
		
		if(pieceColor != currentColor){
			return false;
		}
		return true;
	}

}
