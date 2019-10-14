package geek.lanxy.jvm.oom;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author: lanxinyu@xiaomi.com
 *
 * @create: 2019-09-08
 *
 *          借助CGLib使方法区内存溢出异常
 *
 *          方法区存放Class的相关信息：类名、访问修饰符、常量池、字段描述、方法描述。
 */
public class JavaMethoddAreaOOM {
    @Test
    public void methodArea() {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
                    throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });
        }

    }

    static class OOMObject {

    }
}
