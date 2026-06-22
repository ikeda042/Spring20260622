package com.example.music.service;

import com.example.music.entity.Music;
import com.example.music.form.MusicForm;
import com.example.music.repository.MusicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {
    private final MusicRepository musicRepository;

    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public List<Music> getMusicsByAlbumId(long albumId) {
        return musicRepository.getMusicsByAlbumId(albumId);
    }

    public void createMusic(MusicForm musicForm) {
        Music music = new Music();
        music.setTitle(musicForm.getTitle());
        music.setDuration(musicForm.getDuration());
        music.setAlbumId(musicForm.getAlbumId());

        musicRepository.insertMusic(music);
    }
}
