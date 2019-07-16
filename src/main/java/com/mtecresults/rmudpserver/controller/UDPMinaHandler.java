package com.mtecresults.rmudpserver.controller;

import com.google.gson.JsonSyntaxException;
import com.mtecresults.rmudpserver.domain.Passing;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;


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
        //add back closing "]" stripped out by protocol Decoder
        String line = message.toString() + "]";
        LOG.debug("Message received: "+line);

        try{
            Collection<Passing> passings = Passing.fromJsonString(line);
            LOG.debug("Read passings: "+passings);
            handler.handlePassings(passings);
        }
        catch(JsonSyntaxException pe){
            LOG.error("Unable to parse passing data: "+line, pe);
        }
    }
}
