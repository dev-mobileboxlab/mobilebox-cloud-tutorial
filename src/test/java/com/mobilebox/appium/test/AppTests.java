package com.mobilebox.appium.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mobilebox.appium.screens.AddClock;
import com.mobilebox.appium.screens.HomeScreen;

public class AppTests extends BaseTest {

	HomeScreen home;

	AddClock addClock;
	
	@Test
	public void addOneCity() throws InterruptedException {
		String city = "Honolulu";
		home = getHomeScreen();
		addClock = home.coco();
		addClock.tapByCityName(city);
		addClock.tapBtnOk();
		Assert.assertTrue(home.isCityInList(city));
	}
	
	@Test
	public void addMultipleCitiesAtOnce() throws InterruptedException {
		String city1 = "Tijuana";
		String city2 = "Honolulu";
		String city3 = "Los Angeles";
		home = getHomeScreen();
		addClock = home.coco();
		addClock.tapByCityName(city1);
		addClock.tapByCityName(city2);
		addClock.tapByCityName(city3);
		addClock.tapBtnOk();
		Assert.assertTrue(home.isCityInList(city1));
		Assert.assertTrue(home.isCityInList(city2));
		Assert.assertTrue(home.isCityInList(city3));
	}
	
	@Test
	public void addOneCityAndCancel() throws InterruptedException {
		String city = "Tijuana";
		home = getHomeScreen();
		addClock = home.coco();
		addClock.tapByCityName(city);
		addClock.tapBtnCancel();
		Assert.assertTrue(!home.isCityInList(city));
	}
}