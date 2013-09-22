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

		if (!gameBoard.containsPiece(new Piece(PieceType.FLAG, PlayerColor.BLUE))) {
			status = MoveResultStatus.RED_WINS;
		} else if (!gameBoard.containsPiece(new Piece(PieceType.FLAG, PlayerColor.RED))){
			status = MoveResultStatus.BLUE_WINS;
		} else {
			//else no winner
			status = MoveResultStatus.OK;
		}

		return status;
	}
}
