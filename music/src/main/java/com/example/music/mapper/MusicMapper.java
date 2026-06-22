package com.example.music.mapper;

import com.example.music.entity.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MusicMapper {

    @Select("SELECT * FROM musics WHERE album_id = #{albumId}")
    List<Music> selectMusicsById(long albumId);
}
