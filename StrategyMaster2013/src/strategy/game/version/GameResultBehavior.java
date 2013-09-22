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
	 * @TODO
	 * @param fromLocation
	 * @param toLocation
	 * @return
	 */
	public MoveResultStatus getGameStatus();
	
}
