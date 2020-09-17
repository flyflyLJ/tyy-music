package com.tyy.ss.search.service;

import com.tyy.ss.search.entity.Music;
import com.tyy.ss.search.entity.vo.SearchRequestVo;

import java.util.List;

public interface KuGouMusicService {

    List<Music> findMusicByPage(SearchRequestVo req);

    String loadLyric(String hash);

    String loadPic(String  hash);

    String loadMusicUrl(String hash);

}
