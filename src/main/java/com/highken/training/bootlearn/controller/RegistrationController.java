package com.highken.training.bootlearn.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.view.RedirectView;

import com.highken.training.bootlearn.controller.model.Registration;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	@GetMapping
	String registrationView(Model model) {
		model.addAttribute("registration", new Registration("Samik","Roy"));
		return "registration_view";
	}
	
	@PostMapping
	RedirectView registrationSubmit(@ModelAttribute Registration registration,Model model,RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("registration", registration);
		return new RedirectView("/registration/result",true);
	}
	
	@GetMapping("/result")
	String registrationResult(Model model,HttpServletRequest httpServletRequest) {
		Map<String,?> map=RequestContextUtils.getInputFlashMap(httpServletRequest);
		if(map !=null) {
			Registration registration=(Registration) map.get("registration");
			model.addAttribute("registration",registration);
		}
		return "registration_result_view";
	}
}
