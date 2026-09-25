package com.lumina.resumeanalyzer.controller;

import com.lumina.resumeanalyzer.exception.InvalidFileException;
import com.lumina.resumeanalyzer.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/resume")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping(path = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadResume(
            @RequestParam("file") MultipartFile file
    ) throws InvalidFileException {
        // Logic to handle resume upload and analysis
        return ResponseEntity.ok(resumeService.uploadResume(file));
    }
}
