/**
 * 
 */
package org.throwable.nutz.runner;


import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.nutz.ioc.Ioc;
import org.nutz.ioc.IocLoader;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.nutz.ioc.loader.json.JsonLoader;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.SetupBy;
import org.nutz.mvc.ioc.provider.ComboIocProvider;
import org.nutz.mvc.ioc.provider.JsonIocProvider;
import org.throwable.MainSetup;
import org.throwable.nutz.annoation.ModuleConfiguration;

import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * Nutz Ioc 的 JUnit4 测试容器
 * @author Shach
 * @email shacaihong@vip.qq.com
 *
 */
public class NutzIocJUnit4ClassRunner extends BlockJUnit4ClassRunner {
	
	private Ioc ioc;
	
	private String runMode = "test";
	
	private Class<?> moduleKlass;

	public NutzIocJUnit4ClassRunner(Class<?> klass) throws InitializationError {
		super(klass);
		System.setProperty("runMode", runMode);
	}

	@Override
	public void run(RunNotifier notifier) {
		try {
			initIoc();
			initSetupBy();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		super.run(notifier);
	}

	protected void initIoc() throws Exception {
		System.setProperty("runMode", runMode);
		Class<?> klass = getTestClass().getJavaClass();
		
		//必须继承AbstractJUnit4NutzIocTests
		/*
		if (!AbstractJUnit4NutzIocTests.class.isAssignableFrom(klass)) {
			throw new RuntimeException("Test type is invalid, not inherit AbstractJUnit4NutzIocTests.");
		}
		*/
		
		ModuleConfiguration moduleConfiguration = klass.getAnnotation(ModuleConfiguration.class);
		if (moduleConfiguration == null) {	//未正常配置Nutz模块类
			throw new RuntimeException("We haven't Nutz module configuration.");
		}
		
		moduleKlass = moduleConfiguration.value();
		IocBy iocBy = moduleKlass.getAnnotation(IocBy.class);
		if (iocBy == null) {	//模块类不存在Ioc相关配置
			throw new RuntimeException("Nutz module is not @IocBy statement.");
		}
		
		IocLoader iocLoader = null;
		Class<?> iocType = iocBy.type();
		String[] args = iocBy.args();
		//初始化配置加载
		if (iocType == ComboIocProvider.class) {
			iocLoader = new ComboIocLoader(args);
		} else if (iocType == JsonIocProvider.class) {
			iocLoader = new JsonLoader(args);
		} else {
			throw new UnsupportedOperationException(String.format("Not support %s type of implementation.", iocType.getSimpleName()));
		}
		
		ioc = new NutIoc(iocLoader);
	}
	
	protected void initSetupBy(){
		SetupBy setupanotation = moduleKlass.getAnnotation(SetupBy.class);
		if (setupanotation == null) {
			return;
		}
		
		MainSetup setup = null;
		try {
			Class<MainSetup> setupclass = (Class<MainSetup>) Class.forName(setupanotation.value().getName());
			setup = setupclass.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("实例化SetUp对象失败");
		} catch (InstantiationException e){
			e.printStackTrace();
			throw new RuntimeException("实例化SetUp对象失败");
		} catch (IllegalAccessException e){
			e.printStackTrace();
			throw new RuntimeException("实例化SetUp对象失败");
		}

	}

	@Override
	protected Object createTest() throws Exception {
		Object testObj = super.createTest();
		
		//属性注入
		fieldInject(testObj);
		
		try {
			//注入Ioc容器（测试方法每次执行都会执行，测试用例中每个测试方法都是分开实例执行的）
			Method method = testObj.getClass().getMethod("setIoc", Ioc.class);
			method.invoke(testObj, ioc);
		} catch (NoSuchMethodException e) {
			//可选继承AbstractJUnit4NutzIocTests
		}

		
		return testObj;
	}

	@Override
	protected Statement withBeforeClasses(Statement statement) {
		//XXX 静态变量赋值
		return super.withBeforeClasses(statement);
	}
	
	/**
	 * 属性字段注入
	 * @param target 所属实例
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	protected void fieldInject(Object target) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = target.getClass().getDeclaredFields();
		for (Field field : fields) {
			//过滤未声明了Inject注解的字段
			if (field.getAnnotation(Inject.class) == null) continue;
			Object val = ioc.get(field.getType());
			if (val == null) continue;
			
			field.setAccessible(true);
			field.set(target, val);
		}
		
	}

	

}
