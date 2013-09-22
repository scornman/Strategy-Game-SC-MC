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
	
	public boolean isMoveValid(PieceType piece, Location from, Location to);

}
