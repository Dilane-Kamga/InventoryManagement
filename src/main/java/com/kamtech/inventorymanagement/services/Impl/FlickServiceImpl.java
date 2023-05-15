package com.kamtech.inventorymanagement.services.Impl;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.kamtech.inventorymanagement.services.FlickService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;


@Service
@Slf4j
public class FlickServiceImpl implements FlickService {

    private Flickr flickr;

    @Autowired
    public FlickServiceImpl(Flickr flickr) {
        this.flickr = flickr;
    }

    @Override
    public String savePhoto(InputStream photo, String title) throws FlickrException {
        UploadMetaData uploadMetaData = new UploadMetaData();
        uploadMetaData.setTitle(title);

        String photoId = flickr.getUploader().upload(photo, uploadMetaData);
        log.info("Photo uploaded successfully. Photo id: {}", photoId);
        return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();

    }


}
