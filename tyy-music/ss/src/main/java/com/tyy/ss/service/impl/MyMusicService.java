/** 
* 
* @author linliquan
* @data 2018年12月23日 00:03:48  
*/

package com.tyy.ss.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.tyy.ss.com.AbstractService;
import com.tyy.ss.com.IOperations;
import com.tyy.ss.mapper.IMyMusicMapper;
import com.tyy.ss.pojo.MyMusic;
import com.tyy.ss.service.IMyMusicService;
import org.springframework.stereotype.Service;

@Service("myMusicService")
public class MyMusicService extends AbstractService<MyMusic, MyMusic> implements IMyMusicService {

	public MyMusicService() {
		this.setTableName("myMusic");
	}

	@Resource
	private IMyMusicMapper myMusicMapper;

	@Override          
	protected IOperations<MyMusic, MyMusic> getMapper() {
		return myMusicMapper;
	}

	@Override
	public void setTableName(String tableName) {
		this.tableName = tableName;
		;
	}

	@Override
	public String getUserById(String user_name, String user_password) {
		return myMusicMapper.getUserById(user_name, user_password);
	}

	@Override
	public List<MyMusic> getMyMusicList(int userId) {
		return myMusicMapper.getMyMusicList(userId);
	}

	// 删除音乐
	@Override
	public int deleteMyMusic(int song_id, int user_id) {
		return myMusicMapper.deleteMyMusic(song_id, user_id);
	}

}
