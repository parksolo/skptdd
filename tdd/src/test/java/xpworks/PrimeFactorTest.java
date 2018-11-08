package xpworks;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PrimeFactorTest {
    @Test
    public void primeFactorOf2() {
        assertEquals(Arrays.asList(2), PrimeFactors.of(2));
    }

    @Test
    public void primeFactorOf3() {
        assertEquals(Arrays.asList(3), PrimeFactors.of(3));
    }

    @Test
    public void primeFactorOf4() {
        assertEquals(Arrays.asList(2,2), PrimeFactors.of(4));
    }

    @Test
    public void primeFactorOf6() {
        assertEquals(Arrays.asList(2,3), PrimeFactors.of(6));
    }

    @Test
    public void primeFactorOf9() {
        assertEquals(Arrays.asList(3,3), PrimeFactors.of(9));
    }

    @Test
    public void primeFactorOf10() {
        assertEquals(Arrays.asList(2,5), PrimeFactors.of(10));
    }

    @Test
    public void primeFactorOfBigNumber() {
        assertEquals(Arrays.asList(2,2,3,3,5,5,7,11,13), PrimeFactors.of(2*2*3*3*5*5*7*11*13));
    }
}
