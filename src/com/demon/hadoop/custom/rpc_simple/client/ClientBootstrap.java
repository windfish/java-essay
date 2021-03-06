package com.demon.hadoop.custom.rpc_simple.client;

import com.demon.hadoop.custom.rpc_simple.service.DateTimeService;
import com.demon.hadoop.custom.rpc_simple.utils.Constants;

import java.util.Date;

public class ClientBootstrap {

    public static void main(String[] args) {
        Client client = new Client(Constants.HOST, Constants.PORT);
        client.start();

        DateTimeService serviceProxy = (DateTimeService) client.getProxy(DateTimeService.class);
        String result = serviceProxy.hello("xxx");
        System.out.println("client invoke service.hello result: " + result);

        String result2 = serviceProxy.hello("xxx222");
        System.out.println("client invoke service.hello result: " + result2);

        String result3 = serviceProxy.format(new Date());
        System.out.println("client invoke format result: " + result3);
    }
}
