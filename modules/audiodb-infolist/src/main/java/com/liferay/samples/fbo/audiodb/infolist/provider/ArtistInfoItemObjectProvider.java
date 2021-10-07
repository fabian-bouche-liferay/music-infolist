package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.exception.NoSuchInfoItemException;
import com.liferay.info.item.ClassPKInfoItemIdentifier;
import com.liferay.info.item.GroupUrlTitleInfoItemIdentifier;
import com.liferay.info.item.InfoItemIdentifier;
import com.liferay.info.item.provider.InfoItemObjectProvider;
import com.liferay.samples.fbo.audiodb.infolist.model.Artist;
import com.liferay.samples.fbo.audiodb.service.ArtistService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
		immediate = true,
		property = "service.ranking:Integer=100",
		service = InfoItemObjectProvider.class
	)
public class ArtistInfoItemObjectProvider implements InfoItemObjectProvider<Artist> {

	private final static Logger LOG = LoggerFactory.getLogger(ArtistInfoItemObjectProvider.class);
	
	@Override
	public Artist getInfoItem(long artistId) throws NoSuchInfoItemException {

		LOG.debug("getInfoItem {}", artistId);

		return _artistService.fetchArtist(artistId);
	}
	
	@Override
	public Artist getInfoItem(InfoItemIdentifier infoItemIdentifier)
		throws NoSuchInfoItemException {

		LOG.debug("getInfoItem");
		
		if (!(infoItemIdentifier instanceof ClassPKInfoItemIdentifier) &&
			!(infoItemIdentifier instanceof GroupUrlTitleInfoItemIdentifier)) {

			throw new NoSuchInfoItemException("Invalid infoItemIdentifier");
		}

		Artist artist = null;

		if (infoItemIdentifier instanceof ClassPKInfoItemIdentifier) {
			ClassPKInfoItemIdentifier classPKInfoItemIdentifier =
				(ClassPKInfoItemIdentifier)infoItemIdentifier;

			artist = _artistService.fetchArtist(
				classPKInfoItemIdentifier.getClassPK());
		}
		else if (infoItemIdentifier instanceof
					GroupUrlTitleInfoItemIdentifier) {

			GroupUrlTitleInfoItemIdentifier groupUrlTitleInfoItemIdentifier =
				(GroupUrlTitleInfoItemIdentifier)infoItemIdentifier;

			artist = _artistService.fetchArtist(
				groupUrlTitleInfoItemIdentifier.getUrlTitle(), groupUrlTitleInfoItemIdentifier.getGroupId());
		}

		if (artist == null) {
			throw new NoSuchInfoItemException("Invalid infoItemIdentifier");
		}

		return artist;
	}

	@Reference
	private ArtistService _artistService;
	
}