package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.field.InfoFieldValue;
import com.liferay.info.item.InfoItemFieldValues;
import com.liferay.info.item.InfoItemReference;
import com.liferay.info.item.provider.InfoItemFieldValuesProvider;
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
public class ArtistInfoItemFieldValuesProvider implements InfoItemFieldValuesProvider<Artist> {

	@Override
	public InfoItemFieldValues getInfoItemFieldValues(Artist artist) {
		
		return InfoItemFieldValues.builder()
				.infoFieldValues(_getArtistInfoFieldValues(artist))
				.infoItemReference(new InfoItemReference(Artist.class.getName(), artist.getArtistId()))
				.build();
		
	}

	private List<InfoFieldValue<Object>> _getArtistInfoFieldValues(Artist artist) {
		
		List<InfoFieldValue<Object>> artistFieldValues = new ArrayList<>();
		
		artistFieldValues.add(
				new InfoFieldValue<>(
					ArtistInfoItemFields.artistIdInfoField,
					artist.getArtistId()));

		artistFieldValues.add(
				new InfoFieldValue<>(
					ArtistInfoItemFields.biographyInfoField,
					artist.getBiography()));

		artistFieldValues.add(
				new InfoFieldValue<>(
					ArtistInfoItemFields.shortBioInfoField,
					artist.getShortBio()));

		artistFieldValues.add(
				new InfoFieldValue<>(
					ArtistInfoItemFields.countryInfoField,
					artist.getCountry()));

		artistFieldValues.add(
				new InfoFieldValue<>(
					ArtistInfoItemFields.createDateInfoField,
					artist.getCreateDate()));
		
		artistFieldValues.add(
				new InfoFieldValue<>(
					ArtistInfoItemFields.genreInfoField,
					artist.getGenre()));
		
		artistFieldValues.add(
				new InfoFieldValue<>(
					ArtistInfoItemFields.labelInfoField,
					artist.getLabel()));
		
		artistFieldValues.add(
				new InfoFieldValue<>(
					ArtistInfoItemFields.logoUrlInfoField,
					artist.getLogoUrl()));

		artistFieldValues.add(
				new InfoFieldValue<>(
					ArtistInfoItemFields.urlInfoField,
					artist.getUrl()));

		artistFieldValues.add(
				new InfoFieldValue<>(
					ArtistInfoItemFields.modifiedDateInfoField,
					artist.getModifiedDate()));
		
		artistFieldValues.add(
				new InfoFieldValue<>(
					ArtistInfoItemFields.nameInfoField,
					artist.getName()));
		
		artistFieldValues.add(
				new InfoFieldValue<>(
					ArtistInfoItemFields.styleInfoField,
					artist.getStyle()));
		
		artistFieldValues.add(
				new InfoFieldValue<>(
					ArtistInfoItemFields.thumbUrlInfoField,
					artist.getThumbUrl()));
		
		artistFieldValues.add(
				new InfoFieldValue<>(
					ArtistInfoItemFields.userNameInfoField,
					artist.getUserName()));
		
		return artistFieldValues;
		
	}

}
