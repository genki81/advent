package v20231025;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class B_TestTriChaine
{
    private B_TriChaine triChaine;

    @Before
    public void setUp()
    {
        triChaine = new B_TriChaine();
    }

    @Test
    public void test_helloWorld()
    {
        Assert.assertEquals(" !,HWdellloor", triChaine.trie("Hello, World!"));
    }
}
