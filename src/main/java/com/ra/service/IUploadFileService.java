package com.ra.service;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {
    String uploadFile(MultipartFile multipartFile);
    String uploadFileLocalToFirebase(String localFilePath);

//    boolean deleteLinkImageFirebase(String linkImage);
}
