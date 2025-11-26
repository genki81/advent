package v20231124;

public class B_Pages
{
    private double sommaire;

    public B_Pages(double aSommaire)
    {
        sommaire = aSommaire;
    }

    public double computeNbPages()
    {
        // Le nombre de pages de notre livre
        double vRetNbPages = 0;

        // On commence à 1 caractère,
        // on va compter
        // - le nombre de pages qui s'écrivent sur 1 caractère
        // - la longueur du sommaire qui contient toutes ces pages
        // Si notre sommaire est plus long que ce sommaire,
        // alors
        // - on incrémente le nombre de pages de notre livre de ce nombre de pages constituées de 1 caractère
        // - on décrémente la longeur de notre sommaire de la longueur du sommaire de toutes les pages de 1 caractère
        // - on recommence pour 2 caractères etc.
        // Sinon
        // - on a fini, on incrémente le nombre de pages de notre livre avec le nombre de pages de notre sommaire (division entière)
        // - on renvoie le nombre de pages
        //
        // Attention, on commence à la page 1

        double n = 1;

        // Nombre de pages dont le numéro contient n caractères.
        // On aura besoin du nombre de pages déjà pris en compte au tour d'avant, donc on le sort de la boucle
        // (Lorsqu'on traite les pages sur 2 caractères, il ne faut pas reprendre les pages de 1 à 9. etc.)
        double vNbPagesNCaracteres = 0;

        // La taille du sommaire restant à traiter
        double vTailleCouranteSommaire = sommaire;

        while (true)
        {
            vNbPagesNCaracteres = Math.pow(10, n) - vNbPagesNCaracteres - 1; // 10^n - pages déjà traitées - la page 0;
            double vSommaireNCaracteres = n * vNbPagesNCaracteres; // Taille du sommaire pour ces pages

            // Si on dépasse encore, alors on prend tout.
            if (vTailleCouranteSommaire > vSommaireNCaracteres)
            {
                vRetNbPages += vNbPagesNCaracteres;
                vTailleCouranteSommaire -= vSommaireNCaracteres;
                n++;
            }
            // Sinon on ne prend que le nécessaire.
            else
            {
                vRetNbPages += vTailleCouranteSommaire / n;
                return vRetNbPages;
            }
        }
    }
}
