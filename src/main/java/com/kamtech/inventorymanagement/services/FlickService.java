package com.kamtech.inventorymanagement.services;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface FlickService {

    String savePhoto(InputStream photo, String title) throws FlickrException;
}
