package com.xebia.archery.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.xebia.archery.constant.ScoreConstants;
import com.xebia.archery.exception.ValidationException;
import com.xebia.archery.model.Round;
import com.xebia.archery.utils.Scorer;
import com.xebia.archery.utils.impl.ScorerImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class Test.
 */
public class Test {

	/** The scorer. */
	Scorer scorer = new ScorerImpl();
	
	/** The rounds. */
	List<Round> rounds = new ArrayList<Round>();
	
	/** The scanner. */
	Scanner scanner = new Scanner(System.in);

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Test test = new Test();
		test.scanRoundsInput();
		try {
			System.out.println("The Result is"
					+ test.scorer.findScore(test.rounds));
		} catch (ValidationException e) {
			System.out.println("Invalid Input");
		}

	}

	/**
	 * Scan rounds input.
	 */
	public void scanRoundsInput() {
		for (int i = 0; i < ScoreConstants.TOTAL_ROUND - 1; i++) {

			int results[] = new int[ScoreConstants.TRY_PER_CHANCE];
			int totalMelon = ScoreConstants.MELON_PER_CHANCE;

			System.out.println("Round " + (i + 1));
			for (int j = 0; j < ScoreConstants.TRY_PER_CHANCE; j++) {
				if (totalMelon > 0) {
					System.out.println("Enter Try " + (j + 1) + " result");
					results[j] = Integer.parseInt(scanner.nextLine());
					totalMelon -= results[j];
				} else {
					System.out
							.println("All Melons are pierced for this chance");
					break;
				}
			}
			rounds.add(new Round(results));

		}
		scanLastRoundInput();
	}

	/**
	 * Scan last round input.
	 */
	public void scanLastRoundInput() {
		int results[] = new int[ScoreConstants.TRY_PER_CHANCE + 1];
		int totalMelon = ScoreConstants.MELON_PER_CHANCE;

		System.out.println("Round " + ScoreConstants.TOTAL_ROUND);

		for (int j = 0; j < ScoreConstants.TRY_PER_CHANCE; j++) {
			if (totalMelon > 0) {
				System.out.println("Enter Try " + (j + 1) + " result");
				results[j] = Integer.parseInt(scanner.nextLine());
				if (results[j] == 10)
					totalMelon = ScoreConstants.MELON_PER_CHANCE;
				else
					totalMelon -= results[j];
			}
		}

		if (results[results.length - 2] == ScoreConstants.MELON_PER_CHANCE) {
			System.out.println("Enter Try " + (results.length - 1) + " result");
			results[results.length - 1] = Integer.parseInt(scanner.nextLine());
		}

		rounds.add(new Round(results));
	}

}
