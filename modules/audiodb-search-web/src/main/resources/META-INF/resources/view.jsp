<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.samples.fbo.music.api.model.Artist" %>
<%@ include file="/init.jsp" %>

<%
    boolean matchArtist = GetterUtil.getBoolean(request.getAttribute("matchArtist"), false);
    Artist artist = (Artist) request.getAttribute("artist");
%>

<c:if test="<%= matchArtist %>">
    <h1>
        <%= artist.getName()%>
    </h1>
    <img src="<%= artist.getThumbUrl() %>"
         alt="Photo of <%= artist.getName() %>"
         class="img-thumbnail"
    />
    <p>
        <%= artist.getBiography()%>
    </p>
</c:if>