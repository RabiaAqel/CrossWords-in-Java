/*
 * 
 */
package oop.ex3.crosswords;

/**
 * The Class CrosswordQualityBound implements the QualityBound optimization
 * for the crossword game.
 * .
 */
public class CrosswordQualityBound implements QualityBound {

	/** The structure. */
	protected CrosswordStructure structure;
	
	/** The glossary. */
	protected CrosswordGlossary glossary;

	/**
	 * Instantiates a new crossword quality bound.
	 *
	 * @param structure the structure
	 * @param glossary the glossary
	 */
	public CrosswordQualityBound(CrosswordStructure structure,
			CrosswordGlossary glossary) {
		
		this.structure = structure;
		this.glossary = glossary;
		
	}

	
	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.QualityBound#tryAddTerm(java.lang.String)
	 */
	@Override
	public boolean tryAddTerm(String term) {
		
		return EntryLoader.load(structure, term,
				glossary.getTermDefinition(term), true) != null;
		
	}
	
	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.QualityBound#getQualityBound()
	 */
	public int getQualityBound() {
		
		int quality = 0;
		for (String term : glossary.getTerms()) 
			quality = tryAddTerm(term) ? quality + term
					.length() : quality;
		return quality;
		
	}
}
