package oop.ex3.crosswords;

/**
 * interface that extends CrosswordEntry interface, to add additional required
 * functions.
 * 
 * @author tigers, rabeaaqel.
 * 
 */
public interface MyEntry extends CrosswordEntry {

	/**
	 * get the number of overlaps
	 * 
	 * @return the number of the overlaps
	 */
	public int getOverlapping();

}
