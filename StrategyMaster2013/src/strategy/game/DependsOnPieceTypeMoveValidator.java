package strategy.game;

import java.util.Map;

import strategy.common.PlayerColor;
import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.PieceType;
import strategy.game.version.ValidateMoveBehavior;
import strategy.game.version.validateMoveBehaviors.OneSpaceInDirectionMoveValidator;

/**
 * A validateMoveBehavior that changes its behavior based on the type of piece
 * that is moving.
 * 
 * @author scornman
 * @version 10/5/2013
 */
public class DependsOnPieceTypeMoveValidator implements ValidateMoveBehavior {

	/**
	 * Maps individual piece types to their matching move behaviors.
	 */
	private Map<PieceType, ValidateMoveBehavior> behaviorsByPiece;
	/**
	 * The move validator to use for all piece types not specified in the
	 * behaviorsByPiece map.
	 */
	private ValidateMoveBehavior defaultBehavior;

	/**
	 * Create a new DependsOnPieceTypeMoveValidator object.
	 * 
	 * @param behaviorsByPiece
	 *            Maps individual piece types to their matching move behaviors.
	 * @param defaultBehavior
	 *            The move validator to use for all piece types not specified in
	 *            the behaviorsByPiece map.
	 */
	public DependsOnPieceTypeMoveValidator(
			Map<PieceType, ValidateMoveBehavior> behaviorsByPiece,
			ValidateMoveBehavior defaultBehavior) {
		this.behaviorsByPiece = behaviorsByPiece;
		this.defaultBehavior = defaultBehavior;
	}

	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) throws StrategyException {
		ValidateMoveBehavior pieceBehavior;
		if (behaviorsByPiece.keySet().contains(piece)) {
			pieceBehavior = behaviorsByPiece.get(piece);
		} else {
			pieceBehavior = defaultBehavior;
		}

		return pieceBehavior.isMoveValid(piece, from, to, currentColor);
	}
}
