/**
 * 
 */
package strategy.game.version;

import strategy.common.StrategyException;
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
	 * 
	 * @param fromLocation
	 *            will give the attacking piece
	 * @param toLocation
	 *            will give the defending piece
	 * @return boolean true if battle, false if no battle
	 * @throws StrategyException
	 *             if one of the given locations does not exist on the board.
	 */
	boolean isBattle(Location fromLocation, Location toLocation)
			throws StrategyException;

	/**
	 * 
	 * @param fromLocation
	 *            will give the attacking piece
	 * @param toLocation
	 *            will give the defending piece
	 * @return PieceLocationDescriptor of the piece that won the battle
	 * @throws StrategyException
	 *             if one of the given locations does not exist on the board.
	 */
	PieceLocationDescriptor getBattleWinner(Location fromLocation,
			Location toLocation) throws StrategyException;

}
