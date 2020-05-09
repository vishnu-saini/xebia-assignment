package com.xebia.archery.model;

import java.util.Arrays;

// TODO: Auto-generated Javadoc
/**
 * The Class Round.
 */
public class Round {
	
	/** The tries. */
	private int[] tries;

	/**
	 * Instantiates a new round.
	 */
	public Round() {
	}

	/**
	 * Instantiates a new round.
	 *
	 * @param tries the tries
	 */
	public Round(int[] tries) {
		super();
		this.tries = tries;
	}

	/**
	 * Gets the tries.
	 *
	 * @return the tries
	 */
	public int[] getTries() {
		return tries;
	}

	/**
	 * Sets the tries.
	 *
	 * @param tries the new tries
	 */
	public void setTries(int[] tries) {
		this.tries = tries;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Round [tries=" + Arrays.toString(tries) + "]";
	}

}
