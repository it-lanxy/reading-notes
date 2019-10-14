package geek.lanxy.jvm.oom;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * @author: lanxinyu@xiaomi.com
 *
 * @create: 2019-09-08
 *
 *          运行时常量池导致的内存溢出异常
 *
 *          可通过 -XX:PermSize 和 -XX:MaxPermSize 限制方法区大小
 */
public class RuntimeConstantPoolOOM_2_4_2 {

    @Test
    public void constantPoolOOM() {
        // 使用list保持着常量池引用，避免Full GC回收常量池行为
        List<String> list = new ArrayList<>();
        // 10MB的 PermSize 在 Integer 范围内足够产生OOM了
        int i = 0;
        while (true) {
            // String.intern是一个native()方法，作用是：如果字符串常量池中已经包含一个等于此对象的字符串，则返回代表池中这个字符串的String对象；否则，将此String对象包含的字符串添加到常量池中，并且返回此String对象的引用。
            list.add(String.valueOf(i++).intern());
        }
    }

    @Test
    public void stringIntern() {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

    public static void main(String[] args) {
        new RuntimeConstantPoolOOM_2_4_2().stringIntern();
    }
}
