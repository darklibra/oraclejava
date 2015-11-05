package oraclejava.bit;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Administrator on 2015-11-05.
 */
public class BitTest {
    @Test
    public void bitwise_and() {
        int bitmask = 0x000F;
        int val = 0x2222;

        assertThat(val & bitmask).isEqualTo(2);
    }

    @Test
    public void bit_sift_to_right () {
        // 0000 0100 -> 0000 0010
        assertThat(4 >> 1).isEqualTo(2);

        // different '>>' and '>>>'

        //   11111111111111111111111111111100
        // > 11111111111111111111111111111110
        assertThat(-4 >> 1).isEqualTo(-2);

        //   11111111111111111111111111111100
        // > 01111111111111111111111111111110
        assertThat(-4 >>> 1).isEqualTo(2147483646);
    }

    @Test
    public void bit_sift_to_left () {
        // 0000 0100 -> 0000 1000
        assertThat(4 << 1).isEqualTo(8);
    }
}
