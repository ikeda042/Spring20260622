package com.example.music.mapper;

import com.example.music.entity.Music;
import com.example.music.viewmodel.MusicViewModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MusicMapper {

    @Select("SELECT * FROM musics WHERE album_id = #{albumId}")
    List<Music> selectMusicsById(long albumId);

    @Select("""
            SELECT
                musics.music_id,
                musics.title,
                musics.duration,
                favorites.user_id IS NOT NULL AS is_favorite
            FROM musics
            LEFT JOIN favorites ON musics.music_id = favorites.music_id AND favorites.user_id = #{userId}
            WHERE musics.album_id = #{albumId}
            ORDER BY musics.music_id
            """)
    List<MusicViewModel> selectMusicsWithFavorite(@Param("albumId") long albumId, @Param("userId") long userId);

    @Insert("INSERT INTO musics (title, duration, album_id) VALUES (#{title}, #{duration}, #{albumId})")
    @Options(useGeneratedKeys = true, keyProperty = "musicId")
    void insertMusic(Music music);

    @Delete("DELETE FROM musics WHERE music_id = #{musicId}")
    void deleteMusicById(long musicId);

    @Update("UPDATE musics SET title = #{title}, duration = #{duration} WHERE music_id = #{musicId}")
    void updateMusic(Music music);

    @Select("SELECT * FROM musics WHERE music_id = #{musicId}")
    Music selectMusicById(long musicId);
}
