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

/**
 * The StrategyGameObservable Interface
 * @author Gary Pollice
 * @author Madalyn
 * @version 10/15/13
 *
 */
public interface StrategyGameObservable {

	/**
	 * Registers an observer with this observable.
	 * 
	 * @param observer
	 *            the new observer to register with the observable.
	 */
	// Registers an observer
	void register(StrategyGameObserver observer);

	/**
	 * Unregisters an observer with this observable.
	 * 
	 * @param observer
	 *            the observer to unregister with the observable.
	 */
	// Removes an observer
	void unregister(StrategyGameObserver observer);

}
