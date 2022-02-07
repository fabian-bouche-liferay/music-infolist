package com.liferay.samples.fbo.audiodb.search.web;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.web.portlet.shared.search.PortletSharedSearchRequest;
import com.liferay.portal.search.web.portlet.shared.search.PortletSharedSearchResponse;
import com.liferay.samples.fbo.audiodb.search.web.constants.AudioDBSearchWebKeys;
import com.liferay.samples.fbo.music.api.ArtistService;
import com.liferay.samples.fbo.music.api.exception.ArtistNotFoundException;
import com.liferay.samples.fbo.music.api.model.Artist;
import java.io.IOException;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
    immediate = true,
    property = {
        "com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.instanceable=false",
        "javax.portlet.display-name=AudioDB Search Web",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/view.jsp",
        "javax.portlet.name=" + AudioDBSearchWebKeys.PORTLET_ID,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class AudioDBSearchWeb
    extends MVCPortlet {

  @Override
  public void render(RenderRequest renderRequest, RenderResponse renderResponse)
      throws IOException, PortletException {

    PortletSharedSearchResponse searchResponse = _portletSharedSearchRequest.search(renderRequest);
    String searchQuery = searchResponse.getSearchResponse().getRequest().getQueryString();
    renderRequest.setAttribute("matchArtist", false);

    if(Validator.isNotNull(searchQuery)) {
      try {
        Artist artist = artistService.fetchArtist(searchQuery);
        renderRequest.setAttribute("matchArtist", true);
        renderRequest.setAttribute("artist", artist);
      } catch (ArtistNotFoundException e) {
        _log.warn(e.getMessage());
      }
    }

    super.render(renderRequest, renderResponse);
  }

  public static final Logger _log = LoggerFactory.getLogger(AudioDBSearchWeb.class);

  @Reference(target = "(type=audiodb)")
  private ArtistService artistService;

  @Reference
  PortletSharedSearchRequest _portletSharedSearchRequest;

}