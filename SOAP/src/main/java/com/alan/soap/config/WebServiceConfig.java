package com.alan.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.server.endpoint.interceptor.PayloadLoggingInterceptor;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.List;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    public static final String NBA_TEAMS_PORT = "NbaTeamsPort";
    public static final String WS = "/ws";
    public static final String TARGET_NAMESPACE = "http://www.alan.com/soap/nba";

    @Override
    public void addInterceptors(List<EndpointInterceptor> interceptors) {
        PayloadLoggingInterceptor interceptor = new PayloadLoggingInterceptor();
        interceptors.add(interceptor);
    }
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "nba")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema nbaTeamsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(NBA_TEAMS_PORT);
        wsdl11Definition.setLocationUri(WS);
        wsdl11Definition.setTargetNamespace(TARGET_NAMESPACE);
        wsdl11Definition.setSchema(nbaTeamsSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema countriesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("ApiNba.xsd"));
    }

}
