package codeshake.page;
import codeshake.base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static codeshake.constant.ConstantsGateKeeperPage.*;

public class GatekeeperPage extends BasePage {


    public GatekeeperPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void pressSearchEnter() { sendKeys(SEARCH_TEXT, Keys.ENTER);}

    public String setFirstValue(String value) {
        click(FIRST_VALUE);
        sendKeys(FIRST_VALUE, value);
        return value;

    }

    public String setSecondValue(String value) {
        click(SECOND_VALUE);
        sendKeys(SECOND_VALUE, value);
        return value;
    }

    public String setSearchText(String value) {
        click(SEARCH_TEXT);
        sendKeys(SEARCH_TEXT, value);
        sleep(3);
        return value;
    }

}
