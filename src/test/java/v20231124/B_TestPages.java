package v20231124;

import org.junit.Assert;
import org.junit.Test;

public class B_TestPages
{
    private B_Pages pages;

    @Test
    public void test_5_is_5()
    {
        pages = new B_Pages(5);
        Assert.assertEquals(5, pages.computeNbPages(), 0.1);
    }

    @Test
    public void test_25_is_17()
    {
        pages = new B_Pages(25);
        Assert.assertEquals(17, pages.computeNbPages(), 0.1);
    }

    @Test
    public void test_185_is_97()
    {
        pages = new B_Pages(185);
        Assert.assertEquals(97, pages.computeNbPages(), 0.1);
    }

    @Test
    public void test_660_is_256()
    {
        pages = new B_Pages(660);
        Assert.assertEquals(256, pages.computeNbPages(), 0.1);
    }

    @Test
    public void test_1095_is_401()
    {
        pages = new B_Pages(1095);
        Assert.assertEquals(401, pages.computeNbPages(), 0.1);
    }
    
}
