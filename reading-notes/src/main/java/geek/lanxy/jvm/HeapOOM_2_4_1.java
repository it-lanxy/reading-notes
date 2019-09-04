package geek.lanxy.jvm;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * @author: lanxinyu@xiaomi.com
 *
 * @create: 2019-09-04
 *
 * @describe: VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *            -XX:HeapDumpPath=/Users/it_lanxy/JavaSpace/Lanxy/reading-notes/reading-notes/src/main/java/geek/lanxy/jvm/HeapOOM_2_4_1.hprof
 *
 *            hprof 可用jhat 查看
 */
public class HeapOOM_2_4_1 {

    static class OOMObject {

    }

    @Test
    public void heapOOM() {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
