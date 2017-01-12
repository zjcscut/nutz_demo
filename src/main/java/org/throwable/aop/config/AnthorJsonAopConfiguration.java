package org.throwable.aop.config;

import org.nutz.ioc.aop.config.impl.AbstractAopConfigration;
import org.nutz.ioc.aop.config.impl.AopConfigrationItem;
import org.nutz.json.Json;
import org.nutz.lang.Files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjinci
 * @version 2017/1/12 14:31
 * @function
 */
@Deprecated
public class AnthorJsonAopConfiguration extends AbstractAopConfigration {

    private static final String AOP_FILE = "/aop.json";

    private List<AopConfigrationItem> exAopItemList;
    private List<AopConfigrationItem> NaopItemList;


    public AnthorJsonAopConfiguration() {
        NaopItemList = new ArrayList<>();
        File file = new File(AnthorJsonAopConfiguration.class.getResource(AOP_FILE).getFile());
        String read = Files.read(file);
        exAopItemList = Json.fromJsonAsList(AopConfigrationItem.class, read);
        if (null != exAopItemList && !exAopItemList.isEmpty()) {
            NaopItemList.addAll(exAopItemList);
        }
        setAopItemList(NaopItemList);
    }

    @Override
    public void setAopItemList(List<AopConfigrationItem> aopItemList) {
        super.setAopItemList(NaopItemList);
    }
}
