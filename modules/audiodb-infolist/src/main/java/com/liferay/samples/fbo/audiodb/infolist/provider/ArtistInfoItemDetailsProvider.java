package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.item.InfoItemClassDetails;
import com.liferay.info.item.InfoItemDetails;
import com.liferay.info.item.InfoItemReference;
import com.liferay.info.item.provider.InfoItemDetailsProvider;
import com.liferay.samples.fbo.audiodb.infolist.model.Artist;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = Constants.SERVICE_RANKING + ":Integer=10",
		service = InfoItemDetailsProvider.class
	)
public class ArtistInfoItemDetailsProvider implements InfoItemDetailsProvider<Artist> {

	@Override
	public InfoItemClassDetails getInfoItemClassDetails() {
		return new InfoItemClassDetails(Artist.class.getName());
	}

	@Override
	public InfoItemDetails getInfoItemDetails(Artist artist) {
		return new InfoItemDetails(
				getInfoItemClassDetails(),
				new InfoItemReference(
					Artist.class.getName(),
					artist.getArtistId()));
	}

}