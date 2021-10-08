package com.liferay.samples.fbo.music.api;

import com.liferay.samples.fbo.music.api.model.Album;
import java.util.List;
import java.util.Map;

public interface AlbumJsonParser {

  Album parseAlbum(String json);

  List<Album> parseAlbums(String json);

  Album parseIndividualAlbum(String json);

  Album parseIndividualAlbum(Map<String, String> map);

}
