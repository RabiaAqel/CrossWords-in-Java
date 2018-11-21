/*
 * 
 */
package oop.ex3.crosswords;

import java.util.*;

import oop.ex3.search.SearchBoardNode;

/*
 * The Class MyCrossword.
 * This class implements the Crossword Game.
 */
public class MyCrossword implements Crossword {

	/** The crossword entries. */
	private List<CrosswordEntry> entries = new ArrayList<CrosswordEntry>();

	/** The current quality. */
	private int quality = 0;

	/** The given structure. */
	private MyStructure structure;

	/** The given glossary. */
	private MyGlossary glossary;

	/**
	 * Instantiates a new my crossword.
	 */
	public MyCrossword() {

	}

	/* (non-Javadoc)
	 * @see oop.ex3.search.SearchBoardNode#getQualityBound()
	 */
	@Override
	public int getQualityBound() {
		QualityBound bounder = new CrosswordQualityBound(this.structure,
				this.glossary);
		return bounder.getQualityBound() + this.quality;
	}

	/* (non-Javadoc)
	 * @see oop.ex3.search.SearchBoardNode#getQuality()
	 */
	@Override
	public int getQuality() {
		return this.quality;
	}

	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.Crossword#getCrosswordEntries()
	 */
	@Override
	public Collection<CrosswordEntry> getCrosswordEntries() {
		return this.entries;
	}

	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.Crossword#attachGlossary(oop.ex3.crosswords.CrosswordGlossary)
	 */
	@Override
	public void attachGlossary(CrosswordGlossary glossary) {
		this.glossary = (MyGlossary) glossary;
	}

	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.Crossword#attachStructure(oop.ex3.crosswords.CrosswordStructure)
	 */
	@Override
	public void attachStructure(CrosswordStructure structure) {
		this.structure = (MyStructure) structure;
	}

	/* (non-Javadoc)
	 * @see oop.ex3.search.SearchBoardNode#isBestSolution()
	 */
	@Override
	public boolean isBestSolution() {
		/*
		 * the current node represents a best solution node iff its current
		 * quality equals to the upper quality the node could reach.
		 */
		return this.getQuality() == this.getQualityBound();
	}

	/* (non-Javadoc)
	 * @see oop.ex3.search.SearchBoardNode#getMovesIterator()
	 */
	@Override
	public Iterator<CrosswordEntry> getMovesIterator() {
		
		return new EntriesIterator<CrosswordEntry>(this.structure, this.glossary);
	}

	/* (non-Javadoc)
	 * @see oop.ex3.search.SearchBoardNode#doMove(oop.ex3.search.SearchMove)
	 */
	@Override
	public void doMove(CrosswordEntry move) {
		// appends the term to the structure
		this.structure.appendTerm(move);
		// update the quality value by adding the term's length.
		this.quality += move.getTerm().length();
		// deletes the term out of this glossary
		this.glossary.removeWord(move.getTerm());
		// finally adds the term as an entry
		this.entries.add(move);

	}

	/* (non-Javadoc)
	 * @see oop.ex3.search.SearchBoardNode#undoMove(oop.ex3.search.SearchMove)
	 */
	@Override
	public void undoMove(CrosswordEntry move) {
		/* Unsupported move */
	}

	/* (non-Javadoc)
	 * @see oop.ex3.search.SearchBoardNode#getCopy()
	 */
	@Override
	public SearchBoardNode<CrosswordEntry> getCopy() {

		MyCrossword nodeCopy = new MyCrossword();
		nodeCopy.entries = new ArrayList<CrosswordEntry>();
		nodeCopy.entries.addAll(this.entries);
		// copies the quality
		nodeCopy.quality = this.quality;
		// copies the glossary
		nodeCopy.glossary = (MyGlossary) this.glossary.getCopy();
		// copies the structure
		nodeCopy.structure = this.structure.getCopy();
		return nodeCopy;

	}
}