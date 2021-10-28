package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.field.InfoFieldSet;
import com.liferay.info.localized.InfoLocalizedValue;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		service = AlbumInfoItemFieldSetProvider.class
		)
public class AlbumInfoItemFieldSetProvider {

	public InfoFieldSet getInfoFieldSet() {
		return InfoFieldSet.builder()
				.infoFieldSetEntry(AlbumInfoItemFields.albumIdInfoField)
				.infoFieldSetEntry(AlbumInfoItemFields.nameInfoField)
				.infoFieldSetEntry(AlbumInfoItemFields.descriptionInfoField)
				.infoFieldSetEntry(AlbumInfoItemFields.albumYearReleasedInfoField)
				.infoFieldSetEntry(AlbumInfoItemFields.releaseFormatInfoField)
				.infoFieldSetEntry(AlbumInfoItemFields.genreInfoField)
				.infoFieldSetEntry(AlbumInfoItemFields.styleInfoField)
				.infoFieldSetEntry(AlbumInfoItemFields.labelInfoField)
				.infoFieldSetEntry(AlbumInfoItemFields.thumbUrlInfoField)
				.infoFieldSetEntry(AlbumInfoItemFields.urlInfoField)
				.infoFieldSetEntry(AlbumInfoItemFields.userNameInfoField)
				.infoFieldSetEntry(AlbumInfoItemFields.createDateInfoField)
				.infoFieldSetEntry(AlbumInfoItemFields.modifiedDateInfoField)
				.infoFieldSetEntry(AlbumInfoItemFields.artistNameInfoField)
				.infoFieldSetEntry(AlbumInfoItemFields.artistUrlInfoField)
				.labelInfoLocalizedValue(InfoLocalizedValue.localize(getClass(), "album"))
				.name("album")
				.build();
	}
	
}
