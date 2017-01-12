package org.throwable.nutz.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 模块配置项
 * @author Shach
 * @email shacaihong@vip.qq.com
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface ModuleConfiguration {
	
	/**
	 * 
	 * 模块类
	 * @return
	 */
	Class<?> value();
	
}