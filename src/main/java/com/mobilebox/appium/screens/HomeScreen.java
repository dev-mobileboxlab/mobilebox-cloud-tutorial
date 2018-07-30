package com.mobilebox.appium.screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeScreen extends AbstractScreen {

	@AndroidFindBy(id = "com.simplemobiletools.clock:id/clock_fab")
	private MobileElement btnAddClock;

	@AndroidFindBy(id = "com.simplemobiletools.clock:id/time_zone_title")
	private MobileElement timeZoneList;

	public HomeScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	public AddClock coco() {
		tap(btnAddClock);
		return new AddClock(getDriver());
	}

	public boolean isCityInList(String city) {
		return isTextPresent(city) == true;
	}
}