package com.xebia.archery.utils;

import java.util.List;

import com.xebia.archery.exception.ValidationException;
import com.xebia.archery.model.Round;

// TODO: Auto-generated Javadoc
/**
 * The Interface Scorer.
 */
public interface Scorer {
	
	/**
	 * Find score.
	 *
	 * @param rounds the rounds
	 * @return the int
	 * @throws ValidationException the validation exception
	 */
	public int findScore(List<Round> rounds) throws ValidationException;
}
