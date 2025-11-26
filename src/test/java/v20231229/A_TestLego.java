package v20231229;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class A_TestLego
{
    private A_Lego lego;

    @Before
    public void setUp()
    {
        lego = new A_Lego();
    }

    @Test
    public void test_EMPTY_is_EMPTY()
    {
        Assert.assertEquals("", lego.blockize(""));
    }

    @Test
    public void test_21AxBz_is_xzAB12()
    {
        Assert.assertEquals("xzAB12", lego.blockize("21AxBz"));
    }

    @Test
    public void test_abacad_is_abcd_a_a()
    {
        Assert.assertEquals("abcd-a-a", lego.blockize("abacad"));
    }

    @Test
    public void test_hbh420sUUW222IWOxndjn93cdop69NICEep832_is_bcdehjnopsxCEINOUW0234689_dhnpIUW239_2_2_2()
    {
        Assert.assertEquals("bcdehjnopsxCEINOUW0234689-dhnpIUW239-2-2-2", lego.blockize("hbh420sUUW222IWOxndjn93cdop69NICEep832"));
    }

}
