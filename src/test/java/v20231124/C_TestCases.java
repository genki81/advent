package v20231124;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class C_TestCases
{
    private C_Cases cases;

    @Before
    public void setUp()
    {
        cases = new C_Cases(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 2, 0, 0, 1, 1, 1, 0, 0, 2, 2, 1, 0, 1, 0, 0, 0, 0, 0, 2);
    }

    @Test
    public void test_1_1_is_0()
    {
        Assert.assertEquals(0, cases.compte(1, 1));
    }

    @Test
    public void test_2_3_is_5()
    {
        Assert.assertEquals(5, cases.compte(2, 3));
    }

    @Test
    public void test_3_6_is_0()
    {
        Assert.assertEquals(0, cases.compte(3, 6));
    }

    @Test
    public void test_3_8_is_4()
    {
        Assert.assertEquals(4, cases.compte(3, 8));
    }

}
