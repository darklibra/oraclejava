package sandbox.stream;

import com.google.common.collect.Lists;
import lombok.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by dain on 2015-11-09.
 * <p>
 * ref :
 * http://www.leveluplunch.com/java/examples/java-util-stream-groupingBy-example/
 * http://stackoverflow.com/questions/25441088/group-by-counting-in-java8-stream-api
 */
public class GroupByListToMapTest {

    private List<SourceItem> source;
    private List<SourceItem> expect_grouped_1;
    private List<SourceItem> expect_grouped_2;

    @Before
    public void setUp() throws Exception {
        expect_grouped_1 = Lists.newArrayList(new SourceItem(1, "D1"), new SourceItem(1, "D2"), new SourceItem(1, "D3"));
        expect_grouped_2 = Lists.newArrayList(new SourceItem(2, "D4"));

        source = Stream.concat(expect_grouped_1.stream(), expect_grouped_2.stream()).collect(Collectors.toList());
    }

    @Test
    public void group_by_divider() {
        final BiFunction<List<SourceItem>, List<SourceItem>, Boolean> tester = (l, r) -> (l.size() == r.size()) && l.containsAll(r);

        final Map<Integer, List<SourceItem>> grouped = source.stream()
                .collect(Collectors.groupingBy(SourceItem::getDivider));

        assertThat(tester.apply(expect_grouped_1, grouped.get(1))).isTrue();
        assertThat(tester.apply(expect_grouped_2, grouped.get(2))).isTrue();
    }

    @Test
    public void group_by_identity() {
        final int expect_size = 1;
        final Map<SourceItem, List<SourceItem>> grouped = source.stream()
                .collect(Collectors.groupingBy(Function.identity()));

        grouped.keySet().stream()
                .forEach(e -> assertThat(grouped.get(e).size()).isEqualTo(expect_size));
    }

    @Test
    public void group_by_identity_with_counting() {
        final int expect_size = 1;
        final Map<SourceItem, Long> grouped = source.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        grouped.keySet().stream()
                .forEach(e -> assertThat(grouped.get(e)).isEqualTo(expect_size));
    }

    @Test
    public void group_by_identity_with_ignoring_rest_items() {
        final Map<SourceItem, String> grouped = source.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.reducing("", e -> e.getIdentifier(), (l, r) -> r)));

        source.stream()
                .forEach(e -> assertThat(grouped.get(e)).isEqualTo(e.getIdentifier()));
    }

    @Test
    public void group_by_divider_with_joining_identifier() {
        final Function<List<SourceItem>, String> joining = e -> e.stream().map(SourceItem::getIdentifier).collect(Collectors.joining());

        final Map<Integer, String> grouped = source.stream()
                .collect(Collectors.groupingBy(SourceItem::getDivider, Collectors.reducing("", e -> e.getIdentifier(), (l, r) -> l + r)));

        assertThat(grouped.get(1)).isEqualTo(joining.apply(expect_grouped_1));
        assertThat(grouped.get(2)).isEqualTo(joining.apply(expect_grouped_2));
    }

    @Data @ToString @EqualsAndHashCode(of = {"identifier"})
    @AllArgsConstructor
    private static class SourceItem {
        Integer divider;
        String identifier;
    }
}