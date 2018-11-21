package oop.ex3.crosswords;

/**
 * 
 * interface that extends CrosswordStructure interface, to add additional required
 * functions.
 * 
 * @author tigers, rabeaaqel.
 * 
 */
public interface MyStructure extends CrosswordStructure{
	
	/**
	 * Appends the term to the structure.
	 * 
	 * @param move the move
	 */
	void appendTerm(CrosswordEntry move);

	/**
	 * Gets the copy.
	 * 
	 * @return the copy
	 */
	MyStructure getCopy();

	/**
	 * Gets the vertical array.
	 * each cell in the array represents the column regex.
	 * 
	 * @return the vertical array
	 */
	String[] getVerticalArray();

	/**
	 * Gets the horizontal array.
	 * each cell in the array represents the row regex.
	 * 
	 * @return the horizontal array
	 */
	String[] getHorizontalArray();

}
