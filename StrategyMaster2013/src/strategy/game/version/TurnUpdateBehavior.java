/**
 * 
 */
package strategy.game.version;

import strategy.common.PlayerColor;
import strategy.game.common.PieceLocationDescriptor;

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
