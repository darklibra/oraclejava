package oraclejava.statements;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Administrator on 2015-11-05.
 */
public class BreakStatementTest {
    @Test
    public void 단순_for문() {
        int sum = 100;

        for (int i = 0; i < 10;++i) {
            for (int j = 0; j < 10; ++j) {
                sum += ((i * 10) + j);
            }
        }

        assertThat(sum).isEqualTo(5050);
    }

    @Test
    public void 브레이크_포함된_for문() {
        int sum = 100;

        for (int i = 0; i < 10;++i) {
            for (int j = 0; j < 10; ++j) {
                if (j == 5) break;
                sum += ((i * 10) + j);
            }
        }
        assertThat(sum).isEqualTo(2450);
    }

    @Test
    public void 라벨_브레이크_포함된_for문() {
        int sum = 100;

        root:
        for (int i = 0; i < 10;++i) {
            for (int j = 0; j < 10; ++j) {
                if (j == 5) break root;
                sum += ((i * 10) + j);
            }
        }
        assertThat(sum).isEqualTo(110);
    }
}
