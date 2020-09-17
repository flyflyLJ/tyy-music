/** 
* 
* @author linliquan
* @data 2018年12月23日 00:03:48  
*/

package com.tyy.ss.service;

import com.tyy.ss.com.IServiceOperations;
import com.tyy.ss.pojo.User;

public interface IUserService extends IServiceOperations<User, User> {

	// 判断用户名是否重复
	public String rearchUserName(String user_name);
}
