package com.liferay.samples.fbo.audiodb.infolist.model;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.model.ClassedModel;

import java.io.Serializable;
import java.util.Date;

public class Album implements ClassedModel {

	private long albumId;
	
	private String name;
	private String label;
	private String style;
	private String genre;
	private String description;
	private long yearReleased;
	private String releaseFormat;
	private String albumThumbUrl;

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
		return Album.class;
	}

	@Override
	public String getModelClassName() {
		return Album.class.getName();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return albumId;
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

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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

	public long getYearReleased() {
		return yearReleased;
	}

	public void setYearReleased(long yearReleased) {
		this.yearReleased = yearReleased;
	}

	public String getReleaseFormat() {
		return releaseFormat;
	}

	public void setReleaseFormat(String releaseFormat) {
		this.releaseFormat = releaseFormat;
	}

	public String getAlbumThumbUrl() {
		return albumThumbUrl;
	}

	public void setAlbumThumbUrl(String albumThumbUrl) {
		this.albumThumbUrl = albumThumbUrl;
	}

	public String getDescription() {
		return description;
	}

	public String getShortDescription() {
		if(description.length() > 497) {
			return description.substring(0, 497).concat("...");
		} else {
			return description;
		}
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	
	
}
