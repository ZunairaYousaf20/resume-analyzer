package com.lumina.resumeanalyzer.service;

import com.lumina.resumeanalyzer.dto.ResumeUploadResponse;
import com.lumina.resumeanalyzer.exception.InvalidFileException;
import com.lumina.resumeanalyzer.parser.IDocumentParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResumeService {

    private static final String PDF_CONTENT_TYPE = "application/pdf";

    private final IDocumentParser documentParser;

    public ResumeUploadResponse uploadResume(MultipartFile file) throws InvalidFileException {

        validateUploadedFile(file);

        return new ResumeUploadResponse(file.getOriginalFilename(), documentParser.parse(file));
    }

    private static void validateUploadedFile(MultipartFile file) throws InvalidFileException {
        if (file.isEmpty()) {
            log.info("Invalid file upload attempt: file cannot be empty");
            throw new InvalidFileException("The uploaded resume is empty. Please select a valid PDF file.");
        }

        if (!PDF_CONTENT_TYPE.equals(file.getContentType())) {
            log.info("Invalid file upload attempt: unsupported file type {}", file.getContentType());
            throw new InvalidFileException("Invalid file format. Please upload a resume in PDF format.");
        }
    }
}
