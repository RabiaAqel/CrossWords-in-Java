/*
 * 
 */
package oop.ex3.crosswords;

import java.util.*;

/**
 * The Class EntriesIterator.
 *
 * @param <E> the element type
 */
public class EntriesIterator<E extends CrosswordEntry> implements EntryIterator<E> {
	
	/**
	 * The Class CrosswordTermComparator.
	 *
	 * @param <T> the generic type
	 */
	private static class CrosswordTermComparator<T> implements Comparator<T> {

		/* (non-Javadoc)
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(T o1, T o2) {
			return 0;
		}

		/**
		 * Compare.
		 *
		 * @param o1 the o1
		 * @param o2 the o2
		 * @return the int
		 */
		@SuppressWarnings("unused")
		public int compare(String o1, String o2) {
			if (o1.length() == o2.length())
				return o1.compareTo(o2);
			else
				return o2.length() - o1.length();
		}

	}

	/** The structure. */
	protected final CrosswordStructure structure;
	
	/** The glossary. */
	protected final CrosswordGlossary glossary;
	
	/** The comparator. */
	private final Comparator<String> comparator;

	/** The iterator. */
	private final Iterator<E> iterator;
	
	/**
	 * Instantiates a new entries iterator.
	 *
	 * @param structure the structure
	 * @param glossary the glossary
	 */
	public EntriesIterator(CrosswordStructure structure, CrosswordGlossary glossary) {
		this.structure = structure;
		this.glossary = glossary;
		this.comparator = new CrosswordTermComparator<String>();
		this.iterator = this.iterator();
	}
	
	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.EntryIterator#getComparator()
	 */
	public Comparator<String> getComparator() {
		return this.comparator;
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#hasNext()
	 */
	@Override
	public boolean hasNext() {
		return this.iterator.hasNext();
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	@Override
	public E next() {
		return (E) this.iterator.next();
	}

	/* (non-Javadoc)
	 * @see java.util.Iterator#remove()
	 */
	@Override
	public void remove() {
	}

	/* (non-Javadoc)
	 * @see oop.ex3.crosswords.EntryIterator#iterator()
	 */
	@SuppressWarnings("unchecked")
	public Iterator<E> iterator() {
		ArrayList<String> glossaryCopy = new ArrayList<String>(glossary.getTerms());
		Collections.sort(glossaryCopy, this.getComparator());
		ArrayList<CrosswordEntry> entriesList = new ArrayList<CrosswordEntry>();

		if(!glossaryCopy.isEmpty())
			entriesList.addAll(EntryLoader.load(structure, glossaryCopy.get(0), 
					glossary.getTermDefinition(glossaryCopy.get(0)), false));
		
		return (Iterator<E>) entriesList.iterator();
	}

}