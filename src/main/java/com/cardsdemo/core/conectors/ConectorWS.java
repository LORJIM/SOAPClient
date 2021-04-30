package com.cardsdemo.core.conectors;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.jaimeMW.springsoap.client.gen.GetCountryRequest;
import com.jaimeMW.springsoap.client.gen.GetCountryResponse;

public class ConectorWS extends WebServiceGatewaySupport { //el conector es el que manda la request XML al server y recibe la response
	
	
	//aqui estaran todos los web services de este conector/server
	public GetCountryResponse getCountry(String name) {
        GetCountryRequest request = new GetCountryRequest(); //creamos la request JAXB
        request.setName(name); //seteamos los campos de entrada

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
          .marshalSendAndReceive(request); //llamamos al server y nos responde
        return response;
    }
}
