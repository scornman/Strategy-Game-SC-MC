package strategy.game.version.battleBehaviors;

import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.Piece;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.common.PieceType;
import strategy.game.version.Board;

/**
 * BattleBehavior implementation for Delta Strategy. It uses and builds upon the
 * basic functionality provided by GammaBattleBehavior.
 * 
 * @author scornman
 * @version 10/7/2013
 * 
 */
public class DeltaBattleBehavior extends GammaBattleBehavior {

	/**
	 * Creates a new DeltaBattleBehavior object.
	 * 
	 * @param gameBoard
	 *            the board containing all of the pieces in the game and their
	 *            corresponding locations.
	 */
	public DeltaBattleBehavior(Board gameBoard) {
		super(gameBoard);
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
		// Determine the battle participants
		final Piece attackPiece = gameBoard.getPieceAt(fromLocation);
		final PieceType attackType = attackPiece.getType();
		final Piece defendPiece = gameBoard.getPieceAt(toLocation);
		final PieceType defendType = defendPiece.getType();

		// Handle the battle interactions that do not follow the standard
		// higher-strength-piece-wins pattern.
		switch (defendType) {
		case BOMB:
			// The miner defeats the bomb and takes its position.
			if (attackType == PieceType.MINER) {
				return new PieceLocationDescriptor(attackPiece, toLocation);
			} else {
				// Everything else loses to the bomb, but the bomb does not take
				// the loser's position.
				return new PieceLocationDescriptor(defendPiece, toLocation);
			}
		case MARSHAL:
			// A defending marshal loses to an attacking spy, but interacts
			// normally with all other pieces.
			if (attackType == PieceType.SPY) {
				return new PieceLocationDescriptor(attackPiece, toLocation);
			} else {
				return super.getBattleWinner(fromLocation, toLocation);
			}
		default:
			return super.getBattleWinner(fromLocation, toLocation);
		}
	}

}
