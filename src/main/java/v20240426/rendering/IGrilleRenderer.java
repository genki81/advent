package v20240426.rendering;

import v20240426.IGrille;

/**
 * Affichage d'une {@link IGrille}
 */
public interface IGrilleRenderer
{
    /**
     * Dessin de la grille
     *
     * @param aGrille
     */
    void dessiner(IGrille aGrille);
}
