package com.maghzaz.xmlparsers.dto;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParserDemo {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        
		//Create the parser
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream("xml/DriversLicense.xml"));
		
		//Create a new instance of drivers license class
		DriversLicense license = new DriversLicense();
		
		//get data & parse data
		//deal with Number
		NodeList numberList = document.getElementsByTagName("Number");
		Node numberItem =  numberList.item(0);
		
	    //set number in license instance
		license.setNumber(Long.parseLong(numberItem.getTextContent()));
        
		//deal with First Name
		NodeList FirstNameList = document.getElementsByTagName("FirstName");
		Node FirstNameItem =  FirstNameList.item(0);
				
	    //set First Name in license instance
		license.setFirstName(FirstNameItem.getTextContent());

		//deal with Last Name
		NodeList LastNameList = document.getElementsByTagName("LastName");
		Node LastNameItem = LastNameList.item(0);
				
		//set Last Name in license instance
		license.setLastName(LastNameItem.getTextContent());
		
		System.out.println("Number : "+license.getNumber());
		System.out.println("First Name : "+license.getFirstName());
		System.out.println("Last Name : "+license.getLastName());

	}

}
