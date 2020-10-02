package edu.umb.cs680.hw01;

import static org.junit.Assert.assertArrayEquals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PrimeGeneratorTest {

	// testing constructor
	@Test
	public void test_constructor_PrimeGenerator_from_21_to_31() {
		PrimeGenerator pg = new PrimeGenerator(21L, 31L);
		pg.generatePrimes();

		Long[] expected_value = { 23L, 29L, 31L };
		Object[] actual_value = pg.getPrimes().toArray();

		long from = 21L;
		long to = 31L;
		long actual_range = pg.to - pg.from;
		long expected_range = to - from;

		// checking if pg is an instance of PrimeGenerator
		assertTrue(pg instanceof PrimeGenerator);
		// checking if the range is the same.
		assertEquals(actual_range, expected_range);
		// object is not null
		assertNotNull(pg);
		// must match the expected values of prime number with the number of prime in pg
		// object
		assertArrayEquals(expected_value, actual_value);
	}

	// testing constructor
	@Test
	public void test_constructor_PrimeGenerator_from_47_to_80() {
		PrimeGenerator pg = new PrimeGenerator(47L, 80L);
		pg.generatePrimes();

		Long[] expected_value = { 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L };
		Object[] actual_value = pg.getPrimes().toArray();

		long from = 47L;
		long to = 80L;
		long actual_range = pg.to - pg.from;
		long expected_range = to - from;

		// checking if pg is an instance of PrimeGenerator
		assertTrue(pg instanceof PrimeGenerator);
		// checking if the range is the same.
		assertEquals(actual_range, expected_range);
		// object is not null
		assertNotNull(pg);
		// must match the expected values of prime number with the number of prime in pg
		// object
		assertArrayEquals(expected_value, actual_value);
	}

	// testing constructor with wrong inputs
	@Test
	public void test_constructor_PrimeGenerator_from_100_to_2() {

		try {
			PrimeGenerator pg = new PrimeGenerator(100, 2);
		} catch (RuntimeException ex) {
			assertEquals(ex.getMessage(), "Wrong input values: from=100 to=2");
		}
	}

	// testing constructor with wrong inputs
	@Test
	public void test_constructor_PrimeGenerator_from_negative_1_to_100() {

		try {
			PrimeGenerator pg = new PrimeGenerator(-2, 100);
		} catch (RuntimeException ex) {
			assertEquals(ex.getMessage(), "Wrong input values: from=-2 to=100");
		}
	}

	// testing constructor with wrong inputs
	@Test()
	public void test_constructor_PrimeGenerator_from_negative_2_to_negative_100() {

		try {
			PrimeGenerator pg = new PrimeGenerator(-2, -100);
		} catch (RuntimeException ex) {
			assertEquals(ex.getMessage(), "Wrong input values: from=-2 to=-100");
		}
	}

	// testing getPrimes
	@Test
	public void test_getPrimes_method_generated_from_1_to_10() {
		// create PrimeGenerator object
		PrimeGenerator pg = new PrimeGenerator(1, 10);
		pg.generatePrimes();

		// prime number should be 2,3,5,7
		Long[] expected_list_of_primes = { 2L, 3L, 5L, 7L };

		Object[] actual_list_of_primes = pg.getPrimes().toArray();
		// checking whether pg is null
		assertNotNull(pg);
		assertArrayEquals(expected_list_of_primes, actual_list_of_primes);

	}

	// another testing getPrimes
	@Test
	public void test_getPrimes_method_generated_from_1_to_100() {
		// create Prime
		PrimeGenerator pg = new PrimeGenerator(1, 100);
		pg.generatePrimes();

		Long[] expected_list_of_primes = { 2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L, 41L, 43L, 47L, 53L,
				59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L };

		Object[] actual_list_of_primes = pg.getPrimes().toArray();
		assertArrayEquals(expected_list_of_primes, actual_list_of_primes);

	}

	// another testing getPrimes
	@Test
	public void test_getPrimes_method_generated_from_22_to_41() {
		// create Prime
		PrimeGenerator pg = new PrimeGenerator(22, 41);
		pg.generatePrimes();

		Long[] expected_list_of_primes = { 23L, 29L, 31L, 37L, 41L };

		Object[] actual_list_of_primes = pg.getPrimes().toArray();
		assertArrayEquals(expected_list_of_primes, actual_list_of_primes);

	}

	// testing isEven method
	@Test
	public void checking_1_is_even() {
		boolean expected_result = false;
		// must create a dummy instance of PrimeGerator generated prime number from 1-2
		boolean actual_result = (boolean) ((new PrimeGenerator(1, 2)).isEven(1L));
		assertEquals(expected_result, actual_result);
		// or we can do the assertFalse
		assertFalse(actual_result);
	}

	// another testing isEven method
	@Test
	public void checking_100_is_even() {
		boolean expected_result = true;
		// must create a dummy instance variable of PrimeGerator class generating from
		// 1-10 Prime numbers
		boolean actual_result = (boolean) ((new PrimeGenerator(1, 2)).isEven(100L));
		assertEquals(expected_result, actual_result);
		// or we can do the assertTrue
		assertTrue(actual_result);
	}

	// testing isEven method
	@Test
	public void checking_97_is_even() {
		boolean expected_result = false;
		// must create a dummy instance of PrimeGerator generated prime number from 1-2
		boolean actual_result = (boolean) ((new PrimeGenerator(1, 2)).isEven(97L));
		assertEquals(expected_result, actual_result);
		// or we can do the assertFalse
		assertFalse(actual_result);
	}

	// checking isPrime function
	@Test
	public void is_5_prime() {
		long target = 5L;
		// create an dummy instance variable of PrimeGenerator.
		// final means fixed and not change.
		final PrimeGenerator pg = new PrimeGenerator(1L, 10L);
		boolean expected_result = true;
		boolean actual_result = pg.isPrime(target);
		assertEquals(expected_result, actual_result);

	}

	@Test
	public void is_0_prime() {
		// create an dummy instance variable of PrimeGenerator.
		long target = 0L;
		final PrimeGenerator pg = new PrimeGenerator(1L, 10L);
		boolean expected_result = false;
		boolean actual_result = pg.isPrime(target);

		assertEquals(expected_result, actual_result);
	}

	@Test
	public void is_11_prime() {
		long target = 11L;
		// create an dummy instance variable of PrimeGenerator.
		final PrimeGenerator pg = new PrimeGenerator(1L, 10L);
		boolean expected_result = true;
		boolean actual_result = pg.isPrime(target);

		assertEquals(expected_result, actual_result);
	}

	@Test
	public void is_97_prime() {
		long target = 97L;
		// create an dummy instance variable of PrimeGenerator.
		final PrimeGenerator pg = new PrimeGenerator(1L, 10L);
		boolean expected_result = true;
		boolean actual_result = pg.isPrime(target);

		assertEquals(expected_result, actual_result);
	}

	@Test
	public void is_1_prime() {
		// create an dummy instance variable of PrimeGenerator.
		long target = 1L;
		final PrimeGenerator pg = new PrimeGenerator(1L, 10L);
		boolean expected_result = false;
		boolean actual_result = pg.isPrime(target);

		assertEquals(expected_result, actual_result);

	}

	@Test
	public void is_negative_5_prime() {
		// create an dummy instance variable of PrimeGenerator.
		long target = -5L;
		final PrimeGenerator pg = new PrimeGenerator(1L, 10L);
		boolean expected_result = false;
		boolean actual_result = false;

		try {
			actual_result = pg.isPrime(target);
		} catch (IllegalArgumentException ex) {
			assertEquals(expected_result, actual_result);
		}
	}

	// checking generate method()
	@Test
	public void are_2_5_7_11_13_prime_numbers_from_1_to_15() {
		// create Prime
		PrimeGenerator pg = new PrimeGenerator(1, 15);

		pg.generatePrimes();

		Long[] expected_list_of_primes = { 2L, 3L, 5L, 7L, 11L, 13L };

		Object[] actual_list_of_primes = pg.getPrimes().toArray();
		assertArrayEquals(expected_list_of_primes, actual_list_of_primes);
	}

	// checking generate method()
	@Test
	public void are_47_53_59_61_prime_numbers_from_46_to_61() {
		// create Prime
		PrimeGenerator pg = new PrimeGenerator(46, 61);

		pg.generatePrimes();

		Long[] expected_list_of_primes = { 47L, 53L, 59L, 61L };

		Object[] actual_list_of_primes = pg.getPrimes().toArray();
		assertArrayEquals(expected_list_of_primes, actual_list_of_primes);
	}

	// checking generate method()
	@Test
	public void are_2_5_7_11_13_19_prime_numbers_from_1_to_15() {
		// create Prime
		PrimeGenerator pg = new PrimeGenerator(1L, 15L);

		pg.generatePrimes();

		Long[] expected_list_of_primes = { 2L, 3L, 5L, 7L, 11L, 13L, 19L };

		Object[] actual_list_of_primes = pg.getPrimes().toArray();

		// not equal the number of prime numbers between expected and actual result
		assertNotEquals(expected_list_of_primes.length, actual_list_of_primes.length);
	}

}
