package com.software.crafter.util;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

/**
 * @author Roman Zimnik
 * @version 1.0.0
 */
public class AWSClientFactory {

    /**
     *
     * @param accessKey individual accessKey from your s3 platform.
     * @param secretKey individual secretKey from your s3 platform.
     *                  Both need full read and write access.
     * @return
     */
    public static AmazonS3Client createAmazonS3Client(String accessKey, String secretKey) {

        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        AWSStaticCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(awsCredentials);

        AmazonS3Client s3Client = (AmazonS3Client) AmazonS3ClientBuilder
                .standard()
                .withCredentials(credentialsProvider)
                .withRegion("us-east-1")
                .build();

        return s3Client;
    }
}
