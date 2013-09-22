package strategy.game.version.validateMoveBehaviors;

import strategy.common.PlayerColor;
import strategy.common.StrategyRuntimeException;
import strategy.game.common.Location;
import strategy.game.common.PieceType;
import strategy.game.version.ValidateMoveBehavior;

public class OneSpaceInDirectionMoveValidator implements ValidateMoveBehavior {

	public OneSpaceInDirectionMoveValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) {
		try {
			// @TODO: does this check for diagonal?
			if (from.distanceTo(to) != 1) {
				return false;
			}
		} catch (StrategyRuntimeException e) {
			return false;
		}

		return true;
	}

}
