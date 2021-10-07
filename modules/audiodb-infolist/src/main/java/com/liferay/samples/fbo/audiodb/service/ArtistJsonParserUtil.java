package com.liferay.samples.fbo.audiodb.service;

import com.jayway.jsonpath.JsonPath;
import com.liferay.samples.fbo.audiodb.infolist.model.Artist;

import java.util.Date;

public class ArtistJsonParserUtil {

	public static Artist parse(String json) {
		
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
