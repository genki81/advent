package v20240426;

public class GrilleMorpion extends AbstractGrille
{
    public GrilleMorpion(int hauteur, int largeur, int nbVictoire)
    {
        super(hauteur, largeur, nbVictoire);
    }

    @Override
    public boolean estValide()
    {
        for (int i = 0; i < hauteur; i++)
        {
            for (int j = 0; j < largeur; j++)
            {
                int vValeur = grille[i][j];
                if (vValeur != VIDE && vValeur != J1 && vValeur != J2)
                {
                    return false;
                }
            }
        }
        return true;
    }
}
