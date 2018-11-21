package oop.ex3.search;

import java.util.Iterator;

/**
 * The Class MyDepthFirstSearch.
 * The class implements a generic DFS search recursively and returns the goal node.
 *
 * @param <B> the generic type
 * @param <M> the generic type
 */
public class MyDepthFirstSearch<B extends SearchBoardNode<M>, M extends SearchMove> 
implements DepthFirstSearch<B,M> {


	/** The max depth. */
	private int maxDepth;

	/** The time out. */
	private long timeOut;

	/** The starting time. */
	private long startingTime;

	/** The current best quality. */
	private int bestQuality;

	/** The current best solution. */
	private B bestSolution;


	/* (non-Javadoc)
	 * @see oop.ex3.search.DepthFirstSearch#search(oop.ex3.search.SearchBoardNode, int, long)
	 */
	@Override
	public B search(B startBoard, int maxDepth, long timeOut) {
		// initializes the bestSolution
		this.bestSolution = startBoard;
		// initializes the timeOut field
		this.timeOut = timeOut;
		// initializes the maxDepth
		this.maxDepth = maxDepth;
		// initializes startingTime using System.currentTimeMillis() to get current time.
		this.startingTime = System.currentTimeMillis();
		/* creates a new node and initializes the node with the best solution 
		using the dfs search 
		 */
		B solution = dfs(startBoard, 0);
		// returns the found solution
		return solution;
	}


	/**
	 * This method implements a DFS search recursively.
	 * The algorithm explores every possible child node until it finds
	 * one of the highest quality node within the given time out and max depth.
	 * 
	 * @param startBoard the start board
	 * @param depth the depth
	 * @return the b
	 */
	private B dfs(B startBoard, int depth) {
		// the method process only if the current time is under the time out bound
		if(!underTimeLimit()) {
			// assures not to explore deeper than the given max depth
			if (depth <= this.maxDepth) {
				/* updates the current bestSolution and bestQuality in case a higher quality
				 * node found
				 */
				if (startBoard.getQuality() > this.bestQuality){
					this.bestSolution = startBoard;
					this.bestQuality = this.bestSolution.getQuality();
					// in case that the current node is a solution, then it returns it
					if(isSolution())
						return this.bestSolution;
				}
				/* (startBoard.getQualityBound() <= bestQuality) - 
				 * skips every child with upper bound which is lower than the 
				 * bestQuality so far, this line optimizes the search 
				 * dramatically.
				 */
				int bound= startBoard.getQualityBound();
				if(!(bound <= bestQuality)
						&& !underTimeLimit())

					// fresh iterator which gets the reachable children of the current node
					for (Iterator<M> move = startBoard.getMovesIterator();
					move.hasNext();) { // iterates the current node children
						// creates a new move and gets the next iterator entry
						M nextMove = move.next();
						// gets a copy of the current node
						@SuppressWarnings("unchecked")
						B nodeCopy = (B) startBoard.getCopy();
						if(bound <= bestQuality)
							return bestSolution;
						// gets the child resulted by nextMove
						nodeCopy.doMove(nextMove);
						// explores the current child child's through a recursive call
						dfs(nodeCopy, depth+1);
					}
			}
		}
		// returns the bestSolution found
		return this.bestSolution;
	}


	/**
	 * returns whether is the current bestSolution is one of the best
	 * solutions or not.
	 *
	 * @return true, if is solution
	 */
	private boolean isSolution() {
		// returns whether this bestSolution is a solution
		return (this.bestSolution.isBestSolution());
	}


	/**
	 * checks if the processing time is under the time out limit.
	 *
	 * @return true, if successful
	 */
	private boolean underTimeLimit() {
		// returns whether if the current time is under the timeOut bound
		return (System.currentTimeMillis() >= this.startingTime + this.timeOut);	
	}


}