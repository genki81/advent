package v20240426;

import v20240426.rendering.IGrilleRenderer;
import v20240426.rendering.console.GrilleConsoleRenderer;

public abstract class AbstractGrille implements IGrille
{
    protected int largeur;
    protected int hauteur;
    protected int nbVictoire;

    protected int[][] grille;

    private IGrilleRenderer renderer;

    public AbstractGrille(int aHauteur, int aLargeur, int aNbVictoire)
    {
        if (aHauteur <= 0 || aLargeur <= 0 || aNbVictoire <= 0)
        {
            throw new IllegalArgumentException("Arguments incorrects");
        }
        hauteur = aHauteur;
        largeur = aLargeur;
        setGrille(new int[aHauteur][aLargeur]);
        nbVictoire = aNbVictoire;
        renderer = new GrilleConsoleRenderer();
    }

    public void setGrille(int[][] aGrille)
    {
        if (aGrille.length != hauteur)
        {
            throw new IllegalArgumentException("Hauteur Grille " + aGrille.length + " au lieu de " + hauteur);
        }
        if (aGrille[0].length != largeur)
        {
            throw new IllegalArgumentException("Largeur Grille " + aGrille[0].length + " au lieu de " + largeur);
        }
        grille = aGrille;
    }

    @Override
    public EtatGrille calculeEtat()
    {
        if (!estValide())
        {
            return EtatGrille.INVALIDE;
        }

        EtatGrille vRet = EtatGrille.EGALITE;
        for (int i = hauteur - 1; i >= 0 && !vRet.equals(EtatGrille.INVALIDE); i--)
        {
            for (int j = 0; j < largeur && !vRet.equals(EtatGrille.INVALIDE); j++)
            {
                int vValeurCase = grille[i][j];
                for (Direction vDir : Direction.values())
                {
                    if (vValeurCase == J1 && !vRet.equals(EtatGrille.J1_GAGNANT) || vValeurCase == J2 && !vRet.equals(EtatGrille.J2_GAGNANT))
                    {
                        int nbConsec = 1;
                        boolean vTrouve = true;
                        while (nbConsec < nbVictoire && vTrouve)
                        {
                            int vValeurVoisin = getValeurGrille(i, j, nbConsec, vDir);
                            if (vValeurVoisin == vValeurCase)
                            {
                                nbConsec++;
                            }
                            else
                            {
                                vTrouve = false;
                            }
                        }
                        if (nbConsec == nbVictoire)
                        {
                            vRet = (vRet.equals(EtatGrille.J1_GAGNANT) || vRet.equals(EtatGrille.J2_GAGNANT))
                                    // On a 2 gagnants :o
                                    ? EtatGrille.INVALIDE
                                    // On a un gagnant
                                    : vValeurCase == J1 ? EtatGrille.J1_GAGNANT : EtatGrille.J2_GAGNANT;
                        }
                    }
                }
            }
        }
        return vRet;
    }

    private int getValeurGrille(int i, int j, int decal, Direction aDirection)
    {
        int vNewI = i;
        int vNewJ = j;
        switch (aDirection)
        {
            case H:
                vNewJ += decal;
                break;
            case V:
                vNewI -= decal;
                break;
            case DD:
                vNewI -= decal;
                vNewJ += decal;
                break;
            case DG:
                vNewI -= decal;
                vNewJ -= decal;
                break;
        }
        if (vNewJ >= largeur || vNewJ < 0 || vNewI < 0)
        {
            return 0;
        }
        return grille[vNewI][vNewJ];
    }

    @Override
    public void dessiner()
    {
        renderer.dessiner(this);
    }

    @Override
    public int getValeur(int i, int j)
    {
        return grille[i][j];
    }

    @Override
    public int getHauteur()
    {
        return hauteur;
    }

    @Override
    public int getLargeur()
    {
        return largeur;
    }
}
