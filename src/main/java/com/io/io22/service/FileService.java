package com.io.io22.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class FileService {

    private static final String COMMA = ",";

    public List<String> getProductsToSearch(MultipartFile file) {
        try {
            if (isContentSeparatedByComma(file)) {
                return getProductsToSearchSeparatedByComma(file);
            }
            return getProductsToSearchSeparatedByNewLine(file);
        } catch (IOException exception) {
            return Collections.emptyList();
        }
    }

    private boolean isContentSeparatedByComma(MultipartFile file) {
        try {
            String content = new String(file.getBytes(), StandardCharsets.UTF_8);
            String[] productsToSearch = content.split(COMMA);
            if (productsToSearch.length == 0) {
                return false;
            }
        } catch (IOException exception) {
            return false;
        }
        return true;
    }

    private List<String> getProductsToSearchSeparatedByComma(MultipartFile file) throws IOException {
        String content = new String(file.getBytes(), StandardCharsets.UTF_8);
        return Pattern.compile(COMMA).splitAsStream(content)
                .map(String::strip)
                .collect(Collectors.toList());
    }

    private List<String> getProductsToSearchSeparatedByNewLine(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        return bufferedReader
                .lines()
                .map(String::strip)
                .collect(Collectors.toList());
    }

}
