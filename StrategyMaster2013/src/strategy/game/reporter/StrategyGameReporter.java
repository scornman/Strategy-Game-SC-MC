package strategy.game.reporter;

import java.util.Collection;

import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.MoveResult;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.common.PieceType;
import strategy.game.common.StrategyGameObserver;

/**
 * A reporter that observes a game of Strategy and gives play-by-play text
 * descriptions of each move in the game.
 * 
 * @author Madalyn
 * @author scornman
 * 
 */
public class StrategyGameReporter implements StrategyGameObserver {

	/**
	 * Stores the descritption of the most recent move that has been made in the
	 * game.
	 */
	String lastMoveDescription;

	/**
	 * Creates a new StrategyGameReporter.
	 */
	public StrategyGameReporter() {
		lastMoveDescription = "";
	}

	/**
	 * Detects the gameStart to start observing and announce the start of the
	 * game.
	 */
	@Override
	public void gameStart(Collection<PieceLocationDescriptor> redConfiguration,
			Collection<PieceLocationDescriptor> blueConfiguration) {
		// TODO Auto-generated method stub

	}

	/**
	 * Updates when a move happens, printing a statement describing the move to
	 * the audience.
	 */
	@Override
	public void moveHappened(PieceType piece, Location from, Location to,
			MoveResult result, StrategyException fault) {
		// Construct a statement about the move.
		lastMoveDescription = constructMoveReport(piece, from, to, result,
				fault);
		// Print out the move statement
		printMessage(lastMoveDescription);
	}

	/**
	 * Constructs a message string that reports on the events of a move
	 * 
	 * @param piece
	 *            the type of piece that was moved.
	 * @param from
	 *            the location from which the piece was moved.
	 * @param to
	 *            the location to which the piece was moved.
	 * @param result
	 *            the result of the move.
	 * @param fault
	 *            the error thrown as a result of the move, if any.
	 * @return
	 */
	public String constructMoveReport(PieceType piece, Location from,
			Location to, MoveResult result, StrategyException fault) {
		return "Whoa! Something happened in the game!";
	}

	/**
	 * Prints the message describing a move to the screen.
	 * 
	 * @param message
	 *            the message to print.
	 */
	public void printMessage(String message) {
		System.out.println(message);
	}

}
