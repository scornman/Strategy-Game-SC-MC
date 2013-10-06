package strategy.game.version.validateMoveBehaviors;

import strategy.common.PlayerColor;
import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.PieceType;
import strategy.game.version.ValidateMoveBehavior;

public class SeveralSpacesInOneDirectionMoveValidator implements
		ValidateMoveBehavior {

	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) throws StrategyException {
		// TODO Auto-generated method stub
		return false;
	}

}
