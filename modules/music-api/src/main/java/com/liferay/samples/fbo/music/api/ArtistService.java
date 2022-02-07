package com.liferay.samples.fbo.music.api;

import com.liferay.samples.fbo.music.api.exception.ArtistNotFoundException;
import com.liferay.samples.fbo.music.api.model.Artist;
import java.util.List;

public interface ArtistService {

  List<Artist> getArtists()
      throws ArtistNotFoundException;

  Artist fetchArtist(long artistId);

  Artist fetchArtist(String urlTitle, long groupId)
      throws ArtistNotFoundException;

  Artist fetchArtist(String name)
      throws ArtistNotFoundException;

}
