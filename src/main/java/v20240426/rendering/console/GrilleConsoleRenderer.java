package v20240426.rendering.console;

import java.util.stream.IntStream;

import v20240426.IGrille;
import v20240426.rendering.IGrilleRenderer;

/**
 * Renderer permettant d'afficher une {@link IGrille} dans la console
 */
public class GrilleConsoleRenderer implements IGrilleRenderer
{
    @Override
    public void dessiner(IGrille aGrille)
    {
        int vHauteur = aGrille.getHauteur();
        int vLargeur = aGrille.getLargeur();
        if (vHauteur <= 0 || vLargeur <= 0)
        {
            return;
        }

        // Nombre de caractères utilisés pour représenter un numéro de colonne
        int vNbCarColonnes = String.valueOf(vLargeur).length();
        if (vNbCarColonnes % 2 == 0)
        {
            vNbCarColonnes++;
        }

        // Nombre de caractères utilisés pour représenter un numéro de ligne
        int vNbCarLignes = String.valueOf(vHauteur / 26).length() + 1;

        // On dessine la première ligne, qui contient les numéros de colonne
        dessinerPremiereLigne(vNbCarLignes, vNbCarColonnes, vLargeur);

        // On dessine les lignes du tableau en 2 parties :
        // - La première contient le trait horizontal
        // - La seconde les jetons posés sur le plateau
        for (int i = 0; i < vHauteur; i++)
        {
            dessinerLigneTableau(vNbCarLignes, vNbCarColonnes, vLargeur, aGrille, i);
        }

        // On dessine la bordure inférieure du tableau
        dessinerDerniereLigne(vNbCarLignes, vNbCarColonnes, vLargeur);
    }

    private void dessinerPremiereLigne(int nbCarLignes, int nbCarColonnes, int vLargeur)
    {
        StringBuilder vLigne = new StringBuilder();

        // On commence par des espaces pour laisser la place de représenter le numéro de ligne sur les lignes suivantes
        IntStream.range(0, nbCarLignes).forEach(c -> vLigne.append(" "));

        // On saute la première séparation verticale
        vLigne.append(" ");

        // On ajoute les numéros de colonnes 1 par 1
        for (int i = 0; i < vLargeur; i++)
        {
            vLigne.append(centrer(Integer.toString(i + 1), nbCarColonnes)).append(" ");
        }

        // On affiche le résultat
        System.out.println(vLigne);
    }

    private void dessinerLigneTableau(int vNbCarLignes, int vNbCarColonnes, int vLargeur, IGrille aGrille, int i)
    {
        StringBuilder vLigne1 = new StringBuilder();
        StringBuilder vLigne2 = new StringBuilder();

        // On convertit le numéro de la ligne en lettres A/B/.../Z/AA/BB/...
        String vLigneValue = ligneToString(i);

        // La première ligne représente la bordure horizontale, on affiche pas la ligne ici, donc on met des espaces
        IntStream.range(0, vNbCarLignes).forEach(c -> vLigne1.append(" "));
        // Puis le bord vertical gauche du tableau
        vLigne1.append(i == 0 ? ConsoleBoxDrawingChars.COIN_HAUT_GAUCHE : ConsoleBoxDrawingChars.T_GAUCHE);

        vLigne2.append(centrer(vLigneValue, vNbCarLignes)).append(ConsoleBoxDrawingChars.LIGNE_VERTICALE);

        for (int j = 0; j < vLargeur; j++)
        {
            IntStream.range(0, vNbCarColonnes).forEach(c -> vLigne1.append(ConsoleBoxDrawingChars.LIGNE_HORIZONTALE));
            vLigne2.append(centrer(lireValeur(aGrille.getValeur(i, j)), vNbCarColonnes));

            vLigne1.append(i == 0
                                   ? (j == vLargeur - 1 ? ConsoleBoxDrawingChars.COIN_HAUT_DROITE : ConsoleBoxDrawingChars.T_HAUT)
                                   : (j == vLargeur - 1 ? ConsoleBoxDrawingChars.T_DROITE : ConsoleBoxDrawingChars.CROIX));
            vLigne2.append(ConsoleBoxDrawingChars.LIGNE_VERTICALE);
        }
        System.out.println(vLigne1);
        System.out.println(vLigne2);
    }

    private String centrer(String aTexte, int aTaille)
    {
        StringBuilder vRet = new StringBuilder();
        int vNbBlancs = aTaille - aTexte.replaceAll(ConsoleTextColors.ANSI_REGEX_PATTERN.toString(), "").length();
        int vNbBlancsAvant = Math.max(0, (new Double(Math.floor(vNbBlancs / 2)).intValue()));
        IntStream.range(0, vNbBlancsAvant).forEach(c -> vRet.append(" "));
        vRet.append(aTexte);
        IntStream.range(vNbBlancsAvant, vNbBlancs).forEach(c -> vRet.append(" "));

        return vRet.toString();
    }

    private String lireValeur(int aValeur)
    {
        final String vRet;
        switch (aValeur)
        {
            case IGrille.J1:
                vRet = ConsoleTextColors.ANSI_RED + "X" + ConsoleTextColors.ANSI_RESET;
                break;
            case IGrille.J2:
                vRet = ConsoleTextColors.ANSI_BLUE + "0" + ConsoleTextColors.ANSI_RESET;
                break;
            default:
                vRet = " ";
                break;
        }
        return vRet;
    }

    private String ligneToString(int i)
    {
        StringBuilder vRet = new StringBuilder();
        do
        {
            vRet.append((char) (65 + i % 26));
            i -= 26;
        }
        while (i >= 0);
        return vRet.toString();
    }

    private void dessinerDerniereLigne(int vNbCarLignes, int vNbCarColonnes, int vLargeur)
    {
        StringBuilder vLigne1 = new StringBuilder();
        IntStream.range(0, vNbCarLignes).forEach(c -> vLigne1.append(" "));
        vLigne1.append(ConsoleBoxDrawingChars.COIN_BAS_GAUCHE);
        for (int j = 0; j < vLargeur; j++)
        {
            IntStream.range(0, vNbCarColonnes).forEach(c -> vLigne1.append(ConsoleBoxDrawingChars.LIGNE_HORIZONTALE));
            vLigne1.append(j == vLargeur - 1 ? ConsoleBoxDrawingChars.COIN_BAS_DROITE : ConsoleBoxDrawingChars.T_BAS);
        }
        System.out.println(vLigne1);
    }

}