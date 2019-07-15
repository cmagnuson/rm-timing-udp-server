package com.mtecresults.rmudpserver.controller;

import com.mtecresults.rmudpserver.domain.Passing;

import java.util.Collection;

public abstract class ServerDataHandler {

    public void handlePassings(Collection<Passing> passings){}

    public abstract int getServerPort();
}
