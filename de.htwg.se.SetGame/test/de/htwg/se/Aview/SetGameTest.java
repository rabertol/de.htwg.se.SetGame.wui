package de.htwg.se.Aview;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SetGameTest {
	SetGame set;
	@Before
	public void setUp(){
		this.set = new SetGame();
	}
	@Test
	public void test() {
		assert(this.set == null);
	}

}
