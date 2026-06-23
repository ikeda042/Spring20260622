package com.example.music.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FavoriteMapper {

    @Insert("INSERT INTO favorites (user_id, music_id) VALUES (#{userId}, #{musicId})")
    void insertFavorite(@Param("userId") long userId, @Param("musicId") long musicId);
}
