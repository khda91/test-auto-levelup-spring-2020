package lesson.selenium.allure;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class AllureStepListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        takeScreenshot();
    }

    private void takeScreenshot() {
        byte[] array = {1};
        TakesScreenshot takesScreenshot = (TakesScreenshot) AbstractBaseTest.driver;
        array = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        Allure.getLifecycle().addAttachment("screenshot", "image/png", ".png", array);
    }
}
