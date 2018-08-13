package com.uslogistics.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uslogistics.model.PrimeNumberGenerator;


/**
 * PrimeNumberGeneratorController
 *    - controller for PrimeNumberGenerator
 *    
 * @author angelareaves
 *
 */
@Controller
public class PrimeNumberGeneratorController {
	
	private final Logger logger = LoggerFactory.getLogger(PrimeNumberGeneratorController.class);
	
	
	
	
	@RequestMapping(method = RequestMethod.GET, value="/primenumber_generator")
    public String viewPrimeNumGenForm(Map<String, Object> model) {
		
		logger.debug("viewPrimeNumGenForm() ->");
		
        PrimeNumberGenerator primeForm = new PrimeNumberGenerator();    
        model.put("primeForm", primeForm);
        return "primenumber_generator";
    }
	
    @RequestMapping(method = RequestMethod.POST, value ="/primenumber_generator_results")
    public String showPrimeNumGenResults(@ModelAttribute("primeForm") @Validated PrimeNumberGenerator primeForm, 
    			BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
    	 
    
    	
		logger.debug("showPrimeNumGenResults() ->");
		
		if (result.hasErrors()) {
			return "primenumber_generator";
		} else {

			if(primeForm.getNumberPairInput() != null && !primeForm.getNumberPairInput().equals("")) {
				primeForm.setPairsOfIntegers(primeForm.convertInputToPairsOfNumbers(primeForm.getNumberPairInput()));
				primeForm.setPairsOfNumbers(primeForm.convertPairsToIntTable(primeForm.getPairsOfIntegers()));
				primeForm.setOmitZeroAndOne(true);
				primeForm.getRangeOfPrimesInPairs(primeForm.getPairsOfNumbers());	
			} 
			return "primenumber_generator_results";
		}
        
    }
}
    
    
 
