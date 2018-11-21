/*
 * 
 */
package oop.ex3.crosswords;

/**
 * The Interface QualityBound implements the quality bound optimization.
 */
public interface QualityBound {
	
    /**
     * Gets the quality bound.
     *
     * @return the quality bound
     */
    int getQualityBound();
	
	/**
	 * Tries to add term.
	 *
	 * @param term the term
	 * @return true, if successful
	 */
	boolean tryAddTerm(String term);
	
}
