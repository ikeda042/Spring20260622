package com.example.music.mapper;

import com.example.music.entity.Album;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AlbumMapper {

    @Select("SELECT * FROM albums")
    List<Album> selectAllAlbums();

    @Insert("INSERT INTO albums (title, artist, release_date) VALUES (#{title}, #{artist}, #{releaseDate})")
    @Options(useGeneratedKeys = true, keyProperty = "albumId")
    void insertAlbum(Album album);

    @Select("SELECT * FROM albums WHERE album_id = #{albumId}")
    Album selectAlbumById(long albumId);

    @Delete("DELETE FROM albums WHERE album_id = #{albumId}")
    void deleteAlbumById(long albumId);
}
