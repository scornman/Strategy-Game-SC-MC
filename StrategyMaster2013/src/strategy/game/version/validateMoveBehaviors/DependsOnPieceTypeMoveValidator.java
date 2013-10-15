/*******************************************************************************
 * This files was developed for CS4233: Object-Oriented Analysis & Design.
 * The course was taken at Worcester Polytechnic Institute.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package strategy.game.version.validateMoveBehaviors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import strategy.common.PlayerColor;
import strategy.common.StrategyException;
import strategy.game.common.Location;
import strategy.game.common.PieceType;
import strategy.game.version.ValidateMoveBehavior;

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
	private final Map<PieceType, List<ValidateMoveBehavior>> behaviorsByPiece;
	
	/**
	 * The move validator to use for all piece types not specified in the
	 * behaviorsByPiece map.
	 */
	private final ValidateMoveBehavior defaultBehavior;

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
			Map<PieceType, List<ValidateMoveBehavior>> behaviorsByPiece,
			ValidateMoveBehavior defaultBehavior) {
		this.behaviorsByPiece = behaviorsByPiece;
		this.defaultBehavior = defaultBehavior;
	}
	
	@Override
	public boolean isMoveValid(PieceType piece, Location from, Location to,
			PlayerColor currentColor) throws StrategyException {
		List<ValidateMoveBehavior> pieceBehaviors;
		if (behaviorsByPiece.keySet().contains(piece)) {
			pieceBehaviors = behaviorsByPiece.get(piece);
		} else {
			pieceBehaviors = new ArrayList<ValidateMoveBehavior>();
			pieceBehaviors.add(defaultBehavior);					
		}
		for(ValidateMoveBehavior pieceBehavior : pieceBehaviors) {
			if (!pieceBehavior.isMoveValid(piece, from, to, currentColor)) {
				return false;
			}
		}
		return true;
	}
}
