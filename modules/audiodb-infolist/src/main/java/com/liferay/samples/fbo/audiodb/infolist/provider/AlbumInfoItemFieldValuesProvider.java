package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.field.InfoFieldValue;
import com.liferay.info.item.InfoItemFieldValues;
import com.liferay.info.item.InfoItemReference;
import com.liferay.info.item.provider.InfoItemFieldValuesProvider;
import com.liferay.samples.fbo.audiodb.infolist.model.Album;
import com.liferay.samples.fbo.audiodb.infolist.model.Artist;

import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = Constants.SERVICE_RANKING + ":Integer=10",
		service = InfoItemFieldValuesProvider.class
	)
public class AlbumInfoItemFieldValuesProvider implements InfoItemFieldValuesProvider<Album> {

	@Override
	public InfoItemFieldValues getInfoItemFieldValues(Album album) {
		
		return InfoItemFieldValues.builder()
				.infoFieldValues(_getAlbumInfoFieldValues(album))
				.infoItemReference(new InfoItemReference(Album.class.getName(), album.getAlbumId()))
				.build();
		
	}

	private List<InfoFieldValue<Object>> _getAlbumInfoFieldValues(Album album) {
		
		List<InfoFieldValue<Object>> albumFieldValues = new ArrayList<>();
		
		albumFieldValues.add(
				new InfoFieldValue<>(
					AlbumInfoItemFields.albumIdInfoField,
					album.getAlbumId()));

		albumFieldValues.add(
				new InfoFieldValue<>(
					AlbumInfoItemFields.albumYearReleasedInfoField,
					album.getYearReleased()));

		albumFieldValues.add(
				new InfoFieldValue<>(
					AlbumInfoItemFields.releaseFormatInfoField,
					album.getReleaseFormat()));

		albumFieldValues.add(
				new InfoFieldValue<>(
					AlbumInfoItemFields.createDateInfoField,
					album.getCreateDate()));

		albumFieldValues.add(
				new InfoFieldValue<>(
					AlbumInfoItemFields.descriptionInfoField,
					album.getDescription()));

		albumFieldValues.add(
				new InfoFieldValue<>(
					AlbumInfoItemFields.shortDescriptionInfoField,
					album.getShortDescription()));

		albumFieldValues.add(
				new InfoFieldValue<>(
					AlbumInfoItemFields.genreInfoField,
					album.getGenre()));
		
		albumFieldValues.add(
				new InfoFieldValue<>(
					AlbumInfoItemFields.labelInfoField,
					album.getLabel()));
		
		albumFieldValues.add(
				new InfoFieldValue<>(
					AlbumInfoItemFields.modifiedDateInfoField,
					album.getModifiedDate()));
		
		albumFieldValues.add(
				new InfoFieldValue<>(
					AlbumInfoItemFields.nameInfoField,
					album.getName()));
		
		albumFieldValues.add(
				new InfoFieldValue<>(
					AlbumInfoItemFields.styleInfoField,
					album.getStyle()));
		
		albumFieldValues.add(
				new InfoFieldValue<>(
					AlbumInfoItemFields.thumbUrlInfoField,
					album.getAlbumThumbUrl()));

		albumFieldValues.add(
				new InfoFieldValue<>(
					AlbumInfoItemFields.urlInfoField,
					album.getAlbumUrl()));

		albumFieldValues.add(
				new InfoFieldValue<>(
					AlbumInfoItemFields.userNameInfoField,
					album.getUserName()));

		albumFieldValues.add(
				new InfoFieldValue<>(
					AlbumInfoItemFields.artistUrlInfoField,
					album.getArtistUrl()));

		albumFieldValues.add(
				new InfoFieldValue<>(
					AlbumInfoItemFields.artistNameInfoField,
					album.getArtistName()));

		return albumFieldValues;
		
	}

}
