package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class Randomdatautility {
	
	public static String getRandomEmail() {
		String number = RandomStringUtils.randomNumeric(4);
		return "darshanmesta"+number+"@gmail.com";
	}
	

}
