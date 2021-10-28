package com.liferay.samples.fbo.audiodb.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.samples.fbo.audiodb.infolist.model.Album;

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
		service = AlbumService.class
		)
public class AlbumServiceImpl implements AlbumService {

	private final static Logger LOG = LoggerFactory.getLogger(AlbumServiceImpl.class);
	
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
			return AlbumJsonParserUtil.parseAlbums(responseBody);
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
			return AlbumJsonParserUtil.parseAlbum(responseBody);
		} catch (IOException e) {
			LOG.error("Did not find Album {}", albumId);
		}
		
		album.setAlbumUrl("/album/" + albumId + "-" + album.getName().replace(" ",  "-"));
		album.setArtistUrl("/artist/" + album.getArtistName());
		
		return album;
	}

	@Override
	public Album fetchAlbum(String urlTitle, long groupId) {
		
		long albumId = Long.valueOf(urlTitle.split("-")[0]);
		
		Album album = fetchAlbum(albumId);
		album.setGroupId(groupId);
		try {
			album.setAlbumUrl("/web" + _groupLocalService.getGroup(groupId).getFriendlyURL() + "/album/" + albumId + "-" + album.getName().replace(" ",  "-"));
			album.setArtistUrl("/web" + ServiceContextThreadLocal.getServiceContext().getScopeGroup().getFriendlyURL() + "/artist/" + album.getArtistName());
		} catch (PortalException e) {
			LOG.error("Failed to get Group {}", groupId, e);
		}
		
		return album;
	}
	
	@Reference
	private GroupLocalService _groupLocalService;
	
}
