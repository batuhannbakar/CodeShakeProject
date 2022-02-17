package codeshake;

import codeshake.base.BaseTest;
import codeshake.page.GatekeeperPage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static codeshake.constant.ConstantsGateKeeperPage.*;


public class CodeShakeTest extends BaseTest {

    GatekeeperPage gatekeeperPage;
    Integer firstValue;
    Integer secondValue;
    Integer resultValue;
    String ADDRESS;
    String CONTACT_ADDRESS;


    @Before
    public void install() {

        gatekeeperPage = new GatekeeperPage(getWebDriver());
    }

    @Test
    public void PositiveAddition() {

        firstValue = Integer.valueOf(gatekeeperPage.setFirstValue("5"));
        secondValue = Integer.valueOf(gatekeeperPage.setSecondValue("10"));
        resultValue = Integer.valueOf(gatekeeperPage.getValueAttribute(RESULT_VALUE));
        Assert.assertSame(firstValue + secondValue, resultValue);
        System.out.println(firstValue+secondValue + " = " + resultValue);
        gatekeeperPage.sleep(5);

    }

    @Test
    public void NegativeAddition() {

        firstValue = Integer.valueOf(gatekeeperPage.setFirstValue("-5"));
        secondValue = Integer.valueOf(gatekeeperPage.setSecondValue("-10"));
        resultValue = Integer.valueOf(gatekeeperPage.getValueAttribute(RESULT_VALUE));
        Assert.assertSame(firstValue + secondValue, resultValue);
        System.out.println(firstValue+secondValue + " = " + resultValue);
        gatekeeperPage.sleep(5);

    }

    @Test
    public void WordAddition() {

        gatekeeperPage.setFirstValue("a");
        gatekeeperPage.setSecondValue("b");
        resultValue = Integer.valueOf(gatekeeperPage.getValueAttribute(RESULT_VALUE));
        Assert.assertSame(resultValue, 0);
        System.out.println( "0" + " = " + resultValue);
        gatekeeperPage.sleep(5);

    }

    @Test
    public void SearchBobi() {

        gatekeeperPage.searchBobi("bobi");

    }

    @Test
    public void ReturnofthePop() {

        gatekeeperPage.beginBattle();
        gatekeeperPage.hitTheTarget();
        log.info("Target Defeated !");
    }

    @Test
    public void CompareAddress() {

        ADDRESS = gatekeeperPage.getText(ADDRESS_TEXT);

        System.out.println("Address Text: " + ADDRESS);

        gatekeeperPage.switchFrame(iframe);

        CONTACT_ADDRESS = gatekeeperPage.getText(CODESHAKE_CONTACT_TEXT);

        System.out.println("\nContact Address: " + CONTACT_ADDRESS + "\n");

        WORD_OF_ADDRESS = gatekeeperPage.getWords(ADDRESS);

        WORD_OF_CONTACT_ADDRESS = gatekeeperPage.getWords(CONTACT_ADDRESS);

        System.out.print("Same words of 2 addresses : ");
        gatekeeperPage.printSameWords(WORD_OF_ADDRESS, WORD_OF_CONTACT_ADDRESS);
        gatekeeperPage.sleep(5);


    }


}
