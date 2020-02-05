package com.software.crafter.core.mojo;

import com.software.crafter.core.handler.UploadHandler;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * This mojo maps the entire process of uploads.
 * Uploads are configured via the corresponding POM file.
 * An introduction and examples can be found in the public GitHub repository.
 *
 * @author Roman Zimnik
 * @version 1.0.0
 *
 */
@Mojo( name = "upload", defaultPhase = LifecyclePhase.DEPLOY)
public class UploadMojo extends AbstractCustomMojo {

    /**
     *
     * @throws MojoExecutionException
     * @throws MojoFailureException
     */
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("AWS AccessKey: " + this.accessKey);
        getLog().info("AWS SecretKey: " + this.secretKey);
        getLog().info("Uploads: " + !this.uploads.isEmpty());

        UploadHandler uHandler = new UploadHandler(this.accessKey, this.secretKey, getLog());
        uHandler.uploadAllObjects(this.uploads);
    }
}
