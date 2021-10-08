package com.liferay.samples.fbo.audiodb.service;

import com.jayway.jsonpath.JsonPathException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.samples.fbo.music.api.ArtistJsonParser;
import com.liferay.samples.fbo.music.api.ArtistService;
import com.liferay.samples.fbo.music.api.exception.ArtistNotFoundException;
import com.liferay.samples.fbo.music.api.model.Artist;
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
    service = ArtistService.class
)
public class AudioDBArtistService
    implements ArtistService {

  private final static Logger LOG = LoggerFactory.getLogger(AudioDBArtistService.class);

  @Override
  public List<Artist> getArtists()
      throws ArtistNotFoundException {

    List<Artist> artists = new ArrayList<Artist>();

    artists.add(fetchArtist("coldplay"));
    artists.add(fetchArtist("muse"));
    artists.add(fetchArtist("oasis"));

    return artists;
  }

  @Override
  public Artist fetchArtist(long artistId) {

    Artist artist = new Artist();

    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
        .url("https://theaudiodb.com/api/v1/json/1/artist.php?i=" + artistId)
        .build();

    try (Response response = client.newCall(request).execute()) {
      String responseBody = response.body().string();
      return artistJsonParser.parse(responseBody);
    } catch (IOException e) {
      LOG.error("Did not find Artist {}", artistId);
    }

    artist.setUrl("/artist/" + artist.getName());

    return artist;
  }

  @Override
  public Artist fetchArtist(String urlTitle, long groupId)
      throws ArtistNotFoundException {

    Artist artist = fetchArtist(urlTitle.replace("-", " "));
    artist.setGroupId(groupId);

    try {
      artist.setUrl(
          "/web" + _groupLocalService.getGroup(groupId).getFriendlyURL() + "/artist/" + artist
              .getName().replace(" ", "-"));
    } catch (PortalException e) {
      LOG.error("Failed to get Group {}", groupId, e);
    }

    return artist;
  }

  @Override
  public Artist fetchArtist(String name)
      throws ArtistNotFoundException {

    Artist artist = new Artist();
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
        .url("https://www.theaudiodb.com/api/v1/json/1/search.php?s=" + name)
        .build();

    try (Response response = client.newCall(request).execute()) {
      String responseBody = response.body().string();
      artist = artistJsonParser.parse(responseBody);
    } catch (IOException | JsonPathException e) {
      LOG.error("Did not find Artist {}", name);
      throw new ArtistNotFoundException("Artist with name '" + name + "' not found");
    }

    long groupId = ServiceContextThreadLocal.getServiceContext().getScopeGroupId();

    try {
      artist.setUrl(
          "/web" + _groupLocalService.getGroup(groupId).getFriendlyURL() + "/artist/" + artist
              .getName().replace(" ", "-"));
    } catch (PortalException e) {
      LOG.error("Failed to get Group {}", groupId, e);
    }

    return artist;
  }

  @Reference(target = "(type=audiodb)")
  private ArtistJsonParser artistJsonParser;

  @Reference
  private GroupLocalService _groupLocalService;

}
