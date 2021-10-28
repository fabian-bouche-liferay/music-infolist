package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.item.InfoItemClassDetails;
import com.liferay.info.item.InfoItemDetails;
import com.liferay.info.item.InfoItemReference;
import com.liferay.info.item.provider.InfoItemDetailsProvider;
import com.liferay.samples.fbo.audiodb.infolist.model.Track;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = Constants.SERVICE_RANKING + ":Integer=10",
		service = InfoItemDetailsProvider.class
	)
public class TrackInfoItemDetailsProvider implements InfoItemDetailsProvider<Track> {

	@Override
	public InfoItemClassDetails getInfoItemClassDetails() {
		return new InfoItemClassDetails(Track.class.getName());
	}

	@Override
	public InfoItemDetails getInfoItemDetails(Track track) {
		return new InfoItemDetails(
				getInfoItemClassDetails(),
				new InfoItemReference(
					Track.class.getName(),
					track.getTrackId()));
	}

}