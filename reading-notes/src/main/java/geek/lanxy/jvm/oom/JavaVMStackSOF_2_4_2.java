package geek.lanxy.jvm.oom;

import org.junit.jupiter.api.Test;

/**
 * @author: lanxinyu@xiaomi.com
 *
 * @create: 2019-09-04
 *
 *          虚拟机栈SOF测试
 *
 * @describe: 实验数据：-Xss200k stackLength = 1027
 *
 *            -Xss800k stackLength = 17746
 *
 *            如果是建立过多线程导致的内存溢出，在不能减少或者更换64位虚拟机的情况下，就只能通过减少最大堆和`减少栈容量`来获取更多的线程
 */
public class JavaVMStackSOF_2_4_2 {

    private int stackLength = 1;

    @Test
    public void stackLeak() {
        stackLength++;
        try {
            stackLeak();
        } catch (Throwable e) {
            System.out.println(stackLength);
            throw e;
        }
    }
}
