package strategy.game.version.validateMoveBehaviors;

import strategy.common.PlayerColor;
import strategy.game.common.Location;
import strategy.game.common.PieceType;
import strategy.game.version.ValidateMoveBehavior;

public class NotMovingFlagMoveValidator implements ValidateMoveBehavior {

	public NotMovingFlagMoveValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) {
		// TODO Auto-generated method stub
		if (piece == PieceType.FLAG) {
			return false;
		}
		return true;
	}

}
