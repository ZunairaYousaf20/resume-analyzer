package com.lumina.resumeanalyzer.parser;

import org.springframework.web.multipart.MultipartFile;

public interface IDocumentParser {

    String parse(MultipartFile file);
}
