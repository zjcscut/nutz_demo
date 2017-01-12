package org.throwable.aop;

import org.nutz.aop.MethodInterceptor;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.aop.SimpleAopMaker;
import org.throwable.aop.anno.LogEx;
import org.throwable.aop.interceptor.AbstractLogExInterceptor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjinci
 * @version 2017/1/12 11:50
 * @function
 */
public class AbstractLogAopLoader extends SimpleAopMaker<LogEx> {

    @Override
    public List<? extends MethodInterceptor> makeIt(LogEx systemLog, Method method, Ioc ioc) {
       return Arrays.asList(new AbstractLogExInterceptor());
    }
}
