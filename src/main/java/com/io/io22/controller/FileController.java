package com.io.io22.controller;

import com.io.io22.ceneo.service.CeneoService;
import com.io.io22.dto.ProductClusterDTO;
import com.io.io22.service.FileService;
import com.io.io22.service.SearchHistoryService;
import com.io.io22.utils.SortEnum;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/upload")
public class FileController {

    public static final String FILE_EMPTY_MESSAGE = "File is empty";

    public static final String PARSE_ERROR_MESSAGE = "Could not parse content, use comma or new line as a delimiter";
    public static final String NO_RESULTS_FOUND_MESSAGE = "No results found";

    private final FileService fileService;

    private final CeneoService ceneoService;

    private final SearchHistoryService searchHistoryService;

    public FileController(FileService fileService, CeneoService ceneoService, SearchHistoryService searchHistoryService) {
        this.fileService = fileService;
        this.ceneoService = ceneoService;
        this.searchHistoryService = searchHistoryService;
    }

    @PostMapping
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             @RequestParam("sorting") Optional<SortEnum> sorting,
                             Model model,
                             RedirectAttributes redirectAttributes,
                             @AuthenticationPrincipal OidcUser principal) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", FILE_EMPTY_MESSAGE);
            return "index";
        }
        List<String> productsToSearch = fileService.getProductsToSearch(file);
        if (productsToSearch.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", PARSE_ERROR_MESSAGE);
            return "index";
        }
        List<ProductClusterDTO> ceneoProducts = ceneoService.getCeneoProducts(productsToSearch, sorting);
        if (ceneoProducts.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", NO_RESULTS_FOUND_MESSAGE);
            return "index";
        }
        searchHistoryService.addIfUserAuthenticated(principal, productsToSearch);
        model.addAttribute("products", ceneoProducts);
        return "index";
    }
}
