package ru.levelup.qa.at.taf.skeleton.services.attachment;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.levelup.qa.at.taf.skeleton.services.attachment.impl.AllureAttachmentsImpl;
import ru.levelup.qa.at.taf.skeleton.services.webdriver.WebDriverSingleton;

import java.util.ArrayList;
import java.util.List;

public class AttachmentProvider {
    
    private List<Attachments> attachments = new ArrayList<>();

    public AttachmentProvider() {
        attachments.add(new AllureAttachmentsImpl());
    }

    public void attachScreenshot() {
        byte[] bytes = ((TakesScreenshot) WebDriverSingleton.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
        attachments.forEach(attach -> attach.attachScreenshot(bytes));
    }

    public void attachPageSource() {
        String pageSource = WebDriverSingleton.getInstance().getDriver().getPageSource();
        attachments.forEach(attach -> attach.attachPageSource(pageSource));
    }
}
