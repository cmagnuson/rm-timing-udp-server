package com.mtecresults.mylapstcpserver.controller;

import com.mtecresults.mylapstcpserver.domain.Marker;
import com.mtecresults.mylapstcpserver.domain.Passing;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UDPMinaHandler extends IoHandlerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(UDPMinaHandler.class);
    private static final String NEWLINE = "\r\n";

    private final ServerDataHandler handler;

    public UDPMinaHandler(ServerDataHandler handler){
        super();
        this.handler = handler;
        LOG.debug("New TCPMinaHandler starting up");
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause ) throws Exception {
        LOG.warn("Exception caught in session: "+session, cause);
    }

    @Override
    public void messageReceived( IoSession session, Object message ) throws Exception {
        String line = message.toString();
        LOG.trace("Message received: "+line);
    }
}
