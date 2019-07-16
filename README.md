![Release](https://jitpack.io/v/cmagnuson/rm-timing-udp-server.svg)
(https://jitpack.io/#cmagnuson/rm-timing-udp-server)

# rm-timing-udp-server

Java UDP server for handling rmtiming data feed.  Just override ServerDataHandler and create a new RMTimingUdpServer with that handler.

**Note that the reading of records in Mina is a hack** - it will fail for any record containing a `]` in it's data.  This is good enough for my purposes, but for a robust solution you should implement a proper Mina Decoder, or just read Datagrams yourself.  The RM packets do not end in a newline, and Mina doesn't have a simple method to Decode a single full UDP packet without fixed length of delimiter.

```
public class SampleServerHandler extends ServerDataHandler {

    private static final Logger LOG = LoggerFactory.getLogger(SampleServerHandler.class);

    public static void main(String args[]) throws Exception {
        LOG.info("Sample server startup");
        new RmUdpServer(new SampleServerHandler());
    }

    @Override
    public void handlePassings(Collection<Passing> passings) {
        LOG.info("Passings message received");
        for(Passing passing: passings){
            LOG.info("\t"+passing);
        }
    }

    @Override
    public int getServerPort() {
        return 11000;
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
