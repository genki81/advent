package advent_of_code.v2023.v01;

public class Trebuchet
{
    enum DIGITS
    {
        ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE;

    }

    public int calculer(String aLignes)
    {
        String[] vLignes = aLignes.split("\n");
        int vRet = 0;
        for (String vLigne : vLignes)
        {
            String vDigits = vLigne.replaceAll("[A-Za-z]", "");
            if (!vDigits.isEmpty())
            {
                int vValue = Integer.parseInt(vDigits.charAt(0) + String.valueOf(vDigits.charAt((vDigits.length() - 1))));
                vRet += vValue;
            }
        }
        return vRet;
    }

    public int calculer2(String aLignes)
    {
        String[] vLignes = aLignes.split("\n");
        int vRet = 0;
        for (String vLigne : vLignes)
        {
            System.out.println(vLigne);
            vLigne = findFirstLitteralDigit(vLigne);
            //            System.out.println("- " + vLigne);
            vLigne = findLastLitteralDigit(vLigne);
            //            System.out.println("-- " + vLigne);
            vLigne = vLigne.replaceAll("[A-Za-z]", "");
            //            System.out.println("--- " + vLigne);
            if (!vLigne.isEmpty())
            {
                int vValue = Integer.parseInt(vLigne.charAt(0) + String.valueOf(vLigne.charAt((vLigne.length() - 1))));
                System.out.println("---- " + vValue);
                vRet += vValue;
            }
        }
        return vRet;
    }

    private String findLastLitteralDigit(String vLigne)
    {
        String vRet = vLigne;
        int vIdx = Integer.MIN_VALUE;
        DIGITS vDigit = null;
        for (DIGITS vCurrentDigit : DIGITS.values())
        {
            int vIdxLast = vLigne.lastIndexOf(vCurrentDigit.name().toLowerCase());
            if (vIdxLast > -1 && vIdxLast > vIdx)
            {
                vDigit = vCurrentDigit;
                vIdx = vIdxLast;
            }
        }
        if (vDigit != null)
        {
            vRet = vLigne.substring(0, vIdx) + (vDigit.ordinal() + 1) + vLigne.substring(vIdx + vDigit.name().length());
        }
        return vRet;
    }

    private String findFirstLitteralDigit(String vLigne)
    {
        String vRet = vLigne;
        int vIdx = Integer.MAX_VALUE;
        DIGITS vDigit = null;
        for (DIGITS vCurrentDigit : DIGITS.values())
        {
            int vIdxFirst = vLigne.indexOf(vCurrentDigit.name().toLowerCase());
            if (vIdxFirst > -1 && vIdxFirst < vIdx)
            {
                vDigit = vCurrentDigit;
                vIdx = vIdxFirst;
            }
        }
        if (vDigit != null)
        {
            vRet = vLigne.substring(0, vIdx) + (vDigit.ordinal() + 1) + vLigne.substring(vIdx + vDigit.name().length());
        }
        return vRet;
    }
}
