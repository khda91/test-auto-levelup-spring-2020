package ru.levelup.qa.at.taf.skeleton.test;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.levelup.qa.at.taf.skeleton.services.attachment.AttachmentProvider;

public class AllureStepListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        takeScreenshot();
    }

    private void takeScreenshot() {
        new AttachmentProvider().attachPageSource();
        new AttachmentProvider().attachScreenshot();
    }
}
