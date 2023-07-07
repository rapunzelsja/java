package utilities;

import java.time.LocalDate;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringGenerator {

	public static String RandomStringGeneratorFixedLength() {
		int length = 5;
		boolean useLetters = true;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		return generatedString;
	}

	public static String RandomStringGeneratorLength(int length) {
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		return "Qa" + generatedString.toLowerCase();
	}

	public static String randomYear() {
		Integer ageNum = getRandomNumberInRange(51, 79);
		LocalDate date = LocalDate.now().minusYears(ageNum);
		String formYear[] = date.toString().split("-");
		return formYear[0];
	}

	public static String randomDay() {
		String formDay;
		int day = getRandomNumberInRange(1, 28);
		if (day < 10) {
			formDay = "0" + Integer.toString(day);
			return formDay;
		}
		return Integer.toString(day);
	}

	public static String randomMonth() {
		String formMonth;
		int month = getRandomNumberInRange(1, 12);
		if (month < 10) {
			formMonth = "0" + Integer.toString(month);
			return formMonth;
		}
		return Integer.toString(month);
	}

	public static int getRandomNumberInRange(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}