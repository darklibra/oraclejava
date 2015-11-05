package oraclejava.statements;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Administrator on 2015-11-05.
 */
public class ContinueStatementTest {
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
    public void 컨티뉴_포함된_for문() {
        int sum = 100;

        for (int i = 0; i < 10;++i) {
            for (int j = 0; j < 10; ++j) {
                if (j % 2 == 0) continue;
                sum += ((i * 10) + j);
            }
        }
        assertThat(sum).isEqualTo(2600);
    }

    @Test
    public void 라벨_컨티뉴_포함된_for문() {
        int sum = 100;

        root:
        for (int i = 0; i < 10;++i) {
            for (int j = 0; j < 10; ++j) {
                if (j % 2 == 1) continue root;
                sum += ((i * 10) + j);
            }
        }
        assertThat(sum).isEqualTo(550);
    }
}