/**
 * 
 */
package strategy.game.version;

import strategy.common.PlayerColor;


/**
 * @author Madalyn
 *
 */
public interface TurnUpdateBehavior {

	/**
	 * @TODO
	 * @return the color whose turn it is
	 */
	PlayerColor updateTurn(PlayerColor currentColor);
}
