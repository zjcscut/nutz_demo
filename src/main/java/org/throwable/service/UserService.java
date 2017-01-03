package org.throwable.service;

import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.throwable.dao.UserDao;
import org.throwable.entity.User;

/**
 * @author zjc
 * @version 2017/1/4 1:24
 * @description
 */
@IocBean
public class UserService {

	@Inject
	private UserDao userDao;

	public User findByUserName(String name) {
		return userDao.fetchUserByName(name);
	}
}
