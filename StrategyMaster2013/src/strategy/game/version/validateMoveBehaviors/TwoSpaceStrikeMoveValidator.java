package strategy.game.version.validateMoveBehaviors;

import strategy.common.PlayerColor;
import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.PieceType;
import strategy.game.version.Board;
import strategy.game.version.ValidateMoveBehavior;

public class TwoSpaceStrikeMoveValidator implements ValidateMoveBehavior {

	public TwoSpaceStrikeMoveValidator(Board gameBoard) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) throws StrategyException {
		// TODO Auto-generated method stub
		return true;
	}

}
