package com.mobilebox.appium.test;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.mobilebox.appium.driver.Driver;
import com.mobilebox.appium.screens.HomeScreen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public abstract class BaseTest {

  private HomeScreen homeScreen;

  @BeforeMethod(alwaysRun = true)
  @Parameters({"device", "version", "appURL"})
  public void setup(String device, String version, String appURl) throws MalformedURLException {
    AndroidDriver<AndroidElement> driver = new Driver().getAndroidDriver(device, version, appURl);
    homeScreen = new HomeScreen(driver);
  }

  public HomeScreen getHomeScreen() {
    return homeScreen;
  }

  @AfterTest(alwaysRun = true)
  public void quit() {
    if (homeScreen != null)
      homeScreen.quit();
  }

}
