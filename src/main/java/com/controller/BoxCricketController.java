package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.bean.BoxCricketBean;
import com.util.Validators;

@Controller
public class BoxCricketController {

    @GetMapping("/BoxCricketReg")
    public String BoxCricketReg() {
        return "BoxCricRegForm";
    }
    
    @PostMapping("/StudentRegister")
    public String StudentReg(BoxCricketBean studentregbean, Model model) {
        boolean isError = false;

        // Validate student name
        if (Validators.isBlank(studentregbean.getStudentName())) {
            isError = true;
            model.addAttribute("studentNameError", "Please enter student name");
        } else if (!Validators.isAlpha(studentregbean.getStudentName())) {
            isError = true;
            model.addAttribute("studentNameError", "Please enter a valid student name");
        } else {
            model.addAttribute("StudentNameValue", studentregbean.getStudentName());
        }

        // Validate playing type
        if (studentregbean.getPlayingType() == null) {
            isError = true;
            model.addAttribute("playerTypeError", "Please select playing type");
        } else {
            model.addAttribute("playerTypeValue", studentregbean.getPlayingType());
        }

        // Validate food choice
        if (studentregbean.getFoodChoice().equals("-1")) {
            isError = true;
            model.addAttribute("foodPreferenceError", "Please select food preference");
        } else {
            model.addAttribute("foodPreferenceValue", studentregbean.getFoodChoice());
        }
		if(studentregbean.getDrinks()==null)
		{
			isError=true;
			model.addAttribute("drinkError","*Please Select at least one drink");
		}
		else {
			model.addAttribute("drinkValue", studentregbean.getDrinks());
		}
		if (isError == true) 
		{
			return "BoxCricRegForm";
		} else 
		{
			model.addAttribute("reg", studentregbean);
			return "RegDetails";
		}
    }
}
