package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.field.InfoField;
import com.liferay.info.field.type.DateInfoFieldType;
import com.liferay.info.field.type.ImageInfoFieldType;
import com.liferay.info.field.type.NumberInfoFieldType;
import com.liferay.info.field.type.TextInfoFieldType;
import com.liferay.info.field.type.URLInfoFieldType;
import com.liferay.info.localized.InfoLocalizedValue;

public class ArtistInfoItemFields {
	
	public static final InfoField<NumberInfoFieldType> artistIdInfoField =
			InfoField.builder(
			).infoFieldType(
				NumberInfoFieldType.INSTANCE
			).name(
				"artistId"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					ArtistInfoItemFields.class, "artistId")
			).build();

	public static final InfoField<TextInfoFieldType> nameInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"artistName"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					ArtistInfoItemFields.class, "artistName")
			).build();
	
	public static final InfoField<TextInfoFieldType> labelInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"artistLabel"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					ArtistInfoItemFields.class, "artistLabel")
			).build();
	
	public static final InfoField<TextInfoFieldType> styleInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"artistStyle"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					ArtistInfoItemFields.class, "artistStyle")
			).build();
	
	public static final InfoField<TextInfoFieldType> genreInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"artistGenre"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					ArtistInfoItemFields.class, "artistGenre")
			).build();	
	
	public static final InfoField<TextInfoFieldType> biographyInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"artistBiography"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					ArtistInfoItemFields.class, "artistBiography")
			).build();

	public static final InfoField<TextInfoFieldType> shortBioInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"artistShortBio"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					ArtistInfoItemFields.class, "artistShortBio")
			).build();
	
	public static final InfoField<TextInfoFieldType> countryInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"artistCountry"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					ArtistInfoItemFields.class, "artistCountry")
			).build();
	
	public static final InfoField<ImageInfoFieldType> thumbUrlInfoField =
			InfoField.builder(
			).infoFieldType(
				ImageInfoFieldType.INSTANCE
			).name(
				"artistThumbUrl"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					ArtistInfoItemFields.class, "artistThumbUrl")
			).build();
	
	public static final InfoField<ImageInfoFieldType> logoUrlInfoField =
			InfoField.builder(
			).infoFieldType(
				ImageInfoFieldType.INSTANCE
			).name(
				"artistLogoUrl"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					ArtistInfoItemFields.class, "artistLogoUrl")
			).build();	

	public static final InfoField<URLInfoFieldType> urlInfoField =
			InfoField.builder(
			).infoFieldType(
				URLInfoFieldType.INSTANCE
			).name(
				"artistUrl"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					ArtistInfoItemFields.class, "artistUrl")
			).build();
	
	public static final InfoField<TextInfoFieldType> userNameInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"userName"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					ArtistInfoItemFields.class, "userName")
			).build();

	public static final InfoField<DateInfoFieldType> createDateInfoField =
			InfoField.builder(
			).infoFieldType(
				DateInfoFieldType.INSTANCE
			).name(
				"createDate"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					ArtistInfoItemFields.class, "createDate")
			).build();
	
	public static final InfoField<DateInfoFieldType> modifiedDateInfoField =
			InfoField.builder(
			).infoFieldType(
				DateInfoFieldType.INSTANCE
			).name(
				"modifiedDate"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					ArtistInfoItemFields.class, "modifiedDate")
			).build();
	
}
