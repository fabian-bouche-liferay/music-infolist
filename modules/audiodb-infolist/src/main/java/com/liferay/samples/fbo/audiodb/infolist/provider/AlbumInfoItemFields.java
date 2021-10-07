package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.field.InfoField;
import com.liferay.info.field.type.DateInfoFieldType;
import com.liferay.info.field.type.ImageInfoFieldType;
import com.liferay.info.field.type.NumberInfoFieldType;
import com.liferay.info.field.type.TextInfoFieldType;
import com.liferay.info.field.type.URLInfoFieldType;
import com.liferay.info.localized.InfoLocalizedValue;

public class AlbumInfoItemFields {
	
	public static final InfoField<NumberInfoFieldType> albumIdInfoField =
			InfoField.builder(
			).infoFieldType(
				NumberInfoFieldType.INSTANCE
			).name(
				"albumId"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					AlbumInfoItemFields.class, "albumId")
			).build();

	public static final InfoField<NumberInfoFieldType> albumYearReleasedInfoField =
			InfoField.builder(
			).infoFieldType(
				NumberInfoFieldType.INSTANCE
			).name(
				"albumYearReleased"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					AlbumInfoItemFields.class, "albumYearReleased")
			).build();

	public static final InfoField<TextInfoFieldType> releaseFormatInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"releaseFormat"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					AlbumInfoItemFields.class, "releaseFormat")
			).build();
	
	public static final InfoField<TextInfoFieldType> nameInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"albumName"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					AlbumInfoItemFields.class, "albumName")
			).build();

	public static final InfoField<TextInfoFieldType> descriptionInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"albumDescription"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					AlbumInfoItemFields.class, "albumDescription")
			).build();
	
	public static final InfoField<TextInfoFieldType> labelInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"albumLabel"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					AlbumInfoItemFields.class, "albumLabel")
			).build();
	
	public static final InfoField<TextInfoFieldType> styleInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"albumStyle"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					AlbumInfoItemFields.class, "albumStyle")
			).build();
	
	public static final InfoField<TextInfoFieldType> genreInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"albumGenre"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					AlbumInfoItemFields.class, "albumGenre")
			).build();	
	
	public static final InfoField<ImageInfoFieldType> thumbUrlInfoField =
			InfoField.builder(
			).infoFieldType(
				ImageInfoFieldType.INSTANCE
			).name(
				"albumThumbUrl"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					AlbumInfoItemFields.class, "albumThumbUrl")
			).build();

	public static final InfoField<URLInfoFieldType> urlInfoField =
			InfoField.builder(
			).infoFieldType(
				URLInfoFieldType.INSTANCE
			).name(
				"albumUrl"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					AlbumInfoItemFields.class, "albumUrl")
			).build();
	
	public static final InfoField<TextInfoFieldType> userNameInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"userName"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					AlbumInfoItemFields.class, "userName")
			).build();

	public static final InfoField<DateInfoFieldType> createDateInfoField =
			InfoField.builder(
			).infoFieldType(
				DateInfoFieldType.INSTANCE
			).name(
				"createDate"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					AlbumInfoItemFields.class, "createDate")
			).build();
	
	public static final InfoField<DateInfoFieldType> modifiedDateInfoField =
			InfoField.builder(
			).infoFieldType(
				DateInfoFieldType.INSTANCE
			).name(
				"modifiedDate"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					AlbumInfoItemFields.class, "modifiedDate")
			).build();
	
}
