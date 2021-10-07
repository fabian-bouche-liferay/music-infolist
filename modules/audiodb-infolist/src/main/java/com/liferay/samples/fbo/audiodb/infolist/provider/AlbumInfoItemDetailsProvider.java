package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.item.InfoItemClassDetails;
import com.liferay.info.item.InfoItemDetails;
import com.liferay.info.item.InfoItemReference;
import com.liferay.info.item.provider.InfoItemDetailsProvider;
import com.liferay.samples.fbo.audiodb.infolist.model.Album;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = Constants.SERVICE_RANKING + ":Integer=10",
		service = InfoItemDetailsProvider.class
	)
public class AlbumInfoItemDetailsProvider implements InfoItemDetailsProvider<Album> {

	@Override
	public InfoItemClassDetails getInfoItemClassDetails() {
		return new InfoItemClassDetails(Album.class.getName());
	}

	@Override
	public InfoItemDetails getInfoItemDetails(Album album) {
		return new InfoItemDetails(
				getInfoItemClassDetails(),
				new InfoItemReference(
					Album.class.getName(),
					album.getAlbumId()));
	}

}