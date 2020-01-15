package com.software.crafter.mojo.upload;

import com.amazonaws.auth.BasicAWSCredentials;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo( name = "upload" )
public class UploadMojo extends AbstractMojo {

    @Parameter( property = "upload.accessKey" )
    private String accessKey;

    @Parameter( property = "upload.secretKey")
    private String secretKey;

    @Parameter( property = "upload.bucketName")
    private String bucketName;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("AWS AccessKey: " + accessKey);
        getLog().info("AWS SecretKey: " + secretKey);
        getLog().info("s3 Bucketname: " + bucketName);
    }

    public void uploadObjectToS3(String accessKey, String secretKey) {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
    }
}
