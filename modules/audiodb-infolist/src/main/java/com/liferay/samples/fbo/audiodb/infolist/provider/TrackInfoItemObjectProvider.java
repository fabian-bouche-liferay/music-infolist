package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.exception.NoSuchInfoItemException;
import com.liferay.info.item.ClassPKInfoItemIdentifier;
import com.liferay.info.item.GroupUrlTitleInfoItemIdentifier;
import com.liferay.info.item.InfoItemIdentifier;
import com.liferay.info.item.provider.InfoItemObjectProvider;
import com.liferay.samples.fbo.audiodb.infolist.model.Track;
import com.liferay.samples.fbo.audiodb.service.TrackService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
		immediate = true,
		property = "service.ranking:Integer=100",
		service = InfoItemObjectProvider.class
	)
public class TrackInfoItemObjectProvider implements InfoItemObjectProvider<Track> {

	private final static Logger LOG = LoggerFactory.getLogger(TrackInfoItemObjectProvider.class);
	
	@Override
	public Track getInfoItem(long trackId) throws NoSuchInfoItemException {

		LOG.debug("getInfoItem {}", trackId);

		return _trackService.fetchTrack(trackId);
	}
	
	@Override
	public Track getInfoItem(InfoItemIdentifier infoItemIdentifier)
		throws NoSuchInfoItemException {

		LOG.debug("getInfoItem");
		
		if (!(infoItemIdentifier instanceof ClassPKInfoItemIdentifier) &&
			!(infoItemIdentifier instanceof GroupUrlTitleInfoItemIdentifier)) {

			throw new NoSuchInfoItemException("Invalid infoItemIdentifier");
		}

		Track track = null;

		if (infoItemIdentifier instanceof ClassPKInfoItemIdentifier) {
			ClassPKInfoItemIdentifier classPKInfoItemIdentifier =
				(ClassPKInfoItemIdentifier)infoItemIdentifier;

			track = _trackService.fetchTrack(
				classPKInfoItemIdentifier.getClassPK());
		}
		else if (infoItemIdentifier instanceof
					GroupUrlTitleInfoItemIdentifier) {

			GroupUrlTitleInfoItemIdentifier groupUrlTitleInfoItemIdentifier =
				(GroupUrlTitleInfoItemIdentifier)infoItemIdentifier;

			track = _trackService.fetchTrack(
				groupUrlTitleInfoItemIdentifier.getUrlTitle(), groupUrlTitleInfoItemIdentifier.getGroupId());
		}

		if (track == null) {
			throw new NoSuchInfoItemException("Invalid infoItemIdentifier");
		}

		return track;
	}

	@Reference
	private TrackService _trackService;
	
}