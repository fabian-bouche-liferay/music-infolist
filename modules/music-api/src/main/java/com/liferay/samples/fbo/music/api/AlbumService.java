package com.liferay.samples.fbo.music.api;

import com.liferay.samples.fbo.music.api.model.Album;
import java.util.List;

public interface AlbumService {

	List<Album> getAlbums(long artistId);
	
	Album fetchAlbum(long albumId);
	
	Album fetchAlbum(String urlTitle, long groupId);

}
