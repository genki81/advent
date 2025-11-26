package v20231124;

public class A_Confidentiel
{
    private static final char X = 'X';

    private String chaineEnClair;
    private String chaineExpurgee;

    public A_Confidentiel(String aChaineEnClair, String aChaineExpurgee)
    {
        super();
        chaineEnClair = aChaineEnClair;
        chaineExpurgee = aChaineExpurgee;
    }

    public boolean match()
    {
        // Si les 2 chaînes n'ont même pas la même longueur (l'expurgation, c'est juste un remplacement), pas la peine d'aller plus loin.
        if (chaineEnClair.length() != chaineExpurgee.length())
        {
            return false;
        }

        // Sinon on parcourt.
        // Si tous les caractères sont identiques ou bien que les caractères qui ne correspondent pas sont des X dans la chaîne expurgée, alors ça matche !
        for (int i = 0; i < chaineEnClair.length(); i++)
        {
            final char vCharExpurge = chaineExpurgee.charAt(i);
            // On a pas le droit d'expurger le \n
            if (vCharExpurge == X && chaineEnClair.charAt(i) == '\n')
            {
                return false;
            }
            if (vCharExpurge != X && chaineEnClair.charAt(i) != vCharExpurge)
            {
                return false;
            }
        }
        return true;
    }

}
