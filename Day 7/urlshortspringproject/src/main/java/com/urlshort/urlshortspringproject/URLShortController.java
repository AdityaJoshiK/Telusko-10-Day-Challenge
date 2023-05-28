package com.urlshort.urlshortspringproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


@Controller
public class URLShortController {
    private Map<String, String> urlMap = new HashMap<>();
    private Random random = new Random();

    @PostMapping("/generate")
    @ResponseBody
    public String generateShortURL(@RequestParam("longURL") String longURL) {
        // Check if the original URL is already present in the map
        for (Map.Entry<String, String> entry : urlMap.entrySet()) {
            if (entry.getValue().equals(longURL)) {
                return entry.getKey();
            }
        }

        // Generate a new short URL
        String shortURL = generateShortURLFromOriginalURL(longURL);
        urlMap.put(shortURL, longURL);
        return shortURL;
    }

    private String generateShortURLFromOriginalURL(String longURL) {
        String characters = extractCharacters(longURL);
        int length = 6;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            sb.append(randomChar);
        }

        return "telus.ko/" + sb.toString();
    }

    private String extractCharacters(String longURL) {
        // Remove "https://" from the beginning of the URL
        String withoutHttps = longURL.replaceFirst("^https://", "");

        // Remove "www" from the beginning of the URL if it exists
        String withoutWWW = withoutHttps.replaceFirst("^www.", "");

        // Remove any remaining special characters
        String characters = withoutWWW.replaceAll("[^a-zA-Z0-9]", "");

        if (characters.isEmpty()) {
            throw new IllegalArgumentException("Invalid URL");
        }

        return characters;
    }
}
