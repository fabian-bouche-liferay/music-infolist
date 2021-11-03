package com.liferay.samples.fbo.audiodb.service;

import com.jayway.jsonpath.JsonPath;
import com.liferay.samples.fbo.audiodb.infolist.model.Artist;

import java.util.Date;

public class ArtistJsonParserUtil {

	public static Artist parse(String json) {
		
		Artist artist = new Artist();
		
		artist.setArtistId(Long.valueOf(JsonPath.read(json, "$.artists[0].idArtist")));
		artist.setName(JsonPath.read(json, "$.artists[0].strArtist"));
		if(JsonPath.read(json, "$.artists[0].strBiographyEN") != null) {
			artist.setBiography(JsonPath.read(json, "$.artists[0].strBiographyEN"));
		} else {
			artist.setBiography("n/a");
		}
		if(JsonPath.read(json, "$.artists[0].strCountry") != null) {
			artist.setCountry(JsonPath.read(json, "$.artists[0].strCountry"));
		} else {
			artist.setCountry("n/a");
		}
		if(JsonPath.read(json, "$.artists[0].strGenre") != null) {
			artist.setGenre(JsonPath.read(json, "$.artists[0].strGenre"));
		} else {
			artist.setGenre("n/a");
		}
		if(JsonPath.read(json, "$.artists[0].strStyle") != null) {
			artist.setStyle(JsonPath.read(json, "$.artists[0].strStyle"));
		} else {
			artist.setStyle("n/a");
		}
		if(JsonPath.read(json, "$.artists[0].strLabel") != null) {
			artist.setLabel(JsonPath.read(json, "$.artists[0].strLabel"));
		} else {
			artist.setLabel("n/a");
		}
		artist.setLogoUrl(JsonPath.read(json, "$.artists[0].strArtistLogo"));
		artist.setThumbUrl(JsonPath.read(json, "$.artists[0].strArtistThumb"));

		artist.setUserName("test");
		artist.setCreateDate(new Date());
		artist.setModifiedDate(new Date());
		
		return artist;
		
	}
	
}
