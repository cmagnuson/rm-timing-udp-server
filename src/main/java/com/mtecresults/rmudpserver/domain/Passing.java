package com.mtecresults.mylapstcpserver.domain;

import com.mtecresults.mylapstcpserver.controller.ParseUtils;
import com.mtecresults.mylapstcpserver.controller.TCPMinaHandler;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class Passing {

    private static final Logger LOG = LoggerFactory.getLogger(Passing.class);

    final String chipcode;
    final String locationName;

}
