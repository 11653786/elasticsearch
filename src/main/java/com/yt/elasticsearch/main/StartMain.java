package com.yt.elasticsearch.main;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by PUZE84 on 2017/6/21.
 */
public class StartMain {
    public static void main(String[] args) {
        // on startup

        TransportClient client = null;
        try {
            client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9200));
            GetResponse response = client.prepareGet("blog", "article", "1").execute().actionGet();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        client.close();
    }
}
