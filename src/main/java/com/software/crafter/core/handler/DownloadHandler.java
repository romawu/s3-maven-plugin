package com.software.crafter.core.handler;

import com.amazonaws.services.s3.AmazonS3Client;
import com.software.crafter.core.artifact.Download;
import com.software.crafter.core.common.GoalExecutor;
import com.software.crafter.core.common.GoalExecutorImpl;
import com.software.crafter.util.AWSClientFactory;
import org.apache.maven.plugin.logging.Log;

import java.util.List;

/**
 *
 * @author Roman Zimnik
 * @version 1.0.0
 *
 */
public class DownloadHandler {

    private Log log;

    private AmazonS3Client s3Client;

    public DownloadHandler(String accesskey, String secretkey, Log log) {
        this.log = log;
        init(accesskey, secretkey);
    }

    private void init(String accesskey, String secretkey) {
        this.s3Client = AWSClientFactory.createAmazonS3Client(accesskey, secretkey);
    }

    public void downloadAllObjects(List<Download> downloads) {

        downloads.stream().forEach(d -> this.log.info(
                "Object URI: " + d.getPath()
                        + d.getFileName()));

        downloads.stream().forEach(d -> downloadObjectFromS3(d));
    }

    private void downloadObjectFromS3(Download download) {

        GoalExecutor executor = new GoalExecutorImpl(this.s3Client);
        executor.executeGoal(download);
    }
}
