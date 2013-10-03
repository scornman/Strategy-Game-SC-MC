/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package strategy.game.version.delta;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import strategy.game.*;
import strategy.common.*;
import strategy.game.common.*;

/**
 * Test cases for testing the BetaStrategyGameController class and the overall
 * functionality of the Beta Strategy Game.
 * 
 * @author scornman
 * @author Madalyn
 * @version Sep 15, 2013
 * 
 */
public class DeltaStrategyGameControllerTest {

	/**
	 * The factory that the test cases will use to produce
	 * StrategyGameController objects.
	 */
	private StrategyGameFactory factory;

	/**
	 * The initial piece configurations that the factory method uses to create
	 * the controller. These will be set up with a default configuration before
	 * each test. Each test can then modify them, if desired, before creating
	 * the controller.
	 */
	private Collection<PieceLocationDescriptor> startingRedConfig;
	private Collection<PieceLocationDescriptor> startingBlueConfig;
	
	/**
	 * Constants for easy access to locations
	 */
	private final Location loc00 = new Location2D(0,0);
	private final Location loc01 = new Location2D(0,1);
	private final Location loc02 = new Location2D(0,2);
	private final Location loc03 = new Location2D(0,3);
	private final Location loc04 = new Location2D(0,4);
	private final Location loc05 = new Location2D(0,5);
	private final Location loc06 = new Location2D(0,6);
	private final Location loc07 = new Location2D(0,7);
	private final Location loc08 = new Location2D(0,8);
	private final Location loc09 = new Location2D(0,9);
	private final Location loc10 = new Location2D(1,0);
	private final Location loc11 = new Location2D(1,1);
	private final Location loc12 = new Location2D(1,2);
	private final Location loc13 = new Location2D(1,3);
	private final Location loc14 = new Location2D(1,4);
	private final Location loc15 = new Location2D(1,5);
	private final Location loc16 = new Location2D(1,6);
	private final Location loc17 = new Location2D(1,7);
	private final Location loc18 = new Location2D(1,8);
	private final Location loc19 = new Location2D(1,9);
	private final Location loc20 = new Location2D(2,0);
	private final Location loc21 = new Location2D(2,1);
	private final Location loc22 = new Location2D(2,2);
	private final Location loc23 = new Location2D(2,3);
	private final Location loc24 = new Location2D(2,4);
	private final Location loc25 = new Location2D(2,5);
	private final Location loc26 = new Location2D(2,6);
	private final Location loc27 = new Location2D(2,7);
	private final Location loc28 = new Location2D(2,8);
	private final Location loc29 = new Location2D(2,9);
	private final Location loc30 = new Location2D(3,0);
	private final Location loc31 = new Location2D(3,1);
	private final Location loc32 = new Location2D(3,2);
	private final Location loc33 = new Location2D(3,3);
	private final Location loc34 = new Location2D(3,4);
	private final Location loc35 = new Location2D(3,5);
	private final Location loc36 = new Location2D(3,6);
	private final Location loc37 = new Location2D(3,7);
	private final Location loc38 = new Location2D(3,8);
	private final Location loc39 = new Location2D(3,9);
	private final Location loc40 = new Location2D(4,0);
	private final Location loc41 = new Location2D(4,1);
	private final Location loc42 = new Location2D(4,2);
	private final Location loc43 = new Location2D(4,3);
	private final Location loc44 = new Location2D(4,4);
	private final Location loc45 = new Location2D(4,5);
	private final Location loc46 = new Location2D(4,6);
	private final Location loc47 = new Location2D(4,7);
	private final Location loc48 = new Location2D(4,8);
	private final Location loc49 = new Location2D(4,9);
	private final Location loc50 = new Location2D(5,0);
	private final Location loc51 = new Location2D(5,1);
	private final Location loc52 = new Location2D(5,2);
	private final Location loc53 = new Location2D(5,3);
	private final Location loc54 = new Location2D(5,4);
	private final Location loc55 = new Location2D(5,5);
	private final Location loc56 = new Location2D(5,6);
	private final Location loc57 = new Location2D(5,7);
	private final Location loc58 = new Location2D(5,8);
	private final Location loc59 = new Location2D(5,9);
	private final Location loc60 = new Location2D(6,0);
	private final Location loc61 = new Location2D(6,1);
	private final Location loc62 = new Location2D(6,2);
	private final Location loc63 = new Location2D(6,3);
	private final Location loc64 = new Location2D(6,4);
	private final Location loc65 = new Location2D(6,5);
	private final Location loc66 = new Location2D(6,6);
	private final Location loc67 = new Location2D(6,7);
	private final Location loc68 = new Location2D(6,8);
	private final Location loc69 = new Location2D(6,9);
	private final Location loc70 = new Location2D(7,0);
	private final Location loc71 = new Location2D(7,1);
	private final Location loc72 = new Location2D(7,2);
	private final Location loc73 = new Location2D(7,3);
	private final Location loc74 = new Location2D(7,4);
	private final Location loc75 = new Location2D(7,5);
	private final Location loc76 = new Location2D(7,6);
	private final Location loc77 = new Location2D(7,7);
	private final Location loc78 = new Location2D(7,8);
	private final Location loc79 = new Location2D(7,9);
	private final Location loc80 = new Location2D(8,0);
	private final Location loc81 = new Location2D(8,1);
	private final Location loc82 = new Location2D(8,2);
	private final Location loc83 = new Location2D(8,3);
	private final Location loc84 = new Location2D(8,4);
	private final Location loc85 = new Location2D(8,5);
	private final Location loc86 = new Location2D(8,6);
	private final Location loc87 = new Location2D(8,7);
	private final Location loc88 = new Location2D(8,8);
	private final Location loc89 = new Location2D(8,9);
	private final Location loc90 = new Location2D(9,0);
	private final Location loc91 = new Location2D(9,1);
	private final Location loc92 = new Location2D(9,2);
	private final Location loc93 = new Location2D(9,3);
	private final Location loc94 = new Location2D(9,4);
	private final Location loc95 = new Location2D(9,5);
	private final Location loc96 = new Location2D(9,6);
	private final Location loc97 = new Location2D(9,7);
	private final Location loc98 = new Location2D(9,8);
	private final Location loc99 = new Location2D(9,9);

	/**
	 * Setup method that runs before each test. It sets up sample valid starting
	 * piece configurations for both players, which can be modified and/or used
	 * to create a BetaStrategyGameController.
	 */
	@Before
	public void setUp() {
		factory = StrategyGameFactory.getInstance();
		//startingRedConfig = setupValidRedConfiguration();
		//startingBlueConfig = setupValidBlueConfiguration();
	}



}
