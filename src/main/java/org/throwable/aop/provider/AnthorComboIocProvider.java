package org.throwable.aop.provider;

import org.nutz.ioc.Ioc;
import org.nutz.ioc.impl.NutIoc;
import org.nutz.ioc.impl.ScopeContext;
import org.nutz.ioc.loader.combo.ComboIocLoader;
import org.nutz.lang.Lang;
import org.nutz.mvc.NutConfig;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

import java.util.Arrays;

/**
 * @author zhangjinci
 * @version 2017/1/12 15:56
 * @function 改造启动复合ioc加载器,使之添加自定义AOP加载器
 */
public class AnthorComboIocProvider extends ComboIocProvider {

    private static final String AOP_CONFIG_FILE = "/aop_config.json";

    @Override
    public Ioc create(NutConfig config, String[] args) {
        String[] temp = args;
        try {
            //TODO 扩展语法
            for (int i = 0; i < temp.length; i++) {
                if (temp[i].contains("${main}"))
                    temp[i] = temp[i].replace("${main}", config.getMainModule().getPackage().getName());
            }
            String[] aopArgs = ComboIocProviderAopLoader.getInstance().getAopConfigs(AOP_CONFIG_FILE);
            String[] lastArgs;
            if (null != aopArgs && aopArgs.length > 0) {
                lastArgs = Arrays.copyOf(temp, temp.length + aopArgs.length);
                System.arraycopy(aopArgs, 0, lastArgs, temp.length, aopArgs.length);
            } else {
                lastArgs = temp;
            }
            return new NutIoc(new ComboIocLoader(lastArgs), new ScopeContext("app"), "app");
        } catch (ClassNotFoundException e) {
            throw Lang.wrapThrow(e);
        }
    }
}
