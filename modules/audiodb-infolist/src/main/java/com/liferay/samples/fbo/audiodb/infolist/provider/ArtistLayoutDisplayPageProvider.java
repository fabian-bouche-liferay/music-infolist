package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.item.InfoItemReference;
import com.liferay.layout.display.page.LayoutDisplayPageObjectProvider;
import com.liferay.layout.display.page.LayoutDisplayPageProvider;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.samples.fbo.audiodb.infolist.model.Artist;
import com.liferay.samples.fbo.audiodb.service.ArtistService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
		immediate = true,
		service = LayoutDisplayPageProvider.class
)
public class ArtistLayoutDisplayPageProvider implements LayoutDisplayPageProvider<Artist> {

	private final static Logger LOG = LoggerFactory.getLogger(ArtistLayoutDisplayPageProvider.class);
	
	@Override
	public String getClassName() {
		return Artist.class.getName();
	}

	@Override
	public LayoutDisplayPageObjectProvider<Artist> getLayoutDisplayPageObjectProvider(
			InfoItemReference infoItemReference) {

		LOG.debug("Reference {}", infoItemReference.getClassPK());
		
		Artist artist = _artistService.fetchArtist(
				infoItemReference.getClassPK());
		
		if (artist != null) {
			return new ArtistLayoutDisplayPageObjectProvider(
				artist, _portal);
		}
		
		return null;
	}

	@Override
	public LayoutDisplayPageObjectProvider<Artist> getLayoutDisplayPageObjectProvider(long groupId, String urlTitle) {

		LOG.debug("GroupId {}, urlTitle {}", groupId, urlTitle);
		
		Artist artist = _artistService.fetchArtist(urlTitle, groupId);
		
		if (artist != null) {
			return new ArtistLayoutDisplayPageObjectProvider(
				artist, _portal);
		}
		
		return null;
	}

	@Override
	public String getURLSeparator() {
		return "/artist/";
	}
	
	@Reference
	private Portal _portal;
	
	@Reference
	private ArtistService _artistService;

	@Reference
	private GroupLocalService _groupLocalService;

}
