package com.xebia.archery.utils.impl;

import java.util.List;

import com.xebia.archery.constant.ScoreConstants;
import com.xebia.archery.exception.ValidationException;
import com.xebia.archery.model.Round;
import com.xebia.archery.utils.Scorer;

// TODO: Auto-generated Javadoc
/**
 * The Class ScorerImpl.
 */
public class ScorerImpl implements Scorer {

	/* (non-Javadoc)
	 * @see com.xebia.archery.utils.Scorer#findScore(java.util.List)
	 */
	@Override
	public int findScore(List<Round> rounds) throws ValidationException {
		System.out.println(rounds);
		return findNonLastRoundsScore(rounds)
				+ findLastRoundScore(rounds.get(rounds.size() - 1));
	}

	/**
	 * Find last round score.
	 *
	 * @param round the round
	 * @return the int
	 * @throws ValidationException the validation exception
	 */
	int findLastRoundScore(Round round) throws ValidationException {
		int score = 0;
		if (!Validations.idValidLastRound(round.getTries()))
			throw new ValidationException();
		else
			score += round.getTries()[0] + round.getTries()[1]
					+ round.getTries()[2];

		return score;
	}

	/**
	 * Find non last rounds score.
	 *
	 * @param rounds the rounds
	 * @return the int
	 * @throws ValidationException the validation exception
	 */
	int findNonLastRoundsScore(List<Round> rounds) throws ValidationException {
		int score = 0;
		for (int i = 0; i < rounds.size() - 1; i++) {
			Round round = rounds.get(i);
			if (!Validations.isValidRound(round.getTries()))
				throw new ValidationException();
			else {
				int tries[] = round.getTries();
				int totalMelon = ScoreConstants.MELON_PER_CHANCE;
				for (int j = 0; j < tries.length; j++) {
					if (tries[j] == ScoreConstants.MELON_PER_CHANCE) {
						score += tries[j] + rounds.get(i + 1).getTries()[0]
								+ rounds.get(i + 1).getTries()[1];
						break;
					} else if (totalMelon == tries[j]) {
						score += tries[j] + rounds.get(i + 1).getTries()[0];
						break;
					} else {
						score += tries[j];
						totalMelon -= tries[j];
					}
				}

			}
		}
		return score;
	}
}
