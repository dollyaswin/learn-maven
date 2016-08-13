package com.aqilix.learning.java;

import org.joda.time.DateTime;

public class JodaTimeDemo {

	public static void main(String[] args) {
		DateTime now = new DateTime();
		DateTime nextMonth = now.plusMonths(1);

		System.out.println("Next month : " + nextMonth);

	}

}
