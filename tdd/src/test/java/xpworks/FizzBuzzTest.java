package xpworks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    @Test
    public void fizzBuzz_should_say_number_for_not_multiples_of_3_or_5() {
        assertEquals("1", FizzBuzz.say(1));
        assertEquals("2", FizzBuzz.say(2));
    }

    @Test
    public void fizzBuzz_should_say_Fizz_for_multiples_of_3() {
        assertEquals("Fizz", FizzBuzz.say(3));
        assertEquals("Fizz", FizzBuzz.say(6));
    }

    @Test
    public void fizzBuzz_should_say_Buzz_for_multiples_of_5() {
        assertEquals("Buzz", FizzBuzz.say(5));
        assertEquals("Buzz", FizzBuzz.say(10));
    }

    @Test
    public void fizzBuzz_should_say_Buzz_for_multiples_of_15() {
        assertEquals("FizzBuzz", FizzBuzz.say(15));
        assertEquals("FizzBuzz", FizzBuzz.say(30));
    }

}
