/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package strategy.game.version.gameResultBehaviors;

import java.util.Collection;

import strategy.common.PlayerColor;
import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.MoveResultStatus;
import strategy.game.common.Piece;
import strategy.game.common.PieceType;
import strategy.game.version.Board;
import strategy.game.version.GameResultBehavior;
import strategy.game.version.ValidateMoveBehavior;

/**
 * Implementation of the game result behavior that includes end game conditions
 * for the flags being captured or nobody having legal moves.
 * 
 * @author Madalyn
 * @author scornman
 * @version 9/22/13
 * 
 */
public class TwoFlagGameResultBehavior implements GameResultBehavior {
	private final Board gameBoard;
	private final Collection<ValidateMoveBehavior> moveValidators;

	// Flags that keep track of whether either side has lost a flag.
	private boolean firstRedFlagCaptured;
	private boolean firstBlueFlagCaptured;

	/**
	 * Creates a new StatusGameResultBehavior object.
	 * 
	 * @param gameBoard
	 *            the board for the game
	 * @param moveValidators
	 *            the set of validators that the game is using to check the
	 *            validity of moves.
	 */
	public TwoFlagGameResultBehavior(Board gameBoard,
			Collection<ValidateMoveBehavior> moveValidators) {
		this.gameBoard = gameBoard;
		this.moveValidators = moveValidators;
		firstRedFlagCaptured = false;
		firstBlueFlagCaptured = false;
	}

	/**
	 * Determine the result of the battle. only wins if both flags are captured
	 * 
	 * @return the battle result.
	 * @throws StrategyException
	 */
	@Override
	public MoveResultStatus getGameStatus() throws StrategyException {
		MoveResultStatus status = null;

		// if both blue flags are gone, red wins
		if (!gameBoard
				.containsPiece(new Piece(PieceType.FLAG, PlayerColor.BLUE))) {
			status = MoveResultStatus.RED_WINS;

			// if both red flags a gone, blue wins
		} else if (!gameBoard.containsPiece(new Piece(PieceType.FLAG,
				PlayerColor.RED))) {
			status = MoveResultStatus.BLUE_WINS;

		} else {

			// Otherwise, check if the game ends due to one or both players
			// having no legal moves.
			boolean canRedMove = canMakeValidMove(PlayerColor.RED);
			boolean canBlueMove = canMakeValidMove(PlayerColor.BLUE);

			if (canRedMove && !canBlueMove) {
				return MoveResultStatus.RED_WINS;
			} else if (!canRedMove && canBlueMove) {
				return MoveResultStatus.BLUE_WINS;
			} else if (!canRedMove && !canBlueMove) {
				return MoveResultStatus.DRAW;
			} else {
				// The game is not over
				
				// check if the first red flag has been captured this turn
				if (!firstRedFlagCaptured
						&& gameBoard.getNumberOfFlags(PlayerColor.RED) == 1) {
					firstRedFlagCaptured = true;
					status = MoveResultStatus.FLAG_CAPTURED;
					// check if the first blue flag has been captured this turn
				} else if (!firstBlueFlagCaptured
						&& gameBoard.getNumberOfFlags(PlayerColor.BLUE) == 1) {
					firstBlueFlagCaptured = true;
					status = MoveResultStatus.FLAG_CAPTURED;

					// check if either side has a valid move.
				} else {
					return MoveResultStatus.OK;
				}
			}
		}
		return status;
	}

	/**
	 * Determines whether a player has any valid possible moves.
	 * 
	 * @param color
	 *            the color of the player to check moves for.
	 * @return
	 * @throws StrategyException
	 *             if one of the moves checked includes an invalid location.
	 */
	private boolean canMakeValidMove(PlayerColor color)
			throws StrategyException {
		for (Location from : gameBoard.getValidLocations()) {
			for (Location to : gameBoard.getValidLocations()) {
				if (isValidMove(from, to, color)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Determines whether a move is valid based on the supplied set of
	 * ValidateMoveBehavior objects.
	 * 
	 * @param from
	 *            the location to move from
	 * @param to
	 *            the location to move to
	 * @param color
	 *            the color of the player to check a move for
	 * @return
	 * @throws StrategyException
	 *             if one of the locations is invalid.
	 */
	private boolean isValidMove(Location from, Location to, PlayerColor color)
			throws StrategyException {
		final Piece movingPiece = gameBoard.getPieceAt(from);

		// If there is a piece to attempt to move.
		if (movingPiece != null) {
			final PieceType movingPieceType = movingPiece.getType();

			for (ValidateMoveBehavior validator : moveValidators) {
				if (!(validator.isMoveValid(movingPieceType, from, to, color))) {
					return false;
				}
			}

			return true;
		} else {
			// If there is no piece to move, move is invalid.
			return false;
		}

	}
}
