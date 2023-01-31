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
            String content = new String(file.getBytes(), StandardCharsets.UTF_8);
            if (isContentSeparatedByComma(content)) {
                return getProductsToSearchSeparatedByComma(content);
            } else if (isContentSeparatedByNewLine(content)) {
                return getProductsToSearchSeparatedByNewLine(file);
            } else {
                return Collections.singletonList(content);
            }
        } catch (IOException exception) {
            return Collections.emptyList();
        }
    }

    private boolean isContentSeparatedByComma(String content) {
        String[] productsToSearch = content.split(COMMA);
        return productsToSearch.length > 1;
    }

    private boolean isContentSeparatedByNewLine(String content) {
        String[] split = content.split(System.lineSeparator());
        return split.length > 1;
    }

    private List<String> getProductsToSearchSeparatedByComma(String content) throws IOException {
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
