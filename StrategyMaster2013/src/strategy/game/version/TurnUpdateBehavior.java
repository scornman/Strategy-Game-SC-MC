/**
 * 
 */
package strategy.game.version;

import strategy.common.PlayerColor;
import strategy.game.common.PieceLocationDescriptor;

/**
 * @author Madalyn
 * @version 9/22/13
 * 
 */
public interface TurnUpdateBehavior {

	/**
	 * Strategy Pattern Interface responsible for updating the game state at the
	 * end of each turn.
	 * 
	 * @param currentColor
	 *            the color whose turn it is
	 * @return the color whose turn it will be for the next turn
	 */
	PlayerColor updateTurn(PlayerColor currentColor);
}
