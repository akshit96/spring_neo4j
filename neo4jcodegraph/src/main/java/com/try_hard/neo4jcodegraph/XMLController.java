package com.try_hard.neo4jcodegraph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/submit")
public class XMLController {
    @Autowired
    private XMLCodeService xmlCodeService;
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping(method = RequestMethod.GET)
    public String helloWorld(){
        return "Hello World";
    }

    @RequestMapping(value="/xmlgraph",method = RequestMethod.POST)
    public String insertXml(@RequestParam("xml_string") String xml_string){
        System.out.println("Successful");
        xmlCodeService.insertCode_XMl(xml_string);
        return "Successful";
    }

    @RequestMapping(value = "/getEmployee/{id}",method = RequestMethod.GET)
    public List<String> getEmployee(@PathVariable("id") String name){
        return xmlCodeService.getEmployeeByName(name);
    }
}
