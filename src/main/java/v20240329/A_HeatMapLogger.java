package v20240329;

import java.util.stream.IntStream;

public class A_HeatMapLogger
{
    public static void log(A_HeatMap aHeatMap)
    {
        int vMaxHeat = 0;
        for (int j = 0; j < aHeatMap.rows; j++)
        {
            for (int i = 0; i < aHeatMap.cols; i++)
            {
                vMaxHeat = Math.max(vMaxHeat, aHeatMap.heatmap[i][j]);
            }
        }
        int vNbChars = String.valueOf(vMaxHeat)
                             .length();
        StringBuilder vSb = new StringBuilder();
        IntStream.range(0, vNbChars)
                 .forEach(i -> vSb.append('¤'));
        String vObstacle = vSb.toString();
        for (int j = 0; j < aHeatMap.rows; j++)
        {
            for (int i = 0; i < aHeatMap.cols; i++)
            {
                if (aHeatMap.isObstacle(i, j))
                {
                    System.out.print(vObstacle + " | ");
                }
                else
                {
                    System.out.print(String.format("%" + vNbChars + "d | ", aHeatMap.heatmap[i][j]));
                }
            }
            System.out.println("");
        }
    }
}
