package org.throwable.aop.interceptor;


import org.nutz.aop.interceptor.AbstractMethodInterceptor;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author zhangjinci
 * @version 2017/1/12 11:52
 * @function
 */
public class AbstractLogExInterceptor extends AbstractMethodInterceptor {

    private static final Log log = Logs.get();

    @Override
    public boolean beforeInvoke(Object obj, Method method, Object... args) {
        log.debug("before invoke ... " + Arrays.toString(args));
        return true;
    }

    @Override
    public Object afterInvoke(Object obj, Object returnObj, Method method, Object... args) {
        log.debug("after invoke ... " + Arrays.toString(args));
        return returnObj;
    }

    @Override
    public boolean whenException(Exception e, Object obj, Method method, Object... args) {
        return super.whenException(e, obj, method, args);
    }

    @Override
    public boolean whenError(Throwable e, Object obj, Method method, Object... args) {
        return super.whenError(e, obj, method, args);
    }
}
