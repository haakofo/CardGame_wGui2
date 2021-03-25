import javax.swing.text.PlainDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DeckOfCards
{

    private List<PlayingCard> deck = new ArrayList<>();

    public DeckOfCards()
    {
        final char[] suits = { 'S', 'H', 'D', 'C' };
        for(int suit = 0; suit < 4;suit++)
        {
            for(int face = 1; face <= 13; face++)
            {
                deck.add(new PlayingCard(suits[suit],face));
            }
        }

        shuffle();
    }

    private void shuffle()
    {
        deck.stream()
                .collect(Collectors.toList());
        Collections.shuffle(deck);
    }
}
