import javax.swing.text.PlainDocument;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DeckOfCards
{

    private List<PlayingCard> deck = new ArrayList<>();
    private Set<PlayingCard> hand;

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

    public Set<PlayingCard> dealHand(int cards)
    {
        boolean finished = false;
        Random r = new Random();
        hand = new LinkedHashSet<PlayingCard>();
        while(!finished)
        {
            hand.add(deck.get(r.nextInt(deck.size())));

            if(hand.size() == cards)
            {
                if(deck.containsAll(hand))
                {
                    deck.removeAll(hand);
                }

                finished = true;
            }
        }
        return hand;
    }

    public List<PlayingCard> getDeck()
    {
        return deck;
    }

    public void returnCardsToDeck()
    {
        if(deck.size() != 52)
        {
            deck.addAll(hand);
            hand.removeAll(hand);
        }
    }

}
