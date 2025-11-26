package v20240126;

public class D_Bonus
{
    private static final int[] SOLUTIONS = new int[] {
            71,
            108,
            97,
            68,
            79,
            83
    };

    private static int idx = 0;

    public int solution()
    {
        int vRet = SOLUTIONS[idx];
        next();
        return vRet;
    }

    private void next()
    {
        idx++;
        if (idx == SOLUTIONS.length)
        {
            idx = 0;
        }
    }

}
