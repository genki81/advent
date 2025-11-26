package v20230825_escargot;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestEscargot
{
    private Escargot escargot;

    @Before
    public void setUp()
    {
        escargot = new Escargot();
    }

    @Test
    public void test_3x3()
    {
        //@formatter:off
        Assert.assertArrayEquals("3x3 pb", new int[]{1,2,3,6,9,8,7,4,5},
                              escargot.parcourir(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        //@formatter:on
    }

    @Test
    public void test_4x4()
    {
        //@formatter:off
        Assert.assertArrayEquals("4x4 pb", new int[]{1,2,3,1,4,7,7,9,8,7,7,4,5,6,9,8},
                              escargot.parcourir(new int[][]{{1,2,3,1},{4,5,6,4},{7,8,9,7},{7,8,9,7}}));
        //@formatter:on
    }

    @Test
    public void test_4x4_lisible()
    {
        //@formatter:off
        Assert.assertArrayEquals("4x4 pb", new int[]{1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10},
                             escargot.parcourir(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));
        //@formatter:on
    }
}
