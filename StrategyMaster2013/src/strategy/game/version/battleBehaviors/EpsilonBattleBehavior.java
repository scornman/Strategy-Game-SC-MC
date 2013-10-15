package strategy.game.version.battleBehaviors;

import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.Piece;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.common.PieceType;
import strategy.game.version.Board;

public class EpsilonBattleBehavior extends DeltaBattleBehavior {

	public EpsilonBattleBehavior(Board gameBoard) {
		super(gameBoard);
		// TODO Auto-generated constructor stub
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
		
		PieceLocationDescriptor winner = super.getBattleWinner(fromLocation, toLocation);
		
		//if no battle winner
		if(winner == null){
			return null;
		}
		
		//if the piece attacks from two spaces away, the winner is always at the
		//defender's (or tolocation) location
		if(fromLocation.distanceTo(toLocation) == 2) {
			PieceLocationDescriptor newWinner = new PieceLocationDescriptor(winner.getPiece(), toLocation);
			return newWinner;

		} else {
			return winner;
		}

	
	}

}
