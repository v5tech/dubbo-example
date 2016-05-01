package net.aimeizi.dubbo.service;

import net.aimeizi.dubbo.entity.User;

public interface UserService {

	/**
	 * 保存User,计算出年龄
	 * @param user
	 * @return
	 */
	public User save(User user);
}
