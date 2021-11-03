package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.field.InfoFieldSet;
import com.liferay.info.localized.InfoLocalizedValue;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		service = ArtistInfoItemFieldSetProvider.class
		)
public class ArtistInfoItemFieldSetProvider {

	public InfoFieldSet getInfoFieldSet() {
		return InfoFieldSet.builder()
				.infoFieldSetEntry(ArtistInfoItemFields.artistIdInfoField)
				.infoFieldSetEntry(ArtistInfoItemFields.nameInfoField)
				.infoFieldSetEntry(ArtistInfoItemFields.biographyInfoField)
				.infoFieldSetEntry(ArtistInfoItemFields.shortBioInfoField)
				.infoFieldSetEntry(ArtistInfoItemFields.countryInfoField)
				.infoFieldSetEntry(ArtistInfoItemFields.genreInfoField)
				.infoFieldSetEntry(ArtistInfoItemFields.styleInfoField)
				.infoFieldSetEntry(ArtistInfoItemFields.labelInfoField)
				.infoFieldSetEntry(ArtistInfoItemFields.logoUrlInfoField)
				.infoFieldSetEntry(ArtistInfoItemFields.thumbUrlInfoField)
				.infoFieldSetEntry(ArtistInfoItemFields.urlInfoField)
				.infoFieldSetEntry(ArtistInfoItemFields.userNameInfoField)
				.infoFieldSetEntry(ArtistInfoItemFields.createDateInfoField)
				.infoFieldSetEntry(ArtistInfoItemFields.modifiedDateInfoField)
				.labelInfoLocalizedValue(InfoLocalizedValue.localize(getClass(), "artist"))
				.name("artist")
				.build();
	}
	
}
