package strategy.game.version.gameResultBehaviors;

import strategy.common.PlayerColor;
import strategy.game.common.Location;
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
	public MoveResultStatus getGameStatus(Location fromLocation,
			Location toLocation) {
		final Piece defendPiece = gameBoard.getPieceAt(toLocation);

		MoveResultStatus status = null;

		if (defendPiece.getType() == PieceType.FLAG) {
			if (defendPiece.getOwner() == PlayerColor.BLUE) {
				status = MoveResultStatus.RED_WINS;
			} else {
				status = MoveResultStatus.BLUE_WINS;
			}
		} else {
			status = MoveResultStatus.OK;
		}

		return status;
	}
}
