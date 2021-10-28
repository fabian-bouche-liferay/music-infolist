package com.liferay.samples.fbo.audiodb.infolist.model;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ClassedModel;

import java.io.Serializable;
import java.util.Date;

public class Track implements ClassedModel {

	private long trackId;
	private long trackNumber;
	private String trackUrl;
	private String trackDescription;
	
	private String name;
	private String style;
	private String genre;
	private int duration;
	
	private String musicVideoUrl;

	private long albumId;
	private String albumName;
	private String albumUrl;

	private String artistName;
	private String artistUrl;

	private String userName;
	private Date createDate;
	private Date modifiedDate;
	private long groupId;

	@Override
	public ExpandoBridge getExpandoBridge() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Class<?> getModelClass() {
		return Track.class;
	}

	@Override
	public String getModelClassName() {
		return Track.class.getName();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return trackId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
	}

	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getAlbumUrl() {
		return albumUrl;
	}

	public void setAlbumUrl(String albumUrl) {
		this.albumUrl = albumUrl;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getArtistUrl() {
		return artistUrl;
	}

	public void setArtistUrl(String artistUrl) {
		this.artistUrl = artistUrl;
	}

	public long getTrackId() {
		return trackId;
	}

	public void setTrackId(long trackId) {
		this.trackId = trackId;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getMusicVideoUrl() {
		return musicVideoUrl;
	}

	public void setMusicVideoUrl(String musicVideoUrl) {
		this.musicVideoUrl = musicVideoUrl;
	}

	public String getTrackUrl() {
		return trackUrl;
	}

	public void setTrackUrl(String trackUrl) {
		this.trackUrl = trackUrl;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public long getTrackNumber() {
		return trackNumber;
	}

	public void setTrackNumber(long trackNumber) {
		this.trackNumber = trackNumber;
	}

	public String getTrackDescription() {
		return trackDescription;
	}

	public void setTrackDescription(String trackDescription) {
		this.trackDescription = trackDescription;
	}
	
	
}
