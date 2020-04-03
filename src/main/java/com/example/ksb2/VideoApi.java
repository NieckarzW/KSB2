package com.example.ksb2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/videos")
public class VideoApi {

  private List<Video> videoList;

  public VideoApi() {
    this.videoList = new ArrayList<>();
    videoList.add(new Video(1L, "00039", "https://youtu.be/xh1rPS5lkBU?list=PLMZwzZqspOTKBEnAjApZWp-qyXXDp8Mth"));
    videoList.add(new Video(2L, "00042", "https://youtu.be/rXW0JfiTPw0?list=PLMZwzZqspOTKBEnAjApZWp-qyXXDp8Mth"));
    videoList.add(new Video(3L, "00035", "https://youtu.be/E3WP1hRP400?list=PLMZwzZqspOTKBEnAjApZWp-qyXXDp8Mth"));
  }

  @GetMapping
  public ResponseEntity<List<Video>> getVideos(){
    return new ResponseEntity<>(videoList, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Video> getVideoById(@PathVariable long id){
    Optional<Video> first = videoList.stream().filter(video -> video.getId() == id).findFirst();
    if (first.isPresent()) {
      return new ResponseEntity<>(first.get(), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @PostMapping
  public ResponseEntity addVideo(@RequestBody Video video) {
    boolean add = videoList.add(video);
    if (add){
      return new ResponseEntity(HttpStatus.CREATED);
    }
    return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @PutMapping
  public ResponseEntity modifyVideo(@RequestBody Video newVideo) {
    Optional<Video> first = videoList.stream().filter(video -> video.getId() == newVideo.getId()).findFirst();
    if (first.isPresent()) {
      videoList.remove(first.get());
      videoList.add(newVideo);
      return new ResponseEntity(HttpStatus.OK);
    }
    return new ResponseEntity(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity removeVideo(@PathVariable long id) {
    Optional<Video> first = videoList.stream().filter(video -> video.getId() == id).findFirst();
    if (first.isPresent()) {
      videoList.remove(first.get());
      return new ResponseEntity<>(first.get(), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
