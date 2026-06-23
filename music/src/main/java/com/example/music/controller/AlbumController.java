package com.example.music.controller;

import com.example.music.entity.Album;
import com.example.music.entity.Music;
import com.example.music.form.AlbumForm;
import com.example.music.form.MusicForm;
import com.example.music.security.CustomUserDetails;
import com.example.music.service.AlbumService;
import com.example.music.service.MusicService;
import com.example.music.viewmodel.AlbumViewModel;
import com.example.music.viewmodel.MusicViewModel;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;
    private final MusicService musicService;

    public AlbumController(AlbumService albumService, MusicService musicService) {
        this.albumService = albumService;
        this.musicService = musicService;
    }

    @GetMapping
    public String albums(Model model) {
        List<AlbumViewModel> albums = albumService.getAllAlbumsWithMusicCount();
        model.addAttribute("albums", albums);
        return "album/album-list";
    }

    @GetMapping("/new")
    public String albumForm(Model model) {
        AlbumForm albumForm = new AlbumForm();
        model.addAttribute("albumForm", albumForm);
        return "album/album-form";
    }

    @PostMapping("/new")
    public String createAlbum(AlbumForm albumForm) {
        albumService.createAlbum(albumForm);
        return "redirect:/albums";
    }

    @GetMapping("/{albumId}")
    public String album(@PathVariable long albumId, @AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        Album album = albumService.getAlbumById(albumId);
        long userId = userDetails == null ? 0 : userDetails.getUserId();
        List<MusicViewModel> musics = musicService.selectMusicsWithFavorite(albumId, userId);
        model.addAttribute("album", album);
        model.addAttribute("musics", musics);
        return "album/album-detail";
    }

    @PostMapping("/{albumId}/delete")
    public String deleteAlbum(@PathVariable long albumId) {
        albumService.deleteAlbum(albumId);
        return "redirect:/albums";
    }

    @GetMapping("/{albumId}/edit")
    public String editAlbumForm(@PathVariable long albumId, Model model) {
        Album album = albumService.getAlbumById(albumId);
        model.addAttribute("album", album);
        return "album/album-edit";
    }

    @PostMapping("/{albumId}/edit")
    public String updateAlbum(@PathVariable long albumId, Album album) {
        album.setAlbumId(albumId);
        albumService.updateAlbum(albumId, album);
        return "redirect:/albums";
    }

    @GetMapping("/{albumId}/musics/new")
    public String createMusicForm(@PathVariable long albumId, Model model) {
        MusicForm musicForm = new MusicForm();
        musicForm.setAlbumId(albumId);
        model.addAttribute("musicForm", musicForm);

        return "music/music-form";
    }

    @PostMapping("/{albumId}/musics/new")
    public String createMusic(@PathVariable long albumId, MusicForm musicForm) {
        musicForm.setAlbumId(albumId);
        musicService.createMusic(musicForm);
        return "redirect:/albums/" + albumId;
    }

    @PostMapping("/{albumId}/musics/{musicId}/delete")
    public String deleteMusic(@PathVariable long albumId, @PathVariable long musicId) {
        musicService.deleteMusic(musicId);
        return "redirect:/albums/" + albumId;
    }

    @GetMapping("/{albumId}/musics/{musicId}/edit")
    public String editMusic(@PathVariable long albumId, @PathVariable long musicId, Model model) {
        Music music = musicService.getMusicById(musicId);
        model.addAttribute("music", music);
        return "music/music-edit";
    }

    @PostMapping("/{albumId}/musics/{musicId}/edit")
    public String updateMusic(@PathVariable long albumId, @PathVariable long musicId, Music music) {
        musicService.updateMusic(musicId, music);
        return "redirect:/albums/" + albumId;
    }
}
