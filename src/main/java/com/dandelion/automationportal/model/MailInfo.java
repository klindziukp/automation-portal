package com.dandelion.automationportal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MailInfo {
    @NonNull
    private String sendTo;
    @NonNull
    private String subject;
    @NonNull
    private String text;
    private String copy;
}
