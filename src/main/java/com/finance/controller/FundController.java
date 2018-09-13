package com.finance.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

import com.finance.common.Constants;
import com.finance.common.exception.BusinessException;
import com.finance.common.session.SessionUser;
import com.finance.common.session.SessionUtils;
import com.finance.entities.FundMaster;
import com.finance.form.FolioForm;
import com.finance.form.FundForm;
import com.finance.form.FundSelection;
import com.finance.login.LoginForm;
import com.finance.processor.FundProcessor;
import com.finance.service.FundService;
import com.finance.vo.MutualFundVO;

@Controller
@Scope("prototype")
public class FundController {

	@Autowired
	FundService fundService;
	
	public void setFundService(FundService fundService) {
		this.fundService = fundService;
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(true);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@RequestMapping(value="/addFund.form",method=RequestMethod.GET)
	public String addFund(Model theModel,HttpServletRequest req){
		theModel.addAttribute("fund", new FundForm());
		return "addFund";
	}

	@RequestMapping(value="/viewFunds.form",method=RequestMethod.GET)
	public String viewFunds(Model theModel,HttpServletRequest req){
		List<MutualFundVO> fundList = fundService.fetchAllFunds();
		MutualFundVO vo =null;
		for(int i=0;i<fundList.size();i++) {
			vo = (MutualFundVO)fundList.get(i);
			//System.out.println(vo);
		}
		theModel.addAttribute("fundList",fundList);
		theModel.addAttribute("fundSelection",new FundSelection());
		return "viewFunds";
	}
	
	@ModelAttribute("schmeModeList")
	public Map schmeModeList() {
		Map<String,String> schemeMode = new LinkedHashMap<String,String>();
		schemeMode.put("D", "Direct");
		schemeMode.put("R", "Regular");
		return schemeMode;
	}

	@ModelAttribute("schmeCategoryList")
	public Map schmeCategoryList() {
		Map<String,String> schemeCategory = new LinkedHashMap<String,String>();
		schemeCategory.put("Equity", "Equity");
		schemeCategory.put("Debt", "Debt");
		return schemeCategory;
	}

	
	@RequestMapping(value="/processAddFund.form", method=RequestMethod.POST)
	public String processAddFund(@Valid @ModelAttribute("fund") FundForm form,
								BindingResult bindingResult, HttpServletRequest req) {
//		System.out.println(form.toString());
		if(bindingResult.hasErrors()) {
			return "addFund";
		}else {
			HttpSession session = req.getSession(false);
			SessionUser user = (SessionUser)SessionUtils.getSessionAttribute(session, Constants.SESSION_USER_KEY);
			form.setCreateDate(new java.util.Date());
			form.setCreateUserId(user.getUserId());
			MutualFundVO vo = FundProcessor.mapFundToVO(form);
			try {
				fundService.addFund(vo);
			} catch (BusinessException e) {
				form.setErrorMessage(e.getExceptionMessage());
				e.printStackTrace();
				return "addFund";
			}
			return "fundAddConfirmation";
		}
	}
	
	
	@RequestMapping(value="/updateFund.form",method=RequestMethod.POST)
	public String addFolio(Model theModel,@Valid @ModelAttribute("fundSelection") FundSelection form,
			BindingResult bindingResult,HttpServletRequest req){
		FundForm fundForm = FundProcessor.mapFundSelectionToFundForm(form);
		MutualFundVO vo = FundProcessor.mapFundToVO(fundForm);
		MutualFundVO voPersited = fundService.fetchFund(vo);
		fundForm.setBaseUnits(voPersited.getBaseUnits());
		fundForm.setBaseNav(voPersited.getBaseNav());
		fundForm.setBaseNavDate(voPersited.getBaseNavDate());
		fundForm.setLatestNav(voPersited.getLatestNav());
		fundForm.setLatestNavDate(voPersited.getLatestNavDate());
		theModel.addAttribute("fund",fundForm);
		return "updateFund";
	}

	@RequestMapping(value="/processUpdateFund.form",method=RequestMethod.POST)
	public String addFolio(@Valid @ModelAttribute("fund") FundForm form,
			BindingResult bindingResult, HttpServletRequest req){
		if(bindingResult.hasErrors()) {
			return "addFund";
		}else {
			HttpSession session = req.getSession(false);
			SessionUser user = (SessionUser)SessionUtils.getSessionAttribute(session, Constants.SESSION_USER_KEY);
			form.setUpdateDate(new java.util.Date());
			form.setUpdateUserId(user.getUserId());
			MutualFundVO vo = FundProcessor.mapFundToVO(form);
			try {
				fundService.updateFund(vo);
			} catch (BusinessException e) {
				form.setErrorMessage(e.getExceptionMessage());
				e.printStackTrace();
				return "updateFund";
			}
			form.setSuccessMessage("Fund Updated Successfully");
			return "updateFund";
		}
	}
	
}