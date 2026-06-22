package com.example.music.form;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AlbumForm {
    private String title;
    private String artist;
    private LocalDate releaseDate;
}
