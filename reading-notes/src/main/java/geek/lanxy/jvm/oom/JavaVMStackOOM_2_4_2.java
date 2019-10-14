package geek.lanxy.jvm.oom;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Test;

/**
 * @author: lanxinyu@xiaomi.com
 *
 * @create: 2019-09-04
 *
 *          本地方法栈内存溢出测试
 *
 * @describe: -Xss128k -Xms20m -Xmx20m
 *
 *            如果是建立过多线程导致的内存溢出，在不能减少或者更换64位虚拟机的情况下，就只能通过减少最大堆和减少栈容量来获取更多的线程
 */
public class JavaVMStackOOM_2_4_2 {

    private AtomicInteger threadCount = new AtomicInteger(0);

    private void notStop() throws InterruptedException {
        threadCount.incrementAndGet();
        synchronized (Thread.currentThread()) {
            Thread.currentThread().wait();
        }

    }

    @Test
    public void stackLeakByThread() {
        try {
            while (true) {
                new Thread(() -> {
                    try {
                        notStop();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (Throwable e) {
            System.out.println(threadCount.get());
            // Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
            throw e;
        }

    }
}
