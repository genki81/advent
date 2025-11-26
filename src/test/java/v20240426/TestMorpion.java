package v20240426;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMorpion
{
    private GrilleMorpion morpion;

    @Before
    public void setUp()
    {
        morpion = new GrilleMorpion(10, 5, 4);
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
        morpion.setGrille(vDisposition);
        Assert.assertTrue(morpion.estValide());
    }

    @Test
    public void test_valide()
    {
        //@formatter:off
        int[][] vDisposition = new int[][]{
                {0,0,0,0,0},
                {0,0,2,0,0},
                {0,0,0,0,0},
                {0,2,0,1,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,1,0,1,0},
                {0,0,1,1,0},
                {0,0,1,1,0},
                {0,1,1,1,0}};
        //@formatter:on
        morpion.setGrille(vDisposition);
        Assert.assertTrue(morpion.estValide());
    }

    @Test
    public void test_invalide()
    {
        //@formatter:off
        int[][] vDisposition = new int[][]{
                {0,1,0,0,0},
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,3,0,0,0},
                {0,0,0,-1,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {0,0,1,1,0},
                {0,0,1,1,0},
                {0,1,1,1,0}};
        //@formatter:on
        morpion.setGrille(vDisposition);
        Assert.assertFalse(morpion.estValide());
    }

    @Test
    public void test_J1_GAGNANT_V()
    {
        //@formatter:off
        int[][] vDisposition = new int[][]{
                {0,0,0,0,0},
                {0,0,0,0,0},
                {0,1,0,0,0},
                {0,1,0,0,0},
                {0,1,0,0,0},
                {0,1,0,0,0},
                {0,0,0,1,0},
                {0,0,1,2,2},
                {0,2,1,1,2},
                {0,1,1,1,2}};
        //@formatter:on
        morpion.setGrille(vDisposition);
        Assert.assertEquals(EtatGrille.J1_GAGNANT, morpion.calculeEtat());
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
        morpion.setGrille(vDisposition);
        Assert.assertEquals(EtatGrille.J1_GAGNANT, morpion.calculeEtat());
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
        morpion.setGrille(vDisposition);
        Assert.assertEquals(EtatGrille.J1_GAGNANT, morpion.calculeEtat());
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
        morpion.setGrille(vDisposition);
        Assert.assertEquals(EtatGrille.J2_GAGNANT, morpion.calculeEtat());
    }

    @Test
    public void test_2_GAGNANTS()
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
        morpion.setGrille(vDisposition);
        Assert.assertEquals(EtatGrille.INVALIDE, morpion.calculeEtat());
    }

    @Test
    public void test_EGALITE()
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
        morpion.setGrille(vDisposition);
        Assert.assertEquals(EtatGrille.EGALITE, morpion.calculeEtat());
    }

    @Test
    public void test_grande_grille()
    {
        morpion = new GrilleMorpion(34, 16, 4);
        //@formatter:off
        int[][] vDisposition = new int[][]{
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,2,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,2,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,2,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,2,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,2,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,2,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0},
                {1,1,2,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {2,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0}};
        //@formatter:on
        morpion.setGrille(vDisposition);
        Assert.assertEquals(EtatGrille.INVALIDE, morpion.calculeEtat());
        morpion.dessiner();
    }

}
