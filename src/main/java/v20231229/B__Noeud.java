package v20231229;

import java.util.ArrayList;
import java.util.List;

public class B__Noeud
{
    private int value;
    private List<B__Noeud> children = new ArrayList<>();

    public B__Noeud(int aValue)
    {
        super();
        value = aValue;
    }

    public void addChild(B__Noeud aChild)
    {
        children.add(aChild);
    }

    public int getValue()
    {
        return value;
    }

    public List<B__Noeud> getChildren()
    {
        return children;
    }
}
