package org.throwable.aop.provider;

import org.nutz.json.Json;
import org.nutz.lang.Files;
import org.throwable.aop.entity.AopLoaderNameEntity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjinci
 * @version 2017/1/12 15:57
 * @function
 */
public class ComboIocProviderAopLoader {

    private static ComboIocProviderAopLoader instance = new ComboIocProviderAopLoader();

    private ComboIocProviderAopLoader() {
    }

    public static ComboIocProviderAopLoader getInstance() {
        return instance;
    }

    public String[] getAopConfigs(String location) {
        File file = new File(ComboIocProviderAopLoader.class.getResource(location).getFile());
        String readStr = Files.read(file);
        List<AopLoaderNameEntity> loaders =  Json.fromJsonAsList(AopLoaderNameEntity.class, readStr);
        if (null == loaders || loaders.isEmpty()){
            return null;
        }else {
            List<String> loaderNames = new ArrayList<>(loaders.size());
            for (AopLoaderNameEntity loader : loaders){
                loaderNames.add(loader.getLoaderName());
            }
            return loaderNames.toArray(new String[loaderNames.size()]);
        }
    }
}
