/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.afdemp.cb8.springhibernatenoxml.controllers;

import java.util.List;
import org.afdemp.cb8.springhibernatenoxml.models.Employee;
import org.afdemp.cb8.springhibernatenoxml.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author George.Pasparakis
 */
@Controller
@RequestMapping("/")
public class TestController {
    @Autowired
    EmployeeService service;
    
    @RequestMapping(value = {"/", "/test"}, method = RequestMethod.GET)
    public String test(ModelMap model) {
        List<Employee> employees = service.findAllEmployees();
        model.addAttribute("employees", employees);
        return "employees";
    }
    
    @RequestMapping(value = "/employeeupdate/{id}", method = RequestMethod.GET)
    public String test(ModelMap model,@PathVariable("id") String id) {
       Employee e = service.findById(Integer.parseInt(id));
       model.addAttribute("title","Update");
       model.addAttribute("what","save");
       model.addAttribute("employee", e);
       return "addeditemployee";
    }
    
    @RequestMapping(value = "/addemployee", method = RequestMethod.GET)
	public String add(ModelMap model) {
            model.addAttribute("title", "Add");
            model.addAttribute("what", "save");
            model.addAttribute("employee", new Employee());
            return "addeditemployee";
        }
        
        @RequestMapping(value = "/employeesave", method = RequestMethod.POST)
	public String addsave(ModelMap model,@ModelAttribute("employee") Employee e) {
            if (e.getId()==0){//new employee
                service.saveEmployee(e);
                model.addAttribute("message", "Insert Completed");
            }else{//update old employee
                Employee fromDBempl = service.findById(e.getId());
                fromDBempl.setJoiningDate(e.getJoiningDate());
                fromDBempl.setName(e.getName());
                fromDBempl.setSalary(e.getSalary());
                fromDBempl.setSsn(e.getSsn());
                service.updateEmployee(fromDBempl);
                model.addAttribute("message", "Update Completed");
            }
            List<Employee> employees = service.findAllEmployees();
            model.addAttribute("employees", employees);
            return "employees";
        }
        
        @RequestMapping(value = "/employeedelete/{ssn}", method = RequestMethod.GET)
	public String delete(ModelMap model, @PathVariable String ssn) {
                service.deleteEmployeeBySsn(ssn);
                model.addAttribute("message", "Row successfully deleted");
                List<Employee> employees = service.findAllEmployees();
                model.addAttribute("employees", employees);
                return "employees";
                
	}
    
    
    
}
