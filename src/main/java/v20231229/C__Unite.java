package v20231229;

public class C__Unite
{
    public enum C__UnitType
    {
        ZELOTE(100, 0), TRAQUEUR(125, 50), GARDIEN(50, 100),
        ;

        private int coutMinerais;
        private int coutGaz;
        private int puissance;

        C__UnitType(int aCoutMinerais, int aCoutGaz)
        {
            coutMinerais = aCoutMinerais;
            coutGaz = aCoutGaz;
        }

        public void setPuissance(int aPuissance)
        {
            puissance = aPuissance;
        }

        public int getCoutMinerais()
        {
            return coutMinerais;
        }

        public int getCoutGaz()
        {
            return coutGaz;
        }

        public int getPuissance()
        {
            return puissance;
        }

        /*
        public float getPuissanceParMinerai()
        {
            if (coutMinerais > 0)
            {
                return (float) puissance / coutMinerais;
            }
            return 0;
        }

        public float getPuissanceParGaz()
        {
            if (coutGaz > 0)
            {
                return (float) puissance / coutGaz;
            }
            return 0;
        }

        public float getPuissanceParRessource()
        {
            return Math.max(getPuissanceParMinerai(), getPuissanceParGaz());
        }
        */
    }

    public static void initPuissances(int aPuissanceZelote, int aPuissanceTraqueur, int aPuissanceGardien)
    {
        C__UnitType.ZELOTE.setPuissance(aPuissanceZelote);
        C__UnitType.TRAQUEUR.setPuissance(aPuissanceTraqueur);
        C__UnitType.GARDIEN.setPuissance(aPuissanceGardien);
    }

    /*
    static C__UnitType meilleurType;
    static C__UnitType meilleurTypeMinerai;
    static C__UnitType meilleurTypeGaz;

    public static C__UnitType meilleurType()
    {
        if (meilleurType == null)
        {
            meilleurType = Arrays.stream(C__UnitType.values()).max(Comparator.comparing(C__UnitType::getPuissanceParRessource)).orElse(null);
        }
        return meilleurType;
    }

    public static Stack<C__UnitType> meilleurTypes()
    {
        Stack<C__UnitType> vRet = new Stack<>();
        vRet.addAll(Arrays.stream(C__UnitType.values())
                          .sorted(Comparator.comparing(C__UnitType::getPuissanceParRessource))
                          .collect(Collectors.toList()));
        return vRet;
    }

    public static C__UnitType meilleurTypeMinerai()
    {
        if (meilleurTypeMinerai == null)
        {
            meilleurTypeMinerai = Arrays.stream(C__UnitType.values()).max(Comparator.comparing(C__UnitType::getPuissanceParMinerai)).orElse(null);
        }
        return meilleurTypeMinerai;
    }

    public static C__UnitType meilleurTypeGaz()
    {
        if (meilleurTypeGaz == null)
        {
            meilleurTypeGaz = Arrays.stream(C__UnitType.values()).max(Comparator.comparing(C__UnitType::getPuissanceParGaz)).orElse(null);
        }
        return meilleurTypeGaz;
    }
    */
}
