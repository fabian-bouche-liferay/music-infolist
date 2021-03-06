package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.list.provider.InfoListProvider;
import com.liferay.info.list.provider.InfoListProviderContext;
import com.liferay.info.pagination.Pagination;
import com.liferay.info.sort.Sort;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.samples.fbo.audiodb.infolist.model.Album;
import com.liferay.samples.fbo.audiodb.service.AlbumService;
import com.liferay.samples.fbo.audiodb.service.ArtistService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = InfoListProvider.class)
public class AlbumInfoListProvider implements InfoListProvider<Album> {

	private final static Logger LOG = LoggerFactory.getLogger(AlbumInfoListProvider.class);
	
	@Override
	public List<Album> getInfoList(InfoListProviderContext infoListProviderContext) {

		LOG.debug("GetInfoList Albums");

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		LOG.debug("Current URL {}", serviceContext.getCurrentURL());
		
		if(serviceContext.getCurrentURL().contains("p_p_id=com_liferay_layout_content_page_editor_web_internal_portlet_ContentPageEditorPortlet")
				|| serviceContext.getCurrentURL().contains("p_l_mode=preview")) {
			return new ArrayList<Album>();
		}
		
		long groupId = serviceContext.getScopeGroupId();
		String[] split = serviceContext.getCurrentURL().split("/");
		String artistName = split[split.length-1];
		
		long artistId = _artistService.fetchArtist(artistName, groupId).getArtistId();

		LOG.debug("ArtistId {}", artistId);
			
		List<Album> albums = _albumService.getAlbums(artistId);
		
		LOG.debug("Found {} albums", albums.size());
		
		return albums;
	}

	@Override
	public List<Album> getInfoList(InfoListProviderContext infoListProviderContext, Pagination pagination, Sort sort) {
		return getInfoList(infoListProviderContext);
	}

	@Override
	public int getInfoListCount(InfoListProviderContext infoListProviderContext) {
		return getInfoList(infoListProviderContext).size();
	}

	@Override
	public String getLabel(Locale locale) {
		return "ALBUMS_PROVIDER";
	}
	
	@Reference
	private AlbumService _albumService;

	@Reference
	private ArtistService _artistService;

}
