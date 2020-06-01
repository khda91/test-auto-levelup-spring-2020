package ru.levelup.qa.at.taf.skeleton.services.attachment.impl;

import io.qameta.allure.Allure;
import ru.levelup.qa.at.taf.skeleton.services.attachment.Attachments;

public class AllureAttachmentsImpl implements Attachments {

    @Override
    public void attachScreenshot(byte[] bytes) {
        Allure.getLifecycle().addAttachment("screenshot", "image/png", ".png", bytes);
    }

    @Override
    public void attachPageSource(String pageSource) {
        Allure.getLifecycle().addAttachment("page source", "text/html", ".html", pageSource.getBytes());
    }
}
