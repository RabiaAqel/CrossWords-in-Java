/*
 * 
 */
package oop.ex3.crosswords;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents the structure of the crossword board that is used in
 * this assignment.
 */
public class MyCrosswordStructure implements MyStructure, Cloneable {

	/** The data. */
	private Slot[][] data;

	/**
	 * The Class Slot.
	 */
	private class Slot {

		/** The character. */
		private char character;
		
		/** The overlapping. */
		private int overlapping;
		
		/** The Constant EMPTY_SLOT. */
		public static final char EMPTY_SLOT = '_';
		
		/** The Constant OVERLAPS_INITIAL. */
		private static final int OVERLAPS_INITIAL = 0;

		/**
		 * Instantiates a new slot.
		 *
		 * @param letter the letter
		 */
		public Slot(char letter) {
			this.character = letter;
			this.overlapping = OVERLAPS_INITIAL;
		}

		/**
		 * Gets the character.
		 *
		 * @return the character
		 */
		public char getCharacter() {
			return this.character;
		}

		/**
		 * Gets the slot type.
		 *
		 * @return the slot type
		 */
		public SlotType getSlotType() {
			return (this.character == Slot.EMPTY_SLOT) ? SlotType.UNUSED_SLOT
					: SlotType.FRAME_SLOT;
		}

		/**
		 * Gets the copy.
		 *
		 * @return the copy
		 */
		public Slot getCopy() {
			return new Slot(this.character);
		}

		/**
		 * Sets the character.
		 *
		 * @param letter the new character
		 */
		public void setCharacter(char letter) {
			this.character = letter;
			this.overlapping++;
		}

		/**
		 * Removes the character.
		 */
		public void removeCharacter() {
			if (this.overlapping == 1)
				this.character = EMPTY_SLOT;
			this.overlapping--;
		}

	}

	/**
	 * Removes the word.
	 *
	 * @param entry the entry
	 */
	public void removeWord(CrosswordEntry entry) {
		int x = entry.getPosition().getX();
		int y = entry.getPosition().getY();

		String term = entry.getTerm();
		int length = term.length();

		boolean align = entry.getPosition().isVertical();
		if (align)
			for (int index = 0; index < length; index++) {
				this.data[y][x].removeCharacter();
				y++;
			}
		else
			for (int index = 0; index < length; index++) {
				this.data[y][x].removeCharacter();
				x++;
			}
	}

	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.CrosswordStructure#appendTerm(oop.ex3.crosswords.CrosswordEntry)
	 */
	public void appendTerm(CrosswordEntry entry) {
		int x = entry.getPosition().getX();
		int y = entry.getPosition().getY();

		String term = entry.getTerm();
		int length = term.length();

		boolean align = entry.getPosition().isVertical();

		if (align)
			for (int index = 0; index < length; index++) {
				this.data[y][x].setCharacter(term.charAt(index));
				y++;
			}
		else
			for (int index = 0; index < length; index++) {
				this.data[y][x].setCharacter(term.charAt(index));
				x++;
			}
	}

	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.CrosswordStructure#load(java.lang.String)
	 */
	@Override
	public void load(String textFileName) throws IOException {
		ArrayList<String> lines = new ArrayList<String>();

		String line = null;
		Scanner scanner = null;

		try {
			scanner = new Scanner(new FileReader(textFileName));

			while (scanner.hasNextLine()) {
				line = scanner.nextLine().trim();
				lines.add(line);
			}
		} finally {
			if (scanner != null)
				scanner.close();
		}
		initiateData(lines, line);
	}

	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.CrosswordStructure#getSlotType(oop.ex3.crosswords.CrosswordPosition)
	 */
	@Override
	public SlotType getSlotType(CrosswordPosition pos) {

		if ((pos.getX() >= getWidth()) || (pos.getX() < 0)
				|| (pos.getY() >= getHeight()) || (pos.getY() < 0))
			return SlotType.FRAME_SLOT;

		return this.data[pos.getY()][pos.getX()].getSlotType();
	}

	/**
	 * Gets the slot at.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the slot at
	 */
	public Slot getSlotAt(int x, int y) {
		return this.data[y][x];
	}

	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.CrosswordStructure#getWidth()
	 */
	@Override
	public Integer getWidth() {
		return (this.data[0].length);
	}

	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.CrosswordStructure#getHeight()
	 */
	@Override
	public Integer getHeight() {
		return (this.data.length);
	}

	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.CrosswordStructure#getVerticalArray()
	 */
	public String[] getVerticalArray() {
		String[] verticalRegex = new String[getWidth()];
		StringBuilder content;
		for (int i = 0; i <= getWidth()-1; i++) {
			content = new StringBuilder(getHeight());
			for (int j = 0; j <= getHeight()-1; j++) {
				if (data[j][i].getCharacter() == Slot.EMPTY_SLOT)
					content.insert(j, '.');
				else
					content.insert(j, data[j][i].getCharacter());
			}
			verticalRegex[i] = content.toString();
		}
		return verticalRegex;
	}

	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.CrosswordStructure#getHorizontalArray()
	 */
	public String[] getHorizontalArray() {
		String[] horizontalRegex = new String[getHeight()]; 
		StringBuilder content;

		for (int i = 0; i <= getHeight()-1; i++) {
			content = new StringBuilder(getWidth());
			for (int j = 0; j <= getWidth()-1; j++) {
				if (data[i][j].getCharacter() == Slot.EMPTY_SLOT)
					content.insert(j, '.');
				else
					content.insert(j, data[i][j].getCharacter());
			}
			horizontalRegex[i] = content.toString();
		}
		return horizontalRegex;
	}

	/**
	 * Initiate data.
	 *
	 * @param lines the lines
	 * @param line the line
	 */
	private void initiateData(ArrayList<String> lines, String line) {
		this.data = new Slot[lines.size()][line.length()];
		for (int x = 0; x <= lines.size() - 1; x++)
			for (int y = 0; y <= lines.get(x).length() - 1; y++)
				this.data[x][y] = new Slot(lines.get(x).charAt(y));
	}

	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.CrosswordStructure#getCopy()
	 */
	public MyCrosswordStructure getCopy() {
		Slot[][] copiedBoard = new Slot[this.data.length][this.data[0].length];

		for (int x = 0; x < this.data.length; x++)
			for (int y = 0; y < this.data[0].length; y++)
				copiedBoard[x][y] = this.data[x][y].getCopy();

		MyCrosswordStructure copy = new MyCrosswordStructure();
		copy.data = copiedBoard;

		return copy;
	}

}