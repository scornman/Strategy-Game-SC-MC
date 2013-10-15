/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package strategy.game.version.battleBehaviors;

import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.Piece;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.common.PieceType;
import strategy.game.version.Board;

/**
 * A class that deals with the battle behavior in the Epsilon
 * Version of Strategy Game. It extends Delta Battle Behavior and
 * adds on top of Delta Battle Behavior's functionality for special
 * battle behavior scenarios; specifically dealing with pieces that
 * can strike by moving two spaces at a time. 
 * 
 * @author Madalyn
 * @version 10/15/13
 *
 */
public class EpsilonBattleBehavior extends DeltaBattleBehavior {

	/**
	 * The constructor for EpsilonBattleBehavior
	 * @param gameBoard
	 */
	public EpsilonBattleBehavior(Board gameBoard) {
		super(gameBoard);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Determine which of two pieces wins the battle. if there is no piece
	 * defending the to location, the attacking piece wins if there are two of
	 * the same pieces in the battle, neither wins
	 * 
	 * @param attackPiece
	 *            the piece that is attacking.
	 * @param defendPiece
	 *            the piece that is defending.
	 * @return the piece that wins the battle.
	 * @throws StrategyException
	 */
	@Override
	public PieceLocationDescriptor getBattleWinner(Location fromLocation,
			Location toLocation) throws StrategyException {
		
		final PieceLocationDescriptor winner = super.getBattleWinner(fromLocation, toLocation);
		
		//if no battle winner
		if(winner == null){
			return null;
		}
		
		//if the piece attacks from two spaces away, the winner is always at the
		//defender's (or tolocation) location
		if(fromLocation.distanceTo(toLocation) == 2) {
			final PieceLocationDescriptor newWinner = new PieceLocationDescriptor(winner.getPiece(), toLocation);
			return newWinner;

		} else {
			return winner;
		}

	
	}

}
