package strategy.game;

import java.util.Collection;

import strategy.common.StrategyException;
import strategy.common.StrategyRuntimeException;
import strategy.game.common.Location;
import strategy.game.common.Piece;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.common.StrategyGameObserver;
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
			Collection<PieceLocationDescriptor> startingBlueConfig, Collection<StrategyGameObserver> observers)
			throws StrategyException {
		// Create the board.
		final Board gameBoard = factory.constructFullBoard(startingRedConfig,
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
