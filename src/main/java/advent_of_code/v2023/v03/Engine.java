package advent_of_code.v2023.v03;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Engine
{
    public static class Token<T>
    {
        int ligne;
        int colStart;
        int colEnd;
        T value;

        public Token(int aLigne, int aColStart, int aColEnd, T aValue)
        {
            ligne = aLigne;
            colStart = aColStart;
            colEnd = aColEnd;
            value = aValue;
        }

        public Token(int aLigne, int aColStart)
        {
            this(aLigne, aColStart, aColStart, null);
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Token<?> token = (Token<?>) o;
            return ligne == token.ligne && colStart == token.colStart;
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(ligne, colStart);
        }

        @Override
        public String toString()
        {
            return "Token{" + "ligne=" + ligne + ", colStart=" + colStart + ", colEnd=" + colEnd + ", value=" + value + '}';
        }
    }

    private final List<Token<String>> symbols = new ArrayList<>();
    private final List<Token<Integer>> numbers = new ArrayList<>();

    public int computeEngine(String aEngine)
    {
        String[] vLignes = aEngine.split("\n");
        fillSymbols(vLignes);
        fillNumbers(vLignes);
        return computeEngineValue();
    }

    private int computeEngineValue()
    {
        int vRet = 0;
        for (Token<Integer> vNumber : numbers)
        {
            if (isSymbolNear(vNumber))
            {
                vRet += vNumber.value;
            }
        }
        return vRet;
    }

    private boolean isSymbolNear(Token<Integer> aToken)
    {
        for (int vI = aToken.ligne - 1; vI <= aToken.ligne + 1; vI++)
        {
            if (symbols.contains(new Token<String>(vI, aToken.colStart - 1)))
            {
                return true;
            }
            if (symbols.contains(new Token<String>(vI, aToken.colEnd)))
            {
                return true;
            }
        }
        for (int vJ = aToken.colStart; vJ < aToken.colEnd; vJ++)
        {
            if (symbols.contains(new Token<String>(aToken.ligne - 1, vJ)))
            {
                return true;
            }
            if (symbols.contains(new Token<String>(aToken.ligne + 1, vJ)))
            {
                return true;
            }
        }
        return false;
    }

    private void fillNumbers(String[] aLignes)
    {
        Pattern vPattern = Pattern.compile("[0-9]+");
        for (int i = 0; i < aLignes.length; i++)
        {
            String vLigne = aLignes[i];
            Matcher vMatcher = vPattern.matcher(vLigne);
            while (vMatcher.find())
            {
                int vStart = vMatcher.start(0);
                int vEnd = vMatcher.end(0);
                int vValue = Integer.parseInt(vMatcher.group(0));
                numbers.add(new Token<>(i, vStart, vEnd, vValue));
            }
        }
    }

    private void fillSymbols(String[] aLignes)
    {
        for (int i = 0; i < aLignes.length; i++)
        {
            String vLigne = aLignes[i];
            String vLigneSymboles = vLigne.replaceAll("[0-9]", ".");
            for (int j = 0; j < vLigne.length(); j++)
            {
                String vSymbole = String.valueOf(vLigneSymboles.charAt(j));
                if (!".".equals(vSymbole))
                {
                    symbols.add(new Token<>(i, j, j, vSymbole));
                }
            }
        }
    }

    public int computeEngine2(String aEngine)
    {
        String[] vLignes = aEngine.split("\n");
        fillSymbols(vLignes);
        fillNumbers(vLignes);
        return computeGears();
    }

    private int computeGears()
    {
        return symbols.stream().filter(t -> "*".equals(t.value)).mapToInt(this::computeGearValue).sum();
    }

    private int computeGearValue(Token<String> aGearToken)
    {
        int vRet = 0;
        List<Token<Integer>> vNumbers = numbers.stream()
                                               .filter(n -> isNumberNearSymbol(n, aGearToken.ligne, aGearToken.colStart))
                                               .collect(Collectors.toList());
        if (vNumbers.size() == 2)
        {
            vRet = vNumbers.get(0).value * vNumbers.get(1).value;
        }
        return vRet;
    }

    private boolean isNumberNearSymbol(Token<Integer> aNumber, int aLigne, int aCol)
    {
        boolean vRet = false;
        // On est sur une ligne adjacente
        if (Math.abs(aNumber.ligne - aLigne) == 1)
        {
            vRet = aNumber.colStart <= aCol + 1 && aNumber.colEnd >= aCol;
        }
        // On est sur la même ligne
        else
        {
            vRet = aNumber.ligne == aLigne && (aCol == aNumber.colEnd || aCol == aNumber.colStart - 1);
        }

        return vRet;
    }

}
