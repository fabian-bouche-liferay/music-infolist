package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.list.provider.InfoListProvider;
import com.liferay.info.list.provider.InfoListProviderContext;
import com.liferay.info.pagination.Pagination;
import com.liferay.info.sort.Sort;
import com.liferay.samples.fbo.audiodb.infolist.model.Artist;
import com.liferay.samples.fbo.audiodb.service.ArtistService;

import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = InfoListProvider.class)
public class ArtistInfoListProvider implements InfoListProvider<Artist> {

	private final static Logger LOG = LoggerFactory.getLogger(ArtistInfoListProvider.class);
	
	@Override
	public List<Artist> getInfoList(InfoListProviderContext infoListProviderContext) {
		
		LOG.debug("GetInfoList Artists");

		return _artistService.getArtists();
	}

	@Override
	public List<Artist> getInfoList(InfoListProviderContext infoListProviderContext, Pagination pagination, Sort sort) {
		return getInfoList(infoListProviderContext);
	}

	@Override
	public int getInfoListCount(InfoListProviderContext infoListProviderContext) {
		return getInfoList(infoListProviderContext).size();
	}

	@Override
	public String getLabel(Locale locale) {
		return "ARTISTS_PROVIDER";
	}
	
	@Reference
	private ArtistService _artistService;
	
}
