package ru.levelup.qa.at.taf.skeleton.test.data;

import org.testng.annotations.DataProvider;

public class AllureTestDataProvider {
    
    @DataProvider(name = "Compare project categories data provider")
    public Object[][] compareProductsPageObjectTestDataProvider() {
        return new Object[][] {
                {"Компьютеры", "Ноутбуки"}
        };
    }
}
