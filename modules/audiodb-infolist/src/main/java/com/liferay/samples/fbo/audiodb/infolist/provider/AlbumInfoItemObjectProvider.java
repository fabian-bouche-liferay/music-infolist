package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.exception.NoSuchInfoItemException;
import com.liferay.info.item.ClassPKInfoItemIdentifier;
import com.liferay.info.item.GroupUrlTitleInfoItemIdentifier;
import com.liferay.info.item.InfoItemIdentifier;
import com.liferay.info.item.provider.InfoItemObjectProvider;
import com.liferay.samples.fbo.audiodb.infolist.model.Album;
import com.liferay.samples.fbo.audiodb.service.AlbumService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
		immediate = true,
		property = "service.ranking:Integer=100",
		service = InfoItemObjectProvider.class
	)
public class AlbumInfoItemObjectProvider implements InfoItemObjectProvider<Album> {

	private final static Logger LOG = LoggerFactory.getLogger(AlbumInfoItemObjectProvider.class);
	
	@Override
	public Album getInfoItem(long albumId) throws NoSuchInfoItemException {

		LOG.debug("getInfoItem {}", albumId);

		return _albumService.fetchAlbum(albumId);
	}
	
	@Override
	public Album getInfoItem(InfoItemIdentifier infoItemIdentifier)
		throws NoSuchInfoItemException {

		LOG.debug("getInfoItem");
		
		if (!(infoItemIdentifier instanceof ClassPKInfoItemIdentifier) &&
			!(infoItemIdentifier instanceof GroupUrlTitleInfoItemIdentifier)) {

			throw new NoSuchInfoItemException("Invalid infoItemIdentifier");
		}

		Album album = null;

		if (infoItemIdentifier instanceof ClassPKInfoItemIdentifier) {
			ClassPKInfoItemIdentifier classPKInfoItemIdentifier =
				(ClassPKInfoItemIdentifier)infoItemIdentifier;

			album = _albumService.fetchAlbum(
				classPKInfoItemIdentifier.getClassPK());
		}
		else if (infoItemIdentifier instanceof
					GroupUrlTitleInfoItemIdentifier) {

			GroupUrlTitleInfoItemIdentifier groupUrlTitleInfoItemIdentifier =
				(GroupUrlTitleInfoItemIdentifier)infoItemIdentifier;

			album = _albumService.fetchAlbum(
				groupUrlTitleInfoItemIdentifier.getUrlTitle(), groupUrlTitleInfoItemIdentifier.getGroupId());
		}

		if (album == null) {
			throw new NoSuchInfoItemException("Invalid infoItemIdentifier");
		}

		return album;
	}

	@Reference
	private AlbumService _albumService;
	
}