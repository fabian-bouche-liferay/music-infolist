package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.layout.display.page.LayoutDisplayPageObjectProvider;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.samples.fbo.audiodb.infolist.model.Album;

import java.util.Locale;

public class AlbumLayoutDisplayPageObjectProvider implements LayoutDisplayPageObjectProvider<Album> {

	public AlbumLayoutDisplayPageObjectProvider(
			Album album, Portal portal) {

			_album = album;
			_portal = portal;

	}
	
	@Override
	public long getClassNameId() {
		return _portal.getClassNameId(Album.class.getName());
	}

	@Override
	public long getClassPK() {
		return _album.getAlbumId();
	}

	@Override
	public long getClassTypeId() {
		return 0;
	}

	@Override
	public String getDescription(Locale locale) {
		return _album.getDescription();
	}

	@Override
	public Album getDisplayObject() {
		return _album;
	}

	@Override
	public long getGroupId() {

		return _album.getGroupId();
	}

	@Override
	public String getKeywords(Locale locale) {
		return null;
	}

	@Override
	public String getTitle(Locale locale) {
		return _album.getName();
	}

	@Override
	public String getURLTitle(Locale locale) {
		return _album.getName();
	}

	private final Portal _portal;
	private final Album _album;
	
}
