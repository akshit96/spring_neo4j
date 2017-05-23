package com.try_hard.neo4jcodegraph;

import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;


@Service
public class XMLCodeService {
    @Autowired
    private EmployeeService employeeService;
    public  void insertCode_XMl(String xml_object){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml_object));
            try {
                Document doc = db.parse(is);
                doc.getDocumentElement().normalize();
                NodeList nList = doc.getElementsByTagName("Employee");
                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    System.out.println("\nCurrent Element :" + nNode.getNodeName());
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        System.out.println("Employee Name : " + eElement
                                .getElementsByTagName("name")
                                .item(0)
                                .getTextContent());
                        String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                        String college = eElement.getElementsByTagName("college_name").item(0).getTextContent();
                        String address = eElement.getElementsByTagName("address").item(0).getTextContent();
                        this.employeeService.add_Employee(new Employee(name,college,address));
                    }

                }
                NodeList nList1 = doc.getElementsByTagName("intern_rel");
                for (int temp = 0; temp < nList1.getLength(); temp++) {
                    Node nNode = nList1.item(temp);
                    System.out.println("\nCurrent Element :" + nNode.getNodeName());
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        System.out.println("Mentor Name : " + eElement.getElementsByTagName("mentor").item(0).getTextContent());
                        System.out.println("Mentee Name : " + eElement.getElementsByTagName("mentee").item(0).getTextContent());
                        String mentor_name = eElement.getElementsByTagName("mentor").item(0).getTextContent();
                        String mentee_name = eElement.getElementsByTagName("mentee").item(0).getTextContent();
                        this.employeeService.add_Relationship(mentor_name,mentee_name);
                    }
                }
            } catch (SAXException e) {
                e.printStackTrace();
                // handle SAXException
            } catch (IOException e) {
                e.printStackTrace();
                // handle IOException
            }
        } catch (ParserConfigurationException e1) {
            e1.printStackTrace();
            // handle ParserConfigurationException
        }
       // System.out.println("Insertion Successful "+xml_object);
    }

    public List<String> getEmployeeByName(String name) {
        return employeeService.findByName(name);
    }
}

