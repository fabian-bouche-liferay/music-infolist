package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.list.provider.InfoListProvider;
import com.liferay.info.list.provider.InfoListProviderContext;
import com.liferay.info.pagination.Pagination;
import com.liferay.info.sort.Sort;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.samples.fbo.audiodb.infolist.model.Track;
import com.liferay.samples.fbo.audiodb.service.AlbumService;
import com.liferay.samples.fbo.audiodb.service.ArtistService;
import com.liferay.samples.fbo.audiodb.service.TrackService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = InfoListProvider.class)
public class TrackInfoListProvider implements InfoListProvider<Track> {

	private final static Logger LOG = LoggerFactory.getLogger(TrackInfoListProvider.class);
	
	@Override
	public List<Track> getInfoList(InfoListProviderContext infoListProviderContext) {

		LOG.debug("GetInfoList Tracks");

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		LOG.debug("Current URL {}", serviceContext.getCurrentURL());
		
		if(serviceContext.getCurrentURL().contains("p_p_id=com_liferay_layout_content_page_editor_web_internal_portlet_ContentPageEditorPortlet")
				|| serviceContext.getCurrentURL().contains("p_l_mode=preview")) {
			return new ArrayList<Track>();
		}
		
		long groupId = serviceContext.getScopeGroupId();
		String[] split = serviceContext.getCurrentURL().split("/");
		long albumId = Long.valueOf(split[split.length-1].split("-")[0]);
		
		LOG.debug("AlbumId {}", albumId);
			
		List<Track> tracks = _trackService.getTracks(albumId);
		
		LOG.debug("Found {} tracks", tracks.size());
		
		return tracks;
	}

	@Override
	public List<Track> getInfoList(InfoListProviderContext infoListProviderContext, Pagination pagination, Sort sort) {
		return getInfoList(infoListProviderContext);
	}

	@Override
	public int getInfoListCount(InfoListProviderContext infoListProviderContext) {
		return getInfoList(infoListProviderContext).size();
	}

	@Override
	public String getLabel(Locale locale) {
		return "TRACKS_PROVIDER";
	}

	@Reference
	private TrackService _trackService;

}
