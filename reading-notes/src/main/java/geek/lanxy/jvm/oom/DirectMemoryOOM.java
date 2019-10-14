package geek.lanxy.jvm.oom;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

import sun.misc.Unsafe;

/**
 * @author: lanxinyu@xiaomi.com
 *
 * @create: 2019-09-08
 *
 *          直接内存溢出
 *
 *          DirectMemory容量可通过 -XX:MaxDirectMemorySize指定，如果不指定，则默认与Java堆最大值（-Xmx）一样。 通过反射获取Unsafe实例，进行内存分配。
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    @Test
    public void directMemorkOOM() throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
