package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.field.InfoField;
import com.liferay.info.field.type.DateInfoFieldType;
import com.liferay.info.field.type.NumberInfoFieldType;
import com.liferay.info.field.type.TextInfoFieldType;
import com.liferay.info.field.type.URLInfoFieldType;
import com.liferay.info.localized.InfoLocalizedValue;

public class TrackInfoItemFields {

	public static final InfoField<NumberInfoFieldType> trackIdInfoField =
			InfoField.builder(
			).infoFieldType(
				NumberInfoFieldType.INSTANCE
			).name(
				"trackId"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					TrackInfoItemFields.class, "trackId")
			).build();
	
	public static final InfoField<NumberInfoFieldType> trackNumberInfoField =
			InfoField.builder(
			).infoFieldType(
				NumberInfoFieldType.INSTANCE
			).name(
				"trackNumber"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					TrackInfoItemFields.class, "trackNumber")
			).build();
	
	public static final InfoField<NumberInfoFieldType> albumIdInfoField =
			InfoField.builder(
			).infoFieldType(
				NumberInfoFieldType.INSTANCE
			).name(
				"albumId"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					TrackInfoItemFields.class, "albumId")
			).build();
	
	public static final InfoField<TextInfoFieldType> albumNameInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"albumName"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					TrackInfoItemFields.class, "albumName")
			).build();

	public static final InfoField<URLInfoFieldType> albumUrlInfoField =
			InfoField.builder(
			).infoFieldType(
				URLInfoFieldType.INSTANCE
			).name(
				"albumUrl"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					TrackInfoItemFields.class, "albumUrl")
			).build();
	
	public static final InfoField<TextInfoFieldType> nameInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"trackName"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					TrackInfoItemFields.class, "trackName")
			).build();

	public static final InfoField<TextInfoFieldType> styleInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"trackStyle"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					TrackInfoItemFields.class, "trackStyle")
			).build();
	
	public static final InfoField<TextInfoFieldType> genreInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"trackGenre"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					TrackInfoItemFields.class, "trackGenre")
			).build();	

	public static final InfoField<URLInfoFieldType> urlInfoField =
			InfoField.builder(
			).infoFieldType(
				URLInfoFieldType.INSTANCE
			).name(
				"trackUrl"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					TrackInfoItemFields.class, "trackUrl")
			).build();
	
	public static final InfoField<TextInfoFieldType> userNameInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"userName"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					TrackInfoItemFields.class, "userName")
			).build();

	public static final InfoField<DateInfoFieldType> createDateInfoField =
			InfoField.builder(
			).infoFieldType(
				DateInfoFieldType.INSTANCE
			).name(
				"createDate"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					TrackInfoItemFields.class, "createDate")
			).build();
	
	public static final InfoField<DateInfoFieldType> modifiedDateInfoField =
			InfoField.builder(
			).infoFieldType(
				DateInfoFieldType.INSTANCE
			).name(
				"modifiedDate"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					TrackInfoItemFields.class, "modifiedDate")
			).build();
	
	public static final InfoField<URLInfoFieldType> artistUrlInfoField =
			InfoField.builder(
			).infoFieldType(
				URLInfoFieldType.INSTANCE
			).name(
				"artistUrl"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					TrackInfoItemFields.class, "artistUrl")
			).build();
	
	public static final InfoField<TextInfoFieldType> artistNameInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"artistName"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					TrackInfoItemFields.class, "artistName")
			).build();

	public static final InfoField<TextInfoFieldType> trackDescriptionInfoField =
			InfoField.builder(
			).infoFieldType(
				TextInfoFieldType.INSTANCE
			).name(
				"trackDescription"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					TrackInfoItemFields.class, "trackDescription")
			).build();
	public static final InfoField<NumberInfoFieldType> trackDurationInfoField =
			InfoField.builder(
			).infoFieldType(
				NumberInfoFieldType.INSTANCE
			).name(
				"trackDuration"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					TrackInfoItemFields.class, "trackDuration")
			).build();
	
	public static final InfoField<URLInfoFieldType> musicVideoUrlInfoField =
			InfoField.builder(
			).infoFieldType(
				URLInfoFieldType.INSTANCE
			).name(
				"musicVideoUrl"
			).labelInfoLocalizedValue(
				InfoLocalizedValue.localize(
					TrackInfoItemFields.class, "musicVideoUrl")
			).build();

}
