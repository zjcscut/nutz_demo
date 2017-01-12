package org.throwable.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nutz.ioc.loader.annotation.Inject;
import org.throwable.MainModule;
import org.throwable.entity.User;
import org.throwable.nutz.AbstractJUnit4NutzIocTests;
import org.throwable.nutz.annoation.ModuleConfiguration;
import org.throwable.nutz.runner.NutzIocJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author zjc
 * @version 2017/1/4 1:26
 * @description
 */
@RunWith(NutzIocJUnit4ClassRunner.class)
@ModuleConfiguration(MainModule.class)
public class UserServiceTest extends AbstractJUnit4NutzIocTests {

    @Inject
    private UserService userService;

    @Test
    public void findByUserName() throws Exception {
        User u = userService.findByUserName("zjc");
        System.out.println(u);
    }

}