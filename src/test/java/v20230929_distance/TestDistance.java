package v20230929_distance;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDistance
{
    private Distance distance;
    private DistanceRecursive distanceRecursive;

    private static final String[] DICO_FRUITS = {
            "cherry",
            "pineapple",
            "melon",
            "strawberry",
            "raspberry"
    };

    private static final String[] DICO_ARS = {
            "stars",
            "mars",
            "wars",
            "codec",
            "codewars"
    };

    private static final String[] DICO_LANGUAGES = {
            "javascript",
            "java",
            "ruby",
            "php",
            "python",
            "coffeescript"
    };

    @Before
    public void setUp()
    {
        distance = new Distance();
        distanceRecursive = new DistanceRecursive();
    }

    @Test
    public void test_matrice_fruits_strawbery_is_strawberry()
    {
        Assert.assertEquals("strawberry", distance.suggerer("strawbery", DICO_FRUITS));
    }

    @Test
    public void test_matrice_fruits_berry_is_cherry()
    {
        Assert.assertEquals("cherry", distance.suggerer("berry", DICO_FRUITS));
    }

    @Test
    public void test_matrice_ars_coddwars_is_codewars()
    {
        Assert.assertEquals("codewars", distance.suggerer("coddwars", DICO_ARS));
    }

    @Test
    public void test_matrice_languages_heaven_is_java()
    {
        Assert.assertEquals("java", distance.suggerer("heaven", DICO_LANGUAGES));
    }

    @Test
    public void test_matrice_languages_javascript_is_javascript()
    {
        Assert.assertEquals("javascript", distance.suggerer("javascript", DICO_LANGUAGES));
    }

    @Test
    public void test_recursif_fruits_strawbery_is_strawberry()
    {
        Assert.assertEquals("strawberry", distanceRecursive.suggerer("strawbery", DICO_FRUITS));
    }

    @Test
    public void test_recursif_fruits_berry_is_cherry()
    {
        Assert.assertEquals("cherry", distanceRecursive.suggerer("berry", DICO_FRUITS));
    }

    @Test
    public void test_recursif_ars_coddwars_is_codewars()
    {
        Assert.assertEquals("codewars", distanceRecursive.suggerer("coddwars", DICO_ARS));
    }

    @Test
    public void test_recursif_languages_heaven_is_java()
    {
        Assert.assertEquals("java", distanceRecursive.suggerer("heaven", DICO_LANGUAGES));
    }

    @Test
    public void test_recursif_languages_javascript_is_javascript()
    {
        Assert.assertEquals("javascript", distanceRecursive.suggerer("javascript", DICO_LANGUAGES));
    }

}
