package com.tyy.ss.search.service.impl;

import com.tyy.ss.search.comm.RequestHeaders;
import com.tyy.ss.search.entity.Music;
import com.tyy.ss.search.entity.vo.SearchRequestVo;
import com.tyy.ss.search.entity.xiami.XiaMiMusicBase;
import com.tyy.ss.search.musicEnum.MusicSourceEnum;
import com.tyy.ss.search.service.XiaMiMusicService;
import com.tyy.ss.search.util.OkHttpUtils;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class XiaMiMusicServiceImpl implements XiaMiMusicService {
    private OkHttpClient okHttpClient = new OkHttpClient();
    public static Logger logger = LoggerFactory.getLogger(XiaMiMusicServiceImpl.class);


    /**
     * 分页获取歌曲
     *
     * @param req
     * @return
     */
    @Override
    public List<Music> findMusicByPage(SearchRequestVo req) {
        ArrayList<Music> list = new ArrayList<>();
        String url = "http://api.xiami.com/web?v=2.0&app_key=1&key=" + req.getName() + "&page=" + req.getPageIndex()
                + "&limit=" + req.getPageSize() + "&r=search/songs";
        XiaMiMusicBase xiaMiMusicBase = OkHttpUtils.getRequest(url, RequestHeaders.xiamiHeaders, null, XiaMiMusicBase.class);
        List<XiaMiMusicBase.Data.Songs> songs = xiaMiMusicBase.getData().getSongs();
        for (XiaMiMusicBase.Data.Songs song : songs) {
            Music music = new Music();
            music.setName(song.getSong_name());
            music.setArtist(song.getArtist_name());
            music.setAlbum(song.getAlbum_name());
            music.setUrl(song.getListen_file());
            music.setPic(song.getAlbum_logo());
            music.setLyric(loadLyric(song.getLyric()));
            music.setId(song.getSong_id() + "");
            music.setPic_id(song.getSong_id() + "");
            music.setUrl_id(song.getSong_id() + "");
            music.setLyric_id(song.getSong_id() + "");
            music.setSource(MusicSourceEnum.XiaMiMusic.getSource());
            list.add(music);
        }
        return list;
    }

    @Override
    public String loadPic(String id) {
        return id;
    }

    @Override
    public String loadMusicUrl(String id) {
        return id;
    }


    /**
     * 获取歌词
     *
     * @param url
     * @return
     */
    @Override
    public String loadLyric(String url) {
        String lyr = null;
        if (url != null && url != "" && url.indexOf("http") != -1) {
            String rsp = OkHttpUtils.getRequest(url, RequestHeaders.xiamiHeaders);
            if (rsp != null) {
                String regex = "<([0-9]+)>";
                lyr = rsp.replaceAll(regex, "");
            }
        }
        return lyr;
    }
}
