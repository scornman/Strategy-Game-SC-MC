package strategy.game.version.gameResultBehaviors;

import strategy.common.PlayerColor;
import strategy.game.common.MoveResultStatus;
import strategy.game.common.Piece;
import strategy.game.common.PieceType;
import strategy.game.version.Board;
import strategy.game.version.GameResultBehavior;

public class StatusGameResultBehavior implements GameResultBehavior{
	private Board gameBoard;
	
	public StatusGameResultBehavior(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	/**
	 * Determine the result of the battle.
	 * only wins if the flag is captured
	 * 
	 * @return the battle result.
	 */
	@Override
	public MoveResultStatus getGameStatus() {
		MoveResultStatus status = null;

		//if the blue flag is gone, red wins
		if (!gameBoard.containsPiece(new Piece(PieceType.FLAG, PlayerColor.BLUE))) {
			status = MoveResultStatus.RED_WINS;
			
		//if the red flag is gone, blue wins	
		} else if (!gameBoard.containsPiece(new Piece(PieceType.FLAG, PlayerColor.RED))){
			status = MoveResultStatus.BLUE_WINS;
			
		//no winner
		} else {
			for(PieceType type : PieceType.values()){
				//if there is a piece type besides flag on the board, 
				//the game isn't over yet
				if (type != PieceType.FLAG){
					if ( gameBoard.containsPiece(new Piece(type, PlayerColor.RED)) ||
						 gameBoard.containsPiece(new Piece(type, PlayerColor.BLUE)) ){
						return MoveResultStatus.OK;
					}					
				}
			}
			//if there are only flags on the board, it's a draw
			status = MoveResultStatus.DRAW;
		}
		
		return status;
	}
}
