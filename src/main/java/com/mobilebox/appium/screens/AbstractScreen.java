package com.mobilebox.appium.screens;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public abstract class AbstractScreen {

	protected final AndroidDriver<AndroidElement> driver;
	protected final String ID = "com.simplemobiletools.clock:id";
	private static final int TIME_OUT_IN_SECONDS = 60;

	public AbstractScreen(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public AndroidDriver<AndroidElement> getDriver() {
		return driver;
	}

	protected <K> FluentWait<K> waitOn(K object, int timeOutSeconds) {
		return new FluentWait<>(object).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).withTimeout(timeOutSeconds, SECONDS)
				.pollingEvery(1, SECONDS);
	}

	protected FluentWait<AndroidDriver<AndroidElement>> getWait() {
		return waitOn(getDriver(), TIME_OUT_IN_SECONDS);
	}

	protected void tap(MobileElement element) {
		getWait().until(elementToBeClickable(element)).click();
	}

	public MobileElement findByString(String text) {
		return getDriver().findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + text + "\")"));
	}
	
	public boolean isTextPresent(String text) {
		return getDriver().findElements(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + text + "\")")).size()>0;
	}

	public void quit() {
		driver.closeApp();
		driver.quit();
	}
}
