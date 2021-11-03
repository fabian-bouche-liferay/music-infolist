package com.liferay.samples.fbo.audiodb.service;

import com.jayway.jsonpath.JsonPath;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.samples.fbo.audiodb.infolist.model.Track;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minidev.json.JSONArray;

public class TrackJsonParserUtil {

	private final static Logger LOG = LoggerFactory.getLogger(TrackJsonParserUtil.class);
	
	public static Track parseTrack(String json) {
		
		LOG.debug("Parsing {}", json);
		
		Track track = parseIndividualTrack(JsonPath.read(json, "$.track[0]"));

		LOG.debug("Found {}", track.getName());

		return track;
		
	}
	
	public static List<Track> parseTracks(String json) {
		
		List<Track> tracks = new ArrayList<>();

		LOG.debug("Tracks json: {}", json);
		
		int nbTracks = ((JSONArray)JsonPath.read(json, "$.track[*]")).size();
		
		LOG.debug("Tracks count: {}", nbTracks);
		
		for(int i = 0; i < nbTracks; i++) {
			Map<String, String> trackMap = JsonPath.read(json, "$.track[" + i + "]");
			Track track = parseIndividualTrack(trackMap);
			try {
				track.setAlbumUrl("/web" + ServiceContextThreadLocal.getServiceContext().getScopeGroup().getFriendlyURL() + "/album/" + track.getAlbumId() + "-" + track.getAlbumName().replace(" ",  "-"));
				track.setArtistUrl("/web" + ServiceContextThreadLocal.getServiceContext().getScopeGroup().getFriendlyURL() + "/artist/" + track.getArtistName());
				track.setTrackUrl("/web" + ServiceContextThreadLocal.getServiceContext().getScopeGroup().getFriendlyURL() + "/track/" + track.getTrackId() + "-" + track.getName().replace(" ",  "-"));
			} catch (PortalException e) {
				LOG.error("Failed to get Group", e);
			}
			tracks.add(track);
		}
		
		return tracks;
		
	}	

	private static Track parseIndividualTrack(Map<String, String> map) {
		
		Track track = new Track();
		
		track.setTrackId(Long.valueOf(map.get("idTrack")));
		track.setTrackNumber(Long.valueOf(map.get("intTrackNumber")));
		track.setAlbumId(Long.valueOf(map.get("idAlbum")));
		track.setAlbumName(map.get("strAlbum"));
		track.setName(map.get("strTrack"));
		if(map.get("strGenre") != null) {
			track.setGenre(map.get("strGenre"));
		} else {
			track.setGenre("n/a");
		}
		if(map.get("strStyle") != null) {
			track.setStyle(map.get("strStyle"));
		} else {
			track.setStyle("n/a");
		}
		if(map.get("strDescriptionEN") != null) {
			track.setTrackDescription(map.get("strDescriptionEN"));
		} else {
			track.setTrackDescription("n/a");
		}
		
		if(map.get("strMusicVid") != null) {
			track.setMusicVideoUrl(map.get("strMusicVid"));
		} else {
			track.setMusicVideoUrl("");
		}
		
		if(map.get("intDuration") != null) {
			int duration = Integer.parseInt(map.get("intDuration"));
		    String mmss = String.format("%02d:%02d", TimeUnit.MILLISECONDS.toMinutes(duration),
		            TimeUnit.MILLISECONDS.toSeconds(duration) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
			track.setDuration(mmss);
		} else {
			track.setDuration("n/a");
		}
			
		track.setArtistName(map.get("strArtist"));

		track.setUserName("test");
		track.setCreateDate(new Date());
		track.setModifiedDate(new Date());

		return track;
		
	}	
	
}
