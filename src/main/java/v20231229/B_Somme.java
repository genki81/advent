package v20231229;

public class B_Somme
{
    public int somme(B__Noeud aNoeud)
    {
        int vChildrenValue = aNoeud.getChildren().isEmpty() ? 0 : aNoeud.getChildren().stream().mapToInt(this::somme).sum();
        return aNoeud.getValue() + vChildrenValue;
    }
}
