package org.throwable.aop.anno;

import java.lang.annotation.*;

/**
 * @author zhangjinci
 * @version 2017/1/12 11:58
 * @function
 */
@Retention(RetentionPolicy.RUNTIME) // 必须带这个,不然读取不到的
@Target({ElementType.METHOD}) // aop,一般指方法
@Documented // 记录到javadoc
public @interface LogEx {
}
