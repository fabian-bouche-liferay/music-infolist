package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.layout.display.page.LayoutDisplayPageObjectProvider;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.samples.fbo.audiodb.infolist.model.Track;

import java.util.Locale;

public class TrackLayoutDisplayPageObjectProvider implements LayoutDisplayPageObjectProvider<Track> {

	public TrackLayoutDisplayPageObjectProvider(
			Track track, Portal portal) {

			_track = track;
			_portal = portal;

	}
	
	@Override
	public long getClassNameId() {
		return _portal.getClassNameId(Track.class.getName());
	}

	@Override
	public long getClassPK() {
		return _track.getTrackId();
	}

	@Override
	public long getClassTypeId() {
		return 0;
	}

	@Override
	public String getDescription(Locale locale) {
		return _track.getTrackDescription();
	}

	@Override
	public Track getDisplayObject() {
		return _track;
	}

	@Override
	public long getGroupId() {

		return _track.getGroupId();
	}

	@Override
	public String getKeywords(Locale locale) {
		return null;
	}

	@Override
	public String getTitle(Locale locale) {
		return _track.getName();
	}

	@Override
	public String getURLTitle(Locale locale) {
		return _track.getName();
	}

	private final Portal _portal;
	private final Track _track;
	
}
