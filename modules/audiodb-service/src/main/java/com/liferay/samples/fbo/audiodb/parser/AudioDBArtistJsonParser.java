package com.liferay.samples.fbo.audiodb.parser;

import com.jayway.jsonpath.JsonPath;
import com.liferay.samples.fbo.music.api.ArtistJsonParser;
import com.liferay.samples.fbo.music.api.model.Artist;
import java.util.Date;
import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "type=audiodb"
    },
    service = ArtistJsonParser.class
)
public class AudioDBArtistJsonParser
    implements ArtistJsonParser {

  @Override
  public Artist parse(String json) {

    Artist artist = new Artist();

    artist.setArtistId(Long.valueOf(JsonPath.read(json, "$.artists[0].idArtist")));
    artist.setName(JsonPath.read(json, "$.artists[0].strArtist"));
    artist.setBiography(JsonPath.read(json, "$.artists[0].strBiographyEN"));
    artist.setCountry(JsonPath.read(json, "$.artists[0].strCountry"));
    artist.setGenre(JsonPath.read(json, "$.artists[0].strGenre"));
    artist.setStyle(JsonPath.read(json, "$.artists[0].strStyle"));
    artist.setLabel(JsonPath.read(json, "$.artists[0].strLabel"));
    artist.setLogoUrl(JsonPath.read(json, "$.artists[0].strArtistLogo"));
    artist.setThumbUrl(JsonPath.read(json, "$.artists[0].strArtistThumb"));

    artist.setUserName("test");
    artist.setCreateDate(new Date());
    artist.setModifiedDate(new Date());

    return artist;
  }
}
