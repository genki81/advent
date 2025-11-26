package v20240126;

import java.util.List;
import java.util.stream.Collectors;

public class C_Spore
{
    public int miammiam(String aNourriture)
    {
        int vTaille = 1;
        if (aNourriture == null || aNourriture.isEmpty())
        {
            return vTaille;
        }
        int vMange = 0;
        List<Integer> vPoissons = aNourriture.chars().boxed().sorted().map(i -> i - 48).collect(Collectors.toList());
        for (int p : vPoissons)
        {
            if (p > vTaille)
            {
                break;
            }
            vMange += p;
            if (vMange >= 4 * vTaille)
            {
                vTaille++;
                vMange = 0;
            }
        }
        return vTaille;
    }
}
