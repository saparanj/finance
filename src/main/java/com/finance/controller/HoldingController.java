package com.finance.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.finance.form.FolioSelection;
import com.finance.form.FundForm;
import com.finance.form.HoldingInputForm;
import com.finance.service.HoldingService;
import com.finance.vo.HoldingVO;

@Controller
@Scope("prototype")
public class HoldingController {

	@Autowired
	HoldingService holdingService;
	
	

	public void setHoldingService(HoldingService holdingService) {
		this.holdingService = holdingService;
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(true);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping(value="/viewHoldingInput.form",method=RequestMethod.GET)
	public String viewHoldingInput(Model theModel,HttpServletRequest req) {
		HoldingInputForm form = new HoldingInputForm();
		theModel.addAttribute("holdingInput", form);
		return "viewHoldingInput";
	}
	
	@RequestMapping(value="/viewHoldings.form",method=RequestMethod.POST)
	public String viewHoldings(Model theModel,@Valid @ModelAttribute("holdingInput") HoldingInputForm form,
			BindingResult bindingResult, HttpServletRequest req) {
		if(bindingResult.hasErrors()) {
			return "viewHoldingInput";
		}else {
			List<HoldingVO> holdings = holdingService.fetchAllFunds(form.getFolioHolder());
			theModel.addAttribute("holdings",holdings);
			return "viewHoldings";
		}
	}
 	@RequestMapping(value = "/exportHoldingListExcel.form", method = RequestMethod.POST)
	public ModelAndView exportHoldingListExcel(Model theModel,@Valid @ModelAttribute("holdingInput") HoldingInputForm form,
			BindingResult bindingResult, HttpServletRequest req) {
		if(bindingResult.hasErrors()) {
			return new ModelAndView("viewHoldingInput");
		}else {
			List<HoldingVO> holdings = holdingService.fetchAllFunds(form.getFolioHolder());
			return new ModelAndView("HoldingListExcel", "holdingList", holdings);
		}
	}

}
