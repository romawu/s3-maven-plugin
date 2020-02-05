package com.software.crafter.core.artifact;

/**
 *
 * @author Roman Zimnik
 * @version 1.0.0
 *
 */
public abstract class Artifact {

    protected String bucketName;

    protected String path;

    protected String fileName;

    public Artifact() {
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
