/**
 * 
 */
package strategy.game.version;

import java.util.Collection;
import java.util.List;

import strategy.common.StrategyException;
import strategy.game.StrategyGameController;
import strategy.game.common.Location;
import strategy.game.common.MoveResult;
import strategy.game.common.Piece;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.common.PieceType;

/**
 * @author Madalyn
 *
 */
public class StrategyGameControllerImpl implements StrategyGameController{
	Collection<ValidateConfigurationBehavior> configBehaviors;
	Collection<ValidateMoveBehavior> moveBehaviors;
	TurnUpdateBehavior turnUpdateBehavior;
	BattleBehavior battleBehavior;
	GameResultBehavior gameResultBehavior;
	Board gameBoard;
	
	/**
	 *  
	 */
	public StrategyGameControllerImpl(	Collection<ValidateConfigurationBehavior> configBehaviors,
										Collection<ValidateMoveBehavior> moveBehaviors,
										TurnUpdateBehavior turnUpdateBehavior,
										BattleBehavior battleBehavior,
										GameResultBehavior gameResultBehavior,
										Board gameBoard,
										List<PieceLocationDescriptor> configurations	) {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void startGame() throws StrategyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MoveResult move(PieceType piece, Location from, Location to)
			throws StrategyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Piece getPieceAt(Location location) {
		// TODO Auto-generated method stub
		return null;
	}

}
