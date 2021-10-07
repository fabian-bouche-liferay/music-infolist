package com.liferay.samples.fbo.audiodb.service;

import com.liferay.samples.fbo.audiodb.infolist.model.Artist;

import java.util.List;

public interface ArtistService {

	public List<Artist> getArtists();
	
	public Artist fetchArtist(long artistId);
	
	public Artist fetchArtist(String urlTitle, long groupId);
	
}
