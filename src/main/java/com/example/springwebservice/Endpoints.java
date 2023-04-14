package com.example.springwebservice;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import springwebservice.example.com.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Endpoint
public class Endpoints {
    @Autowired
    private HaiService service;

    private static final String url="http://com.example.springwebservice";
    //private static final String url="http://localhost:8082/haiservice";
    private Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @PayloadRoot(namespace = url,localPart = "deleteByIdRequest")
    @ResponsePayload
    public DeleteByIdResponse callDelete(@RequestPayload DeleteByIdRequest deleteByIdRequest){
        DeleteByIdResponse response=new DeleteByIdResponse();
        response.setInfo(service.delete(deleteByIdRequest.getId()));
        return response;
    }

    @PayloadRoot(namespace = url,localPart = "getAllHaiRequest")
    @ResponsePayload
    public GetAllHaiResponse callEvery(@RequestPayload GetAllHaiRequest getAllHaiRequest){
        GetAllHaiResponse response=new GetAllHaiResponse();
        List<springwebservice.example.com.Hai> xmlHai=new ArrayList<>();
        List<Hai> entityHai=service.list();

        for(Hai h:entityHai){
            springwebservice.example.com.Hai hi=new springwebservice.example.com.Hai();
            BeanUtils.copyProperties(h,hi);
            xmlHai.add(hi);
        }

        response.getHai().addAll(xmlHai);

        logger.log(Level.INFO,"collected list is "+response);

        return response;
        //return new ClientSoap().getAllHaiResponse();
    }

    @PayloadRoot(namespace = url,localPart = "getHaiByIdRequest")
    @ResponsePayload
    public GetHaiByIdResponse callRead(@RequestPayload GetHaiByIdRequest getHaiByIdRequest){
        GetHaiByIdResponse response=new GetHaiByIdResponse();
//        Hai read = service.read(getHaiByIdRequest.getId());
//        springwebservice.example.com.Hai hai=new springwebservice.example.com.Hai();
//        logger.log(Level.INFO,read.toString()+" "+hai.toString());
        springwebservice.example.com.Hai hai=new springwebservice.example.com.Hai();
        BeanUtils.copyProperties(service.read(getHaiByIdRequest.getId()),hai);
//        BeanUtils.copyProperties(service.read(getHaiByIdRequest.getId()),hai);
        response.setHai(hai);
        return response;
    }

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
