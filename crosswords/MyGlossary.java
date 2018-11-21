package oop.ex3.crosswords;

/**
 *
 * interface that extends CrosswordGlossary interface, to add additional required
 * functions.
 * 
 * @author tigers, rabeaaqel.
 */
public interface MyGlossary extends CrosswordGlossary{
	
	/**
	 * Removes the term.
	 * 
	 * @param term the term
	 */
	void removeWord(String term);

	/**
	 * Gets the copy.
	 * 
	 * @return the copy
	 */
	CrosswordGlossary getCopy();

	/**
	 * Append word.
	 * 
	 * @param term the term to add
	 * @param definition the definition to add
	 */
	void appendWord(String term, String definition);

}
