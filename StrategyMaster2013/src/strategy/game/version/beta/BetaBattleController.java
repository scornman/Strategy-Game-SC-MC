package strategy.game.version.beta;

import strategy.common.PlayerColor;
import strategy.game.common.Location;
import strategy.game.common.MoveResult;
import strategy.game.common.MoveResultStatus;
import strategy.game.common.Piece;
import strategy.game.common.PieceLocationDescriptor;
import strategy.game.common.PieceType;

/**
 * Class for handling battles between two pieces.
 * 
 * @author scornman
 * @version Sep 15, 2013
 * 
 */
public class BetaBattleController {

	BetaBoard gameBoard;
	Location attackLocation;
	Location defendLocation;

	public BetaBattleController(BetaBoard board, Location attackLocation,
			Location defendLocation) {
		gameBoard = board;
		this.attackLocation = attackLocation;
		this.defendLocation = defendLocation;
	}

	public MoveResult getBattleResult() {
		Piece attackPiece = gameBoard.getPieceAt(attackLocation);
		Piece defendPiece = gameBoard.getPieceAt(defendLocation);

		// TODO: HACK!
		Piece winningPiece = attackPiece;

		MoveResultStatus status = MoveResultStatus.RED_WINS;

		return new MoveResult(status,
				new PieceLocationDescriptor(attackPiece, defendLocation));

//		if (targetPiece.getOwner() == PlayerColor.BLUE) {
//			// TODO: Remove Fake
//
//		} else if (targetPiece.getOwner() == PlayerColor.RED) {
//			// TODO: Remove Fake
//			return new MoveResult(MoveResultStatus.BLUE_WINS,
//					new PieceLocationDescriptor(movingPiece, to));
//		}

	}
}
