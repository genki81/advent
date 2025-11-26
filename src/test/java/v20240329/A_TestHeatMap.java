package v20240329;

import org.junit.Test;

public class A_TestHeatMap
{
    private A_HeatMap heatMap;

    @Test
    public void test_EMPTY_is_EMPTY()
    {
        heatMap = new A_HeatMap(19, 10);
        for (int i = 5; i <= 6; i++)
        {
            for (int j = 2; j <= 8; j++)
            {
                heatMap.addObstacle(i, j);
            }
        }
        heatMap.addObstacle(5, 2);
        heatMap.computeHeats(11, 4, 1, 1);
        A_HeatMapLogger.log(heatMap);
    }

}
