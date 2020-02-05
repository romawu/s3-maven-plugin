package com.software.crafter.core.mojo;

import com.software.crafter.core.handler.DownloadHandler;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * This mojo maps the entire process of downloads.
 * Downloads are configured via the corresponding POM file.
 * An introduction and examples can be found in the public GitHub repository.
 *
 * @author Roman Zimnik
 * @version 1.0.0
 *
 */
@Mojo( name = "download", defaultPhase = LifecyclePhase.GENERATE_RESOURCES)
public class DownloadMojo extends AbstractCustomMojo {

    /**
     * Main method for the download goal.
     * Instantiates a DownlandHandler which takes care of the complete execution of the download goal.
     *
     * @throws MojoExecutionException
     * @throws MojoFailureException
     */
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("AWS AccessKey: " + this.accessKey);
        getLog().info("AWS SecretKey: " + this.secretKey);
        getLog().info("Downloads: " + !this.downloads.isEmpty());

        DownloadHandler dHandler = new DownloadHandler(this.accessKey, this.secretKey, getLog());
        dHandler.downloadAllObjects(this.downloads);
    }
}
