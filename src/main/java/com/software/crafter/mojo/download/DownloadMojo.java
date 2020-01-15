package com.software.crafter.mojo.download;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.software.crafter.mojo.common.AbstractCustomMojo;
import com.software.crafter.util.AWSClientFactory;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.*;
import java.util.List;

@Mojo( name = "download" )
public class DownloadMojo extends AbstractCustomMojo {

//    @Parameter( property = "download.bucketName")
//    private String bucketName;
//
//    @Parameter( property = "download.path")
//    private String path;
//
//    @Parameter( property = "download.download.object" )
//    private String object;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("AWS AccessKey: " + super.getAccessKey());
        getLog().info("AWS SecretKey: " + super.getSecretKey());
        getLog().info("Downloads: " + !super.getDownloads().isEmpty());
        downloadAllObjects(super.getDownloads());
    }

    public void downloadAllObjects(List<Download> downloads) {

        downloads.stream().forEach(d -> System.out.println(
                "Path: " + d.getDownloadPath()
                        + d.getFileName()));

//        downloads.stream().forEach(d -> downloadObjectFromS3(
//                super.accessKey,
//                super.secretKey,
//                d.getBucketName(),
//                d.getDownloadPath(),
//                d.getFileName()));

        downloads.stream().forEach(d -> downloadObjectFromS3(d));
    }

    public void downloadObjectFromS3(Download download) {

        final String DOWNLOAD_PATH = download.getDownloadPath()
                + download.getFileName();

        AmazonS3Client s3Client = AWSClientFactory.createAmazonS3Client(
                super.accessKey,
                super.secretKey);

        try {
            S3Object s3Object = s3Client.getObject(new GetObjectRequest(
                    download.getBucketName(),
                    download.getFileName()));

            S3ObjectInputStream s3inputStream = s3Object.getObjectContent();
            FileOutputStream fos = new FileOutputStream(new File(DOWNLOAD_PATH));

            byte[] readBuffer = new byte[1024];
            int readLength;
            while ((readLength = s3inputStream.read(readBuffer)) > 0) {
                fos.write(readBuffer, 0, readLength);
            }
            s3inputStream.close();
            fos.close();

        } catch (AmazonServiceException e) {
            e.printStackTrace();
        } catch (SdkClientException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public void downloadObjectFromS3(String accessKey,
//                                     String secretKey,
//                                     String bucketName,
//                                     String path,
//                                     String object) {
//
//        final String DOWNLOAD_PATH = path + object;
//
//        AmazonS3Client s3Client = AWSClientFactory.createAmazonS3Client(accessKey, secretKey);
//
//        try {
//            S3Object s3Object = s3Client.getObject(new GetObjectRequest(bucketName, object));
//            S3ObjectInputStream s3inputStream = s3Object.getObjectContent();
//
//            FileOutputStream fos = new FileOutputStream(new File(DOWNLOAD_PATH));
//
//            byte[] readBuffer = new byte[1024];
//            int readLength;
//            while ((readLength = s3inputStream.read(readBuffer)) > 0) {
//                fos.write(readBuffer, 0, readLength);
//            }
//            s3inputStream.close();
//            fos.close();
//
//        } catch (AmazonServiceException e) {
//            e.printStackTrace();
//        } catch (SdkClientException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
