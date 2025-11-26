package v20240126;

public class B_FuelCraft
{
    enum CARBURANT
    {
        BATON(1), BLOC(15), CHARBON(80), INCANDESCENT(120), LAVE(800);

        int duree;

        CARBURANT(int aDuree)
        {
            duree = aDuree;
        }
    }

    public int[] calculRessources(int aNbLingots)
    {
        int[] vRet = new int[CARBURANT.values().length];
        int vReste = aNbLingots * 11;
        CARBURANT[] vCarburants = CARBURANT.values();
        for (int i = vCarburants.length - 1; i >= 0 && vReste > 0; i--)
        {
            CARBURANT vCarburant = vCarburants[i];
            int vNombre = vReste / vCarburant.duree;
            vReste -= vNombre * vCarburant.duree;

            vRet[i] = vNombre;
        }
        return vRet;
    }

}
