package org.throwable.aop.entity;

import java.util.List;

/**
 * @author zhangjinci
 * @version 2017/1/12 14:52
 * @function
 */
public class AopConfigEntityList {

    List<AopConfigEntiry> aopConfigEntiryList;

    public AopConfigEntityList() {
    }

    public List<AopConfigEntiry> getAopConfigEntiryList() {
        return aopConfigEntiryList;
    }

    public void setAopConfigEntiryList(List<AopConfigEntiry> aopConfigEntiryList) {
        this.aopConfigEntiryList = aopConfigEntiryList;
    }
}
