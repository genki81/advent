package v20240329;

import java.util.ArrayList;
import java.util.List;

public class A_HeatMap
{
    // Cette case est un obstacle
    private static final int OBSTACLE = -1;

    // Cette case n'est pas encore visitée
    private static final int VOID = Integer.MAX_VALUE;

    // Nombre de colonnes
    public int cols;

    // Nombre de lignes
    public int rows;

    // Matric de chaleurs
    public int[][] heatmap;

    public A_HeatMap(int aCols, int aRows)
    {
        cols = aCols;
        rows = aRows;
        heatmap = new int[aCols][aRows];

        // On initialise la map des chaleurs à "Vide"
        for (int i = 0; i < cols; i++)
        {
            for (int j = 0; j < rows; j++)
            {
                heatmap[i][j] = VOID;
            }
        }
    }

    /**
     * Ajout d'un obstacle en la case aX, aY
     *
     * @param aX
     * @param aY
     */
    public void addObstacle(int aX, int aY)
    {
        heatmap[aX][aY] = OBSTACLE;
    }

    /**
     * Calcul de la Heatmap à partir de l'arrivée
     *
     * @param aStartX abscisse de départ des points d'objectif
     * @param aStartY ordonnée de départ des points d'objectif
     * @param aColspan nombre de colonnes sur lesquelles l'objectif s'étend
     * @param aRowspan nombre de lignes sur lesquelles l'objectif s'étend
     */
    public void computeHeats(int aStartX, int aStartY, int aColspan, int aRowspan)
    {
        // Indication de l'objectif
        for (int i = 0; i <= aColspan; i++)
        {
            for (int j = 0; j <= aRowspan; j++)
            {
                heatmap[aStartX + i][aStartY + j] = 0;
            }
        }

        // On parcourt les points d'objectifs pour calculer la heatmap en parcourant les voisins
        for (int i = 0; i <= aColspan; i++)
        {
            for (int j = 0; j <= aRowspan; j++)
            {
                traiterVoisins(aStartX + i, aStartY + j, 0);
            }
        }
    }

    private void traiterVoisins(int aCurrentX, int aCurrentY, int aCurrentHeat)
    {
        // On regarde les 4 voisins et on attribue la chaleur courante si on doit
        List<int[]> vChangedNeighbours = new ArrayList<>();

        // Voisin de gauche
        if (aCurrentX > 0 && shouldChangeHeat(aCurrentX - 1, aCurrentY, aCurrentHeat))
        {
            heatmap[aCurrentX - 1][aCurrentY] = aCurrentHeat + 1;
            vChangedNeighbours.add(new int[] {
                    aCurrentX - 1,
                    aCurrentY
            });
        }
        // Voisin de droite
        if (aCurrentX < cols - 1 && shouldChangeHeat(aCurrentX + 1, aCurrentY, aCurrentHeat))
        {
            heatmap[aCurrentX + 1][aCurrentY] = aCurrentHeat + 1;
            vChangedNeighbours.add(new int[] {
                    aCurrentX + 1,
                    aCurrentY
            });
        }
        // Voisin du dessus
        if (aCurrentY > 0 && shouldChangeHeat(aCurrentX, aCurrentY - 1, aCurrentHeat))
        {
            heatmap[aCurrentX][aCurrentY - 1] = aCurrentHeat + 1;
            vChangedNeighbours.add(new int[] {
                    aCurrentX,
                    aCurrentY - 1
            });
        }
        // Voisin du dessous
        if (aCurrentY < rows - 1 && shouldChangeHeat(aCurrentX, aCurrentY + 1, aCurrentHeat))
        {
            heatmap[aCurrentX][aCurrentY + 1] = aCurrentHeat + 1;
            vChangedNeighbours.add(new int[] {
                    aCurrentX,
                    aCurrentY + 1
            });
        }

        //Une fois les chaleurs allouées, on continue l'algo en récursif sur les voisins

        // si on a des voisins traités
        for (int[] vChangedNeighbour : vChangedNeighbours)
        {
            traiterVoisins(vChangedNeighbour[0], vChangedNeighbour[1], aCurrentHeat + 1);
        }
    }

    /**
     * On change la valeur de la heatmap si la chaleur actuelle de la case est supérieure à celle qu'on souhaite allouer et si la case n'est pas un obstacle
     */
    private boolean shouldChangeHeat(int aX, int aY, int aCurrentScore)
    {
        return heatmap[aX][aY] > aCurrentScore && !isObstacle(aX, aY);
    }

    public boolean isObstacle(int i, int j)
    {
        return heatmap[i][j] == OBSTACLE;
    }
}
