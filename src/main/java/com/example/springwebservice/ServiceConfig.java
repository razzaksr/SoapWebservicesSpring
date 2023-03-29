package com.example.springwebservice;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import javax.servlet.ServletContext;

@EnableWs
@Configuration
public class ServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext applicationContext){
        MessageDispatcherServlet servlet=new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet,"/haiservice/*");
    }
    @Bean(name="hai")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema haiSchema){
        DefaultWsdl11Definition wsdl11Definition=new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("HaiPort");
        wsdl11Definition.setLocationUri("/haiservice");
        wsdl11Definition.setTargetNamespace("http://com.example.springwebservice");
        wsdl11Definition.setSchema(haiSchema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema haiSchema(){
        return new SimpleXsdSchema(new ClassPathResource("hai.xsd"));
    }
}
