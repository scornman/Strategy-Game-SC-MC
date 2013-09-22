package strategy.game.version.turnUpdateBehaviors;

import strategy.common.PlayerColor;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.version.TurnUpdateBehavior;

public class AlternateTeamTurnBehavior implements TurnUpdateBehavior{

	public AlternateTeamTurnBehavior() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public PlayerColor updateTurn(PieceLocationDescriptor attackPiece) {
		PlayerColor currentColor = attackPiece.getPiece().getOwner();
		
		if (currentColor == PlayerColor.RED){
			currentColor = PlayerColor.BLUE;
		}else{
			currentColor = PlayerColor.RED;
		}
		return currentColor;
	}

}
