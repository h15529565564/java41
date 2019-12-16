/**
 * @filename UserInfoMapper.java
 * @author lg
 * @date 2018年1月11日 下午4:44:39
 * @version 1.0
 * Copyright (C) 2018 
 */

package com.auth.mapper;

import com.auth.entity.UserInfo;

/**
 * 持久化层用户接口
 * @author lg
 * @date  2018-01-11
 */
public interface UserInfoMapper {
	/**
	 * 用户登录接口	
	 * @param user 用户对象
	 * @return 用户对象
	 * @author lg
	 * @date  2018-01-11
	 */
	public UserInfo login(UserInfo user);
	
}
