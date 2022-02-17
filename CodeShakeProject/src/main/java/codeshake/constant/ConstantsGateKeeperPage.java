package codeshake.constant;

import codeshake.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ConstantsGateKeeperPage extends BaseTest {

    public static final By FIRST_VALUE = By.id("mat-input-0");
    public static final By SECOND_VALUE = By.id("mat-input-1");
    public static final By RESULT_VALUE = By.id("mat-input-2");
    public static final By SEARCH_TEXT = By.id("mat-input-3");
    public static final By BOBI_CONTROL = By.xpath("//div[normalize-space(text())='Bobi Codeshake']");
    public static final By BEGIN_BATTLE = By.xpath("//button//span[normalize-space(text())='Let the battle begin']");
    public static final By ORANGE_TARGET = By.xpath("//div//i[@style='color: orange; cursor: pointer;']");
    public static final By ADDRESS_TEXT = By.xpath("//span[normalize-space(text())='Vefabey Sokak, No:16 D:11, 34349, Gayrettepe/Istanbul/Turkey']");
    public static final WebElement iframe = getWebDriver().findElement(By.id("iframe"));

    public static final By CODESHAKE_CONTACT_TEXT = By.id("comp-kvi6khho");

    public static String[] WORD_OF_ADDRESS;
    public static String[] WORD_OF_CONTACT_ADDRESS;

}