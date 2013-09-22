/**
 * 
 */
package strategy.game.version;

import strategy.game.common.Location;
import strategy.game.common.PieceLocationDescriptor;

/**
 * @author Madalyn
 *
 */
public interface BattleBehavior {
	
	/**
	 * checks to see if there is a battle
	 * @param fromLocation will give the attacking piece
	 * @param toLocation will give the defending piece
	 * @return
	 */
	public boolean isBattle(Location fromLocation, Location toLocation);
	
	/**
	 * 
	 * @return
	 */
	public PieceLocationDescriptor getBattleWinner(Location fromLocation, Location toLocation);

}
