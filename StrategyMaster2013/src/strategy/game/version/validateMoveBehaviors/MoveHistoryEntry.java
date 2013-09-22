package strategy.game.version.validateMoveBehaviors;

import strategy.game.common.Location;
import strategy.game.common.PieceType;

/**
 * Stores a single move as a history entry, which can be used to check the
 * history of past moves.
 * 
 * @author scornman
 * 
 */
public class MoveHistoryEntry {

	private PieceType piece;
	private Location from;
	private Location to;

	/**
	 * Creates a new MoveHistoryEntry object.
	 * 
	 * @param piece
	 *            the type of piece that was moved.
	 * @param from
	 *            the location that the piece was moved from.
	 * @param to
	 *            the location that the piece was moved to.
	 */
	public MoveHistoryEntry(PieceType piece, Location from, Location to) {
		this.piece = piece;
		this.from = from;
		this.to = to;
	}

	/**
	 * Gets the type of piece that was moved.
	 * 
	 * @return the type of piece that was moved.
	 */
	public PieceType getPieceType() {
		return piece;
	}

	/**
	 * Gets the location that was moved from.
	 * 
	 * @return the location that was moved from.
	 */
	public Location getFrom() {
		return from;
	}

	/**
	 * Gets the location that was moved to.
	 * 
	 * @return the location that was moved to.
	 */
	public Location getTo() {
		return to;
	}

	/**
	 * Determines whether this move is the same as another move in terms of
	 * from and to locations.
	 * 
	 * @param otherMove
	 *            the other move to compare this move to.
	 * @return true if the from location of this move matches the from location of
	 *         the other move and the to location of this move matches the to
	 *         location of the other move.
	 */
	public boolean isSameMove(MoveHistoryEntry otherMove) {
		return (from == otherMove.getFrom()) && (to == otherMove.getTo());
	}

	/**
	 * Determines whether this move is the reverse of another move in terms of
	 * from and to locations.
	 * 
	 * @param otherMove
	 *            the other move to compare this move to.
	 * @return true if the to location of this move matches the from location of
	 *         the other move and the from location of this move matches the to
	 *         location of the other move.
	 */
	public boolean isOppositeMove(MoveHistoryEntry otherMove) {
		return (from == otherMove.getTo()) && (to == otherMove.getFrom());
	}

}
