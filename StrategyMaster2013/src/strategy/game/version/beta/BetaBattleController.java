/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package strategy.game.version.beta;

import java.util.HashMap;
import java.util.Map;

import strategy.common.PlayerColor;
import strategy.game.common.Location;
import strategy.game.common.MoveResult;
import strategy.game.common.MoveResultStatus;
import strategy.game.common.Piece;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.common.PieceType;

/**
 * Class for handling battles between two pieces.
 * 
 * @author scornman
 * @author Madalyn
 * @version Sep 15, 2013
 * 
 */
public class BetaBattleController {

	BetaBoard gameBoard;
	Location attackLocation;
	Location defendLocation;
	Map<PieceType, Integer> rankMap;

	/**
	 * Create a new BetaBattleController to manage a battle.
	 * 
	 * @param board
	 *            the game board.
	 * @param attackLocation
	 *            the location that the attacking piece moved from.
	 * @param defendLocation
	 *            the location of the defending piece.
	 */
	public BetaBattleController(BetaBoard board, Location attackLocation,
			Location defendLocation) {
		gameBoard = board;
		this.attackLocation = attackLocation;
		this.defendLocation = defendLocation;
		rankMap = setupPieceRanks();
	}

	/**
	 * Sets up the relationships between the piece types and their ranks.
	 * 
	 * @return a map that maps piece type to rank.
	 */
	private static Map<PieceType, Integer> setupPieceRanks() {
		final Map<PieceType, Integer> pieceRanks = new HashMap<PieceType, Integer>();
		pieceRanks.put(PieceType.MARSHAL, 12);
		pieceRanks.put(PieceType.COLONEL, 10);
		pieceRanks.put(PieceType.CAPTAIN, 8);
		pieceRanks.put(PieceType.LIEUTENANT, 7);
		pieceRanks.put(PieceType.SERGEANT, 6);
		pieceRanks.put(PieceType.FLAG, 1);
		return pieceRanks;
	}

	/**
	 * Determine the result of the battle.
	 * 
	 * @return the battle result.
	 */
	public MoveResult getBattleResult() {
		final Piece attackPiece = gameBoard.getPieceAt(attackLocation);
		final Piece defendPiece = gameBoard.getPieceAt(defendLocation);

		final Piece winningPiece = getWinningPiece(attackPiece, defendPiece);
		Location winnerLocation;
		PieceLocationDescriptor battleWinner;

		if (winningPiece == null) {
			battleWinner = null;
		} else {
			if (winningPiece.equals(attackPiece)) {
				winnerLocation = defendLocation;
			} else {
				winnerLocation = attackLocation;
			}
			battleWinner = new PieceLocationDescriptor(winningPiece,
					winnerLocation);
		}

		MoveResultStatus status = null;

		if (defendPiece.getType() == PieceType.FLAG) {
			if (defendPiece.getOwner() == PlayerColor.BLUE) {
				status = MoveResultStatus.RED_WINS;
			} else {
				status = MoveResultStatus.BLUE_WINS;
			}
		} else {
			status = MoveResultStatus.OK;
		}

		return new MoveResult(status, battleWinner);

	}

	/**
	 * Determine which of two pieces wins the battle.
	 * 
	 * @param attackPiece
	 *            the piece that is attacking.
	 * @param defendPiece
	 *            the piece that is defending.
	 * @return the piece that wins the battle.
	 */
	private Piece getWinningPiece(Piece attackPiece, Piece defendPiece) {
		final int attackerRank = rankMap.get(attackPiece.getType());
		final int defenderRank = rankMap.get(defendPiece.getType());

		if (attackerRank > defenderRank) {
			return attackPiece;
		} else if (defenderRank > attackerRank) {
			return defendPiece;
		} else {
			// If the two pieces have the same rank, there is no battle winner.
			return null;
		}
	}
}
