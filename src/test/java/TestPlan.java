import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final WebDriver webDriver = new ChromeDriver();

    @BeforeSuite
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER);
    }

    @Test(testName = "Search Google.com for ltu")
    public static void searchGoogle() {
        final String SEARCH_TERM = "ltu";
        final String EXPECTED_RESULT = "Luleå Tekniska Universitet";

        webDriver.get(Utils.URL);
        GoogleSearch googleSearch = new GoogleSearch(webDriver);
        waitForPage();
        googleSearch.acceptTerms();
        waitForPage();
        googleSearch.enterSearchTerm(SEARCH_TERM);
        waitForPage();
        googleSearch.submitSearch();
        Assert.assertEquals(true, googleSearch.searchForStringInResult(EXPECTED_RESULT));
    }

    @AfterSuite
    public static void clean() {
        webDriver.manage().deleteAllCookies();
        webDriver.close();
    }

    private static void waitForPage() {
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
}
