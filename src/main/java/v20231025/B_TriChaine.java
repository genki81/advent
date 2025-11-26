package v20231025;

import java.util.stream.Collector;

public class B_TriChaine
{
    public String trie(String aChaine)
    {
        return aChaine.chars()
                      .mapToObj(c -> (char) c)
                      .sorted()
                      .collect(Collector.of(StringBuilder::new, StringBuilder::append, StringBuilder::append, StringBuilder::toString));
    }
}
