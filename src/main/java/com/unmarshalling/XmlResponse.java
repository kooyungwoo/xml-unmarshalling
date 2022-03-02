package com.unmarshalling;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@NoArgsConstructor
@XmlRootElement(name="response")
public class XmlResponse {
	@XmlElement(name = "body")
    public XmlBody xmlBody;
	
	public XmlBody bodyInfo() {
		return xmlBody;
	}
}
