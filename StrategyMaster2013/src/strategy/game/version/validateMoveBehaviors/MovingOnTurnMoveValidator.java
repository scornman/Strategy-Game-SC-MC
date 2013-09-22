package strategy.game.version.validateMoveBehaviors;

import strategy.common.PlayerColor;
import strategy.game.common.Location;
import strategy.game.common.PieceType;
import strategy.game.version.Board;
import strategy.game.version.ValidateMoveBehavior;

public class MovingOnTurnMoveValidator implements ValidateMoveBehavior{
	private Board gameBoard;
	
	public MovingOnTurnMoveValidator(Board gameBoard) {
		// TODO Auto-generated constructor stub
		this.gameBoard = gameBoard;
	}

	/**
	 * move is valid only if it is the player's turn
	 */
	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) {
		PlayerColor pieceColor = gameBoard.getPieceAt(from).getOwner();
		
		if(pieceColor != currentColor){
			return false;
		}
		return true;
	}

}
