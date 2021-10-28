package com.liferay.samples.fbo.audiodb.service;

import com.liferay.samples.fbo.audiodb.infolist.model.Track;

import java.util.List;

public interface TrackService {

	public List<Track> getTracks(long trackId);
	
	public Track fetchTrack(long trackId);
	
	public Track fetchTrack(String urlTitle, long groupId);
	
}
