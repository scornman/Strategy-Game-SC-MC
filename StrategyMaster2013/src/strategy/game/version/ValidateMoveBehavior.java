/**
 * 
 */
package strategy.game.version;

import strategy.common.PlayerColor;
import strategy.game.common.Location;
import strategy.game.common.PieceType;

/**
 * @author Madalyn
 * @version 9/22/13
 * 
 */
public interface ValidateMoveBehavior {

	/**
	 * @TODO
	 * @param piece
	 * @param from
	 * @param to
	 * @param currentColor
	 * @return true if the move is valid according to this condition, false
	 *         otherwise.
	 */
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor);

}
