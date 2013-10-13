package strategy.game.reporter;

import java.util.Collection;

import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.MoveResult;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.common.PieceType;
import strategy.game.common.StrategyGameObserver;

public class StrategyGameReporter implements StrategyGameObserver{

	public StrategyGameReporter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * detect the gameStart to start observing
	 */
	@Override
	public void gameStart(Collection<PieceLocationDescriptor> redConfiguration,
			Collection<PieceLocationDescriptor> blueConfiguration) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * updates when a move happens
	 */
	@Override
	public void moveHappened(PieceType piece, Location from, Location to,
			MoveResult result, StrategyException fault) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Print the change
	 */
	public void print(){
		System.out.println("");
	}
	
}
