package com.fitchconnect.utilities;

import com.fitchconnect.framework.PropertyReader;
/**
 * Created by Miah Ashrafuzzaman.
 */
public class Delayed {

	public void sleeper(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void delay(int time) {
		final String tbrowser = PropertyReader.BROWSER_TO_RUN;
		switch (tbrowser) {

		case "chrome":
			sleeper(time - time);
			break;

		case "":
			sleeper(time - time);
			break;

		default:
			sleeper(time);
			break;
		}
	}

}
