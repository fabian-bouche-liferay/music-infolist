package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.item.InfoItemReference;
import com.liferay.layout.display.page.LayoutDisplayPageObjectProvider;
import com.liferay.layout.display.page.LayoutDisplayPageProvider;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.samples.fbo.audiodb.infolist.model.Album;
import com.liferay.samples.fbo.audiodb.service.AlbumService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
		immediate = true,
		service = LayoutDisplayPageProvider.class
)
public class AlbumLayoutDisplayPageProvider implements LayoutDisplayPageProvider<Album> {

	private final static Logger LOG = LoggerFactory.getLogger(AlbumLayoutDisplayPageProvider.class);
	
	@Override
	public String getClassName() {
		return Album.class.getName();
	}

	@Override
	public LayoutDisplayPageObjectProvider<Album> getLayoutDisplayPageObjectProvider(
			InfoItemReference infoItemReference) {

		LOG.debug("Reference {}", infoItemReference.getClassPK());
		
		Album album = _albumService.fetchAlbum(
				infoItemReference.getClassPK());
		
		if (album != null) {
			return new AlbumLayoutDisplayPageObjectProvider(
				album, _portal);
		}
		
		return null;
	}

	@Override
	public LayoutDisplayPageObjectProvider<Album> getLayoutDisplayPageObjectProvider(long groupId, String urlTitle) {

		LOG.debug("GroupId {}, urlTitle {}", groupId, urlTitle);
		
		Album album = _albumService.fetchAlbum(urlTitle, groupId);
		
		if (album != null) {
			return new AlbumLayoutDisplayPageObjectProvider(
				album, _portal);
		}
		
		return null;
	}

	@Override
	public String getURLSeparator() {
		return "/album/";
	}
	
	@Reference
	private Portal _portal;
	
	@Reference
	private AlbumService _albumService;

	@Reference
	private GroupLocalService _groupLocalService;

}
