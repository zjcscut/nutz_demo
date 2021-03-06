package org.throwable;


import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.annotation.SetupBy;
import org.throwable.aop.provider.AnthorComboIocProvider;

@IocBy(type = AnthorComboIocProvider.class, args = {"*js", "conf/ioc/",
        "*anno", "org.throwable",
        "*tx", // 事务拦截 aop
        "*async", // 异步执行aop
})
@Modules(scanPackage = true)
@SetupBy(value = MainSetup.class)
public class MainModule {
}