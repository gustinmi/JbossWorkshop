package database;

import static org.junit.Assert.*;

import java.io.Console;

import org.junit.Test;

public class TestDriverManagerDatabase {

	@Test
	public void test() {
		String test = DriverManagerDatabase.instance.get();
		assertTrue(test!=null);
		System.out.print(test);
	}

}
