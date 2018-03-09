package com.xsis.batch137.controller;

import java.io.IOException;
import java.util.List;
 
import javax.servlet.http.HttpServletRequest;
 
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xsis.batch137.model.Employee;
import com.xsis.batch137.service.EmployeeService;

@Controller
@RequestMapping("/")
public class EmployeeController {
	/*private static final Logger logger = Logger
            .getLogger(EmployeeController.class);*/
 
    /*public EmployeeController() {
        System.out.println("EmployeeController()");
    }*/
 
    @Autowired
    private EmployeeService employeeService;
 
    @RequestMapping(value = "/view-emp")
    public ModelAndView listEmployee(ModelAndView model) throws IOException {
        List<Employee> listEmployee = employeeService.selectAll();
        model.addObject("listEmployee", listEmployee);
        //               attribute name  attribute value<-- dari list employee di atas
        model.setViewName("employee/view");
        //				 alamat yang mau ditampilkan
        return model;
    }
 
    @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Employee employee = new Employee();
        model.addObject("employee", employee);
        model.setViewName("/employee/form");
        return model;
    }
 
    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
        if (employee.getId() == 0) { // if employee id is 0 then creating the
            // employee other updating the employee
            employeeService.save(employee);
        } else {
            employeeService.update(employee);
        }
        return new ModelAndView("redirect:/view-emp");
    }
 
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
    	int empId = Integer.parseInt(request.getParameter("id"));
    	employeeService.delete(empId);
        return new ModelAndView("redirect:/view-emp");
    }
 
    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.getOne(employeeId);
        ModelAndView model = new ModelAndView("/employee/form");
        model.addObject("employee", employee);
 
        return model;
    }
}
