package v20240126;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class C_TestSpore
{
    private C_Spore spore;

    @Before
    public void setUp()
    {
        spore = new C_Spore();
    }

    @Test
    public void test_EMPTY_is_1()
    {
        Assert.assertEquals(1, spore.miammiam(""));
    }

    @Test
    public void test_0_is_1()
    {
        Assert.assertEquals(1, spore.miammiam("0"));
    }

    @Test
    public void test_6_is_1()
    {
        Assert.assertEquals(1, spore.miammiam("6"));
    }

    @Test
    public void test_1111_is_2()
    {
        Assert.assertEquals(2, spore.miammiam("1111"));
    }

    @Test
    public void test_11112222_is_3()
    {
        Assert.assertEquals(3, spore.miammiam("11112222"));
    }

    @Test
    public void test_111122223333_is_4()
    {
        Assert.assertEquals(4, spore.miammiam("111122223333"));
    }

    @Test
    public void test_111111111111_is_3()
    {
        Assert.assertEquals(3, spore.miammiam("111111111111"));
    }

    @Test
    public void test_111111111111111111112222222222_is_5()
    {
        Assert.assertEquals(5, spore.miammiam("111111111111111111112222222222"));
    }

    @Test
    public void test_151128241212192113722321331_is_5()
    {
        Assert.assertEquals(5, spore.miammiam("151128241212192113722321331"));
    }

}
