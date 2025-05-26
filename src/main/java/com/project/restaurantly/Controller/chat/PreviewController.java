package com.project.restaurantly.Controller.chat;

import com.project.restaurantly.dto.response.chat.LinkPreviewResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jsoup.Jsoup;
import org.springframework.web.bind.annotation.*;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;

@RestController
@RequestMapping("${api.prefix}preview")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PreviewController {
    @GetMapping
    public LinkPreviewResponse getLinkPreview(@RequestParam String url) throws IOException {
        String cleanUrl = url.replace("\"", "");
        Document doc = Jsoup.connect(cleanUrl).get();

        String title = getMetaTag(doc, "og:title", "title");
        String description = getMetaTag(doc, "og:description", "description");
        String image = getMetaTag(doc, "og:image", null);
        String siteName = getMetaTag(doc, "og:site_name", null);

        String domain = "";
        try {
            URL urlObj = new URL(cleanUrl);
            domain = urlObj.getHost();  // lấy host như www.youtube.com
        } catch (Exception e) {
            // nếu URL không hợp lệ, domain để trống hoặc xử lý khác
        }

        return new LinkPreviewResponse(title, description, image, siteName, cleanUrl, domain);
    }

    private String getMetaTag(Document doc, String ogProperty, String fallbackTag) {
        Element tag = doc.selectFirst("meta[property=" + ogProperty + "]");
        if (tag != null) return tag.attr("content");

        if (fallbackTag != null) {
            Element fallback = doc.selectFirst("meta[name=" + fallbackTag + "]");
            if (fallback != null) return fallback.attr("content");
        }

        if (ogProperty.equals("og:title")) return doc.title();

        return null;
    }
}
