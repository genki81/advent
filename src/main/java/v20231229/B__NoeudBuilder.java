package v20231229;

public class B__NoeudBuilder
{

    private B__Noeud noeud;

    public B__NoeudBuilder(int aValue)
    {
        noeud = new B__Noeud(aValue);
    }

    public B__Noeud toNoeud()
    {
        return noeud;
    }

    public B__NoeudBuilder addChild(B__Noeud aChild)
    {
        noeud.addChild(aChild);
        return this;
    }
}
