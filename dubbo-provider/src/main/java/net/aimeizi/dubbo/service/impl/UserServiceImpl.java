package net.aimeizi.dubbo.service.impl;

import net.aimeizi.dubbo.entity.User;
import net.aimeizi.dubbo.service.UserService;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public User save(User user) {
		user.setUserId(++UserIdGenerator.id);
		return user;
	}

}
