/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package strategy.game.common;

import java.util.Collection;

import strategy.common.StrategyException;

/**
 * The StrategyGameObserver Interface
 * @author Gary Pollice
 * @author Madalyn
 * @version 10/15/13
 *
 */
public interface StrategyGameObserver {

	 /**
	  * Initializes the observer to the state at the start of the game.
	  * @param redConfiguration the starting configuration of red pieces.
	  * @param blueConfiguration the starting configuration of blue pieces.
	  */
	 // Called at the beginning of the game with the initial 
	 // configurations. 
	 void gameStart( 
			 Collection<PieceLocationDescriptor> redConfiguration, 
			 Collection<PieceLocationDescriptor> blueConfiguration); 
	 
	 /**
	  * update method for the observer called whenever a move is made.
	  * @param piece the type of the piece that is moved.
	  * @param from the location moved from.
	  * @param to the location moved to.
	  * @param result the result of the move.
	  * @param fault the error thrown when attempting to execute the move, if any.
	  */
	 // Called whenever a move is made by the game controller. If 
	 // the controller caught an exception, it returns null for the 
	 // result, but the exception in the fault; otherwise, fault 
	 // is null. 
	 void moveHappened(PieceType piece, Location from, Location to,  MoveResult result, StrategyException fault); 
	 
}
