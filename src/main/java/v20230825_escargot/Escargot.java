package v20230825_escargot;

public class Escargot
{
    private int ligneMin;
    private int ligneMax;
    private int ligneCourante;

    private int colonneMin;
    private int colonneMax;
    private int colonneCourante;

    private Direction directionCourante;

    enum Direction
    {
        EST, SUD, OUEST, NORD;
    }

    public int[] parcourir(int[][] aInput)
    {
        directionCourante = Direction.EST;
        ligneMin = 0;
        ligneMax = aInput.length - 1;
        colonneMin = 0;
        colonneMax = aInput[0].length - 1;

        int vElementsTraites = 0;
        int vNbElementsATraiter = (ligneMax + 1) * (colonneMax + 1);
        int[] vRet = new int[vNbElementsATraiter];

        ligneCourante = 0;
        colonneCourante = 0;

        while (vElementsTraites < vNbElementsATraiter)
        {
            vRet[vElementsTraites++] = aInput[ligneCourante][colonneCourante];
            determinerSuite();
        }

        return vRet;
    }

    private void determinerSuite()
    {
        switch (directionCourante)
        {
            case EST:
                if (colonneCourante == colonneMax)
                {
                    directionCourante = Direction.SUD;
                    ligneMin++;
                    ligneCourante++;
                }
                else
                {
                    colonneCourante++;
                }
                break;
            case SUD:
                if (ligneCourante == ligneMax)
                {
                    directionCourante = Direction.OUEST;
                    colonneMax--;
                    colonneCourante--;
                }
                else
                {
                    ligneCourante++;
                }
                break;
            case OUEST:
                if (colonneCourante == colonneMin)
                {
                    directionCourante = Direction.NORD;
                    ligneMax--;
                    ligneCourante--;
                }
                else
                {
                    colonneCourante--;
                }
                break;
            case NORD:
                if (ligneCourante == ligneMin)
                {
                    directionCourante = Direction.EST;
                    colonneMin++;
                    colonneCourante++;
                }
                else
                {
                    ligneCourante--;
                }
                break;
        }
    }
}
