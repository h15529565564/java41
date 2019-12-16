/**
 * @filename AuthTest.java
 * @author lg
 * @date 2017年12月22日 下午4:43:12
 * @version 1.0
 * Copyright (C) 2017 
 */

package com.util;

public class AuthTest {

	/*//用于拼装当前用户的所有权限，
		StringBuffer buf=new StringBuffer();
		
		//1、查询当前用户一级权限
		List firstList=fistService.getFirstAuth();
		//2、循环一级权限
		for(Auth auth:firstList){
			//获取一级权限id
			int authId=auth.getAuthId();
			//3、通过一级权限查询二级权限
			List secondList=secondService.getSecondAuth(authId);
			//4、设置子权限
			auth.setChildList(secondList);
			
			//5、通过二级权限查询三级权限
			for(Auth auth2:secondList){//循环遍历二级权限
				//获取二级权限id
				int authId2=auth2.getAuthId();

				String authUrl=auth2.getAuthUrl();
				buf.append(authUrl+";");

				//6、通过二级权限查询三级权限
				List thirdList=thirdService.getThirdAuth(authId2);
				//7、设置子权限
				auth2.setChildList(thirdList);
				//8、循环遍历三级权限，获取按钮权限的code
				for(Auth auth3:thirdList){
					String authCode=auth3.getAuthCode();// 如：user:saveUser
					//9、将权限code放入StringBuffer对象中
					buf.append(authCode+";");
				}
				
			}
			
		}
		
	  //10、将查询返回的权限集合放入session中
		session.setAttribute("firstList",firstList);
	//11、将三级权限查询返回的按钮权限，通过StringBuffer放入session中
		session.setAttribute("authCodes",buf.toString());*/

}
