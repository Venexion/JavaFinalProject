/**
 *  Created on 11/02/11
 */
package com.ai4u.util.heap;


/**
 * This is an interface for heaps. This sort of Datastructures is build for
 * efficient access to prioritized objects, holding the object with the highest
 * priority always at the top of the heap. 
 * 
 * @param <T> The type of elements in the heap.
 *  
 * @author kreich
 */
public interface IHeap<T extends Comparable<?>> {

	/** This enum defines the mode of heap search. */
	public static enum HeapMode {
		/** This is the mode for a maximum heap. */
		MAX,
		/** This is the mode for a minimum heap. */
		MIN
	}
	
	/**
	 * Inserts the given object into the heap.
	 * 
	 * @param obj The object to insert into the heap.
	 */
	public void insert(T obj);
	
	/**
	 * Returns the object at the top of the heap, while leaving it there.
	 * Don't change the priority of this object since no later validation is
	 * made and this might ruin the heap's sorting.
	 * 
	 * @return The object at the top of the heap (the one with the highest
	 *         priority from those in the heap).
	 */
	public T top();
	
	/**
	 * Removes the object at the top of the heap.
	 * 
	 * @return The removed object. 
	 */
	public T deleteTop();
	
	/**
	 * @return Whether the heap is empty.
	 */
	public boolean isEmpty();
	
}
