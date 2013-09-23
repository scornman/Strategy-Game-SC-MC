package strategy.game.version.battleBehaviors;

import java.util.HashMap;
import java.util.Map;

import strategy.game.common.Location;
import strategy.game.common.Piece;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.common.PieceType;
import strategy.game.version.BattleBehavior;
import strategy.game.version.Board;

public class GammaBattleBehavior implements BattleBehavior {
	private Board gameBoard;
	private Map<PieceType, Integer> rankMap;

	/**
	 * Constructor for GammaBattleBehavior
	 * @param gameBoard takes in the board
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
	private Map<PieceType, Integer> setupPieceRanks() {
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
	public boolean isBattle(Location fromLocation, Location toLocation) {
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
	 */
	@Override
	public PieceLocationDescriptor getBattleWinner(Location fromLocation,
			Location toLocation) {
		Piece attackPiece = gameBoard.getPieceAt(fromLocation);
		Piece defendPiece = gameBoard.getPieceAt(toLocation);

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
