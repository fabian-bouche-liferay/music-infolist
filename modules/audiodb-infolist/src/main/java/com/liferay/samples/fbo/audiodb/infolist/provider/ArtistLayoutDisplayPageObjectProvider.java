package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.layout.display.page.LayoutDisplayPageObjectProvider;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.samples.fbo.audiodb.infolist.model.Artist;

import java.util.Locale;

public class ArtistLayoutDisplayPageObjectProvider implements LayoutDisplayPageObjectProvider<Artist> {

	public ArtistLayoutDisplayPageObjectProvider(
			Artist artist, Portal portal) {

			_artist = artist;
			_portal = portal;

	}
	
	@Override
	public long getClassNameId() {
		return _portal.getClassNameId(Artist.class.getName());
	}

	@Override
	public long getClassPK() {
		return _artist.getArtistId();
	}

	@Override
	public long getClassTypeId() {
		return 0;
	}

	@Override
	public String getDescription(Locale locale) {
		return _artist.getBiography();
	}

	@Override
	public Artist getDisplayObject() {
		return _artist;
	}

	@Override
	public long getGroupId() {

		return _artist.getGroupId();
	}

	@Override
	public String getKeywords(Locale locale) {
		return null;
	}

	@Override
	public String getTitle(Locale locale) {
		return _artist.getName();
	}

	@Override
	public String getURLTitle(Locale locale) {
		return _artist.getName();
	}

	private final Portal _portal;
	private final Artist _artist;
	
}
