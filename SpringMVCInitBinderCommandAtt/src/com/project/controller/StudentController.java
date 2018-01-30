package com.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.custome.edit.StudentNameCustomeEditor;
import com.project.model.Student;

@Controller
public class StudentController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, true));
		
		binder.registerCustomEditor(String.class, "name", new StudentNameCustomeEditor());
		binder.setDisallowedFields("dob");
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String redirect(Model model) {
		model.addAttribute("student", new Student());
		return "register";
	}

	@RequestMapping(value = "/registerSuccess", method = RequestMethod.POST)
	public ModelAndView registerSuccess(@ModelAttribute("student") Student student, BindingResult result) {
		
		if(student.getName().isEmpty()){
			throw new RuntimeException();
		}
		if(result.hasErrors()){
			return new ModelAndView("register");
		}
		
		System.out.println(student.getDob());
		ModelAndView modelAndView = new ModelAndView("success", "stud", student);
		//modelAndView.addObject("student", student);
		
		return modelAndView;
	}
	
	
}
