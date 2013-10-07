package strategy.game.version.validateMoveBehaviors;

import strategy.common.PlayerColor;
import strategy.common.StrategyException;
import strategy.game.common.Coordinate;
import strategy.game.common.Location;
import strategy.game.common.PieceType;
import strategy.game.version.Board;
import strategy.game.version.ValidateMoveBehavior;

public class SeveralSpacesInOneDirectionMoveValidator implements
		ValidateMoveBehavior {
	private final Board gameBoard;

	/**
	 * Constructor for SeveralSpacesInOneDirectionMoveValidator
	 * @param gameBoard must take-in game board to determine if moving over
	 * spaces with pieces on them & violating rules
	 */
	public SeveralSpacesInOneDirectionMoveValidator(Board gameBoard){
		this.gameBoard = gameBoard;
	}
	
	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) throws StrategyException {
		// TODO Auto-generated method stub
		isInSameLine(from, to);
		return false;
	}
	
	/**
	 * Makes sure the piece [Scout] is trying to move somewhere in the same line
	 * Check that either the x coords are the same or the y coords are the same
	 * @param from starting piece location
	 * @param to ending location piece is moving to
	 * @return true if moving in the same line
	 */
	private boolean isInSameLine(Location from, Location to){
		return (from.getCoordinate(Coordinate.X_COORDINATE) == to.getCoordinate(Coordinate.X_COORDINATE) ||
				from.getCoordinate(Coordinate.Y_COORDINATE) == to.getCoordinate(Coordinate.Y_COORDINATE));
	
	}

}
