package com.project.restaurantly.dto.response.chat;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LinkPreviewResponse {
    String title;
    String description;
    String image;
    String siteName;
    String cleanUrl;
    String domain;
}
