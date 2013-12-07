package setgame.modell;

import setgame.modell.Card.Cards;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	Card card;
	Cards[] list;

	@Before
	public void setUp() throws Exception {
		this.card = new Card();
		this.list = card.getCards();

	}

	@Test
	public void testCard() {
		boolean b = false;
		for (Cards c : list) {
			for (Cards cards : list) {
				if (c.getColor().equals(cards.getColor())
						|| c.getFomr().equals(cards.getFomr())
						|| c.getPanelFilling().equals(cards.getPanelFilling())
						|| c.getNumberOfComponents() == cards.getNumberOfComponents( ) ) {

					b = true;
				} else if(c.getColor().equals(null)
						|| c.getFomr().equals(null)
						|| c.getPanelFilling().equals(null)
						|| c.getNumberOfComponents() == -1) {
					b = false;
				}
			}
		}

		if (!b)
			fail("not good :(");
	}

	@Test
	public void testGetCards() {
		if (!(this.list instanceof Cards[]))
			fail("not a instance of");

	}

}
