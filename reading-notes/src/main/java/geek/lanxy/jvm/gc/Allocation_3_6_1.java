package geek.lanxy.jvm.gc;

/**
 * @author: lanxinyu@xiaomi.com
 *
 * @create: 2019-09-08
 */
public class Allocation_3_6_1 {

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
     *
     * 练习题：根据GC日志进行内存分配分析。
     */
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation0, allocation1, allocation2, allocation3;
        allocation0 = new byte[2 * _1MB];
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[4 * _1MB];
    }
}
