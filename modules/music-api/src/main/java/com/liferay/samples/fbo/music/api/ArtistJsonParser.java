package com.liferay.samples.fbo.music.api;

import com.liferay.samples.fbo.music.api.model.Artist;

public interface ArtistJsonParser {

  Artist parse(String json);

}
