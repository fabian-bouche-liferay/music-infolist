package com.liferay.samples.fbo.audiodb.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.samples.fbo.music.api.AlbumJsonParser;
import com.liferay.samples.fbo.music.api.AlbumService;
import com.liferay.samples.fbo.music.api.model.Album;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    immediate = true,
    property = {
        "type=audiodb"
    },
    service = AlbumService.class
)
public class AudioDBAlbumService
    implements AlbumService {

  private final static Logger LOG = LoggerFactory.getLogger(AudioDBAlbumService.class);

  @Override
  public List<Album> getAlbums(long artistId) {

    List<Album> albums = new ArrayList<Album>();

    LOG.debug("Making request https://theaudiodb.com/api/v1/json/1/album.php?i={}", artistId);

    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
        .url("https://theaudiodb.com/api/v1/json/1/album.php?i=" + artistId)
        .build();

    try (Response response = client.newCall(request).execute()) {
      String responseBody = response.body().string();
      return albumJsonParser.parseAlbums(responseBody);
    } catch (IOException e) {
      LOG.error("Did not find Artist {}", artistId);
    }

    return albums;
  }

  @Override
  public Album fetchAlbum(long albumId) {

    Album album = new Album();

    LOG.debug("Making request https://theaudiodb.com/api/v1/json/1/album.php?m={}", albumId);

    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
        .url("https://theaudiodb.com/api/v1/json/1/album.php?m=" + albumId)
        .build();

    try (Response response = client.newCall(request).execute()) {
      String responseBody = response.body().string();
      return albumJsonParser.parseAlbum(responseBody);
    } catch (IOException e) {
      LOG.error("Did not find Album {}", albumId);
    }

    album.setAlbumUrl("/album/" + albumId + "-" + album.getName());

    return album;
  }

  @Override
  public Album fetchAlbum(String urlTitle, long groupId) {

    long albumId = Long.valueOf(urlTitle.split("-")[0]);

    Album album = fetchAlbum(albumId);
    album.setGroupId(groupId);
    try {
      album.setAlbumUrl(
          "/web" + _groupLocalService.getGroup(groupId).getFriendlyURL() + "/album/" + albumId + "-"
              + album.getName());
    } catch (PortalException e) {
      LOG.error("Failed to get Group {}", groupId, e);
    }

    return album;
  }

  @Reference(target = "(type=audiodb)")
  private AlbumJsonParser albumJsonParser;

  @Reference
  private GroupLocalService _groupLocalService;

}
