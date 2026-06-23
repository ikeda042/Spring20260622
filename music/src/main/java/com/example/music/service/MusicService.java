package com.example.music.service;

import com.example.music.entity.Album;
import com.example.music.entity.Music;
import com.example.music.exception.AlbumNotFoundException;
import com.example.music.exception.MusicNotFoundException;
import com.example.music.form.MusicForm;
import com.example.music.repository.AlbumRepository;
import com.example.music.repository.MusicRepository;
import com.example.music.viewmodel.MusicViewModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MusicService {
    private final MusicRepository musicRepository;
    private final AlbumRepository albumRepository;

    public MusicService(MusicRepository musicRepository, AlbumRepository albumRepository) {
        this.musicRepository = musicRepository;
        this.albumRepository = albumRepository;
    }

    public List<Music> getMusicsByAlbumId(long albumId) {
        return musicRepository.getMusicsByAlbumId(albumId);
    }

    public List<MusicViewModel> selectMusicsWithFavorite(long albumId, long userId) {
        return musicRepository.selectMusicsWithFavorite(albumId, userId);
    }

    @Transactional
    public void createMusic(MusicForm musicForm) {
        Album existingAlbum = albumRepository.getAlbumById(musicForm.getAlbumId());
        if (existingAlbum == null) {
            throw new AlbumNotFoundException("Album not found");
        }

        Music music = new Music();
        music.setTitle(musicForm.getTitle());
        music.setDuration(musicForm.getDuration());
        music.setAlbumId(musicForm.getAlbumId());

        musicRepository.insertMusic(music);
    }

    public void deleteMusic(long musicId) {
        musicRepository.deleteMusicById(musicId);
    }

    public Music getMusicById(long musicId) {
        return musicRepository.selectMusicById(musicId);
    }

    @Transactional
    public void updateMusic(long musicId, Music music) {
        Music existingMusic = getMusicById(musicId);
        if (existingMusic == null) {
            throw new MusicNotFoundException("Music not found", music.getAlbumId());
        }

        if (musicId != music.getMusicId()) {
            throw new MusicNotFoundException("Music ID does not match", music.getAlbumId());
        }

        musicRepository.updateMusic(music);
    }
}
