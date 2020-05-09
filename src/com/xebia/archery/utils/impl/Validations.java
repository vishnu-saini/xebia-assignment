package com.xebia.archery.utils.impl;

import com.xebia.archery.constant.ScoreConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class Validations.
 */
public class Validations {
	
	/**
	 * Id valid last round.
	 *
	 * @param tries the tries
	 * @return true, if successful
	 */
	public static boolean idValidLastRound(int[] tries) {
		int totalMelon = ScoreConstants.MELON_PER_CHANCE;
		for (int i = 0; i < ScoreConstants.TRY_PER_CHANCE; i++) {
			if (tries[i] > totalMelon)
				return false;
			else if (tries[i] < ScoreConstants.MELON_PER_CHANCE)
				totalMelon -= tries[i];
		}
		if (tries[ScoreConstants.TRY_PER_CHANCE - 1] != ScoreConstants.MELON_PER_CHANCE
				&& tries[ScoreConstants.TRY_PER_CHANCE] > 0)
			return false;
		else if (tries[ScoreConstants.TRY_PER_CHANCE - 1] == ScoreConstants.MELON_PER_CHANCE
				&& tries[ScoreConstants.TRY_PER_CHANCE] > ScoreConstants.MELON_PER_CHANCE)
			return false;
		return true;
	}

	/**
	 * Checks if is valid round.
	 *
	 * @param tries the tries
	 * @return true, if is valid round
	 */
	public static boolean isValidRound(int[] tries) {
		if ((tries[0] + tries[1]) > ScoreConstants.MELON_PER_CHANCE) {
			return false;
		} else {
			return true;
		}
	}

}
