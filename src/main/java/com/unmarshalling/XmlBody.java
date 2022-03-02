package com.unmarshalling;

import javax.xml.bind.annotation.XmlElement;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@NoArgsConstructor
public class XmlBody {
	@XmlElement(name = "items")
    public XmlItems xmlItems;
	
	public XmlItems itemsInfo() {
		return xmlItems;
	}
}
