package v20230929_distance;

public class Distance
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

    private int calculerDistance(String aChaine1, String aChaine2)
    {
        final int aTailleChaine1 = aChaine1.length();
        final int aTailleChaine2 = aChaine2.length();

        final int[][] distances = new int[aTailleChaine1 + 1][aTailleChaine2 + 1];
        //Initialisation de la première ligne et première colonne de la matrice Distances
        for (int i = 0; i < aTailleChaine1 + 1; i++)
        {
            distances[i][0] = i;
        }
        for (int j = 1; j < aTailleChaine2 + 1; j++)
        {
            distances[0][j] = j;
        }
        for (int i = 1; i < aTailleChaine1 + 1; i++)
        {
            for (int j = 1; j < aTailleChaine2 + 1; j++)
            {
                int vCout = (aChaine1.charAt(i - 1) == aChaine2.charAt(j - 1)) ? 0 : 1;

                distances[i][j] = Math.min(Math.min(distances[i - 1][j] + 1, distances[i][j - 1] + 1), distances[i - 1][j - 1] + vCout);
            }
        }

        return distances[aTailleChaine1][aTailleChaine2];
    }
}
