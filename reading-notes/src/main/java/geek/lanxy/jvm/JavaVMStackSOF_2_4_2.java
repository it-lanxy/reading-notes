package geek.lanxy.jvm;

import org.junit.jupiter.api.Test;

/**
 * @author: lanxinyu@xiaomi.com
 *
 * @create: 2019-09-04
 *
 * @describe: -Xss128k
 */
public class JavaVMStackSOF_2_4_2 {

    private int stackLength = 1;

    @Test
    public void stackLeak() throws Throwable {
        stackLength++;
        try {
            stackLeak();
        } catch (Throwable e) {
            System.out.println(stackLength);
            throw e;
        }
    }
}
