package com.liferay.samples.fbo.audiodb.service;

import com.liferay.samples.fbo.audiodb.infolist.model.Album;

import java.util.List;

public interface AlbumService {

	public List<Album> getAlbums(long artistId);
	
	public Album fetchAlbum(long albumId);
	
	public Album fetchAlbum(String urlTitle, long groupId);
	
}
