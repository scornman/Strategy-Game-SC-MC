/**
 * 
 */
package strategy.game.version;

import strategy.game.common.Location;
import strategy.game.common.PieceLocationDescriptor;

/**
 * @author Madalyn
 * @version 9/22/13
 *
 */
public interface BattleBehavior {
	
	/**
	 * checks to see if there is a battle
	 * @param fromLocation will give the attacking piece
	 * @param toLocation will give the defending piece
	 * @return boolean true if battle, false if no battle
	 */
	boolean isBattle(Location fromLocation, Location toLocation);
	
	/**
	 * 
	 * @param fromLocation will give the attacking piece
	 * @param toLocation will give the defending piece
	 * @return PieceLocationDescriptor of the piece that won the battle
	 */
	PieceLocationDescriptor getBattleWinner(Location fromLocation, Location toLocation);

}
