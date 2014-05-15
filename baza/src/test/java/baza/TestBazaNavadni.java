package baza;

import static org.junit.Assert.*;

import java.io.Console;

import org.junit.Test;

public class TestBazaNavadni {

	@Test
	public void test() {
		String test = NavadnaBaza.instance.get();
		System.out.print(test);
	}

}
