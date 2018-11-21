/*
 * 
 */
package oop.ex3.crosswords;

/**
 * A crossword entry is a word at a given position in a crossword.
 */
public class MyCrosswordEntry implements MyEntry, Comparable<MyEntry> {

	/** The position. */
	private final CrosswordPosition position;

	/** The term. */
	private final String term;

	/** The term definition. */
	private final String definition;

	/** The number of overlaps. */
	private final int overlapping;

	/**
	 * Instantiates a new my crossword entry.
	 *
	 * @param pos the pos
	 * @param term the term
	 * @param definition the definition
	 * @param numberOfOverlaps the number of overlaps
	 */
	public MyCrosswordEntry(CrosswordPosition pos, String term, String definition,
			int numberOfOverlaps) {
		this.position = pos;
		this.term = term;
		this.definition = definition;
		this.overlapping = numberOfOverlaps;
	}

	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.CrosswordEntry#getPosition()
	 */
	public CrosswordPosition getPosition() {
		return position;
	}


	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.CrosswordEntry#getTerm()
	 */
	public String getTerm() {
		return term;
	}

	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.CrosswordEntry#getLength()
	 */
	public int getLength() {
		return term.length();
	}


	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.CrosswordEntry#getNumberOfOverlaps()
	 */
	public int getOverlapping() {
		return overlapping;
	}


	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(MyEntry otherEntry) {
		int x = otherEntry.getPosition().getX();
		int y = otherEntry.getPosition().getY();
		boolean isVertical = otherEntry.getPosition().isVertical();

		if (this.overlapping < otherEntry.getOverlapping())
			return 1;
		else 
			if (this.overlapping > otherEntry.getOverlapping())
				return -1;
			else {

				if(this.position.getX() == x){
					if(this.position.getY() == y){
						if(this.position.isVertical() && isVertical){
							return 0;

						}
						return this.position.isVertical() ? 1 : -1;
					}
					return this.position.getY() - y;
				}
				return this.position.getX() - x;
			}
	}

	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.CrosswordEntry#getDefinition()
	 */
	@Override
	public String getDefinition() {
		return this.definition;
	}
}