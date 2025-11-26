package v20230728_romain;

import java.util.HashMap;
import java.util.Map;

public class Romain
{
    private static final Map<Character, Integer> VALUES = new HashMap<>();

    static
    {
        VALUES.put('I', 1);
        VALUES.put('V', 5);
        VALUES.put('X', 10);
        VALUES.put('L', 50);
        VALUES.put('C', 100);
        VALUES.put('D', 500);
        VALUES.put('M', 1000);
    }

    public int convertir(String aInput)
    {
        if (aInput == null || aInput.trim().isEmpty())
        {
            return 0;
        }
        if (aInput.length() == 1)
        {
            return VALUES.get(aInput.charAt(0));
        }

        char vChiffreDroite = ' ';
        int vValeurChiffreDroite = 0;

        char vChiffreGauche;
        int vValeurChiffreGauche;

        int vRet = VALUES.get(aInput.charAt(aInput.length() - 1));

        for (int i = aInput.length() - 1; i > 0; i--)
        {

            vChiffreGauche = aInput.charAt(i - 1);
            vValeurChiffreGauche = VALUES.get(vChiffreGauche);

            vChiffreDroite = aInput.charAt(i);
            vValeurChiffreDroite = VALUES.get(vChiffreDroite);

            if (vValeurChiffreGauche >= vValeurChiffreDroite)
            {
                vRet += vValeurChiffreGauche;
            }
            else
            {
                vRet -= vValeurChiffreGauche;
            }
        }

        return vRet;
    }

}
