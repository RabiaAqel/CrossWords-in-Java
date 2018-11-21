/*
 * 
 */
package oop.ex3.crosswords;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class EntryLoader.
 */
public class EntryLoader {

	/**
	 * Load the entries.
	 *
	 * @param structure the structure
	 * @param term the term
	 * @param definition the term definition
	 * @param optimizer the optimizer
	 * @return the sets the
	 */
	public static Set<CrosswordEntry> load(
			CrosswordStructure structure, String term, String definition,
			boolean optimizer) {

		Set<CrosswordEntry> entries = new TreeSet<CrosswordEntry>();
		String[] verticalRegex = ((MyStructure) structure).getVerticalArray();
		String[] horizontalRegex = ((MyStructure) structure).getHorizontalArray();

		if (term.length() <= structure.getHeight()) {
			entries.addAll(getEntries(term, definition, verticalRegex,
					structure, optimizer, false));
			if (isEmpty(optimizer, entries)) 
				return entries;
		}

		if (term.length() <= structure.getWidth()) {
			entries.addAll(getEntries(term, definition, horizontalRegex,
					structure, optimizer, true));
			if (isEmpty(optimizer, entries))  
				return entries;

		}

		return entries;
	}

	/**
	 * Checks if is empty.
	 *
	 * @param optimizer the optimizer
	 * @param entries the entries
	 * @return true, if is empty
	 */
	private static boolean isEmpty(boolean optimizer, Set<CrosswordEntry> entries) {
		return optimizer && !entries.isEmpty();
	}

	/**
	 * Gets the entries.
	 *
	 * @param term the term
	 * @param definition the definition
	 * @param patterns the patterns
	 * @param structure the structure
	 * @param optimizer the optimizer
	 * @param row the row
	 * @return the entries
	 */
	public static Set<CrosswordEntry> getEntries(String term,
			String definition, String[] patterns, CrosswordStructure structure,
			boolean optimizer, boolean row) {

		final String DOT_REGEX = "\\.";
		final String EMPTY_REGEX = "";
		Pattern pattern;
		Matcher matcher;
		int overlapping;
		CrosswordPosition pos;
		Set<CrosswordEntry> entries = new TreeSet<CrosswordEntry>();

		for (int i = 0; i < patterns.length; i++) 
			for (int j = 0; j <= patterns[0].length() - term.length(); j++) {

				pattern = Pattern.compile(patterns[i].substring(j,
						j + term.length()));
				matcher = Pattern.compile(patterns[i].substring(j,
						j + term.length())).matcher(term);
				
				if (matcher.matches()) {
					pos = setPosition(i, j, row);
					overlapping = pattern.pattern().replaceAll(DOT_REGEX,EMPTY_REGEX)
							.length();
					CrosswordEntry entry = new MyCrosswordEntry(pos, term,
							definition, overlapping);
					entries.add(entry);
					if(isEmpty(optimizer, entries))
						return entries;
				}

			}
		
		return (entries);
	}

	/**
	 * Sets the position.
	 *
	 * @param x the x
	 * @param y the y
	 * @param row the row
	 * @return the crossword position
	 */
	private static CrosswordPosition setPosition(int x, int y, boolean row) {
		return row ? (new MyCrosswordPosition(y, x, false))
				: (new MyCrosswordPosition(x, y, true));
	}
}
