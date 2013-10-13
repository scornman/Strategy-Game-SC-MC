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
import strategy.game.common.PieceType;
import strategy.game.common.StrategyGameObserver;
import strategy.game.version.BattleBehavior;
import strategy.game.version.Board;
import strategy.game.version.GameResultBehavior;
import strategy.game.version.MoveHistory;
import strategy.game.version.StrategyGameControllerImpl;
import strategy.game.version.TurnUpdateBehavior;
import strategy.game.version.ValidateConfigurationBehavior;
import strategy.game.version.ValidateMoveBehavior;
import strategy.game.version.alpha.AlphaStrategyGameController;
import strategy.game.version.battleBehaviors.DeltaBattleBehavior;
import strategy.game.version.battleBehaviors.GammaBattleBehavior;
import strategy.game.version.beta.BetaStrategyGameController;
import strategy.game.version.gameResultBehaviors.StatusGameResultBehavior;
import strategy.game.version.turnUpdateBehaviors.AlternateTeamTurnBehavior;
import strategy.game.version.validateConfigurationBehaviors.DeltaPieceDistributionConfigValidator;
import strategy.game.version.validateConfigurationBehaviors.DeltaStartLocationsConfigValidator;
import strategy.game.version.validateConfigurationBehaviors.GammaPieceDistributionConfigValidator;
import strategy.game.version.validateConfigurationBehaviors.GammaStartLocationsConfigValidator;
import strategy.game.version.validateConfigurationBehaviors.NoPiecesStartAtSameLocationConfigValidator;
import strategy.game.version.validateMoveBehaviors.CorrectPieceTypeMoveValidator;
import strategy.game.version.validateMoveBehaviors.DependsOnPieceTypeMoveValidator;
import strategy.game.version.validateMoveBehaviors.MoveRepetitionRuleValidator;
import strategy.game.version.validateMoveBehaviors.MovingOnTurnMoveValidator;
import strategy.game.version.validateMoveBehaviors.NotAttackingOwnTeamMoveValidator;
import strategy.game.version.validateMoveBehaviors.NotMovingBombMoveValidator;
import strategy.game.version.validateMoveBehaviors.NotMovingFlagMoveValidator;
import strategy.game.version.validateMoveBehaviors.OneSpaceInDirectionMoveValidator;
import strategy.game.version.validateMoveBehaviors.SeveralSpacesInOneDirectionMoveValidator;

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
	 * @return a StrategyGameController for a gamma strategy game
	 * @throws StrategyException
	 */
	public StrategyGameController makeGammaStrategyGame(
			Collection<PieceLocationDescriptor> startingRedConfig,
			Collection<PieceLocationDescriptor> startingBlueConfig)
			throws StrategyException {

		final Collection<Location> chokePoints = new ArrayList<Location>();
		chokePoints.add(new Location2D(2, 2));
		chokePoints.add(new Location2D(2, 3));
		chokePoints.add(new Location2D(3, 2));
		chokePoints.add(new Location2D(3, 3));
		final Map<Location, Piece> pieceMap = makeBoard(startingRedConfig,
				startingBlueConfig, 6, 6, chokePoints);

		final Board gameBoard = new Board(pieceMap);

		final MoveHistory moveHistory = new MoveHistory();

		final Collection<ValidateConfigurationBehavior> configValidators = new ArrayList<ValidateConfigurationBehavior>();
		configValidators.add(new GammaPieceDistributionConfigValidator(
				startingRedConfig, startingBlueConfig));
		configValidators.add(new GammaStartLocationsConfigValidator(
				startingRedConfig, startingBlueConfig));
		// Combine the two configurations into one total configuration for
		// passing to the NoPiecesStartAtSameLocationConfigValidator
		final Collection<PieceLocationDescriptor> totalStartingConfig = new ArrayList<PieceLocationDescriptor>();
		for (PieceLocationDescriptor iPLD : startingRedConfig) {
			totalStartingConfig.add(iPLD);
		}
		for (PieceLocationDescriptor iPLD : startingBlueConfig) {
			totalStartingConfig.add(iPLD);
		}
		configValidators.add(new NoPiecesStartAtSameLocationConfigValidator(
				totalStartingConfig));

		final Collection<ValidateMoveBehavior> moveValidators = new ArrayList<ValidateMoveBehavior>();
		moveValidators.add(new NotAttackingOwnTeamMoveValidator(gameBoard));
		moveValidators.add(new OneSpaceInDirectionMoveValidator());
		moveValidators.add(new NotMovingFlagMoveValidator());
		moveValidators.add(new MovingOnTurnMoveValidator(gameBoard));
		moveValidators.add(new CorrectPieceTypeMoveValidator(gameBoard));
		moveValidators.add(new MoveRepetitionRuleValidator(moveHistory));

		final TurnUpdateBehavior turnUpdateBehavior = new AlternateTeamTurnBehavior();

		final BattleBehavior battleBehavior = new GammaBattleBehavior(gameBoard);

		final GameResultBehavior gameResultBehavior = new StatusGameResultBehavior(
				gameBoard, moveValidators);

		return new StrategyGameControllerImpl(configValidators, moveValidators,
				turnUpdateBehavior, battleBehavior, gameResultBehavior,
				gameBoard, moveHistory);
	}

	/**
	 * Create a new delta strategy game
	 * 
	 * @param startingRedConfig
	 *            the starting locations of all red pieces.
	 * @param startingBlueConfig
	 *            the starting locations of all blue pieces.
	 * @return a StrategyGameController for a delta strategy game
	 * @throws StrategyException
	 */
	public StrategyGameController makeDeltaStrategyGame(
			Collection<PieceLocationDescriptor> startingRedConfig,
			Collection<PieceLocationDescriptor> startingBlueConfig)
			throws StrategyException {
		
		

		// Create the board.
		final Board gameBoard = constructDeltaBoard(startingRedConfig,
				startingBlueConfig);

		// Create the configuration validators.
		final Collection<ValidateConfigurationBehavior> configValidators = getDeltaConfigurationValidators(
				startingRedConfig, startingBlueConfig);

		// Finish construction of the game.
		return constructDeltaStrategyFromBoardAndConfigValidators(gameBoard,
				configValidators);

	}

	/**
	 * Create a new epsilon strategy game
	 * 
	 * @param startingRedConfig
	 *            the starting locations of all red pieces.
	 * @param startingBlueConfig
	 *            the starting locations of all blue pieces.
	 * @return a StrategyGameController for a epsilon strategy game
	 * @throws StrategyException
	 */
	public StrategyGameController makeEpsilonStrategy(
			Collection<PieceLocationDescriptor> startingRedConfig,
			Collection<PieceLocationDescriptor> startingBlueConfig,
			Collection<StrategyGameObserver> observers)
			throws StrategyException {

		// Create the board.
		final Board gameBoard = constructDeltaBoard(startingRedConfig,
				startingBlueConfig);

		// Create the configuration validators.
		final Collection<ValidateConfigurationBehavior> configValidators = getDeltaConfigurationValidators(
				startingRedConfig, startingBlueConfig);

		// Finish construction of the game.
		return constructDeltaStrategyFromBoardAndConfigValidators(gameBoard,
				configValidators);

	}

	/**
	 * Creates a board for Delta Strategy based on the given starting piece
	 * configurations.
	 * 
	 * @param startingRedConfig
	 *            the starting locations of all red pieces.
	 * @param startingBlueConfig
	 *            the starting locations of all blue pieces.
	 * @return the initial game board.
	 */
	public Board constructDeltaBoard(
			Collection<PieceLocationDescriptor> startingRedConfig,
			Collection<PieceLocationDescriptor> startingBlueConfig) {
		final Collection<Location> chokePoints = new ArrayList<Location>();
		chokePoints.add(new Location2D(2, 4));
		chokePoints.add(new Location2D(2, 5));
		chokePoints.add(new Location2D(3, 4));
		chokePoints.add(new Location2D(3, 5));
		chokePoints.add(new Location2D(6, 4));
		chokePoints.add(new Location2D(6, 4));
		chokePoints.add(new Location2D(7, 4));
		chokePoints.add(new Location2D(7, 5));
		final Map<Location, Piece> pieceMap = makeBoard(startingRedConfig,
				startingBlueConfig, 10, 10, chokePoints);
		final Board gameBoard = new Board(pieceMap);

		return gameBoard;
	}

	/**
	 * Creates the behaviors with which a Delta Strategy game determines whether
	 * a set of starting configurations are valid.
	 * 
	 * @param startingRedConfig
	 *            the starting locations of all red pieces.
	 * @param startingBlueConfig
	 *            the starting locations of all blue pieces.
	 * @return the set of configuration validation behaviors.
	 */
	public Collection<ValidateConfigurationBehavior> getDeltaConfigurationValidators(
			Collection<PieceLocationDescriptor> startingRedConfig,
			Collection<PieceLocationDescriptor> startingBlueConfig) {

		// Combine the two configurations into one total configuration for
		// passing to the NoPiecesStartAtSameLocationConfigValidator
		final Collection<PieceLocationDescriptor> totalStartingConfig = combineConfigs(
				startingRedConfig, startingBlueConfig);

		// Create the config validators.
		final Collection<ValidateConfigurationBehavior> configValidators = new ArrayList<ValidateConfigurationBehavior>();
		configValidators.add(new DeltaPieceDistributionConfigValidator(
				startingRedConfig, startingBlueConfig));
		configValidators.add(new DeltaStartLocationsConfigValidator(
				startingRedConfig, startingBlueConfig));
		configValidators.add(new NoPiecesStartAtSameLocationConfigValidator(
				totalStartingConfig));

		return configValidators;
	}

	/**
	 * Handles the portion of constructing a StrategyGameController for Delta
	 * Strategy that does not involve dealing with piece configurations.
	 * 
	 * @param gameBoard
	 *            the initial board containing all pieces at their starting
	 *            locations.
	 * @param configValidators
	 *            the set of behaviors responsible for validating the starting
	 *            piece configurations.
	 * @return a new StrategyGameControllerImpl()
	 * @throws StrategyException
	 */
	public StrategyGameController constructDeltaStrategyFromBoardAndConfigValidators(
			Board gameBoard,
			Collection<ValidateConfigurationBehavior> configValidators)
			throws StrategyException {
		final MoveHistory moveHistory = new MoveHistory();

		final Collection<ValidateMoveBehavior> moveValidators = new ArrayList<ValidateMoveBehavior>();
		// Validators for movement behaviors common to all piece types.
		moveValidators.add(new NotAttackingOwnTeamMoveValidator(gameBoard));
		moveValidators.add(new NotMovingFlagMoveValidator());
		moveValidators.add(new NotMovingBombMoveValidator());
		moveValidators.add(new MovingOnTurnMoveValidator(gameBoard));
		moveValidators.add(new CorrectPieceTypeMoveValidator(gameBoard));
		moveValidators.add(new MoveRepetitionRuleValidator(moveHistory));
		// For movement behavior that varies based on the piece type
		final Map<PieceType, ValidateMoveBehavior> validatorsByPiece = new HashMap<PieceType, ValidateMoveBehavior>();
		validatorsByPiece.put(PieceType.SCOUT,
				new SeveralSpacesInOneDirectionMoveValidator(gameBoard));
		// pass in map of pieces that use unique move validators, pass in
		// one-space-per-move validator as default
		moveValidators.add(new DependsOnPieceTypeMoveValidator(
				validatorsByPiece, new OneSpaceInDirectionMoveValidator()));

		final TurnUpdateBehavior turnUpdateBehavior = new AlternateTeamTurnBehavior();
		final BattleBehavior battleBehavior = new DeltaBattleBehavior(gameBoard);
		final GameResultBehavior gameResultBehavior = new StatusGameResultBehavior(
				gameBoard, moveValidators);

		return new StrategyGameControllerImpl(configValidators, moveValidators,
				turnUpdateBehavior, battleBehavior, gameResultBehavior,
				gameBoard, moveHistory);
	}

	/**
	 * Creates a game board for a given size, set of choke point locations, and
	 * piece configurations.
	 * 
	 * @param redConfiguration
	 *            the starting locations of all red pieces.
	 * @param blueConfiguration
	 *            the starting locations of all blue pieces.
	 * @param BOARD_SIZE_X
	 *            the size of the board in the X Dimension.
	 * @param BOARD_SIZE_Y
	 *            the size of the board in the Y Dimension.
	 * @param chokePoints
	 *            a list of all locations within the dimensions that are choke
	 *            points, and thus invalid locations.
	 * @return the newly-created game board.
	 */
	private static Map<Location, Piece> makeBoard(
			Collection<PieceLocationDescriptor> redConfiguration,
			Collection<PieceLocationDescriptor> blueConfiguration,
			int BOARD_SIZE_X, int BOARD_SIZE_Y, Collection<Location> chokePoints) {

		final Map<Location, Piece> pieceMap = new HashMap<Location, Piece>();

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

		return pieceMap;
	}

	/**
	 * Returns one total configuration of the board.
	 * 
	 * @param startingRedConfig
	 *            the config of the red pieces.
	 * @param startingBlueConfig
	 *            the config of the blue pieces.
	 * @return a collection of all pieces.
	 */
	private Collection<PieceLocationDescriptor> combineConfigs(
			Collection<PieceLocationDescriptor> startingRedConfig,
			Collection<PieceLocationDescriptor> startingBlueConfig) {
		final Collection<PieceLocationDescriptor> totalStartingConfig = new ArrayList<PieceLocationDescriptor>();
		for (PieceLocationDescriptor iPLD : startingRedConfig) {
			totalStartingConfig.add(iPLD);
		}
		for (PieceLocationDescriptor iPLD : startingBlueConfig) {
			totalStartingConfig.add(iPLD);
		}
		return totalStartingConfig;
	}
}