package oraclejava.classesandobjects.initializing;

/**
 * Created by Administrator on 2015-11-06.
 */
public class BlockInit {
    private static int countOfStaticBlockCall = 0;
    private static int countOfBlockCall = 0;

    static {
        ++countOfStaticBlockCall;
    }

    {
        ++countOfBlockCall;
    }

    public static int getCountOfStaticBlockCall() {
        return countOfStaticBlockCall;
    }

    public static int getCountOfBlockCall() {
        return countOfBlockCall;
    }
}
