package v20230728_romain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRomain
{
    private Romain romain;

    @Before
    public void setUp()
    {
        romain = new Romain();
    }

    @Test
    public void testRomain_Vide_egal_0()
    {
        Assert.assertEquals(0, romain.convertir(""));
    }

    @Test
    public void testRomain_IV_egal_4()
    {
        Assert.assertEquals(4, romain.convertir("IV"));
    }

    @Test
    public void testRomain_XLIX_egal_49()
    {
        Assert.assertEquals(49, romain.convertir("XLIX"));
    }

    @Test
    public void testRomain_LIII_egal_53()
    {
        Assert.assertEquals(53, romain.convertir("LIII"));
    }

    @Test
    public void testRomain_CXI_egal_111()
    {
        Assert.assertEquals(111, romain.convertir("CXI"));
    }

    @Test
    public void testRomain_CCXXII_egal_222()
    {
        Assert.assertEquals(222, romain.convertir("CCXXII"));
    }

    @Test
    public void testRomain_CDXLIV_egal_444()
    {
        Assert.assertEquals(444, romain.convertir("CDXLIV"));
    }

    @Test
    public void testRomain_CMXCIX_egal_999()
    {
        Assert.assertEquals(999, romain.convertir("CMXCIX"));
    }

    @Test
    public void testRomain_MMDCCLXXXVI_egal_2786()
    {
        Assert.assertEquals(2786, romain.convertir("MMDCCLXXXVI"));
    }

    @Test
    public void testRomain_MMMDCCVIII_egal_3708()
    {
        Assert.assertEquals(3708, romain.convertir("MMMDCCVIII"));
    }

    @Test
    public void testRomain_MMMCMXCIX_egal_3999()
    {
        Assert.assertEquals(3999, romain.convertir("MMMCMXCIX"));
    }

    @Test
    public void testRomain_MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMCMXCIX_egal_99999()
    {
        Assert.assertEquals(99_999,
                            romain.convertir(
                                    "MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMCMXCIX"));
    }

    @Test
    public void testRomain_MMMC_egal_970()
    {
        Assert.assertEquals(970, romain.convertir("XXXM"));
    }

    @Test
    public void testRomain_CMLXX_egal_970()
    {
        Assert.assertEquals(970, romain.convertir("CMLXX"));
    }

}
