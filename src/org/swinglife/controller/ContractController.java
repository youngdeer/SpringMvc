package org.swinglife.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.swinglife.form.Contract;

@Controller
public class ContractController {
	
	@RequestMapping(value="/addContact",method=RequestMethod.POST)  
	public String addContract(@ModelAttribute("contact")
			Contract contract,BindingResult result){
		System.out.println("FirstName :" + contract.getFirstname()+
				" LastName :" + contract.getLastname());
		return "redirect:contacts.html";
	}
	
	@RequestMapping("/contacts")
	public ModelAndView showContacts(){
		return new ModelAndView("contacts", "command", new Contract());
	}
}
