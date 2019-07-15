![Release](https://jitpack.io/v/cmagnuson/rm-timing-udp-server.svg)
(https://jitpack.io/#cmagnuson/rm-timing-udp-server)

# rm-timing-udp-server

Java UDP server for handling rmtiming data feed.  Just override ServerDataHandler and create a new RMTimingUdpServer with that handler.

```
public class SampleServerHandler extends ServerDataHandler {

    private static final Logger LOG = LoggerFactory.getLogger(SampleServerHandler.class);

    public static void main(String args[]) throws Exception {
        LOG.info("Sample server startup");
        new MyLapsTCPServer(new SampleServerHandler());
    }

    @Override
    public void handlePassings(Collection<Passing> passings) {
        LOG.info("Passings message received");
        for(Passing passing: passings){
            LOG.info("\t"+passing);
        }
    }

    @Override
    public String getServerName() {
        return "SampleServer";
    }

    @Override
    public int getServerPort() {
        return 3097;
    }
}
```

Easiest to integrate with your project using jitpack https://jitpack.io
```    
implementation 'com.github.cmagnuson:rm-timing-udp-server:TAG' 
```

For Android exclude slf4j and include Android version:   
``` 
implementation('com.github.cmagnuson:rm-timing-udp-server:TAG'){
    exclude group: 'org.slf4j'
}
implementation 'org.slf4j:slf4j-android:1.7.25'
```