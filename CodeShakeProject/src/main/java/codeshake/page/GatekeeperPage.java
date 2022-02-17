package codeshake.page;

import codeshake.base.BasePage;
import logger.Log;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static codeshake.constant.ConstantsGateKeeperPage.*;

public class GatekeeperPage extends BasePage {

    public Log log = new Log();


    public GatekeeperPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void pressSearchEnter() {
        sendKeys(SEARCH_TEXT, Keys.ENTER);
    }

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

    public void searchBobi(String value) {
        sendKeys(SEARCH_TEXT, value);
        pressSearchEnter();
        try {
            waitUntilElementIsVisible(BOBI_CONTROL);
            log.info("!!! Found BOBI !!!");

        }
        catch (Throwable throwable){
            log.info("!!! Can not find the Bobi !!!");
        }
    }

    public void beginBattle(){
        try {
            click(BEGIN_BATTLE);
            waitUntilElementIsVisible(ORANGE_TARGET);
            log.info("Battle Started");
        }
        catch (Throwable throwable){
            log.info("!!! Battle could not Start");
        }

    }

    public void hitTheTarget(){
        click(ORANGE_TARGET);
        waitUntilElementIsNotVisible(ORANGE_TARGET);
        log.info("Target was HIT !!! ");
    }

}