package com.mtecresults.rmudpserver.domain;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;


@Data
public class Passing {

    private static final Logger LOG = LoggerFactory.getLogger(Passing.class);

    final String chipcode;
    final String locationName;

    public static Passing fromJsonString(String jsonData) throws ParseException {
        //TODO: implement and flesh out test cases
        return null;
    }
}
