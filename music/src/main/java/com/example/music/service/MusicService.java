package com.example.music.service;

import com.example.music.entity.Music;
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
}
