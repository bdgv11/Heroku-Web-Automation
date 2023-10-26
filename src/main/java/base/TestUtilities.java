package base;

public class TestUtilities extends BaseTest {

    /**
     * This method should not be used in production. Here is added to help the QA
     * when need time to see steps or outputs happening.
     */
    protected void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
