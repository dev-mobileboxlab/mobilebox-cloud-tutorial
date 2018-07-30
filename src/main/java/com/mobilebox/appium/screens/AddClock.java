package com.mobilebox.appium.screens;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddClock extends AbstractScreen {

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement btnOK;
	
	@AndroidFindBy(id = "android:id/button2")
	private MobileElement btnCancel;

	public AddClock(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	public void tapByCityName(String city) {
		tap(findByString(city));
	}

	public void tapBtnOk() {
		tap(btnOK);
	}
	
	public void tapBtnCancel() {
		tap(btnCancel);
	}
}