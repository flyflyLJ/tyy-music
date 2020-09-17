package com.tyy.ss.search.service;

import com.tyy.ss.search.entity.Music;
import com.tyy.ss.search.entity.vo.SearchRequestVo;

import java.util.List;

public interface XiaMiMusicService {

    List<Music> findMusicByPage(SearchRequestVo req);

    String loadLyric(String url);

    String loadPic(String  id);

    String loadMusicUrl(String id);
}
