package com.istad.springthymleafpartone.service.serviceImpl;

import com.istad.springthymleafpartone.service.FileUploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    Path fileLocationStorage;

    FileUploadServiceImpl() {
        fileLocationStorage = Paths.get("src/main/resources/images");
    }

    @Override
    public String uploadFile(MultipartFile file) throws IOException {

        String filename = file.getOriginalFilename();
        // dog.png

        if (filename != null) {
            // condition for filename
            if (filename.contains("..")) {
                System.out.println("Filename is incorrect !! ");
                return null;
            }
            String[] fileParts = filename.split("\\.");
            filename = UUID.randomUUID() +"." + fileParts[1];
            // asdlfkasfd-asdfkasdjflasd-sdkfj.png
            //resolved path

            Path resolvedPath = fileLocationStorage.resolve(filename);
            Files.copy(file.getInputStream(), resolvedPath, StandardCopyOption.REPLACE_EXISTING);
            return filename;

        }else return null ;
    }
}
