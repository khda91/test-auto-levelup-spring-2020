package ru.levelup.qa.at.taf.skeleton.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:env/${env}.properties"})
public interface WebDriverConfiguration extends Config {
    
    @Key("browser.name")
    String browserName();
    
    @Key("site.url")
    String siteUrl();
    
    @Key("driver.implicit.timeout.millis")
    long implicitlyTimeout();

    @Key("driver.explicit.timeout.sec")
    long explicitlyTimeout();
}
