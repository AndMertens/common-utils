package be.bornput.lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static be.bornput.lists.LoopUtil.withCounter;
import static org.assertj.core.api.Assertions.*;

class LoopUtilTest {

    List<String> actualListOfMovies;
    List<String> expectedListOfOutputs;
    List<String> actualListOfOutputs;

    @BeforeEach
    void setUp() {
        actualListOfMovies = Arrays.asList("Mother in law", "Braveheart", "Modulus");
        expectedListOfOutputs = Arrays.asList("Movie 0 : Mother in law","Movie 1 : Braveheart","Movie 2 : Modulus");
        expectedListOfOutputs = new ArrayList<>();
        actualListOfOutputs = new ArrayList<>();
    }

    @Test
    public void testForEachWithCounter(){

        LoopUtil.forEachWithCounter(
                actualListOfMovies,
                (index, movie) -> actualListOfOutputs.add("Movie " + index + " : " + movie)
                );
        assertThat(actualListOfOutputs.get(0)).isEqualTo(expectedListOfOutputs.get(0));
        assertThat(actualListOfOutputs.get(1)).isEqualTo(expectedListOfOutputs.get(1));
        assertThat(actualListOfOutputs.get(2)).isEqualTo(expectedListOfOutputs.get(2));
    }

    @Test
    public void testWithCounter(){

        actualListOfMovies.forEach(withCounter((index,movie) -> actualListOfOutputs.add("Movie " + index + " : " + movie)));
        assertThat(actualListOfOutputs.get(0)).isEqualTo(expectedListOfOutputs.get(0));
        assertThat(actualListOfOutputs.get(1)).isEqualTo(expectedListOfOutputs.get(1));
        assertThat(actualListOfOutputs.get(2)).isEqualTo(expectedListOfOutputs.get(2));
    }

}