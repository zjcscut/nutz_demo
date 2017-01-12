package org.throwable.nutz;


import org.nutz.ioc.Ioc;
import org.nutz.mvc.Mvcs;

import java.util.Iterator;
import java.util.List;

/**
 * Nutz Ioc测试用例的抽象基类.<br>
 * 提供实例化好的Ioc容器
 * @author Shach
 * @email shacaihong@vip.qq.com
 *
 */
public abstract class AbstractJUnit4NutzIocTests {
	
	/**
	 * Nutz Ioc 容器 
	 */
	protected Ioc ioc;
	
	public final Ioc getIoc() {
		return ioc;
	}

	public final void setIoc(Ioc ioc) {
		Mvcs.setIoc(ioc);
		this.ioc = ioc;
	}

	/**
	 * 职责：将Object对象转换为json字符串输出，方便查看返回值
	 * @param obj
	 */
	public void voToString(Object obj) {

		System.err.println(obj.getClass().getSimpleName());
	}
	
	/**
	 * 职责：将List对象转换为json字符串输出，方便查看返回值
	 */
	public void listToString(List list) {
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			voToString(iterator.next());
		}
	}
}
