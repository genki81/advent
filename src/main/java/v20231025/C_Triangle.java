package v20231025;

import java.util.function.BiFunction;

public class C_Triangle
{
    /** La caratères gérés. On utilise une enum pour l'implémentation de l'algo. */
    private enum Caractere
    {
        R, G, B;
    }

    /**
     * Opérateur qui va déduire le sommet résultant de la composition de la base.<br>
     * public pour le TU.
     */
    public static final BiFunction<String, String, String> operateur = new BiFunction<>()
    {
        private static final int positions = 0b111;
        private final Caractere[] carArray = Caractere.values();

        private int calculBitActif(int aBin)
        {
            int vRet = 0;
            int vBitTest = 1;

            while ((aBin & vBitTest) == 0)
            {
                vBitTest = vBitTest << 1;
                vRet++;
            }

            return vRet;
        }

        @Override
        public String apply(String c1, String c2)
        {
            // On va chercher les caractères dans l'enum des caractères gérés.
            // Envoie une exception si caractère non prévu
            Caractere vCar1 = Caractere.valueOf(c1.toString());
            Caractere vCar2 = Caractere.valueOf(c2.toString());

            // Si 2 caractères identiques, alors on renvoie ce caractère
            if (vCar1 == vCar2)
                return c1;

            // Sinon, on va jouer en binaire avec le 0b111
            // - Remplacer les 1 par des 0 aux positions des 2 caractères déjà pris (position = ordinal dans l'enum)
            // - Retrouver la position du 1 restant
            // - Déduire le caractère résultat en fonction de cette position, et donc de son ordinal

            // Les valeurs binaires des ordinaux des 2 caractères d'entrée
            // Si ordinal = 0 (ici R), alors valeur binaire = 2^0 = 1 = 0b001
            // Si ordinal = 1 (ici G), alors valeur binaire = 2^1 = 2 = 0b010
            // Si ordinal = 2 (ici B), alors valeur binaire = 2^2 = 4 = 0b100
            int vOrdinal1 = (int) Math.pow(2, vCar1.ordinal());
            int vOrdinal2 = (int) Math.pow(2, vCar2.ordinal());

            // On applique des XOR (OU eXclusifs) entre la valeur de départ 0b111 et les 2 valeurs précédemment calculées.
            // Cela va remplacer les 1 de 0b111 par des 0 aux positions où se trouvent les 2 caractères d'entrée
            // Si vOrdinal1 = 0b001 & vOrdinal 2 = 0b100, alors 0b111 ^ 0b001 ^ 0b100 = 0b010
            int vLastPos = positions ^ vOrdinal1 ^ vOrdinal2;

            // On détermine la position du 1 restant dans le resultat
            int vLastOrdinal = (int) (calculBitActif(vLastPos));

            // On renvoie le caractère qui a pour ordinal cette valeur
            return carArray[vLastOrdinal].toString();
        }
    };

    public String determineSommet(String aBase)
    {
        // On transforme notre chaîne d'entrée en tableau de String contenant chacun 1 caractère.
        String[] vLigneCourante = aBase.chars().mapToObj(c -> String.valueOf((char) c)).toArray(String[]::new);

        // On va boucler jusqu'çà ce qu'il ne reste plus qu'un élément
        while (true)
        {
            // On prépare la ligne suivante qui contiendra les résultats des applications de notre opérateur aux éléments de la ligne courante
            String[] vLigneSuivante = new String[vLigneCourante.length - 1];

            // On applique l'opérateur à chaque paire de caractères voisins de la ligne courante
            for (int i = 0; i < vLigneSuivante.length; i++)
            {
                vLigneSuivante[i] = operateur.apply(vLigneCourante[i], vLigneCourante[i + 1]);
            }
            // Si on a plus qu'un élément dans la ligne de résultats, c'est fini.
            if (vLigneSuivante.length == 1)
            {
                return vLigneSuivante[0];
            }
            vLigneCourante = vLigneSuivante;
        }
    }
}
