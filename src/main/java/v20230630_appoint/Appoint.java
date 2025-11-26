package v20230630_appoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Appoint
{
    // La Monnaie dont on dispose
    private static final List<Integer> MONNAIES = Arrays.asList(1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000, 20000, 50000);

    // On trie en ordre décroissant ces monnaies
    static
    {
        MONNAIES.sort(Comparator.reverseOrder());
    }

    // Prix de l'objet
    private double prix;

    // Montant payé
    private double paye;

    public Appoint(double aPrix, double aPaye)
    {
        prix = aPrix;
        paye = aPaye;
    }

    public static void main(String[] args)
    {
        Appoint vAppoint = new Appoint(100, 245.32);
        Map<Integer, Integer> vRes = vAppoint.calculRendu();
        vAppoint.afficheResultat(vRes);
    }

    private void afficheResultat(Map<Integer, Integer> vRes)
    {
        if (!vRes.isEmpty())
        {
            System.out.println("Il faut :");
            vRes.forEach((m, nb) -> {
                System.out.println(nb + " exemplaires de coupures de " + m / 100d + " euros.");
            });
        }
    }

    public Map<Integer, Integer> calculRendu()
    {
        Map<Integer, Integer> vRet = new LinkedHashMap<>(); // pour garder l'ordre de tri des coupures
        List<Integer> vMonnaies = new ArrayList<>(MONNAIES);
        int vReste = (int) (100 * (paye - prix));

        while (vMonnaies.size() > 0 && vReste >= vMonnaies.get(vMonnaies.size() - 1))
        {
            int vMonnaieCourante = vMonnaies.remove(0);
            int vResultat = (int) (vReste / vMonnaieCourante);
            if (vResultat > 0)
            {
                vRet.put(vMonnaieCourante, vResultat);
                vReste -= vMonnaieCourante * vResultat;
            }
        }
        return vRet;
    }

}
