package com.dandelion.automationportal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Document(collection = "mentorships")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Mentorship {

    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Id
    private String id;
    private String mentorName;
    @Indexed(unique = true)
    private String menteeName;
    private String startDate;
    private String endDate;
    private Integer result;

    public Mentorship(){
    }

    public Mentorship(String mentorName, String menteeName, String startDate, String endDate) {
        this.mentorName = mentorName;
        this.menteeName = menteeName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDateFormatted() {
        try {
            return DATE_FORMAT.parse(startDate);
        } catch (ParseException e) {
            return new Date();
        }
    }
}
