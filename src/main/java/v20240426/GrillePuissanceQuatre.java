package v20240426;

import java.util.Arrays;

public class GrillePuissanceQuatre extends AbstractGrille
{
    public GrillePuissanceQuatre(int hauteur, int largeur, int nbVictoire)
    {
        super(hauteur, largeur, nbVictoire);
    }

    @Override
    public boolean estValide()
    {
        int[] vColonnesRemplies = Arrays.copyOf(grille[hauteur - 1], largeur);
        boolean vOk = true;

        int i = hauteur - 2;
        while (i >= 0 && vOk)
        {
            int[] vLigne = grille[i];
            for (int j = 0; j < largeur; j++)
            {
                int vValeur = vLigne[j];
                if (vValeur != VIDE)
                {
                    // On a un jeton dans la case
                    if (vColonnesRemplies[j] == VIDE)
                    {
                        // On a un jeton dans une colonne qui était vide précédemment. Impossible
                        vOk = false;
                    }
                    else if (vValeur != J1 && vValeur != J2)
                    {
                        // Valeur inattendue
                        vOk = false;
                    }
                }
                else
                {
                    // La case est vide
                    vColonnesRemplies[j] = VIDE;
                }
            }
            i--;
        }
        return vOk;
    }

}
