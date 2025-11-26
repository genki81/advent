package v20240126;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class A_TestHighlander
{
    private A_Highlander highlander;

    @Before
    public void setUp()
    {
        highlander = new A_Highlander();
    }

    @Test
    public void test_EMPTY_is_EMPTY()
    {
        Assert.assertEquals("", highlander.ilNePeutEnResterQuUn(""));
    }

    @Test
    public void test_a_is_a()
    {
        Assert.assertEquals("alpha", highlander.ilNePeutEnResterQuUn(" alpha"));
    }

    @Test
    public void test_a2_is_a2()
    {
        Assert.assertEquals("alpha alphaalpha alphaalphaalpha", highlander.ilNePeutEnResterQuUn("alpha alphaalpha         alphaalphaalpha"));
    }

    @Test
    public void test_ab2c3dab2c3d_is_abcdabcd()
    {
        Assert.assertEquals("alpha beta gamma delta alpha beta gamma delta",
                            highlander.ilNePeutEnResterQuUn("alpha   beta beta gamma gamma gamma delta alpha beta beta gamma gamma gamma delta  "));
    }

    @Test
    public void test_a4_is_a()
    {
        Assert.assertEquals("alpha", highlander.ilNePeutEnResterQuUn("alpha alpha alpha alpha"));
    }

    @Test
    public void test_aba_is_aba()
    {
        Assert.assertEquals("alpha beta alpha", highlander.ilNePeutEnResterQuUn("alpha beta alpha"));
    }

    @Test
    public void test_a2ba2_is_aba()
    {
        Assert.assertEquals("alpha beta alpha", highlander.ilNePeutEnResterQuUn("alpha alpha beta alpha alpha"));
    }

    @Test
    public void test_abb_is_ab()
    {
        Assert.assertEquals("alpha beta", highlander.ilNePeutEnResterQuUn("alpha beta beta"));
    }

}
