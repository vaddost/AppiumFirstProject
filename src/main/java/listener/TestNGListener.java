package listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

    static Logger LOG = LogManager.getLogger(TestNGListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOG.info(String.format("'%s' test is started",result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOG.info(String.format("'%s' test is PASSED",result.getMethod().getMethodName()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.error(String.format("'%s' test is FAILED",result.getMethod().getMethodName()));
    }
}
