package com.software.crafter.core.mojo;

import com.amazonaws.services.s3.AmazonS3Client;
import com.software.crafter.core.common.GoalExecutorImpl;
import com.software.crafter.core.common.GoalExecutor;
import com.software.crafter.core.artifact.Upload;
import com.software.crafter.core.handler.UploadHandler;
import com.software.crafter.util.AWSClientFactory;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

import java.util.List;

@Mojo( name = "upload" )
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
