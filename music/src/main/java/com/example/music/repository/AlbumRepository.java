package com.example.music.repository;

import com.example.music.entity.Album;
import com.example.music.mapper.AlbumMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumRepository {
    private final AlbumMapper albumMapper;

    public AlbumRepository(AlbumMapper albumMapper) {
        this.albumMapper = albumMapper;
    }

    public List<Album> getAllAlbums() {
        return albumMapper.selectAllAlbums();
    }
}
