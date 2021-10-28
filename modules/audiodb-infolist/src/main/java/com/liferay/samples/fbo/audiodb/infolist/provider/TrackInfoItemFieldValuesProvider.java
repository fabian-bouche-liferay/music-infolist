package com.liferay.samples.fbo.audiodb.infolist.provider;

import com.liferay.info.field.InfoFieldValue;
import com.liferay.info.item.InfoItemFieldValues;
import com.liferay.info.item.InfoItemReference;
import com.liferay.info.item.provider.InfoItemFieldValuesProvider;
import com.liferay.samples.fbo.audiodb.infolist.model.Track;

import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property = Constants.SERVICE_RANKING + ":Integer=10",
		service = InfoItemFieldValuesProvider.class
	)
public class TrackInfoItemFieldValuesProvider implements InfoItemFieldValuesProvider<Track> {

	@Override
	public InfoItemFieldValues getInfoItemFieldValues(Track track) {
		
		return InfoItemFieldValues.builder()
				.infoFieldValues(_getAlbumInfoFieldValues(track))
				.infoItemReference(new InfoItemReference(Track.class.getName(), track.getTrackId()))
				.build();
		
	}

	private List<InfoFieldValue<Object>> _getAlbumInfoFieldValues(Track track) {
		
		List<InfoFieldValue<Object>> trackFieldValues = new ArrayList<>();
		
		trackFieldValues.add(
				new InfoFieldValue<>(
					TrackInfoItemFields.trackIdInfoField,
					track.getTrackId()));

		trackFieldValues.add(
				new InfoFieldValue<>(
					TrackInfoItemFields.trackNumberInfoField,
					track.getTrackNumber()));

		trackFieldValues.add(
				new InfoFieldValue<>(
					TrackInfoItemFields.trackDescriptionInfoField,
					track.getTrackDescription()));

		trackFieldValues.add(
				new InfoFieldValue<>(
					TrackInfoItemFields.createDateInfoField,
					track.getCreateDate()));

		trackFieldValues.add(
				new InfoFieldValue<>(
					TrackInfoItemFields.genreInfoField,
					track.getGenre()));
		
		trackFieldValues.add(
				new InfoFieldValue<>(
					TrackInfoItemFields.modifiedDateInfoField,
					track.getModifiedDate()));
		
		trackFieldValues.add(
				new InfoFieldValue<>(
					TrackInfoItemFields.nameInfoField,
					track.getName()));
		
		trackFieldValues.add(
				new InfoFieldValue<>(
					TrackInfoItemFields.styleInfoField,
					track.getStyle()));
		
		trackFieldValues.add(
				new InfoFieldValue<>(
					TrackInfoItemFields.urlInfoField,
					track.getTrackUrl()));

		trackFieldValues.add(
				new InfoFieldValue<>(
					TrackInfoItemFields.userNameInfoField,
					track.getUserName()));

		trackFieldValues.add(
				new InfoFieldValue<>(
					TrackInfoItemFields.artistUrlInfoField,
					track.getArtistUrl()));

		trackFieldValues.add(
				new InfoFieldValue<>(
					TrackInfoItemFields.artistNameInfoField,
					track.getArtistName()));

		trackFieldValues.add(
				new InfoFieldValue<>(
					TrackInfoItemFields.albumUrlInfoField,
					track.getAlbumUrl()));

		trackFieldValues.add(
				new InfoFieldValue<>(
					TrackInfoItemFields.albumIdInfoField,
					track.getAlbumId()));

		trackFieldValues.add(
				new InfoFieldValue<>(
					TrackInfoItemFields.albumNameInfoField,
					track.getAlbumName()));
		
		trackFieldValues.add(
				new InfoFieldValue<>(
					TrackInfoItemFields.musicVideoUrlInfoField,
					track.getMusicVideoUrl()));

		trackFieldValues.add(
				new InfoFieldValue<>(
					TrackInfoItemFields.trackDurationInfoField,
					track.getDuration()));
		
		return trackFieldValues;
		
	}

}
