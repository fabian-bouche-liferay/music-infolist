package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.item.InfoItemReference;
import com.liferay.layout.display.page.LayoutDisplayPageObjectProvider;
import com.liferay.layout.display.page.LayoutDisplayPageProvider;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.samples.fbo.audiodb.infolist.model.Track;
import com.liferay.samples.fbo.audiodb.service.TrackService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
		immediate = true,
		service = LayoutDisplayPageProvider.class
)
public class TrackLayoutDisplayPageProvider implements LayoutDisplayPageProvider<Track> {

	private final static Logger LOG = LoggerFactory.getLogger(TrackLayoutDisplayPageProvider.class);
	
	@Override
	public String getClassName() {
		return Track.class.getName();
	}

	@Override
	public LayoutDisplayPageObjectProvider<Track> getLayoutDisplayPageObjectProvider(
			InfoItemReference infoItemReference) {

		LOG.debug("Reference {}", infoItemReference.getClassPK());
		
		Track track = _trackService.fetchTrack(
				infoItemReference.getClassPK());
		
		if (track != null) {
			return new TrackLayoutDisplayPageObjectProvider(
				track, _portal);
		}
		
		return null;
	}

	@Override
	public LayoutDisplayPageObjectProvider<Track> getLayoutDisplayPageObjectProvider(long groupId, String urlTitle) {

		LOG.debug("GroupId {}, urlTitle {}", groupId, urlTitle);
		
		Track track = _trackService.fetchTrack(urlTitle, groupId);
		
		if (track != null) {

			LOG.debug("Found {}", track.getName());

			return new TrackLayoutDisplayPageObjectProvider(
				track, _portal);
		}

		LOG.debug("Found nothing");

		return null;
	}

	@Override
	public String getURLSeparator() {
		return "/track/";
	}
	
	@Reference
	private Portal _portal;
	
	@Reference
	private TrackService _trackService;

	@Reference
	private GroupLocalService _groupLocalService;

}
