package com.software.crafter.mojo.common;

import com.software.crafter.mojo.download.Download;
import com.software.crafter.mojo.upload.Upload;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.List;

public abstract class AbstractCustomMojo extends AbstractMojo {

    @Parameter( property = "accessKey" )
    protected String accessKey;

    @Parameter( property = "secretKey")
    protected String secretKey;

    @Parameter( property = "downloads" )
    private List<Download> downloads;

    @Parameter( property = "uploads" )
    private List<Upload> uploads;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public List<Download> getDownloads() {
        return downloads;
    }

    public void setDownloads(List<Download> downloads) {
        this.downloads = downloads;
    }

    public List<Upload> getUploads() {
        return uploads;
    }

    public void setUploads(List<Upload> uploads) {
        this.uploads = uploads;
    }
}
