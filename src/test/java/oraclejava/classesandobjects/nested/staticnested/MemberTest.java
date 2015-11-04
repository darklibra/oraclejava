package oraclejava.classesandobjects.nested.staticnested;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Administrator on 2015-11-04.
 */
public class MemberTest {
    @Test
    public void nested_static_class_test () {
        String data = "Values#100";

        // Member member = new Member(); // error
        Member member = Member.MemberParser.parser(data);

        assertThat(member.toString()).isEqualTo(data);
        // assertThat(Member.MemberParser.toString(member)).isEqualTo(data); // error
    }
}
