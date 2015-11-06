package oraclejava.classesandobjects.initializing;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by dain on 2015-11-06.
 */
public class BlockInitTest {
    /*
    * 현 테스트는 다음 경우를 가정으로 작성되었다.
    *  - 한 메소드 테스트가 끝나면 클래스가 가지고 있는 static 변수도 초기화 된다.
    *   : 이는 각 테스트 마다 다른 환경이 클래스에 부여됨을 의미한다.
    * */
    @Test
    public void 객체_생성_없는_상태_테스트 () {
        assertThat(BlockInit.getCountOfStaticBlockCall()).isEqualTo(1);
        assertThat(BlockInit.getCountOfBlockCall()).isEqualTo(0);
    }

    @Test
    public void 객체생성시_상태변환_테스트 () {
        new BlockInit();

        assertThat(BlockInit.getCountOfStaticBlockCall()).isEqualTo(1);
        assertThat(BlockInit.getCountOfBlockCall()).isEqualTo(1);

        new BlockInit();

        assertThat(BlockInit.getCountOfStaticBlockCall()).isEqualTo(1);
        assertThat(BlockInit.getCountOfBlockCall()).isEqualTo(2);
    }

    @Test
    public void 객체생성시_상태변환_테스트2 () {
        new BlockInit();

        assertThat(BlockInit.getCountOfStaticBlockCall()).isEqualTo(1);
        assertThat(BlockInit.getCountOfBlockCall()).isEqualTo(1);

        new BlockInit();

        assertThat(BlockInit.getCountOfStaticBlockCall()).isEqualTo(1);
        assertThat(BlockInit.getCountOfBlockCall()).isEqualTo(2);
    }
}