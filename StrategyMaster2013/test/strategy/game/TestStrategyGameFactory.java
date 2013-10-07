package strategy.game;

import java.util.Collection;

import strategy.common.StrategyException;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.version.Board;
import strategy.game.version.ValidateConfigurationBehavior;

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
		factory = new StrategyGameFactory();
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
		final Board gameBoard = factory.constructDeltaBoard(startingRedConfig,
				startingBlueConfig);
		
		// Store the board for later use
		this.board = gameBoard;

		// Create the configuration validators.
		final Collection<ValidateConfigurationBehavior> configValidators = factory
				.getDeltaConfigurationValidators(startingRedConfig,
						startingBlueConfig);

		// Finish construction of the game.
		return factory.constructDeltaStrategyFromBoardAndConfigValidators(
				gameBoard, configValidators);
	}

}
