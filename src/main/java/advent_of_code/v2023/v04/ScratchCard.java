package advent_of_code.v2023.v04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ScratchCard
{
    private final Pattern pattern = Pattern.compile("^[A-Za-z]+[ ]+([0-9]+)[ ]*:[ ]*(([0-9]+[ ]*)+)[|][ ]*(([0-9]+[ ]*)+)$");

    public static class Game
    {
        public int id;
        public Set<Integer> winning = new HashSet<>();
        public Set<Integer> numbers = new HashSet<>();
        public int nbWin;
    }

    public int computeCards(String aCards)
    {
        return Arrays.stream(aCards.split("\n")).map(this::toGame).mapToInt(this::computeCard).sum();
    }

    private int computeCard(Game aGame)
    {
        aGame.winning.retainAll(aGame.numbers);

        if (aGame.winning.isEmpty())
        {
            return 0;
        }
        return (int) Math.pow(2, aGame.winning.size() - 1);
    }

    private Game toGame(String aChaine)
    {
        Game vRet = new Game();

        Matcher vMatcher = pattern.matcher(aChaine);

        if(vMatcher.matches()){
            vRet.id = Integer.parseInt(vMatcher.group(1));

            String vWinning = vMatcher.group(2);
            String vNumbers = vMatcher.group(4);

            Arrays.stream(vWinning.trim().split("[ ]+")).mapToInt(Integer::parseInt).forEach(i -> vRet.winning.add(i));
            Arrays.stream(vNumbers.trim().split("[ ]+")).mapToInt(Integer::parseInt).forEach(i -> vRet.numbers.add(i));
        }

        return vRet;
    }

    public int countCards2(String aCards)
    {
        List<Game> vGames = Arrays.stream(aCards.split("\n")).map(this::toGame).collect(Collectors.toList());

        return 0;
    }
}
