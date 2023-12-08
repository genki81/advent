package advent_of_code.v2023.v02;

import java.util.List;

public class Cubes
{
    private int nbRInit = -1;
    private int nbGInit = -1;
    private int nbBInit = -1;

    public class Game
    {
        public int id;
        public int nbR;
        public int nbG;
        public int nbB;

        public int getId()
        {
            return id;
        }

        public int computePower()
        {
            return nbR * nbB * nbG;
        }
    }

    public void init(int aNbRInit, int aNbGInit, int aNbBInit)
    {
        nbRInit = aNbRInit;
        nbGInit = aNbGInit;
        nbBInit = aNbBInit;
    }

    public int findGames1(String aGames)
    {
        List<String> vGames = List.of(aGames.split("\n"));
        int vRet = vGames.stream().map(this::toGame).filter(this::match).map(Game::getId).reduce(0, (a, b) -> a + b);
        return vRet;
    }

    private boolean match(Game game)
    {
        return game.nbR <= nbRInit && game.nbG <= nbGInit && game.nbB <= nbBInit;
    }

    private Game toGame(String aGame)
    {
        Game vRet = new Game();
        vRet.id = Integer.parseInt(aGame.substring(aGame.indexOf(' ') + 1, aGame.indexOf(':')));
        aGame = aGame.substring(aGame.indexOf(':') + 1).trim();
        for (String vSubGame : aGame.split(";"))
        {
            for (String vColor : vSubGame.split(","))
            {
                vColor = vColor.trim();
                int vValue = Integer.parseInt(vColor.substring(0, vColor.indexOf(' ')));
                if (vColor.indexOf("red") > -1)
                {
                    vRet.nbR = Math.max(vRet.nbR, vValue);
                }
                else if (vColor.indexOf("green") > -1)
                {
                    vRet.nbG = Math.max(vRet.nbG, vValue);
                }
                else if (vColor.indexOf("blue") > -1)
                {
                    vRet.nbB = Math.max(vRet.nbB, vValue);
                }
            }
        }
        return vRet;
    }

    public int findGames2(String aGames)
    {
        List<String> vGames = List.of(aGames.split("\n"));
        int vRet = vGames.stream().map(this::toGame).map(Game::computePower).reduce(0, (a, b) -> a + b);
        return vRet;
    }

}
