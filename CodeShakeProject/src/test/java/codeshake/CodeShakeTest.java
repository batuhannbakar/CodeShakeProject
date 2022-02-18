package codeshake;

import codeshake.base.BaseTest;
import codeshake.page.GatekeeperPage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static codeshake.constant.ConstantsGateKeeperPage.*;


public class CodeShakeTest extends BaseTest {

    GatekeeperPage gatekeeperPage;


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

    }

    @Test
    public void NegativeAddition() {

        firstValue = Integer.valueOf(gatekeeperPage.setFirstValue("-5"));
        secondValue = Integer.valueOf(gatekeeperPage.setSecondValue("-10"));
        resultValue = Integer.valueOf(gatekeeperPage.getValueAttribute(RESULT_VALUE));
        Assert.assertSame(firstValue + secondValue, resultValue);
        System.out.println(firstValue+secondValue + " = " + resultValue);

    }

    @Test
    public void WordAddition() {

        gatekeeperPage.setFirstValue("a");
        gatekeeperPage.setSecondValue("b");
        resultValue = Integer.valueOf(gatekeeperPage.getValueAttribute(RESULT_VALUE));
        Assert.assertSame(resultValue, 0);
        System.out.println( 0 + " = " + resultValue);

    }

    @Test
    public void SearchBobi() {

        gatekeeperPage.searchBobi("bobi");

    }

    @Test
    public void ReturnofthePop() {

        gatekeeperPage.beginBattle();
        gatekeeperPage.hitTheTarget();
    }

    @Test
    public void CompareAddress() {

        gatekeeperPage.sameWordsofTwoAddresses(gatekeeperPage.getFirstAddress(),gatekeeperPage.getSecondAddress());

    }


}
