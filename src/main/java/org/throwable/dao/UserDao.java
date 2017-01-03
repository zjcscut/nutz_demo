package org.throwable.dao;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;
import org.throwable.entity.User;

/**
 * @author zjc
 * @version 2017/1/4 1:22
 * @description
 */
@IocBean
public class UserDao {

	@Inject
	private Dao dao;

	public User fetchUserByName(String name) {
		Cnd cnd = Cnd.NEW();
		cnd.where().and("name", "=", name);
		return dao.fetch(User.class, cnd);
	}
}
