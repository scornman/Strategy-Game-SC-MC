/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package strategy.game.version.battleBehaviors;

import java.util.HashMap;
import java.util.Map;

import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.Piece;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.common.PieceType;
import strategy.game.version.BattleBehavior;
import strategy.game.version.Board;

/**
 * 
 * Battle behavior implementation for Gamma Strategy.
 * 
 * @author Madalyn
 * @author scornman
 * @version 9/22/13
 * 
 */
public class GammaBattleBehavior implements BattleBehavior {
	private final Board gameBoard;
	private final Map<PieceType, Integer> rankMap;

	/**
	 * Constructor for GammaBattleBehavior
	 * 
	 * @param gameBoard
	 *            takes in the board
	 */
	public GammaBattleBehavior(Board gameBoard) {
		this.gameBoard = gameBoard;
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

	@Override
	public boolean isBattle(Location fromLocation, Location toLocation) throws StrategyException {
		// check if there is a piece in the toLocation
		if (gameBoard.getPieceAt(toLocation) != null) {
			return true;
		}
		return false;
	}

	/**
	 * Determine which of two pieces wins the battle. if there is no piece
	 * defending the to location, the attacking piece wins if there are two of
	 * the same pieces in the battle, neither wins
	 * 
	 * @param attackPiece
	 *            the piece that is attacking.
	 * @param defendPiece
	 *            the piece that is defending.
	 * @return the piece that wins the battle.
	 * @throws StrategyException 
	 */
	@Override
	public PieceLocationDescriptor getBattleWinner(Location fromLocation,
			Location toLocation) throws StrategyException {
		final Piece attackPiece = gameBoard.getPieceAt(fromLocation);
		final Piece defendPiece = gameBoard.getPieceAt(toLocation);

		final int attackerRank = rankMap.get(attackPiece.getType());
		final int defenderRank = rankMap.get(defendPiece.getType());

		if (attackerRank > defenderRank) {
			return new PieceLocationDescriptor(attackPiece, toLocation);
		} else if (defenderRank > attackerRank) {
			return new PieceLocationDescriptor(defendPiece, fromLocation);
		} else {
			// If the two pieces have the same rank, there is no battle winner.
			return null;
		}
	}
}
