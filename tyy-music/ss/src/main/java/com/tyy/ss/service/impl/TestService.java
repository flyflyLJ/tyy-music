/** 
* 
* @author linliquan 
* @data 2018年12月23日 00:03:48  
*/

package com.tyy.ss.service.impl;

import javax.annotation.Resource;

import com.tyy.ss.com.AbstractService;
import com.tyy.ss.com.IOperations;
import com.tyy.ss.mapper.ITestMapper;
import com.tyy.ss.pojo.Test;
import com.tyy.ss.service.ITestService;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestService extends AbstractService<Test, Test> implements ITestService {

	public TestService() {
		this.setTableName("test");
	}

	@Resource   
	private ITestMapper testMapper;

	@Override
	protected IOperations<Test, Test> getMapper() {
		return testMapper;
	}

	@Override
	public void setTableName(String tableName) {
		this.tableName = tableName;
		;
	}

}
