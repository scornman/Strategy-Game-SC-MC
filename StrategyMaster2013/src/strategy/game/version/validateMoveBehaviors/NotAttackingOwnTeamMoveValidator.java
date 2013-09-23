/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package strategy.game.version.validateMoveBehaviors;

import strategy.common.PlayerColor;
import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.Piece;
import strategy.game.common.PieceType;
import strategy.game.version.Board;
import strategy.game.version.ValidateMoveBehavior;

/**
 * Class for NotAttackingOwnTeamValidator makes sure player doesn't attempt to
 * move onto space with teammate
 * 
 * @author Madalyn
 * @version 9/22/13
 * 
 */
public class NotAttackingOwnTeamMoveValidator implements ValidateMoveBehavior {
	private final Board gameBoard;

	/**
	 * Constructor for NotAttackingOwnTeamMoveValidator
	 * 
	 * @param gameBoard
	 */
	public NotAttackingOwnTeamMoveValidator(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	/**
	 * makes sure that the piece the player is attacking is not its own team
	 * 
	 * @throws StrategyException
	 *             if one of the locations given is not a valid location on the
	 *             board.
	 */
	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) throws StrategyException {
		final Piece attackingPiece = gameBoard.getPieceAt(from);
		final Piece defendingPiece = gameBoard.getPieceAt(to);

		if (attackingPiece != null) {
			if (defendingPiece == null) {
				return true;
			}
			final PlayerColor attackColor = attackingPiece.getOwner();
			final PlayerColor defendColor = defendingPiece.getOwner();
			return (attackColor != defendColor);
		} else {
			return false;
		}
	}
}
