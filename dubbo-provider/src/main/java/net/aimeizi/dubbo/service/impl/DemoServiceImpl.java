package net.aimeizi.dubbo.service.impl;

import net.aimeizi.dubbo.service.DemoService;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class DemoServiceImpl implements DemoService {

	@Override
	public int getLength(String words) {
		if (words == null || words.isEmpty()) {
			return -1;
		} else {
			return words.length();
		}
	}
}
