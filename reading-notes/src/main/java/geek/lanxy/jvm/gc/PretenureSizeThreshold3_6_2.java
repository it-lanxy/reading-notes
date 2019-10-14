package geek.lanxy.jvm.gc;

/**
 * @author: lanxinyu@xiaomi.com
 *
 * @create: 2019-09-08
 */
public class PretenureSizeThreshold3_6_2 {
    private static final int _1MB = 1024 * 1024;

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseSerialGC
     * -XX:PretenureSizeThreshold=3145728
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(_1MB * 4);
        byte[] allocation = new byte[4 * _1MB];
    }
}
