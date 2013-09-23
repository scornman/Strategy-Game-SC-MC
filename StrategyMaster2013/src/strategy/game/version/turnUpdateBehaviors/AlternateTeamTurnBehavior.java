package strategy.game.version.turnUpdateBehaviors;

import strategy.common.PlayerColor;

import strategy.game.version.TurnUpdateBehavior;

public class AlternateTeamTurnBehavior implements TurnUpdateBehavior{

	

	@Override
	public PlayerColor updateTurn(PlayerColor currentColor) {		
		if (currentColor == PlayerColor.RED){
			currentColor = PlayerColor.BLUE;
		}else{
			currentColor = PlayerColor.RED;
		}
		return currentColor;
	}

}
