package strategy.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import strategy.common.StrategyException;
import strategy.common.StrategyRuntimeException;
import strategy.game.common.Location;
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
import strategy.game.version.battleBehaviors.DeltaBattleBehavior;
import strategy.game.version.battleBehaviors.EpsilonBattleBehavior;
import strategy.game.version.gameResultBehaviors.StatusGameResultBehavior;
import strategy.game.version.gameResultBehaviors.TwoFlagGameResultBehavior;
import strategy.game.version.turnUpdateBehaviors.AlternateTeamTurnBehavior;
import strategy.game.version.validateConfigurationBehaviors.DeltaPieceDistributionConfigValidator;
import strategy.game.version.validateConfigurationBehaviors.DeltaStartLocationsConfigValidator;
import strategy.game.version.validateConfigurationBehaviors.EpsilonPieceDistributionConfigValidator;
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
import strategy.game.version.validateMoveBehaviors.TwoSpaceStrikeMoveValidator;

/**
 * Test factory which constructs StrategyGameController objects while retaining
 * access to the board, with which it implements additional functionality.
 * 
 * @author scornman
 * @version 10/7/2013
 * 
 */
public class TestStrategyGameFactory {

	StrategyGameFactory factory;
	Board board;

	public TestStrategyGameFactory() {
		factory = StrategyGameFactory.getInstance();
		board = null;
	}

	/**
	 * Create a new test delta strategy game
	 * 
	 * @param startingRedConfig
	 * @param startingBlueConfig
	 * @return a StrategyGameController for a delta strategy game
	 * @throws StrategyException
	 */
	public StrategyGameController makeDeltaStrategyGame(
			Collection<PieceLocationDescriptor> startingRedConfig,
			Collection<PieceLocationDescriptor> startingBlueConfig)
			throws StrategyException {
		// Create the board.
		final Board gameBoard = factory.constructFullBoard(startingRedConfig,
				startingBlueConfig);

		// Hold on to a copy of the board.
		this.board = gameBoard;

		// Combine the two configurations into one total configuration for
		// passing to the NoPiecesStartAtSameLocationConfigValidator
		final Collection<PieceLocationDescriptor> totalStartingConfig = factory
				.combineConfigs(startingRedConfig, startingBlueConfig);

		// Create the config validators.
		final Collection<ValidateConfigurationBehavior> configValidators = new ArrayList<ValidateConfigurationBehavior>();
		configValidators.add(new DeltaPieceDistributionConfigValidator(
				startingRedConfig, startingBlueConfig));
		configValidators.add(new DeltaStartLocationsConfigValidator(
				startingRedConfig, startingBlueConfig));
		configValidators.add(new NoPiecesStartAtSameLocationConfigValidator(
				totalStartingConfig));

		// Create the move history
		final MoveHistory moveHistory = new MoveHistory();

		// Create the move validators
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

		// Create the remaining components
		final TurnUpdateBehavior turnUpdateBehavior = new AlternateTeamTurnBehavior();
		final BattleBehavior battleBehavior = new DeltaBattleBehavior(gameBoard);
		final GameResultBehavior gameResultBehavior = new StatusGameResultBehavior(
				gameBoard, moveValidators);

		return new StrategyGameControllerImpl(configValidators, moveValidators,
				turnUpdateBehavior, battleBehavior, gameResultBehavior,
				gameBoard, moveHistory);

	}

	/**
	 * Create a new test epsilon strategy game
	 * 
	 * @param startingRedConfig
	 * @param startingBlueConfig
	 * @return a StrategyGameController for a epsilon strategy game
	 * @throws StrategyException
	 */
	public StrategyGameController makeEpsilonStrategy(
			Collection<PieceLocationDescriptor> startingRedConfig,
			Collection<PieceLocationDescriptor> startingBlueConfig,
			Collection<StrategyGameObserver> observers)
			throws StrategyException {
		// Create the board.
		final Board gameBoard = factory.constructFullBoard(startingRedConfig,
				startingBlueConfig);

		// Hold on to a copy of the board.
		this.board = gameBoard;

		// Combine the two configurations into one total configuration for
		// passing to the NoPiecesStartAtSameLocationConfigValidator
		final Collection<PieceLocationDescriptor> totalStartingConfig = factory
				.combineConfigs(startingRedConfig, startingBlueConfig);

		// Create the config validators.
		final Collection<ValidateConfigurationBehavior> configValidators = new ArrayList<ValidateConfigurationBehavior>();
		configValidators.add(new EpsilonPieceDistributionConfigValidator(
				startingRedConfig, startingBlueConfig));
		configValidators.add(new DeltaStartLocationsConfigValidator(
				startingRedConfig, startingBlueConfig));
		configValidators.add(new NoPiecesStartAtSameLocationConfigValidator(
				totalStartingConfig));

		// Create the move history
		final MoveHistory moveHistory = new MoveHistory();

		// Create the move validators
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
		validatorsByPiece.put(PieceType.FIRST_LIEUTENANT,
				new TwoSpaceStrikeMoveValidator(gameBoard));

		// pass in map of pieces that use unique move validators, pass in
		// one-space-per-move validator as default
		moveValidators.add(new DependsOnPieceTypeMoveValidator(
				validatorsByPiece, new OneSpaceInDirectionMoveValidator()));

		// Create the remaining components
		final TurnUpdateBehavior turnUpdateBehavior = new AlternateTeamTurnBehavior();
		final BattleBehavior battleBehavior = new EpsilonBattleBehavior(
				gameBoard);
		final GameResultBehavior gameResultBehavior = new TwoFlagGameResultBehavior(
				gameBoard, moveValidators);

		return new StrategyGameControllerImpl(configValidators, moveValidators,
				turnUpdateBehavior, battleBehavior, gameResultBehavior,
				gameBoard, moveHistory);

	}

	/**
	 * Removes all pieces from the board. This will fail if no strategy game has
	 * yet been created.
	 */
	public void clearBoard() {
		if (board == null) {
			throw new StrategyRuntimeException("The Board does not exist!!");
		}
		for (Location iLoc : board.getValidLocations()) {
			board.putPiece(iLoc, null);
		}
	}

	/**
	 * Puts a new piece onto the board at the specified location.
	 * 
	 * @param newPiece
	 *            the piece to add.
	 * @param newLocation
	 *            the location at which to add the new piece.
	 */
	public void putPieceOnBoard(Location newLocation, Piece newPiece) {
		board.putPiece(newLocation, newPiece);
	}

}
