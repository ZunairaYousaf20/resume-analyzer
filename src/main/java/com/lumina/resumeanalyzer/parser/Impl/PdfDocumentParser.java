package com.lumina.resumeanalyzer.parser.Impl;

import com.lumina.resumeanalyzer.exception.DocumentParsingException;
import com.lumina.resumeanalyzer.parser.IDocumentParser;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class PdfDocumentParser implements IDocumentParser {

    @Override
    public String parse(MultipartFile file) {

        try (PDDocument document = Loader.loadPDF(file.getBytes())) {

           PDFTextStripper textStripper = new PDFTextStripper();
            return textStripper.getText(document);
        } catch (IOException exp) {
            throw new DocumentParsingException("Exception occurred while parsing the PDF document: " + exp.getMessage(), exp);
        }
    }
}
