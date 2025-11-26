package v20240126;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class D_TestBonus
{
    private D_Bonus bonus;

    @Before
    public void setUp()
    {
        bonus = new D_Bonus();
    }

    @Test
    public void test()
    {
        assertEquals("should return 71", 71, bonus.solution());
        assertEquals("should also return 108", 108, bonus.solution());
        assertEquals("should also return 97", 97, bonus.solution());
        assertEquals("What! The same function can't return different values!!!", 68, bonus.solution());
        assertEquals("WTF is going on?!?!...", 79, bonus.solution());
        assertEquals("Again, we apologize for this clearly broken kata, which is obviosuly impossible...", 83, bonus.solution());
        assertEquals("Maybe you should stop here...", 71, bonus.solution());
    }

}
