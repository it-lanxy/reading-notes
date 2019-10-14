package geek.lanxy.jvm.gc;

/**
 * @author: lanxinyu@xiaomi.com
 *
 * @create: 2019-09-04
 */

import org.junit.jupiter.api.Test;

/**
 * 引用计数法的缺陷：循环引用
 */
public class ReferenceCountingGC_3_2_1 {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    /**
     * 这个成员的唯一意义是占点内存，以便在GC日志中看清楚是否被回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    @Test
    public void testGC() {
        ReferenceCountingGC_3_2_1 objA = new ReferenceCountingGC_3_2_1();
        ReferenceCountingGC_3_2_1 objB = new ReferenceCountingGC_3_2_1();

        objA.instance = objB;
        objB.instance = objA;

        // 假设在这行发生GC，objA和objB能否被回收？
        System.gc();
    }
}
