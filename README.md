# s3-maven-plugin

![s3-maven-plugin logo](./s3-maven-plugin-logo.png "s3 Maven Plugin Logo")

**Important Note:** s3-maven-plugin is not currently available from Maven central repository. It is currently being worked on, so manual compilation will soon no longer be necessary.

**What:** *s3-maven-plugin* allows you to download and upload files and artifacts of any kind from and to an s3 bucket via maven execution.  

**How:** Downloading and uploading can be bound to specific maven goals. The configuration of all parameters is done directly in the POM file, so no additional scripts or tools have to be used for the data transfer from or to the s3 storage. The entire process can be managed by Maven.

## Installation

1. Download/git clone this repository.
2. Execute `mvn install`.
3. Implement the following configuration into your pom file setup.

## Manual execution

1. Executing downloads only: `mvn s3:download`
2. Executing uploads only: `mvn s3:uploads`
3. Executing downloads and uploads: `mvn s3:execute-all`

## POM file configuration for execution during build runtime

    <build>
        <plugins>
            <plugin>
                <groupId>com.software-crafter</groupId>
                <artifactId>s3-maven-plugin</artifactId>
                <version>1.0.0</version>
                <configuration>
                    <accessKey>${INSERT_OWN_ACCESSKEY}</accessKey>
                    <secretKey>${INSERT_OWN_SECRETKEY}</secretKey>
                    <downloads>
                        <download>
                            <fileName>${DUMMY_FILENAME}</fileName>
                            <bucketName>${DUMMY_BUCKETNAME}</bucketName>
                            <downloadPath>${DUMMY_DOWNLOAD_DIRECTORY}</downloadPath>
                        </download>
                    </downloads>
                    <uploads>
                        <upload>
                            <fileName>${DUMMY_FILENAME}</fileName>
                            <bucketName>${DUMMY_BUCKETNAME}</bucketName>
                            <downloadPath>${DUMMY_DOWNLOAD_DIRECTORY}</downloadPath>
                        </upload>
                    </uploads>
                </configuration>
            </plugin>
        </plugins>
    </build>

## Implementation example

    <build>
        <plugins>
            <plugin>
                <groupId>com.software-crafter</groupId>
                <artifactId>s3-maven-plugin</artifactId>
                <version>1.0.0</version>
                <configuration>
                    <accessKey>AKIAWA6VGJY43EAG4YS3N</accessKey>
                    <secretKey>FmlwgsjYBJgB2YmR5TybT8H7V3Osh3d138</secretKey>
                    <downloads>
                        <download>
                            <fileName>s3-download.zip</fileName>
                            <bucketName>s3-maven-plugin-bucket</bucketName>
                            <path>/Users/dummy/project/s3-maven-plugin/</path>
                        </download>
                    </downloads>
                    <uploads>
                        <upload>
                            <fileName>s3-upload.jar</fileName>
                            <bucketName>s3-maven-plugin-bucket</bucketName>
                            <path>/Users/dummy/project/s3-maven-plugin/</path>
                        </upload>
                    </uploads>
                </configuration>
            </plugin>
        </plugins>
    </build>
