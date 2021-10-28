package com.liferay.samples.fbo.audiodb.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.samples.fbo.audiodb.infolist.model.Track;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Component(
		immediate = true,
		service = TrackService.class
		)
public class TrackServiceImpl implements TrackService {

	private final static Logger LOG = LoggerFactory.getLogger(TrackServiceImpl.class);
	
	@Override
	public List<Track> getTracks(long trackId) {
		List<Track> tracks = new ArrayList<Track>();

		LOG.debug("Making request https://theaudiodb.com/api/v1/json/1/track.php?m={}", trackId);
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
			      .url("https://theaudiodb.com/api/v1/json/1/track.php?m=" + trackId)
			      .build();

		try (Response response = client.newCall(request).execute()) {
			String responseBody = response.body().string();
			return TrackJsonParserUtil.parseTracks(responseBody);
		} catch (IOException e) {
			LOG.error("Did not find Track {}", trackId);
		}

		return tracks;
	}

	@Override
	public Track fetchTrack(long trackId) {
		Track track = new Track();
		
		LOG.debug("Making request https://theaudiodb.com/api/v1/json/1/track.php?h={}", trackId);
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
			      .url("https://theaudiodb.com/api/v1/json/1/track.php?h=" + trackId)
			      .build();

		try (Response response = client.newCall(request).execute()) {
			String responseBody = response.body().string();
			return TrackJsonParserUtil.parseTrack(responseBody);
		} catch (IOException e) {
			LOG.error("Did not find Track {}", trackId);
		}
		
		track.setTrackUrl("/track/" + trackId + "-" + track.getName().replace(" ",  "-"));
		track.setAlbumUrl("/album/" + track.getAlbumId() + "-" + track.getAlbumName().replace(" ",  "-"));
		track.setArtistUrl("/artist/" + track.getArtistName());
		
		return track;
	}

	@Override
	public Track fetchTrack(String urlTitle, long groupId) {
		
		long trackId = Long.valueOf(urlTitle.split("-")[0]);
		
		Track track = fetchTrack(trackId);
		track.setGroupId(groupId);
		try {
			track.setTrackUrl("/web" + _groupLocalService.getGroup(groupId).getFriendlyURL() + "/track/" + track.getTrackId() + "-" + track.getName().replace(" ",  "-"));
			track.setAlbumUrl("/web" + _groupLocalService.getGroup(groupId).getFriendlyURL() + "/album/" + track.getAlbumId() + "-" + track.getAlbumName().replace(" ",  "-"));
			track.setArtistUrl("/web" + ServiceContextThreadLocal.getServiceContext().getScopeGroup().getFriendlyURL() + "/artist/" + track.getArtistName());
		} catch (PortalException e) {
			LOG.error("Failed to get Group {}", groupId, e);
		}
		
		return track;
	}
	
	@Reference
	private GroupLocalService _groupLocalService;
	
}
