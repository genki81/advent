package v20231229;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class C_TestGate
{
    private C_Gate gate;

    @Before
    public void setUp()
    {
        gate = new C_Gate();
    }

    @Test
    public void test_1_is_0()
    {
        Assert.assertEquals(0, gate.maximiserArmee(0, 0, 0, 0, 1));
    }

    @Test
    public void test_2_is_95()
    {
        Assert.assertEquals(95, gate.maximiserArmee(500, 400, 10, 20, 15));
    }

    @Test
    public void test_3_is_0()
    {
        Assert.assertEquals(0, gate.maximiserArmee(0, 0, 1000, 1000, 1000));
    }

    @Test
    public void test_4_is_750()
    {
        Assert.assertEquals(750, gate.maximiserArmee(50000, 50000, 1, 1, 1));
    }

    @Test
    public void test_5_is_142()
    {
        Assert.assertEquals(142, gate.maximiserArmee(749, 603, 13, 8, 15));
    }

    @Test
    public void test_6_is_2018()
    {
        Assert.assertEquals(2018, gate.maximiserArmee(2763, 2942, 1, 74, 48));
    }

}
