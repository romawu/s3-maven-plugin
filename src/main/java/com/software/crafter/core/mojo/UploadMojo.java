package com.software.crafter.core.mojo;

import com.software.crafter.core.handler.UploadHandler;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo( name = "upload", defaultPhase = LifecyclePhase.DEPLOY)
public class UploadMojo extends AbstractCustomMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("AWS AccessKey: " + this.accessKey);
        getLog().info("AWS SecretKey: " + this.secretKey);
        getLog().info("Uploads: " + !this.uploads.isEmpty());

        UploadHandler uHandler = new UploadHandler(this.accessKey, this.secretKey, getLog());
        uHandler.uploadAllObjects(this.uploads);
    }
}
