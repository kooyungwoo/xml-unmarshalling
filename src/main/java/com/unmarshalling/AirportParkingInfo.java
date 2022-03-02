package com.unmarshalling;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class AirportParkingInfo  implements ApplicationRunner{

	@Override
	public void run(ApplicationArguments args) throws Exception {
		HttpClient client 				= HttpClientBuilder.create().build();
        HttpGet request 				= new HttpGet("http://openapi.airport.co.kr/service/rest/AirportParking/airportparkingRT?serviceKey=EtJfB1nu62e79mlcOeOOL8k49BIKChfZAdIc3PbFAfIzM6yLr71kyikvvMdEyj7WAO1VExFUf0q2hdivC9upLQ==");
        
        HttpResponse response 	= client.execute(request);
        HttpEntity entity 				= response.getEntity();
        

        String returnXml 				= EntityUtils.toString(entity, "UTF-8");
        
        System.out.println("returnXml: "+returnXml);
        
        //getter����ϴ� ��� counts of IllegalAnnotationExceptions ���� ������ �߻� �� �� ����
        //@XmlAccessorType �� ���õ� ���� �ε� get, set�� �ʵ���ΰ� ���� �Ǳ� ������ �������� element��� ���� ��� ������ key�� ���� �Ǽ� ������
        //�߻��� �׽�Ʈ �ҽ� �̱� ������ get���� ������ �ٷ� ����
        //get�޼ҵ带 ����� ��� https://code.google.com/archive/p/smw2010-prj3-rest/wikis/JAXBSummary.wiki ����
        
        JAXBContext jaxbContext 		= JAXBContext .newInstance(XmlResponse.class);
        Unmarshaller unmarshaller 	= jaxbContext.createUnmarshaller();
        
        XmlResponse xmlResponse 	= (XmlResponse)unmarshaller.unmarshal(new StringReader(returnXml));
        
        List<XmlItem> xmlItemList = xmlResponse.bodyInfo().itemsInfo().itemList();
        for(XmlItem tempInfo:xmlItemList) {
        	System.out.println("aprKor: "+tempInfo.aprKor);
        	System.out.println("parkingFullSpace: "+tempInfo.parkingFullSpace);
        }
	}
}
