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

import strategy.common.PlayerColor;
import strategy.common.StrategyException;
import strategy.game.common.Coordinate;
import strategy.game.common.Location;
import strategy.game.common.MoveResult;
import strategy.game.common.MoveResultStatus;
import strategy.game.common.Piece;
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
	PlayerColor currentColor;

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
		currentColor = PlayerColor.RED;
		lastMoveDescription = "Ladies and Gentlemen, welcome to the Strategy Arena "
				+ "for an exciting match between the visiting RED team and the "
				+ "home team: BLUE! Let the game begin!";
		printMessage(lastMoveDescription);
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
		// Update the turn color.
		if (currentColor == PlayerColor.RED) {
			currentColor = PlayerColor.BLUE;
		} else {
			currentColor = PlayerColor.RED;
		}
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
		String report = "";
		PlayerColor otherColor;
		if (currentColor == PlayerColor.RED) {
			otherColor = PlayerColor.BLUE;
		} else {
			otherColor = PlayerColor.RED;
		}

		if (result != null) {

			// Include information on the piece that moved.
			report += "The " + currentColor + " " + piece.getPrintableName()
					+ " makes a move!\n";
			// Include the from and to locations.
			report += "It's leaving location " + getPrintableLocation(from)
					+ " and heading for " + getPrintableLocation(to) + ".\n";
			// Determine the battle winner, if any.
			PieceLocationDescriptor winner = result.getBattleWinner();
			// If there was a battle
			if (winner != null) {
				report += "What's this? A battle! ";

				// Inclue the battle winner
				report += "And the " + getPrintableBattleWinner(winner)
						+ " is the winner!\n";
			}

			// Get the move result status
			MoveResultStatus status = result.getStatus();

			// If one of the flags has been captured report this.
			if (status == MoveResultStatus.FLAG_CAPTURED) {
				report += "And " + currentColor + " has captured one of the "
						+ otherColor + " flags! What a huge turn of events!\n";
				// If the game is over, report the appropriate messages.
			} else if (status != MoveResultStatus.OK) {
				report += "The game is over! The game is over! Do you believe it?\n";
				if (status == MoveResultStatus.RED_WINS) {
					report += "RED HAS WON THE GAME! What a REDiculously impressive finish!\n";
				} else if (status == MoveResultStatus.BLUE_WINS) {
					report += "BLUE HAS WON THE GAME! Blue fans will leave excited today, while you red fans will be feeling the BLUEs.\n";
				} else {
					report += "It's a draw! I can't believe I stayed for the whole game only for nobody to win!\n";
				}
				report += "And that's all from Strategy Arena. This is your announcer, Obser Ver, signing off.\n";
			}
		}

		return report;
	}

	/**
	 * Constructs a string representation of a location
	 * 
	 * @param location
	 *            the location to represent
	 * @return a string representation of a location
	 */
	private String getPrintableLocation(Location location) {
		String printableLoc = "("
				+ location.getCoordinate(Coordinate.X_COORDINATE) + ", "
				+ location.getCoordinate(Coordinate.Y_COORDINATE) + ")";
		return printableLoc;
	}

	/**
	 * Constructs a string representation of a battle winner
	 * (PieceLocationDescriptor)
	 * 
	 * @param battleWinner
	 *            the battle winner to represent
	 * @return a string representation of a battle winner
	 *         (PieceLocationDescriptor)
	 */
	private String getPrintableBattleWinner(PieceLocationDescriptor battleWinner) {
		Piece winningPiece = battleWinner.getPiece();
		String printableWinner = "the " + winningPiece.getOwner() + " "
				+ winningPiece.getType().getPrintableName();
		return printableWinner;
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

	/**
	 * Accesses the string announced for the last move.
	 * 
	 * @return the string announced for the last move.
	 */
	public String getLastMoveDescription() {
		return lastMoveDescription;
	}

}
