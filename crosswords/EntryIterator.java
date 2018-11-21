/*
 * 
 */
package oop.ex3.crosswords;

import java.util.Comparator;
import java.util.Iterator;

/**
 * The Interface EntryIterator.
 *
 * @param <E> the element type
 */
public interface EntryIterator<E> extends Iterator<E> {
	
	/**
	 * Gets the comparator.
	 *
	 * @return the comparator
	 */
	Comparator<String> getComparator();
	
	/**
	 * Iterator.
	 *
	 * @return the iterator
	 */
	Iterator<E> iterator();

}
