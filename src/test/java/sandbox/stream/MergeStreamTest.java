package sandbox.stream;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dain on 2015-11-09.
 */
public class MergeStreamTest {

    private List<Integer> source;
    private List<Integer> target;

    @Before
    public void setUp() throws Exception {
        source = Lists.newArrayList(1, 2, 3, 4);
        target = Lists.newArrayList(5, 6, 7, 8, 9);
    }

    @Test
    public void simple_merge () {
        final int expectedListSize = source.size() + target.size();

        source.addAll(target);

        assertThat(source.size()).isEqualTo(expectedListSize);
        IntStream.range(1, 10).forEach(e -> assertThat(e).isEqualTo(source.get(e - 1)));
    }

    @Test
    public void simple_merge_with_stream () {
        final int expected = source.size() + target.size();
        final List<Integer> result = Stream.concat(source.stream(), target.stream())
                .collect(Collectors.toList());

        assertThat(result.size()).isEqualTo(expected);
        IntStream.range(1, 10).forEach(e -> assertThat(e).isEqualTo(result.get(e - 1)));
    }

    @Test
    public void three_stream_merge_with_stream_way_1 () {
        final List<Integer> three = Lists.newArrayList(10, 11, 12, 13, 14);
        final int expectedResultSize = source.size() + target.size() + three.size();

        final List<Integer> result = Stream.concat(Stream.concat(source.stream(), target.stream()), three.stream())
                .collect(Collectors.toList());

        assertThat(result.size()).isEqualTo(expectedResultSize);
        IntStream.range(1, 14).forEach(e -> assertThat(e).isEqualTo(result.get(e - 1)));
    }

    @Test
    public void three_stream_merge_with_stream_way_2 () {
        final List<Integer> three = Lists.newArrayList(10, 11, 12, 13, 14);
        final int expectedResultSize = source.size() + target.size() + three.size();

        final List<Integer> result = Optional.of(source.stream())
                .map(e -> Stream.concat(e, target.stream()))
                .map(e -> Stream.concat(e, three.stream()))
                .map(e -> e.collect(Collectors.toList()))
                .get();

        assertThat(result.size()).isEqualTo(expectedResultSize);
        IntStream.range(1, 14).forEach(e -> assertThat(e).isEqualTo(result.get(e - 1)));
    }

    @Test
    public void three_stream_merge_with_stream_way_3 () {
        final List<Integer> three = Lists.newArrayList(10, 11, 12, 13, 14);
        final int expectedResultSize = source.size() + target.size() + three.size();

        final List<Integer> result = Stream.of(source.stream(), target.stream(), three.stream())
                .flatMap(Function.identity())
                .collect(Collectors.toList());

        assertThat(result.size()).isEqualTo(expectedResultSize);
        IntStream.range(1, 14).forEach(e -> assertThat(e).isEqualTo(result.get(e - 1)));
    }
}