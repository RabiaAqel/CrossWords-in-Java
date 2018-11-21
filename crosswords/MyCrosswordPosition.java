/*
 * 
 */
package oop.ex3.crosswords;

import oop.ex3.crosswords.CrosswordPosition;

/**
 * The Class MyCrosswordPosition.
 */
public class MyCrosswordPosition implements CrosswordPosition {

	/** The x coordinate position on the board. */
	private int x;

	/** The y coordinate position on the board. */
	private int y;

	/** Holds true iff the position is a vertical position. */
	private boolean isVertical;

	/**
	 * Instantiates a new my crossword position.
	 *
	 * @param x the x
	 * @param y the y
	 * @param isVertical the is vertical
	 */
	public MyCrosswordPosition(int x, int y, boolean isVertical) {
		this.x = x;
		this.y = y;
		this.isVertical = isVertical;
	}

	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.CrosswordPosition#getX()
	 */
	@Override
	public int getX() {
		return (this.x);
	}

	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.CrosswordPosition#getY()
	 */
	@Override
	public int getY() {
		return (this.y);
	}

	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.CrosswordPosition#isVertical()
	 */
	@Override
	public boolean isVertical() {
		return (this.isVertical);
	}

}