package v20231229;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class B_TestSomme
{
    private B_Somme somme;

    @Before
    public void setUp()
    {
        somme = new B_Somme();
    }

    @Test
    public void test_1_is_13()
    {
        B__Noeud vTree = new B__NoeudBuilder(10) //
                                                 .addChild(new B__Noeud(1))//
                                                 .addChild(new B__Noeud(2))//
                                                 .toNoeud();
        Assert.assertEquals(13, somme.somme(vTree));
    }

    @Test
    public void test_2_is_3()
    {
        B__Noeud vTree = new B__NoeudBuilder(1) //
                                                .addChild(new B__Noeud(0))//
                                                .addChild(new B__NoeudBuilder(0)//
                                                                                .addChild(new B__Noeud(2))//
                                                                                .toNoeud())//
                                                .toNoeud();
        Assert.assertEquals(3, somme.somme(vTree));
    }

    @Test
    public void test_3_is_111()
    {
        B__Noeud vTree = new B__NoeudBuilder(1) //
                                                .addChild(new B__Noeud(0))//
                                                .addChild(new B__NoeudBuilder(0)//
                                                                                .addChild(new B__Noeud(2))//
                                                                                .toNoeud())//
                                                .addChild(new B__Noeud(7))//
                                                .addChild(new B__NoeudBuilder(85)//
                                                                                 .addChild(new B__NoeudBuilder(1)//
                                                                                                                 .addChild(new B__Noeud(6))//
                                                                                                                 .addChild(new B__Noeud(-8))//
                                                                                                                 .addChild(new B__Noeud(17))//
                                                                                                                 .toNoeud()//
                                                                                 )//
                                                                                 .toNoeud())//
                                                .toNoeud();
        Assert.assertEquals(111, somme.somme(vTree));
    }

}
