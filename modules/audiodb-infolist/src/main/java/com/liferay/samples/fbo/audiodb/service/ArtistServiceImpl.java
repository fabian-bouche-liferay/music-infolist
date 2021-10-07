package com.liferay.samples.fbo.audiodb.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.samples.fbo.audiodb.infolist.model.Album;
import com.liferay.samples.fbo.audiodb.infolist.model.Artist;

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
		service = ArtistService.class
		)
public class ArtistServiceImpl implements ArtistService {

	private final static Logger LOG = LoggerFactory.getLogger(ArtistServiceImpl.class);
	
	@Override
	public List<Artist> getArtists() {
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
			return ArtistJsonParserUtil.parse(responseBody);
		} catch (IOException e) {
			LOG.error("Did not find Artist {}", artistId);
		}
		
		artist.setUrl("/artist/" + artist.getName());
		
		return artist;
	}

	@Override
	public Artist fetchArtist(String urlTitle, long groupId) {
		
		Artist artist = fetchArtist(urlTitle.replace("-", " "));
		artist.setGroupId(groupId);

		try {
			artist.setUrl("/web" + _groupLocalService.getGroup(groupId).getFriendlyURL() + "/artist/" + artist.getName().replace(" ", "-"));
		} catch (PortalException e) {
			LOG.error("Failed to get Group {}", groupId, e);
		}

		return artist;
	}

	private Artist fetchArtist(String name) {
		Artist artist = new Artist();

		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
			      .url("https://www.theaudiodb.com/api/v1/json/1/search.php?s=" + name)
			      .build();

		try (Response response = client.newCall(request).execute()) {
			String responseBody = response.body().string();
			artist = ArtistJsonParserUtil.parse(responseBody);
		} catch (IOException e) {
			LOG.error("Did not find Artist {}", name);
		}

		long groupId = ServiceContextThreadLocal.getServiceContext().getScopeGroupId();
		
		try {
			artist.setUrl("/web" + _groupLocalService.getGroup(groupId).getFriendlyURL() + "/artist/" + artist.getName().replace(" ", "-"));
		} catch (PortalException e) {
			LOG.error("Failed to get Group {}", groupId, e);
		}
		
		return artist;
	}

	@Reference
	private GroupLocalService _groupLocalService;

}
