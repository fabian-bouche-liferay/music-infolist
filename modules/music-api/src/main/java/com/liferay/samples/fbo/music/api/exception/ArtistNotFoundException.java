package com.liferay.samples.fbo.music.api.exception;

public class ArtistNotFoundException
    extends Exception {

  public ArtistNotFoundException(String message) {

    super(message);
  }

  public ArtistNotFoundException(String message, Throwable cause) {

    super(message, cause);
  }

  public ArtistNotFoundException(Throwable cause) {

    super(cause);
  }

}
