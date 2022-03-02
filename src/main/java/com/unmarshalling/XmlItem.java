package com.unmarshalling;

import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@NoArgsConstructor
public class XmlItem {
	@XmlElement(name = "aprEng")
	String aprEng;
	@XmlElement(name = "aprKor")
	String aprKor;
	@XmlElement(name = "parkingAirportCodeName")
	String parkingAirportCodeName;
	@XmlElement(name = "parkingFullSpace")
	String parkingFullSpace;
	@XmlElement(name = "parkingGetdate")
	String parkingGetdate;
	@XmlElement(name = "parkingGettime")
	String parkingGettime;
	@XmlElement(name = "parkingIincnt")
	String parkingIincnt;
	@XmlElement(name = "parkingIoutcnt")
	String parkingIoutcnt;
	@XmlElement(name = "parkingIstay")
	String parkingIstay;
}
