package com.software.crafter.core.handler;

import com.amazonaws.services.s3.AmazonS3Client;
import com.software.crafter.core.artifact.Download;
import com.software.crafter.core.artifact.Upload;
import com.software.crafter.core.common.GoalExecutor;
import com.software.crafter.core.common.GoalExecutorImpl;
import com.software.crafter.util.AWSClientFactory;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugin.logging.SystemStreamLog;

import java.util.List;

public class UploadHandler {

    private Log log;

    private AmazonS3Client s3Client;

    public UploadHandler(String accesskey, String secretkey, Log log) {
        this.log = log;
        init(accesskey, secretkey);
    }

    private void init(String accesskey, String secretkey) {
        this.s3Client = AWSClientFactory.createAmazonS3Client(accesskey, secretkey);
    }

    public void uploadAllObjects(List<Upload> uploads) {

        uploads.stream().forEach(u -> this.log.info(
                "Object URI: " + u.getPath()
                        + u.getFileName()));

        uploads.stream().forEach(u -> uploadObjectFromS3(u));
    }

    private void uploadObjectFromS3(Upload upload) {

        GoalExecutor executor = new GoalExecutorImpl(this.s3Client);
        executor.executeGoal(upload);
    }
}
