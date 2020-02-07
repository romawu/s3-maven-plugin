# s3-maven-plugin

![s3-maven-plugin logo](./s3-maven-plugin-logo.png "s3 Maven Plugin Logo")

**What:** *s3-maven-plugin* allows you to download and upload files and artifacts of any kind from and to an s3 bucket via maven execution.  

**How:** Downloading and uploading can be bound to specific maven goals. The configuration of all parameters is done directly in the POM file, so no additional scripts or tools have to be used for the data transfer from or to the s3 storage. The entire process can be managed by Maven.

## Installation

`s3-maven-plugin` has been released to the Maven Central Repository. It can be downloaded and configured as usual via the maven dependency management:

    <dependency>
        <groupId>com.software-crafter</groupId>
        <artifactId>s3-maven-plugin</artifactId>
        <version>1.0.0</version>
    </dependency>

Please follow the configuration instructions as described below.

## POM file configuration example

    <build>
        <plugins>
            <plugin>
                <groupId>com.software-crafter</groupId>
                <artifactId>s3-maven-plugin</artifactId>
                <version>1.0.0</version>
                <configuration>
                    <accessKey>${s3.accessKey}</accessKey>
                    <secretKey>${s3.secretKey}</secretKey>
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

## settings.xml configuration

    <profiles>
        <profile>
            <id>s3-maven-plugin</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <s3.accessKey>INSERT YOUR ACCESSKEY</s3.accessKey>
                <s3.secretKey>INSERT YOUR SECRETKEY</s3.secretKey>
            </properties>
        </profile>
    </profiles>

## Manual execution

1. Executing downloads only: `mvn s3:download`
2. Executing uploads only: `mvn s3:uploads`
3. Executing downloads and uploads: `mvn s3:execute-all`

