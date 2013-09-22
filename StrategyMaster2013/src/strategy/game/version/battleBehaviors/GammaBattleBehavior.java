package strategy.game.version.battleBehaviors;

import strategy.game.common.Location;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.version.BattleBehavior;

public class GammaBattleBehavior implements BattleBehavior{

	public GammaBattleBehavior() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isBattle(Location fromLocation, Location toLocation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PieceLocationDescriptor getBattleWinner(Location fromLocation,
			Location toLocation) {
		// TODO Auto-generated method stub
		return null;
	}

}
