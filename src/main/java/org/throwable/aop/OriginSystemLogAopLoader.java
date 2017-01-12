package org.throwable.aop;

import org.nutz.aop.MethodInterceptor;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.aop.SimpleAopMaker;
import org.throwable.aop.anno.SystemLog;
import org.throwable.aop.interceptor.OriginSystemLogInterceptor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangjinci
 * @version 2017/1/12 11:50
 * @function
 */
public class OriginSystemLogAopLoader extends SimpleAopMaker<SystemLog> {

    @Override
    public List<? extends MethodInterceptor> makeIt(SystemLog systemLog, Method method, Ioc ioc) {
       return Arrays.asList(new OriginSystemLogInterceptor());
    }
}
