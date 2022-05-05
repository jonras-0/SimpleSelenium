import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleSearch extends PageObject {

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(id = "L2AGLb")
    private WebElement acceptTermsBtn;

    @FindBy(id = "search")
    private WebElement searchResult;

    public GoogleSearch(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterSearchTerm(String searchTerm) {
        searchField.sendKeys(searchTerm);
    }

    public void submitSearch() {
        searchField.submit();
    }

    public void acceptTerms() {
        if(acceptTermsBtn.isDisplayed()) {
            acceptTermsBtn.click();
        }
    }

    public boolean searchForStringInResult(String text) {
        return searchResult.getText().contains(text);
    }
}
