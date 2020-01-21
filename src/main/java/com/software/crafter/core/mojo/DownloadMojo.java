package com.software.crafter.core.mojo;

import com.software.crafter.core.handler.DownloadHandler;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo( name = "download" )
public class DownloadMojo extends AbstractCustomMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("AWS AccessKey: " + this.accessKey);
        getLog().info("AWS SecretKey: " + this.secretKey);
        getLog().info("Downloads: " + !this.downloads.isEmpty());

        DownloadHandler dHandler = new DownloadHandler(this.accessKey, this.secretKey, getLog());
        dHandler.downloadAllObjects(this.downloads);
    }
}
