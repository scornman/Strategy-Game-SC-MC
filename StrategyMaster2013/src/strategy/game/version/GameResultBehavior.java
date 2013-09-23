/**
 * 
 */
package strategy.game.version;

import strategy.game.common.Location;
import strategy.game.common.MoveResultStatus;

/**
 * @author Madalyn
 * @version 9/22/13
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
