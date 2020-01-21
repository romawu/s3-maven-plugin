package com.software.crafter.core.common;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.software.crafter.core.artifact.Artifact;
import com.software.crafter.core.artifact.Download;
import com.software.crafter.core.artifact.Upload;

import java.io.File;

public class GoalExecutorImpl implements GoalExecutor {

    private AmazonS3Client s3Client;

    public GoalExecutorImpl(AmazonS3Client s3Client) {
        this.s3Client = s3Client;
    }

    @Override
    public void executeGoal(Artifact artifact) {

        if (artifact instanceof Download) {
            executeDownload(s3Client, (Download) artifact);
        } else if (artifact instanceof Upload) {
            executeUpload(s3Client, (Upload) artifact);
        }
    }

    private void executeDownload(AmazonS3Client s3Client, Download download) {

        final String DOWNLOAD_PATH = download.getPath()
                + download.getFileName();

        try {
            s3Client.getObject(new GetObjectRequest(
                    download.getBucketName(),
                    download.getFileName()),
                    new File(DOWNLOAD_PATH));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void executeUpload(AmazonS3Client s3Client, Upload upload) {

        final String OBJECT_PATH = upload.getPath()
                + upload.getFileName();

        try {
            s3Client.putObject(
                    upload.getBucketName(),
                    upload.getFileName(),
                    OBJECT_PATH);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
