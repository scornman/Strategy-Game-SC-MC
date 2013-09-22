/**
 * 
 */
package strategy.game.version;

import strategy.game.common.Location;
import strategy.game.common.PieceType;

/**
 * @author Madalyn
 *
 */
public interface ValidateMoveBehavior {
	
	/**
	 * @TODO
	 * @param piece
	 * @param from
	 * @param to
	 * @return
	 */
	public boolean isMoveValid(PieceType piece, Location from, Location to);

}
