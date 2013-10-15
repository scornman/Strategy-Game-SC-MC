/**
 * 
 */
package strategy.game.version;

import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.MoveResultStatus;
import strategy.game.common.PieceType;

/**
 * @author Madalyn
 * @version 9/22/13
 * 
 */
public interface GameResultBehavior {

	/**
	 * gets the status of the game lets know if game is over/not and winner/no
	 * winner
	 * 
	 * @return MoveResultStatus indicating the state of the overall game
	 *         following this move.
	 * @throws StrategyException
	 */
	MoveResultStatus getGameStatus()
			throws StrategyException;

}
