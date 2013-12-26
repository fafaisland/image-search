// Copyright 2012 Google Inc. All Rights Reserved.

package com.example.image_search;

/**
 * A minimal implementation of VelvetImage for internal storage
 */
public class VelvetImage  {

    private String mId;
    private String mName;
    private String mDomain;
    private String mUri;
    private String mThumbnailUri;
    private int mHeight;
    private int mWidth;
    private int mThumbnailWidth;
    private int mThumbnailHeight;
    private String mSourceUri;
    private String mSnippet;
    private String mNavigationUri;

    public VelvetImage() {}
    public VelvetImage(String id) {
        mId = id;
    }

    /**
     * Two VelvetImages are equal if they have equal IDs
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof VelvetImage)) {
            return false;
        }
        VelvetImage rhs = (VelvetImage) o;
        if (rhs.getId().equals(mId)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        if (mId != null) {
            return mId.hashCode();
        } else {
            return super.hashCode();
        }
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDomain() {
        return mDomain;
    }

    public void setDomain(String domain) {
        this.mDomain = domain;
    }

    public String getUri() {
        return mUri;
    }

    public void setUri(String uri) {
        this.mUri = uri;
    }

    public String getThumbnailUri() {
        return mThumbnailUri;
    }

    public void setThumbnailUri(String thumbnailUri) {
        this.mThumbnailUri = thumbnailUri;
    }

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        this.mHeight = height;
    }

    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int width) {
        this.mWidth = width;
    }

    //@VisibleForTesting
    public int getThumbnailWidth() {
        return mThumbnailWidth;
    }

    public void setThumbnailWidth(int thumbnailWidth) {
        this.mThumbnailWidth = thumbnailWidth;
    }

    //@VisibleForTesting
    public int getThumbnailHeight() {
        return mThumbnailHeight;
    }

    public void setThumbnailHeight(int thumbnailHeight) {
        this.mThumbnailHeight = thumbnailHeight;
    }

    public String getSourceUri() {
        return mSourceUri;
    }

    public void setSourceUri(String sourceUri) {
        this.mSourceUri = sourceUri;
    }

    //@VisibleForTesting
    public String getSnippet() {
        return mSnippet;
    }

    public void setSnippet(String snippet) {
        this.mSnippet = snippet;
    }

    public String getNavigationUri() {
        return mNavigationUri;
    }

    public void setNavigationUri(String navigationUri) {
        mNavigationUri = navigationUri;
    }
}