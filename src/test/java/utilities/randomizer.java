package utilities;

import org.apache.commons.text.RandomStringGenerator;

public class randomizer {
	public String randomAlphabet()
	{
		RandomStringGenerator randomAlphGenerator = new RandomStringGenerator.Builder()
				.withinRange('a','z').build();
		String randomAlph = randomAlphGenerator.generate(10);
		return randomAlph;
	}
	
	public String randomNumber()
	{
		RandomStringGenerator randomNumbGenerator = new RandomStringGenerator.Builder()
				.withinRange('0','9').build();
		String randomNumb = randomNumbGenerator.generate(8);
		return randomNumb;
	}
}
