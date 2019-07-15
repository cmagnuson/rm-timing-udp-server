package com.mtecresults.rmudpserver.controller;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Set;

public class RmUdpServer {

    private static final Logger LOG = LoggerFactory.getLogger(RmUdpServer.class);

    final NioDatagramAcceptor acceptor;
    final ServerDataHandler handler;
    final UDPMinaHandler minaHandler;
    private final SessionTrackingListener sessionTrackingListener = new SessionTrackingListener();

    public RmUdpServer(ServerDataHandler handler) throws IOException {
        this.handler = handler;
        minaHandler = new UDPMinaHandler(handler);
        LOG.info("Server startup for server port: "+handler.getServerPort());

        acceptor = new NioDatagramAcceptor();
            //acceptor.getFilterChain().addLast( "logger", new LoggingFilter() );
        TextLineCodecFactory textLineCodecFactory = new TextLineCodecFactory( Charset.forName( "UTF-8" ));
        textLineCodecFactory.setDecoderMaxLineLength(64_000);
        textLineCodecFactory.setEncoderMaxLineLength(64_000);
        acceptor.getFilterChain().addLast( "codec", new ProtocolCodecFilter(textLineCodecFactory));
        acceptor.addListener(sessionTrackingListener);
        acceptor.setHandler(minaHandler);
        acceptor.bind( new InetSocketAddress(handler.getServerPort()) );
    }

    public void stopServer() {
        LOG.info("Server shutdown for server port: "+handler.getServerPort());
        acceptor.dispose();
    }
    
    public ServerDataHandler getHandler() {
        return handler;
    }

    public Set<IoSession> getActiveSessions() {
        return sessionTrackingListener.getActiveSessions();
    }
}
