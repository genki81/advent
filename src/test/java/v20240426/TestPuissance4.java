package v20240426;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPuissance4
{
    private GrillePuissanceQuatre puissanceQuatre;

    @Before
    public void setUp()
    {
        puissanceQuatre = new GrillePuissanceQuatre(10, 5, 4);
    }

    @Test
    public void test_vide_is_valide()
    {
        //@formatter:off
        int[][] vDisposition = new int[][]{
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0}};
        //@formatter:on
        puissanceQuatre.setGrille(vDisposition);
        Assert.assertTrue(puissanceQuatre.estValide());
    }

    @Test
    public void test_valide()
    {
        //@formatter:off
        int[][] vDisposition = new int[][]{
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {0,0,1,1,0},
                {0,0,1,1,0},
                {0,1,1,1,0}};
        //@formatter:on
        puissanceQuatre.setGrille(vDisposition);
        Assert.assertTrue(puissanceQuatre.estValide());
    }

    @Test
    public void test_invalide()
    {
        //@formatter:off
        int[][] vDisposition = new int[][]{
                {0,1,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {0,0,1,1,0},
                {0,0,1,1,0},
                {0,1,1,1,0}};
        //@formatter:on
        puissanceQuatre.setGrille(vDisposition);
        Assert.assertFalse(puissanceQuatre.estValide());
    }

    @Test
    public void test_J1_GAGNANT_V()
    {
        //@formatter:off
        int[][] vDisposition = new int[][]{
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {0,0,1,1,2},
                {0,2,1,1,2},
                {0,1,1,1,2}};
        //@formatter:on
        puissanceQuatre.setGrille(vDisposition);
        Assert.assertEquals(EtatGrille.J1_GAGNANT, puissanceQuatre.calculeEtat());
    }

    @Test
    public void test_J1_GAGNANT_H()
    {
        //@formatter:off
        int[][] vDisposition = new int[][]{
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {1,1,1,1,0},
                {2,2,1,2,0},
                {1,1,2,1,0},
                {2,1,1,1,0}};
        //@formatter:on
        puissanceQuatre.setGrille(vDisposition);
        Assert.assertEquals(EtatGrille.J1_GAGNANT, puissanceQuatre.calculeEtat());
    }

    @Test
    public void test_J1_GAGNANT_DD()
    {
        //@formatter:off
        int[][] vDisposition = new int[][]{
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {1,1,2,1,0},
                {2,2,1,2,0},
                {1,1,2,1,0},
                {2,2,1,1,1}};
        //@formatter:on
        puissanceQuatre.setGrille(vDisposition);
        Assert.assertEquals(EtatGrille.J1_GAGNANT, puissanceQuatre.calculeEtat());
    }

    @Test
    public void test_J2_GAGNANT_DG()
    {
        //@formatter:off
        int[][] vDisposition = new int[][]{
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {1,1,2,1,2},
                {2,2,1,2,1},
                {1,1,2,2,1},
                {2,2,1,1,1}};
        //@formatter:on
        puissanceQuatre.setGrille(vDisposition);
        Assert.assertEquals(EtatGrille.J2_GAGNANT, puissanceQuatre.calculeEtat());
    }

    @Test
    public void test_2_gagnants()
    {
        //@formatter:off
        int[][] vDisposition = new int[][]{
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {1,1,1,1,0},
                {2,2,2,2,0},
                {1,1,2,1,0},
                {2,1,1,1,0}};
        //@formatter:on
        puissanceQuatre.setGrille(vDisposition);
        Assert.assertEquals(EtatGrille.INVALIDE, puissanceQuatre.calculeEtat());
    }

    @Test
    public void test_0_gagnant()
    {
        //@formatter:off
        int[][] vDisposition = new int[][]{
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {2,1,1,1,0},
                {2,2,1,2,0},
                {1,1,2,1,0},
                {2,1,1,1,0}};
        //@formatter:on
        puissanceQuatre.setGrille(vDisposition);
        Assert.assertEquals(EtatGrille.EGALITE, puissanceQuatre.calculeEtat());
    }

}
