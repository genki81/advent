package v20231229;

public class C_Gate
{
    private int minerais;
    private int gaz;

    //private int puissanceArmee;

    public int maximiserArmee(int aMinerais, int aGaz, int aPuissanceZelote, int aPuissanceTraqueur, int aPuissanceGardien)
    {
        minerais = aMinerais;
        gaz = aGaz;
        C__Unite.initPuissances(aPuissanceZelote, aPuissanceTraqueur, aPuissanceGardien);

        return algoBourrinDegueu();
        /*
        Stack<C__Unite.C__UnitType> vTypesPrio = C__Unite.meilleurTypes();
        while (!vTypesPrio.isEmpty())
        {
            C__Unite.C__UnitType vTypePrio = vTypesPrio.pop();
            while (acheterUnite(vTypePrio))
            {
            }
        }
        return puissanceArmee;
        */
    }

    private int algoBourrinDegueu()
    {
        int vRet = 0;
        for (int nz = 0; nz < 10000; nz++)
        {
            int vCzm = nz * C__Unite.C__UnitType.ZELOTE.getCoutMinerais();
            int vCzg = nz * C__Unite.C__UnitType.ZELOTE.getCoutGaz();
            if (vCzm > minerais || vCzg > gaz)
            {
                break;
            }
            for (int nt = 0; nt < 10000; nt++)
            {
                int vCtm = nt * C__Unite.C__UnitType.TRAQUEUR.getCoutMinerais();
                int vCtg = nt * C__Unite.C__UnitType.TRAQUEUR.getCoutGaz();
                if (vCzm + vCtm > minerais || vCzg + vCtg > gaz)
                {
                    break;
                }
                for (int ng = 0; ng < 10000; ng++)
                {
                    int vCgm = ng * C__Unite.C__UnitType.GARDIEN.getCoutMinerais();
                    int vCgg = ng * C__Unite.C__UnitType.GARDIEN.getCoutGaz();

                    if (vCzm + vCtm + vCgm > minerais || vCzg + vCtg + vCgg > gaz)
                    {
                        break;
                    }
                    vRet = Math.max(vRet,
                                    nz * C__Unite.C__UnitType.ZELOTE.getPuissance()
                                    + nt * C__Unite.C__UnitType.TRAQUEUR.getPuissance()
                                    + ng * C__Unite.C__UnitType.GARDIEN.getPuissance());
                }
            }

        }
        return vRet;
    }

    /*
    private boolean acheterUnite(C__Unite.C__UnitType aUnite)
    {
        if (minerais < aUnite.getCoutMinerais())
        {
            return false;
        }
        if (gaz < aUnite.getCoutGaz())
        {
            return false;
        }
        puissanceArmee += aUnite.getPuissance();
        minerais -= aUnite.getCoutMinerais();
        gaz -= aUnite.getCoutGaz();
        return true;
    }
    */
}
