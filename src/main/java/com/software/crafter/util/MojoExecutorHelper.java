package com.software.crafter.util;

import com.software.crafter.core.artifact.Download;
import com.software.crafter.core.artifact.Upload;
import org.twdata.maven.mojoexecutor.MojoExecutor;

import java.util.ArrayList;
import java.util.List;

public class MojoExecutorHelper {

    /**
     *
     * @param downloads
     * @return
     */
    public static MojoExecutor.Element getDownloadsElement(List<Download> downloads) {
        return new MojoExecutor.Element("downloads", getDownloadChildren(downloads));
    }

    private static MojoExecutor.Element[] getDownloadChildren(List<Download> downloads) {
        List<MojoExecutor.Element> children = new ArrayList<>();
        for (Download download : downloads) {
            children.add(parseDownload(download));
        }

        MojoExecutor.Element[] childrenArray =
                children.toArray(new MojoExecutor.Element[children.size()]);

        return childrenArray;
    }

    private static MojoExecutor.Element parseDownload(Download download) {
        return new MojoExecutor.Element("download",
                    new MojoExecutor.Element("fileName", download.getFileName()),
                    new MojoExecutor.Element("bucketName", download.getBucketName()),
                    new MojoExecutor.Element("path", download.getPath()));
    }

    /**
     *
     * @param uploads
     * @return
     */
    public static MojoExecutor.Element getUploadsElement(List<Upload> uploads) {
        return new MojoExecutor.Element("uploads", getUploadChildren(uploads));
    }

    private static MojoExecutor.Element[] getUploadChildren(List<Upload> uploads) {
        List<MojoExecutor.Element> children = new ArrayList<>();
        for (Upload upload : uploads) {
            children.add(parseUpload(upload));
        }

        MojoExecutor.Element[] childrenArray =
                children.toArray(new MojoExecutor.Element[children.size()]);

        return childrenArray;
    }

    private static MojoExecutor.Element parseUpload(Upload upload) {
        return new MojoExecutor.Element("upload",
                    new MojoExecutor.Element("fileName", upload.getFileName()),
                    new MojoExecutor.Element("bucketName", upload.getBucketName()),
                    new MojoExecutor.Element("path", upload.getPath()));
    }

}
