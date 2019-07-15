package com.mtecresults.rmudpserver.controller;

import com.mtecresults.rmudpserver.domain.Passing;
import org.apache.mina.core.session.DummySession;
import org.junit.Before;
import org.junit.Test;


import java.util.Collection;

import static org.junit.Assert.*;

public class UDPMinaHandlerTest extends ServerDataHandler {

    Collection<Passing> passingsReceived;

    UDPMinaHandler handler;

    @Before
    public void setUp() throws Exception {
        passingsReceived = null;
        handler = new UDPMinaHandler(this);
    }

    @Test
    public void messageReceived() throws Exception {
        fail("Implement me for RM systems");
//        handler.messageReceived(new DummySession(), "Finish@Marker@t=2017-10-25 11:03:40.347|mt=gun|n=Gunshot 1@4@$\n");
//        handler.messageReceived(new DummySession(), "10KM@Passing@t=13:11:30.904|c=0000041|ct=UH|d=120606|l=13|dv=4|re=0|an=00001111|g=0|b=41|n=41@t=13:12:21.830|c=0000039|ct=UH|d=120606|l=30|dv=4|re=0|an=00001101|g=0|b=39|n=39@ 1016@$");
//        assertEquals(2, passingsReceived.size());
    }

    @Override
    public void handlePassings(Collection<Passing> passings) {
        passingsReceived = passings;
    }

    @Override
    public int getServerPort() {
        return 0;
    }
}