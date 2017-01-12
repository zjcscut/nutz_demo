package org.throwable.nutz.mvc;



/**
 * Nutz mvc（action）单元测试基类
 * @author chenxf
 * @since 2015-11-27
 */
public class NutzMvcBaseTest extends AbstractMvcTest {

	@Override
	protected void initServletConfig() {
		System.setProperty("runMode", "dev");//设置为开发模式，调用dev的配置文件
		servletConfig.addInitParameter("modules", "com.whtr.eam.MainModule");  
	}




}
