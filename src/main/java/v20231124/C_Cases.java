package v20231124;

import java.util.ArrayList;
import java.util.List;

public class C_Cases
{
    private int[][] matrice; // La matrice représentant les valeurs dans les cases

    private int[][] visite; // Une matrice permettant de savoir quelles cases on a déjà traitées, identifiées par la valeur 1

    private int nbLignes; // Nombre de lignes de la matrice

    private int nbCols; // Nombre de colonnes de la matrice

    private int valeur; // Valeur de référence de la case dont on souhaite trouver les adjacentes de même valeur

    private class Case
    {
        private int ligne;
        private int colonne;

        public Case(int aLigne, int aColonne)
        {
            ligne = aLigne;
            colonne = aColonne;
        }

    }

    /**
     * Constructeur prenant le nombre de lignes de la matrice, puis toutes les valeurs, dans le sens naturel de lecture (pour nous européens)
     *
     * @param aNbLignes
     * @param aValeurs
     */
    public C_Cases(int aNbLignes, int... aValeurs)
    {
        // On vérifie que les valeurs sont toutes là, puis on alimente les infos de la classe, on construit les matrices.
        if (aValeurs.length % aNbLignes != 0)
        {
            throw new IllegalArgumentException("ça tombe pas juste votre truc là");
        }
        nbLignes = aNbLignes;
        nbCols = aValeurs.length / nbLignes;
        matrice = new int[nbLignes][nbCols];
        visite = new int[nbLignes][nbCols];
        int i = 0;
        int j = 0;
        for (int vVal : aValeurs)
        {
            matrice[i][j++] = vVal;
            if (j >= nbCols)
            {
                j = 0;
                i++;
            }
        }
    }

    /**
     * Compte le nombre de cases adjacentes à la case dont les coordonnées sont passées en argument, dont la valeur correspond à celle de cette case
     *
     * @param aLigne
     * @param aCol
     * @return
     */
    public int compte(int aLigne, int aCol)
    {
        // On regarde la valeur de la case de départ
        // Si c'est un 0 on s'arrête
        valeur = matrice[aLigne][aCol];
        if (valeur == 0)
        {
            return 0;
        }

        // La valeur n'est pas 0, on continue
        // On va construire une file dans laquelle on va mettre les cases adjacentes dont la valeur correspond à la case de départ
        // Tant que la file n'est pas vide, on dépile :
        // - Pour chaque case, on regarde ses voisines. Si leur valeur correspond, on les met dans la file et on continue et on incrémente notre compteur à renvoyer.
        // - Dans tous les cas on les marque comme visitées

        // Initialisation de la file avec notre case de départ
        List<Case> vCases = new ArrayList<>();
        vCases.add(new Case(aLigne, aCol));

        // On marque la case de départ comme visitée
        visite[aLigne][aCol] = 1;

        // On initialise le compteur à renvoyer
        int vRet = 1;

        // Tant qu'il y a des cases dans la file...
        while (!vCases.isEmpty())
        {
            Case vCase = vCases.remove(0);

            // On vérifie la case du dessus
            int vLigne = vCase.ligne - 1;
            int vColonne = vCase.colonne;
            vRet += checkCaseAdjacente(vLigne, vColonne, vCases);

            // On vérifie la case du dessous
            vLigne = vCase.ligne + 1;
            vRet += checkCaseAdjacente(vLigne, vColonne, vCases);

            //On vérifie à droite
            vLigne = vCase.ligne;
            vColonne = vCase.colonne + 1;
            vRet += checkCaseAdjacente(vLigne, vColonne, vCases);

            //On vérifie à gauche
            vColonne = vCase.colonne - 1;
            vRet += checkCaseAdjacente(vLigne, vColonne, vCases);
        }
        return vRet;
    }

    /**
     * Vérifie que la case indiquée en argument a la bonne valeur.
     * Si c'est le cas, on la pousse dans la file et on renvoie 1.
     * Dans tous les cas, on marque la case comme visitée.
     *
     * @param vLigne
     * @param vColonne
     * @param vCases
     * @return
     */
    private int checkCaseAdjacente(int vLigne, int vColonne, List<Case> vCases)
    {
        int vRet = 0;
        if (vLigne >= 0 && vLigne < nbLignes && vColonne >= 0 && vColonne < nbCols && visite[vLigne][vColonne] == 0)
        {
            if (valeur == matrice[vLigne][vColonne])
            {
                // ça matche, on ajoute la case dans la file, on marque la case comme visitée et on incrémente le compteur.
                Case vNewCase = new Case(vLigne, vColonne);
                vCases.add(vNewCase);
                vRet = 1;
            }
            visite[vLigne][vColonne] = 1;
        }
        return vRet;
    }

}
