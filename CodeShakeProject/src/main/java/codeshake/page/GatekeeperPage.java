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

        } catch (Throwable throwable) {
            log.error("!!! Can not find the Bobi !!!");
        }
    }

    public void beginBattle() {
        try {
            click(BEGIN_BATTLE);
            waitUntilElementIsVisible(ORANGE_TARGET);
            log.info("Battle Started");
        } catch (Throwable throwable) {
            log.error("!!! Battle could not Start");
        }

    }

    public void hitTheTarget() {
        click(ORANGE_TARGET);
        waitUntilElementIsNotVisible(ORANGE_TARGET);
        log.info("Target DEFEATED !!! ");
    }

    public String[] getFirstAddress() {

        ADDRESS = getText(ADDRESS_TEXT);
        System.out.println("Address Text: " + ADDRESS);
        WORD_OF_ADDRESS = getWords(ADDRESS);
        return WORD_OF_ADDRESS;
    }

    public String[] getSecondAddress() {

        switchFrame(iframe);
        CONTACT_ADDRESS = getText(CODESHAKE_CONTACT_TEXT);
        System.out.println("\nContact Address: " + CONTACT_ADDRESS + "\n");
        WORD_OF_CONTACT_ADDRESS = getWords(CONTACT_ADDRESS);
        return WORD_OF_CONTACT_ADDRESS;
    }

}