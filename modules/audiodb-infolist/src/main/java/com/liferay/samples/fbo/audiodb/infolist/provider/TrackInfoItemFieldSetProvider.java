package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.field.InfoFieldSet;
import com.liferay.info.localized.InfoLocalizedValue;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		service = TrackInfoItemFieldSetProvider.class
		)
public class TrackInfoItemFieldSetProvider {

	public InfoFieldSet getInfoFieldSet() {
		return InfoFieldSet.builder()
				.infoFieldSetEntry(TrackInfoItemFields.trackIdInfoField)
				.infoFieldSetEntry(TrackInfoItemFields.trackNumberInfoField)
				.infoFieldSetEntry(TrackInfoItemFields.trackDescriptionInfoField)
				.infoFieldSetEntry(TrackInfoItemFields.albumIdInfoField)
				.infoFieldSetEntry(TrackInfoItemFields.albumNameInfoField)
				.infoFieldSetEntry(TrackInfoItemFields.albumUrlInfoField)
				.infoFieldSetEntry(TrackInfoItemFields.nameInfoField)
				.infoFieldSetEntry(TrackInfoItemFields.genreInfoField)
				.infoFieldSetEntry(TrackInfoItemFields.styleInfoField)
				.infoFieldSetEntry(TrackInfoItemFields.urlInfoField)
				.infoFieldSetEntry(TrackInfoItemFields.userNameInfoField)
				.infoFieldSetEntry(TrackInfoItemFields.createDateInfoField)
				.infoFieldSetEntry(TrackInfoItemFields.modifiedDateInfoField)
				.infoFieldSetEntry(TrackInfoItemFields.artistNameInfoField)
				.infoFieldSetEntry(TrackInfoItemFields.artistUrlInfoField)
				.infoFieldSetEntry(TrackInfoItemFields.trackDurationInfoField)
				.infoFieldSetEntry(TrackInfoItemFields.musicVideoUrlInfoField)
				.labelInfoLocalizedValue(InfoLocalizedValue.localize(getClass(), "track"))
				.name("track")
				.build();
	}
	
}
