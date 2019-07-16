package com.mtecresults.rmudpserver.domain;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class PassingTest {

    @Test
    public void parsePassing() {
       List<Passing> passings = Passing.fromJsonString("[{\"mode\":2,\"comingFromLocationName\":\"\",\"BIBNumber\":9898,\"eventId\":0,\"dt\":\"2019-07-16T13:04:22.909618-05:00\",\"dtString\":\"\",\"antennaPortNo\":\"M\",\"readerIdentity\":\"R\",\"PeakRSSIInDBM\":\"M\",\"TCPPacketNo\":0,\"UDPPacketNo\":78,\"rowData\":{\"BIB\":\"9898\",\"GunStart\":\"00:00:00.000\",\"ChipStart\":\"00:00:00.000\",\"Split1\":\"00:00:00.000\",\"Split2\":\"00:00:00.000\",\"Split3\":\"00:00:00.000\",\"Split4\":\"00:00:00.000\",\"Split5\":\"00:00:00.000\",\"Split6\":\"00:00:00.000\",\"Split7\":\"00:00:00.000\",\"Split8\":\"00:00:00.000\",\"Split9\":\"00:00:00.000\",\"Split10\":\"00:00:00.000\",\"Penalty\":\"00:00:00.000\",\"FinishTime\":\"13:04:22.909\",\"GunElapsed\":\"00:00:00.000\",\"ChipElapsed\":\"00:00:00.000\",\"Age\":\"0\",\"Modified\":\"07/16/2019 13:04:22.909\",\"Split11\":\"00:00:00.000\",\"Split12\":\"00:00:00.000\",\"Split13\":\"00:00:00.000\",\"Split14\":\"00:00:00.000\",\"Split15\":\"00:00:00.000\"},\"deleteRow\":false,\"isSameDayRegistration\":false,\"LapNo\":0,\"note\":null}]");
       assertEquals(1, passings.size());
       Passing p = passings.get(0);
       assertEquals("9898", p.chipcode);
       assertEquals("", p.locationName);
    }
}