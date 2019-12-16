/**
 * @filename UserInfoService.java
 * @author lg
 * @date 2018年1月11日 下午5:03:58
 * @version 1.0
 * Copyright (C) 2018 
 */

package com.auth.service;

import com.auth.entity.UserInfo;

/**
 * 用户管理业务接口
 * @author lg
 * @date  2018-01-11
 */
public interface UserInfoService {
	/**
	 * 用户登录接口	
	 * @param user 用户对象
	 * @return 用户对象
	 * @author lg
	 * @date  2018-01-11
	 */
	public UserInfo login(UserInfo user);
}
