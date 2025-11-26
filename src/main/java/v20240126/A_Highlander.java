package v20240126;

import java.util.StringTokenizer;

public class A_Highlander
{
    public String ilNePeutEnResterQuUn(String aInput)
    {
        StringBuilder vRet = new StringBuilder();

        String vInput = aInput.trim().toLowerCase().replaceAll("[ ]+", " ");
        StringTokenizer vSt = new StringTokenizer(vInput, " ");
        String vPreviousToken = "";
        while (vSt.hasMoreTokens())
        {
            String vToken = vSt.nextToken();
            if (!vPreviousToken.equals(vToken))
            {
                vPreviousToken = vToken;
                vRet.append(vToken).append(" ");
            }
        }

        return vRet.toString().trim();
    }
}
