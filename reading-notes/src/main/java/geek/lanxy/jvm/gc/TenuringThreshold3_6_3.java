package geek.lanxy.jvm.gc;

/**
 * @author: lanxinyu@xiaomi.com
 *
 * @create: 2019-09-08
 */
public class TenuringThreshold3_6_3 {

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
     * -XX:MaxTenuringThreshold=1
     *
     * 10M给老年代，10M新生代。survivorRatio=8，Eden和Survivor比例是8：1 Eden 8M 练习题：根据GC日志进行内存分配分析。
     */
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation0, allocation1, allocation2, allocation3;
        allocation0 = new byte[_1MB / 4];
        // 什么时候进入老年代取决于 XX:MaxTenuringThreshold设置
        allocation1 = new byte[4 * _1MB];
        // Eden 8M，此时已使用 256kb + 4096kb 5702 - 4096 = 1606kb
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
    }
}
