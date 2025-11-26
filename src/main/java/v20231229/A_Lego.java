package v20231229;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class A_Lego
{
    private static final String SEPARATOR = "-";

    /**
     * Comparateur qui va mettre classer les caractères dans l'ordre suivant : a-zA-Z0-9
     */
    private static final Comparator<Character> COMPARATOR = new Comparator<Character>()
    {
        @Override
        public int compare(Character o1, Character o2)
        {
            if (Character.isDigit(o1) && !Character.isDigit(o2))
            {
                return 1;
            }
            if (!Character.isDigit(o1) && Character.isDigit(o2))
            {
                return -1;
            }
            if (Character.isUpperCase(o1) && !Character.isUpperCase(o2))
            {
                return 1;
            }
            if (!Character.isUpperCase(o1) && Character.isUpperCase(o2))
            {
                return -1;
            }
            return Character.compare(o1, o2);
        }
    };

    public String blockize(String aInput)
    {
        // Caractères qu'il reste à traiter
        String vATraiter = aInput;

        //Liste qui va contenir les blocs à trier puis à regrouper avec un -
        List<String> vPreRet = new ArrayList<>();

        // On va parcourir les caractères à traiter vATraiter.
        // Tant qu'on a pas de doublon, on les ajoute dans la chaîne de sortie courante, qui ira dans vPreRet
        // En cas de doublon on les met dans une chaîne à recycler dont vATraiter prendra la valeur en fin de boucle
        while (!vATraiter.isEmpty())
        {
            // Les caractères de la chaîne courante
            Set<Character> vKeep = new HashSet<>();

            // Les caractères en double
            StringBuilder vReste = new StringBuilder();

            for (int i = 0; i < vATraiter.length(); i++)
            {
                char vChar = vATraiter.charAt(i);
                if (!vKeep.add(vChar))
                {
                    // Doublon
                    vReste.append(vChar);
                }
            }

            // On ajoute la chaîne courante dans la sortie
            vPreRet.add(vKeep.stream().sorted(COMPARATOR) // On trie
                             .map(String::valueOf).collect(Collectors.joining()) // On transforme en String
            );

            // On recycle les doublons
            vATraiter = vReste.toString();
        }

        // On assemble els blocs avec des "-"
        return vPreRet.stream().collect(Collectors.joining(SEPARATOR));
    }
}
