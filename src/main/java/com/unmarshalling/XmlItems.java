package com.unmarshalling;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@NoArgsConstructor
public class XmlItems {
	@XmlElement(name = "item")
    public List<XmlItem> xmlItemList;
	
	public List<XmlItem> itemList() {
		return xmlItemList;
	}
}
