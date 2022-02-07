package com.liferay.samples.fbo.audiodb.parser;

import com.jayway.jsonpath.JsonPath;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.samples.fbo.music.api.AlbumJsonParser;
import com.liferay.samples.fbo.music.api.model.Album;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import net.minidev.json.JSONArray;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    immediate = true,
		property = {
			"type=audiodb"
		},
		service = AlbumJsonParser.class
)
public class AudioDBAlbumJsonParser
    implements AlbumJsonParser {

  private final static Logger LOG = LoggerFactory.getLogger(AudioDBAlbumJsonParser.class);

  @Override
  public Album parseAlbum(String json) {

    Album album = parseIndividualAlbum((Map) JsonPath.read(json, "$.album[0]"));

    return album;
  }

  @Override
  public List<Album> parseAlbums(String json) {

    List<Album> albums = new ArrayList<Album>();

    LOG.debug("Albums json: {}", json);

    int nbAlbums = ((JSONArray) JsonPath.read(json, "$.album[*]")).size();

    LOG.debug("Albums count: {}", nbAlbums);

    for (int i = 0; i < nbAlbums; i++) {
      Map<String, String> albumMap = JsonPath.read(json, "$.album[" + i + "]");
      Album album = parseIndividualAlbum(albumMap);
      try {
        album.setAlbumUrl(
            "/web" + ServiceContextThreadLocal.getServiceContext().getScopeGroup().getFriendlyURL()
                + "/album/" + album.getAlbumId() + "-" + album.getName());
      } catch (PortalException e) {
        LOG.error("Failed to get Group", e);
      }
      albums.add(album);
    }

    return albums;
  }

  @Override
  public Album parseIndividualAlbum(String json) {

    Album album = new Album();

    album.setAlbumId(Long.valueOf(JsonPath.read(json, "$.idAlbum")));
    album.setYearReleased(Long.valueOf(JsonPath.read(json, "$.intYearReleased")));
    album.setReleaseFormat(JsonPath.read(json, "$.strReleaseFormat"));
    album.setDescription(JsonPath.read(json, "$.strDescriptionEN"));
    album.setName(JsonPath.read(json, "$.strAlbum"));
    album.setGenre(JsonPath.read(json, "$.strGenre"));
    album.setStyle(JsonPath.read(json, "$.strStyle"));
    album.setLabel(JsonPath.read(json, "$.strLabel"));
    album.setAlbumThumbUrl(JsonPath.read(json, "$.strAlbumThumb"));

    album.setUserName("test");
    album.setCreateDate(new Date());
    album.setModifiedDate(new Date());

    return album;
  }

  @Override
  public Album parseIndividualAlbum(Map<String, String> map) {

    Album album = new Album();

    album.setAlbumId(Long.valueOf(map.get("idAlbum")));
    album.setYearReleased(Long.valueOf(map.get("intYearReleased")));
    album.setReleaseFormat(map.get("strReleaseFormat"));
    album.setDescription(map.get("strDescriptionEN"));
    album.setName(map.get("strAlbum"));
    album.setGenre(map.get("strGenre"));
    album.setStyle(map.get("strStyle"));
    album.setLabel(map.get("strLabel"));
    album.setAlbumThumbUrl(map.get("strAlbumThumb"));

    album.setUserName("test");
    album.setCreateDate(new Date());
    album.setModifiedDate(new Date());

    return album;
  }
}
