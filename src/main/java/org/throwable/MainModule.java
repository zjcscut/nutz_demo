package org.throwable;


import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

@IocBy(type = ComboIocProvider.class, args = {"*js", "conf/ioc/",
        "*anno", "org.throwable",
        "*tx", // 事务拦截 aop
        "*async", // 异步执行aop
        "*org.throwable.aop.OriginSystemLogAopLoader",//自定义aop注解处理器
        "*org.throwable.aop.AbstractLogAopLoader"})  //自定义aop注解处理器
@Modules(scanPackage = true)
@SetupBy(value = MainSetup.class)
public class MainModule {
}