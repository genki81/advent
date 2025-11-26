package v20240126;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class B_TestFuelCraft
{
    private B_FuelCraft fuelCraft;

    @Before
    public void setUp()
    {
        fuelCraft = new B_FuelCraft();
    }

    @Test
    public void test_37()
    {

        Assert.assertArrayEquals(new int[] {
                2,
                3,
                0,
                3,
                0
        }, fuelCraft.calculRessources(37));
    }

    @Test
    public void test_21()
    {

        Assert.assertArrayEquals(new int[] {
                1,
                2,
                1,
                1,
                0
        }, fuelCraft.calculRessources(21));
    }

    @Test
    public void test_123()
    {

        Assert.assertArrayEquals(new int[] {
                13,
                4,
                0,
                4,
                1
        }, fuelCraft.calculRessources(123));
    }
}
