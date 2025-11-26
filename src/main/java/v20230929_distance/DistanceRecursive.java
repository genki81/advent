package v20230929_distance;

public class DistanceRecursive
{

    public String suggerer(String aEntree, String[] aDictionnaire)
    {
        int vMin = Integer.MAX_VALUE;
        String vRet = null;

        for (int i = 0; i < aDictionnaire.length; i++)
        {
            int vDistance = calculerDistance(aEntree, aDictionnaire[i]);
            if (vDistance < vMin)
            {
                vMin = vDistance;
                vRet = aDictionnaire[i];
                if (vMin == 0)
                    break;
            }
        }
        return vRet;
    }

    public static void main(String[] args)
    {
        DistanceRecursive vRec = new DistanceRecursive();
        System.out.println(vRec.calculerDistance("heaven", "javascript"));
    }

    private int calculerDistance(String aChaine1, String aChaine2)
    {
        final int aTailleChaine1 = aChaine1.length();
        final int aTailleChaine2 = aChaine2.length();

        if (Math.min(aTailleChaine1, aTailleChaine2) == 0)
        {
            return Math.max(aTailleChaine1, aTailleChaine2);
        }

        String vSub1 = aChaine1.substring(1);
        String vSub2 = aChaine2.substring(1);
        int vDistanceSub1Sub2 = calculerDistance(vSub1, vSub2);

        if (aChaine1.charAt(0) == aChaine2.charAt(0))
        {
            return vDistanceSub1Sub2;
        }

        return 1 + Math.min(Math.min(calculerDistance(vSub1, aChaine2), calculerDistance(aChaine1, vSub2)), vDistanceSub1Sub2);
    }
}
