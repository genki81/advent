package v20231124;

import org.junit.Assert;
import org.junit.Test;

public class A_TestConfidentiel
{
    private A_Confidentiel confidentiel;

    @Test
    public void test_matchCourt()
    {
        String vChaineExpurgee = "TOP SECRET:\nThe missile launch code for Sunday XXXXXXXXXX is:\nXXXXXXXXXXXXXXXXX";
        String vChaineEnClair = "TOP SECRET:\nThe missile launch code for Sunday 5th August is:\n7-ZERO-8X-ALPHA-1";

        confidentiel = new A_Confidentiel(vChaineEnClair, vChaineExpurgee);
        Assert.assertTrue(confidentiel.match());
    }

    @Test
    public void test_noMatch()
    {
        String vChaineExpurgee = "The name of the mole is Professor XXXXX";
        String vChaineEnClair = "The name of the mole is Professor Dinglemouse";

        confidentiel = new A_Confidentiel(vChaineEnClair, vChaineExpurgee);
        Assert.assertFalse(confidentiel.match());
    }

    @Test
    public void test_noMatchLF()
    {
        String vChaineExpurgee = "XXXXXXXX XXXXXXX XXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXX XXXXXXXXXXXXX XXXXX";
        String vChaineEnClair = "Area-51. Medical Report. 23/Oct/1969\nE.T. subject 4 was given an asprin after reporting sick for duty today";

        confidentiel = new A_Confidentiel(vChaineEnClair, vChaineExpurgee);
        Assert.assertFalse(confidentiel.match());
    }

    @Test
    public void test_matchLong()
    {
        String vChaineExpurgee = "XXXXXXXX XXXXXXX XXXXXXXXXXXXXXXXXXX\nXXXX XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX XXXXXXXXX XXXXXXXXXXXXX XXXXX";
        String vChaineEnClair = "Area-51. Medical Report. 23/Oct/1969\nE.T. subject 4 was given an asprin after reporting sick for duty today";

        confidentiel = new A_Confidentiel(vChaineEnClair, vChaineExpurgee);
        Assert.assertTrue(confidentiel.match());
    }

}
