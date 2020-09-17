package com.tyy.ss.search.service;

public interface KgService {

    String loadLyric(String id);

    String loadMusicUrl(String id);

    String playList(String id);

    String kgUserList();
}
