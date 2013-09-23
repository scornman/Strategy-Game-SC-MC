/**
 * 
 */
package strategy.game.version;

import strategy.game.common.Location;
import strategy.game.common.MoveResultStatus;

/**
 * @author Madalyn
 *
 */
public interface GameResultBehavior {
	

	/**
	 * gets the status of the game
	 * lets know if game is over/not and winner/no winner
	 * @return MoveResultStatus
	 */
	MoveResultStatus getGameStatus();
	
}
