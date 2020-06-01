package ru.levelup.qa.at.taf.skeleton.services.pages;

import ru.levelup.qa.at.taf.skeleton.services.webdriver.WebDriverSingleton;

public class YandexMarketHomePage extends YandexMarketBasePage {

    private static YandexMarketHomePage instance;
    
    private YandexMarketHomePage() {
        super(WebDriverSingleton.getInstance().getDriver());
    }

    public static YandexMarketHomePage getInstance() {
        if (instance == null) {
            instance = new YandexMarketHomePage();
        }
        return instance;
    }

}
