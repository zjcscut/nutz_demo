package org.throwable.action;

import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.throwable.service.UserService;

/**
 * @author zhangjinci
 * @version 2017/1/12 16:17
 * @function
 */
@IocBean
@InjectName(value = "userAction")
public class UserAction {

    @Inject
    private UserService userService;

    @At("/user/find")
    @Ok("json:{quoteName:true, ignoreNull:true}")
    public String getUser() {
        return userService.findByUserName("zjc").toString();
    }
}
