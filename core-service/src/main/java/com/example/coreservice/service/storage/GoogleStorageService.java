package com.example.coreservice.service.storage;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.UUID;

@Service
public class GoogleStorageService {
    @Value("${google.storage.bucket-name}")
    private String bucketName;
    @Value("${google.storage.project-id}")
    private String projectId;
    @Value("${google.storage.credentials-file}")
    private String credentialsFile;

    private Storage storage;

    @PostConstruct
    public void init() throws IOException {
        this.storage = StorageOptions.getDefaultInstance().getService();
//        InputStream credentialsFileStream = getClass().getClassLoader().getResourceAsStream(credentialsFile);
//        if(credentialsFileStream == null){
//            throw new RuntimeException(credentialsFile + " not found el archivo de configuracion");
//        }
//        this.storage = StorageOptions.newBuilder()
//                .setProjectId(projectId)
//                .setCredentials(GoogleCredentials.fromStream(credentialsFileStream))
//                .build()
//                .getService();
    }
    public String uploadFile(MultipartFile file, String folderName) throws IOException {
        String fileName = this.generateFileName(file, folderName);
        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, fileName)
                .setContentType(file.getContentType())
                .setAcl(Collections.singletonList(Acl.of(Acl.User.ofAllUsers(), Acl.Role.READER)))
                .build();
        storage.create(blobInfo, file.getBytes());
        return String.format("https://storage.googleapis.com/%s/%s", bucketName, fileName);
    }
    private String generateFileName(MultipartFile file, String folderName) {
        String originalFileName = file.getOriginalFilename();
        String cleanFileName = removeSpaces(originalFileName);
        return folderName + "/" + UUID.randomUUID() + "_" + cleanFileName;
    }
    private String removeSpaces(String fileName) {
        if (fileName == null) {
            return "file";
        }
        String cleanName = fileName.replaceAll("\\s+", "_");
        cleanName = cleanName.replaceAll("[^a-zA-Z0-9._-]", "");
        if (cleanName.isEmpty()) {
            cleanName = "file_" + System.currentTimeMillis();
        }

        return cleanName;
    }
    public void deleteFile(String fileUrl) {
        try {
            String fileName = fileUrl.replace("https://storage.googleapis.com/" + bucketName + "/", "");
            storage.delete(bucketName, fileName);
        } catch (Exception e) {
            System.err.println("Error deleting file from Google Storage: " + e.getMessage());
        }
    }
}
