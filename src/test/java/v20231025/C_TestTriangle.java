package v20231025;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class C_TestTriangle
{
    private C_Triangle triangle;

    @Before
    public void setUp()
    {
        triangle = new C_Triangle();
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_operateur_AR_is_error()
    {
        triangle.operateur.apply("A", "R");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_operateur_RA_is_error()
    {
        triangle.operateur.apply("R", "A");
    }

    @Test
    public void test_operateur_RR_is_R()
    {
        Assert.assertEquals("R", triangle.operateur.apply("R", "R"));
    }

    @Test
    public void test_operateur_RG_is_B()
    {
        Assert.assertEquals("B", triangle.operateur.apply("R", "G"));
    }

    @Test
    public void test_operateur_RB_is_G()
    {
        Assert.assertEquals("G", triangle.operateur.apply("R", "B"));
    }

    @Test
    public void test_operateur_BG_is_R()
    {
        Assert.assertEquals("R", triangle.operateur.apply("B", "G"));
    }

    @Test
    public void test_triangle_RR_is_R()
    {
        Assert.assertEquals("R", triangle.determineSommet("RR"));
    }

    @Test
    public void test_triangle_RG_is_B()
    {
        Assert.assertEquals("B", triangle.determineSommet("RG"));
    }

    @Test
    public void test_triangle_RBRGBRBGGRRRBGBBBGG_is_G()
    {
        Assert.assertEquals("G", triangle.determineSommet("RBRGBRBGGRRRBGBBBGG"));
    }
}
