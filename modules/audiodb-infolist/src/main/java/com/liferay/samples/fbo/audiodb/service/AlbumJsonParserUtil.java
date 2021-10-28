package com.liferay.samples.fbo.audiodb.service;

import com.jayway.jsonpath.JsonPath;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.samples.fbo.audiodb.infolist.model.Album;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minidev.json.JSONArray;

public class AlbumJsonParserUtil {

	private final static Logger LOG = LoggerFactory.getLogger(AlbumJsonParserUtil.class);
	
	public static Album parseAlbum(String json) {
		
		Album album = parseIndividualAlbum(JsonPath.read(json, "$.album[0]"));
		
		return album;
		
	}
	
	public static List<Album> parseAlbums(String json) {
		
		List<Album> albums = new ArrayList<Album>();

		LOG.debug("Albums json: {}", json);
		
		int nbAlbums = ((JSONArray)JsonPath.read(json, "$.album[*]")).size();
		
		LOG.debug("Albums count: {}", nbAlbums);
		
		for(int i = 0; i < nbAlbums; i++) {
			Map<String, String> albumMap = JsonPath.read(json, "$.album[" + i + "]");
			Album album = parseIndividualAlbum(albumMap);
			try {
				album.setAlbumUrl("/web" + ServiceContextThreadLocal.getServiceContext().getScopeGroup().getFriendlyURL() + "/album/" + album.getAlbumId() + "-" + album.getName().replace(" ",  "-"));
				album.setArtistUrl("/web" + ServiceContextThreadLocal.getServiceContext().getScopeGroup().getFriendlyURL() + "/artist/" + album.getArtistName());
			} catch (PortalException e) {
				LOG.error("Failed to get Group", e);
			}
			albums.add(album);
		}
		
		return albums;
		
	}	

	private static Album parseIndividualAlbum(Map<String, String> map) {
		
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

		album.setArtistName(map.get("strArtist"));

		album.setUserName("test");
		album.setCreateDate(new Date());
		album.setModifiedDate(new Date());

		return album;
		
	}	
	
}
