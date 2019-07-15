package com.mtecresults.rmudpserver.controller;

import com.mtecresults.rmudpserver.domain.Passing;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Collections;


public class UDPMinaHandler extends IoHandlerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(UDPMinaHandler.class);

    private final ServerDataHandler handler;

    public UDPMinaHandler(ServerDataHandler handler){
        super();
        this.handler = handler;
        LOG.debug("New UDPMinaHandler starting up");
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause ) throws Exception {
        LOG.warn("Exception caught in session: "+session, cause);
    }

    @Override
    public void messageReceived( IoSession session, Object message ) throws Exception {
        String line = message.toString();
        LOG.trace("Message received: "+line);

        try{
            Passing p = Passing.fromJsonString(line);
            handler.handlePassings(Collections.singleton(p));
        }
        catch(ParseException pe){
            LOG.error("Unable to parse passing data: "+line, pe);
        }
    }
}
