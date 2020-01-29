package com.software.crafter.core.mojo;

import com.software.crafter.core.handler.DownloadHandler;
import com.software.crafter.core.handler.UploadHandler;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * This mojo executes both download goal and upload goal.
 * Generally just a wrapper, which calls both other two mojos.
 * @see com.software.crafter.core.mojo.DownloadMojo
 * @see com.software.crafter.core.mojo.UploadMojo
 *
 *
 * @author Roman Zimnik
 * @version 1.0.0
 *
 */
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
