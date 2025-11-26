package v20240426.rendering.console;

/**
 * De quoi dessiner des tableaux en sortie console
 */
public enum ConsoleBoxDrawingChars
{
    //@formatter:off
    LIGNE_HORIZONTALE("─"),
    LIGNE_VERTICALE("│"),

    COIN_HAUT_GAUCHE("┌"),
    COIN_HAUT_DROITE("┐"),
    COIN_BAS_GAUCHE("└"),
    COIN_BAS_DROITE("┘"),

    T_HAUT("┬"),
    T_BAS("┴"),
    T_GAUCHE("├"),
    T_DROITE("┤"),

    CROIX("┼"),
    ;
    //@formatter:on

    private final String representation;

    ConsoleBoxDrawingChars(String aRepresentation)
    {
        representation = aRepresentation;
    }

    @Override
    public String toString()
    {
        return representation;
    }
}
