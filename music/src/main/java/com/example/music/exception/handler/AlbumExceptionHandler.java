package com.example.music.exception.handler;

import com.example.music.exception.AlbumNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class AlbumExceptionHandler {

    @ExceptionHandler(AlbumNotFoundException.class)
    public String handleAlbumNotFoundException(AlbumNotFoundException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "対象のアルバムが見つかりませんでした");
        return "redirect:/albums";
    }
}
