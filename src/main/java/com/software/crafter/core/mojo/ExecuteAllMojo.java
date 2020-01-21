package com.software.crafter.core.mojo;

import com.software.crafter.core.handler.DownloadHandler;
import com.software.crafter.core.handler.UploadHandler;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo( name = "execute-all" )
public class ExecuteAllMojo extends AbstractCustomMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        getLog().info("Execute-all goal initiated.");
        getLog().info("Starting downloads...");

        DownloadHandler dHandler = new DownloadHandler(this.accessKey, this.secretKey, getLog());
        dHandler.downloadAllObjects(this.downloads);

        getLog().info("Downloads finished.");
        getLog().info("Starting uploads...");

        UploadHandler uHandler = new UploadHandler(this.accessKey, this.secretKey, getLog());
        uHandler.uploadAllObjects(this.uploads);

        getLog().info("Uploads finished.");
    }
}
