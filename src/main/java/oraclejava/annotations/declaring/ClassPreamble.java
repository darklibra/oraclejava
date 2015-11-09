package oraclejava.annotations.declaring;

import java.lang.annotation.Documented;

/**
 * Created by dain on 2015-11-07.
 */
@Documented
public @interface ClassPreamble {
    String author();
    String date();
    int currentRevision() default 1;
    String lastModified() default "N/A";
    String lastModifiedBy() default "N/A";
    // Note use of array
    String[] reviewers();
}
