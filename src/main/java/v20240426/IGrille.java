package v20240426;

public interface IGrille
{
    int VIDE = 0;
    int J1 = 1;
    int J2 = 2;

    int getHauteur();

    int getLargeur();

    boolean estValide();

    EtatGrille calculeEtat();

    void dessiner();

    int getValeur(int i, int j);
}
