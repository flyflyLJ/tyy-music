package com.tyy.ss.search.service;

import com.tyy.ss.search.entity.Music;
import com.tyy.ss.search.entity.vo.SearchRequestVo;

import java.util.List;

public interface QQMusicService {

    List<Music> findMusicByPage(SearchRequestVo req);

    String loadLyric(String media_mid);

    String loadPic(String  id);

    String loadMusicUrl(String id);
}
