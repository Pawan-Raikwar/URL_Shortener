package URL_package;

import java.util.HashMap;
import java.util.Map;

public class URLShortener {
    private Map<String, String> shortToOriginal = new HashMap<>();
    private Map<String, String> originalToShort = new HashMap<>();
    private static final String BASE_URL = "http://short.url/";

    public String shorten(String originalURL) {
        if (originalToShort.containsKey(originalURL)) {
            return BASE_URL + originalToShort.get(originalURL);
        }
        String shortURL = generateShortURL();
        shortToOriginal.put(shortURL, originalURL);
        originalToShort.put(originalURL, shortURL);
        return BASE_URL + shortURL;
    }

    public String redirect(String shortURL) {
        String originalURL = shortToOriginal.get(shortURL.substring(BASE_URL.length()));
        if (originalURL != null) {
            return originalURL;
        } else {
            return "URL not found";
        }
    }

    private String generateShortURL() {
        // Implement your logic to generate short URL keys (e.g., using hashing algorithms)
        // For simplicity, this example generates a random string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            char c = (char) ('a' + Math.random() * ('z' - 'a' + 1));
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        URLShortener shortener = new URLShortener();

        // this is the original URL
        String originalURL = "https://www.example.com/very/long/url";

        // this is the short URL
        String shortURL = shortener.shorten(originalURL);

        // for print the output
        System.out.println("Short URL: " + shortURL);
        System.out.println("Original URL: " + shortener.redirect(shortURL));
    }
}
