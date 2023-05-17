package com.kamtech.inventorymanagement.controllers.api;

import com.flickr4java.flickr.FlickrException;
import io.swagger.annotations.Api;

import java.io.InputStream;

import static com.kamtech.inventorymanagement.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/flickr")
public interface FlickApi {

    String savePhoto(InputStream photo, String title) throws FlickrException;
}
