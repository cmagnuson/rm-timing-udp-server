package com.mtecresults.rmudpserver.domain;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Data
public class Passing {

    private static final Logger LOG = LoggerFactory.getLogger(Passing.class);

    final String chipcode;
    final String locationName;

    public static List<Passing> fromJsonString(String jsonData) throws JsonSyntaxException {
        ArrayList<Passing> passings = new ArrayList<>();
        Gson gson = new Gson();
        PassingJsonMapping[] mapping = gson.fromJson(jsonData, PassingJsonMapping[].class);
        for(PassingJsonMapping pjm: mapping){
            passings.add(new Passing(pjm.BIBNumber, pjm.comingFromLocationName));
        }
       return passings;
    }

    private class PassingJsonMapping {
        private String comingFromLocationName;
        private String BIBNumber;

        PassingJsonMapping(){}
    }
}
