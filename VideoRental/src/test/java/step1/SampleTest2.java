package step1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

public class SampleTest2 {

    @Test
    public void test() {
        IntStream y = range(1, 9);
        y.forEach( System.out::println );

        IntStream z = IntStream.range(100,103);
        z.forEach( x -> System.out.println(x) );
    }

}
