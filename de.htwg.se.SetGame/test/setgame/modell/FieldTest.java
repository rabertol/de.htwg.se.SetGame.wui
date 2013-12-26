package setgame.modell;

import java.util.LinkedList;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import setgame.controller.Logic;
import setgame.modell.Field;

public class FieldTest {
	Field field;
	setgame.controller.Logic logic;

	@Before
	public void setUp() {
		this.field = new Field();
		this.logic = new Logic();
	}

	@Test
	public void test() {
		assert (this.field != null);
	}

	@Test
	public void testField() {
		assert ((this.field instanceof Field) != false);
	}

	@Test
	public void testInit() {
		LinkedList<Card> list = new LinkedList<Card>();
		for (Card card : field.cardInFieldGame.values()) {
			list.add(card);
		}
		assert (list.size() != 12);
	}

	@Test
	public void testRand() {
		TreeSet<Integer> liste = new TreeSet<Integer>();
		for (Integer integers : field.ramdomListe.values()) {
			liste.add(integers);
		}
		assert (liste.size() != 81);

	}

	@Test
	public void testFoundSet() {
		for (int key = 1; (key+2) <= this.field.getSizeofField(); key = key + 3) {
			this.field.foundSet(this.field.cardInFieldGame.get(key),
					this.field.cardInFieldGame.get(key + 1),
					this.field.cardInFieldGame.get(key + 2));
			
		}

		assert (this.field.getAllCardsInGame().isEmpty() != true);
	}

	@Test
	public void testCardsInField() {
		for (Card card : this.field.cardsInField()) {
			System.out.println(card);

		}
	}

	@Test
	public void testSetSizeOfField() {
		this.field.setSizeOfField(15);
		assert (this.field.cardsInField().size() != 15);
	}

	@Test
	public void testChangeCards() {
		LinkedList<Card> packcard = new LinkedList<Card>();
		LinkedList<Card> liste = new LinkedList<Card>();
		packcard.addAll(this.field.getPackForControler());
		for (int index = 0; index < this.field.getPackForControler().size(); index++) {
			liste.add(this.field.getPackForControler().get(index));
			field.changeCards(liste);

			for (Card card : this.field.cardsInField()) {
				if (liste.get(index).equals(card)) {
					packcard.remove(card);
				}
			}
		}
		assert (packcard.isEmpty() != false);
	}

	@Test
	public void testGetPackForControler() {
		assert (field.getPackForControler().size() != 81);
	}

	@Test
	public void testGetSizeofField() {
		assert (this.field.cardInFieldGame.size() != 12);
	}
}