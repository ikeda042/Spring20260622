package com.example.music.repository;

import com.example.music.entity.Music;
import com.example.music.mapper.MusicMapper;
import com.example.music.viewmodel.MusicViewModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MusicRepository {
    private final MusicMapper musicMapper;

    public MusicRepository(MusicMapper musicMapper) {
        this.musicMapper = musicMapper;
    }

    public List<Music> getMusicsByAlbumId(long albumId) {
        return musicMapper.selectMusicsById(albumId);
    }

    public List<MusicViewModel> selectMusicsWithFavorite(long albumId, long userId) {
        return musicMapper.selectMusicsWithFavorite(albumId, userId);
    }

    public void insertMusic(Music music) {
        musicMapper.insertMusic(music);
    }

    public void deleteMusicById(long musicId) {
        musicMapper.deleteMusicById(musicId);
    }

    public void updateMusic(Music music) {
        musicMapper.updateMusic(music);
    }

    public Music selectMusicById(long musicId) {
        return musicMapper.selectMusicById(musicId);
    }
}
