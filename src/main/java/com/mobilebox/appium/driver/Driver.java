package com.mobilebox.appium.driver;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.Platform.ANDROID;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Driver {

  private final String MB_HUB = "https://babbagecloud.com/wd/hub";
  private final int TIMEOUT = 20;

  /**
   * Create an <code>AndroidDriver</code> instance.
   * 
   * @param device The device name.
   * @param version The Android OS version. E.G: 6.0.0
   * @param path The remote http URL to an .apk file. E.G: http://www.test.com/myapp.apk
   * @return An <code>AndroidDriver</code>.
   * @throws MalformedURLException If the Mobilebox hub URL is malformed.
   */
  public AndroidDriver<AndroidElement> getAndroidDriver(final String device, final String version,
      final String path) throws MalformedURLException {
    URL hub = new URL(MB_HUB);

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ANDROID);
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, device);
    capabilities.setCapability(MobileCapabilityType.APP, path);
    capabilities.setCapability("appActivity", "com.simplemobiletools.clock.activities.SplashActivity");
    capabilities.setCapability("appPackage", "com.simplemobiletools.clock");
    capabilities.setCapability("mobileboxToken", "token");

    AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(hub, capabilities);
    driver.manage().timeouts().implicitlyWait(TIMEOUT, SECONDS);
    return driver;
  }

}
