package org.throwable.aop.interceptor;

import org.nutz.aop.InterceptorChain;
import org.nutz.aop.MethodInterceptor;
import org.nutz.log.Log;
import org.nutz.log.Logs;

/**
 * @author zhangjinci
 * @version 2017/1/12 11:52
 * @function
 */
public class OriginSystemLogInterceptor implements MethodInterceptor {

    private static final Log log = Logs.get();

    @Override
    public void filter(InterceptorChain chain) throws Throwable {
        log.debug("hi");
        chain.doChain();
        log.debug("bye");
    }
}
