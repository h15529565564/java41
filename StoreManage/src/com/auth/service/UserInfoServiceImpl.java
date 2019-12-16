/**
 * @filename UserInfoServiceImpl.java
 * @author lg
 * @date 2018年1月11日 下午5:05:16
 * @version 1.0
 * Copyright (C) 2018 
 */

package com.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auth.entity.UserInfo;
import com.auth.mapper.UserInfoMapper;

/**
 * 用户管理业务实现类
 * @author lg
 * @date  2018-01-11
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{
    //注入用户mapper接口
	@Autowired
	UserInfoMapper userInfoMapper;
	/**
	 * 用户登录接口	
	 * @param user 用户对象
	 * @return 用户对象
	 * @author lg
	 * @date  2018-01-11
	 */
	public UserInfo login(UserInfo user) {		
		return userInfoMapper.login(user);
	}

}
