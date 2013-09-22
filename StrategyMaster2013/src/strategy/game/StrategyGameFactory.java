/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package strategy.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.Location2D;
import strategy.game.common.Piece;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.version.BattleBehavior;
import strategy.game.version.Board;
import strategy.game.version.GameResultBehavior;
import strategy.game.version.StrategyGameControllerImpl;
import strategy.game.version.TurnUpdateBehavior;
import strategy.game.version.ValidateConfigurationBehavior;
import strategy.game.version.ValidateMoveBehavior;
import strategy.game.version.alpha.AlphaStrategyGameController;
import strategy.game.version.beta.BetaStrategyGameController;
import strategy.game.version.turnUpdateBehaviors.AlternateTeamTurnBehavior;
import strategy.game.version.validateMoveBehaviors.NotAttackingOwnTeamMoveValidator;
import strategy.game.version.validateMoveBehaviors.OneSpaceInDirectionMoveValidator;

/**
 * <p>
 * Factory to produce various versions of the Strategy game. This is implemented
 * as a singleton.
 * </p>
 * <p>
 * NOTE: If an error occurs creating any game, that is not specified in the
 * particular factory method's documentation, the factory method should throw a
 * StrategyRuntimeException.
 * </p>
 * 
 * @author gpollice
 * @version Sep 10, 2013
 */
public class StrategyGameFactory {
	private final static StrategyGameFactory instance = new StrategyGameFactory();

	/**
	 * Default private constructor to ensure this is a singleton.
	 */
	private StrategyGameFactory() {
		// Intentionally left empty.
	}

	/**
	 * @return the instance
	 */
	public static StrategyGameFactory getInstance() {
		return instance;
	}

	/**
	 * Create an Alpha Strategy game.
	 * 
	 * @return the created Alpha Strategy game
	 */
	public StrategyGameController makeAlphaStrategyGame() {
		final StrategyGameController controller = new AlphaStrategyGameController();
		return controller;
	}

	/**
	 * Create a new Beta Strategy game given the
	 * 
	 * @param redConfiguration
	 *            the initial starting configuration for the RED pieces
	 * @param blueConfiguration
	 *            the initial starting configuration for the BLUE pieces
	 * @return the Beta Strategy game instance with the initial configuration of
	 *         pieces
	 * @throws StrategyException
	 *             if either configuration is correct
	 */
	public StrategyGameController makeBetaStrategyGame(
			Collection<PieceLocationDescriptor> redConfiguration,
			Collection<PieceLocationDescriptor> blueConfiguration)
			throws StrategyException {
		final StrategyGameController controller = new BetaStrategyGameController(
				redConfiguration, blueConfiguration);
		return controller;
	}

	/**
	 * Create a new gamma strategy game
	 * 
	 * @param startingRedConfig
	 * @param startingBlueConfig
	 * @return
	 */
	public StrategyGameController makeGammaStrategyGame(
			Collection<PieceLocationDescriptor> startingRedConfig,
			Collection<PieceLocationDescriptor> startingBlueConfig) {
		
		Collection<Location> chokePoints = new ArrayList<Location>();
		chokePoints.add(new Location2D(2, 2));
		chokePoints.add(new Location2D(2, 3));
		chokePoints.add(new Location2D(3, 2));
		chokePoints.add(new Location2D(3, 3));
		Map<Location, Piece> pieceMap = makeBoard(	startingRedConfig,
													startingBlueConfig, 
													6, 
													6, 
													chokePoints	);
		
		Board gameBoard = new Board(pieceMap);
		
		Collection<ValidateConfigurationBehavior> configValidators = null;
		
		Collection<ValidateMoveBehavior> moveValidators = new ArrayList<ValidateMoveBehavior>();
		moveValidators.add(new NotAttackingOwnTeamMoveValidator(gameBoard));
		moveValidators.add(new OneSpaceInDirectionMoveValidator());
		
		TurnUpdateBehavior turnUpdateBehavior = new AlternateTeamTurnBehavior();
		
		BattleBehavior battleBehavior = null;
		
		GameResultBehavior gameResultBehavior = null;
		


		return new StrategyGameControllerImpl(	configValidators, 
												moveValidators,
												turnUpdateBehavior, 
												battleBehavior, 
												gameResultBehavior,
												gameBoard	);
	}

	private HashMap<Location, Piece> makeBoard(
			Collection<PieceLocationDescriptor> redConfiguration,
			Collection<PieceLocationDescriptor> blueConfiguration,
			int BOARD_SIZE_X, int BOARD_SIZE_Y, Collection<Location> chokePoints) {

		Map<Location, Piece> pieceMap = new HashMap<Location, Piece>();

		// create the locations on the board by the dimensions given
		for (int i = 0; i < BOARD_SIZE_X; i++) {
			for (int j = 0; j < BOARD_SIZE_Y; j++) {
				pieceMap.put(new Location2D(i, j), null);
			}
		}

		// add the red pieces to the board
		for (PieceLocationDescriptor red : redConfiguration) {
			Location redLocation = red.getLocation();
			Piece redPiece = red.getPiece();

			pieceMap.put(redLocation, redPiece);
		}

		// add the blue pieces to the board
		for (PieceLocationDescriptor blue : blueConfiguration) {
			Location blueLocation = blue.getLocation();
			Piece bluePiece = blue.getPiece();

			pieceMap.put(blueLocation, bluePiece);
		}

		// remove the chokepoints from the map
		for (Location chokePoint : chokePoints) {
			pieceMap.remove(chokePoint);
		}

		return (HashMap<Location, Piece>) pieceMap;
	}
}