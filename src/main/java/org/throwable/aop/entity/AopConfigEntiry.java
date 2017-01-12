package org.throwable.aop.entity;

/**
 * @author zhangjinci
 * @version 2017/1/12 14:52
 * @function
 */
public class AopConfigEntiry {

    private String className;

    private String methodName;

    private String interceptor;

    private boolean singleton;

    public AopConfigEntiry() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getInterceptor() {
        return interceptor;
    }

    public void setInterceptor(String interceptor) {
        this.interceptor = interceptor;
    }

    public boolean isSingleton() {
        return singleton;
    }

    public void setSingleton(boolean singleton) {
        this.singleton = singleton;
    }
}
