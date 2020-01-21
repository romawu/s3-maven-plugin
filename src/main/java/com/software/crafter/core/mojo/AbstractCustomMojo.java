package com.software.crafter.core.mojo;

import com.software.crafter.core.artifact.Download;
import com.software.crafter.core.artifact.Upload;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.List;

public abstract class AbstractCustomMojo extends AbstractMojo {

    @Parameter( property = "accessKey" )
    protected String accessKey;

    @Parameter( property = "secretKey")
    protected String secretKey;

    @Parameter( property = "downloads" )
    protected List<Download> downloads;

    @Parameter( property = "uploads" )
    protected List<Upload> uploads;
}
