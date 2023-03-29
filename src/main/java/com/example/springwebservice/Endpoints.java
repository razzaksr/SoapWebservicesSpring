package com.example.springwebservice;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import springwebservice.example.com.AddHaiRequest;
import springwebservice.example.com.AddHaiResponse;
import springwebservice.example.com.ServiceStatus;

@Endpoint
public class Endpoints {
    @Autowired
    private HaiService service;

    private static final String url="http://com.example.springwebservice";

    @PayloadRoot(namespace = url,localPart = "addHaiRequest")
    @ResponsePayload
    public AddHaiResponse callCreate(@RequestPayload AddHaiRequest addHaiRequest){
        AddHaiResponse haiResponse=new AddHaiResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        Hai hai=new Hai();
        BeanUtils.copyProperties(addHaiRequest.getHai(),hai);
        service.create(hai);
        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Added successfully");
        haiResponse.setServiceStatus(serviceStatus);
        return haiResponse;
    }
}
