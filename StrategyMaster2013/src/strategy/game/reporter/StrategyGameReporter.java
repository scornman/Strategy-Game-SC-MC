/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package strategy.game.reporter;

import java.util.Collection;

import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.MoveResult;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.common.PieceType;
import strategy.game.common.StrategyGameObserver;

public class StrategyGameReporter implements StrategyGameObserver{

	public StrategyGameReporter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * detect the gameStart to start observing
	 */
	@Override
	public void gameStart(Collection<PieceLocationDescriptor> redConfiguration,
			Collection<PieceLocationDescriptor> blueConfiguration) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * updates when a move happens
	 */
	@Override
	public void moveHappened(PieceType piece, Location from, Location to,
			MoveResult result, StrategyException fault) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Print the change
	 */
	public void print(){
		System.out.println("");
	}
	
}
