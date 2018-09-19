package com.finance.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.finance.form.FolioForm;
import com.finance.form.FolioSelection;
import com.finance.form.FundForm;
import com.finance.form.FundSelection;
import com.finance.form.TransactionForm;
import com.finance.processor.FundProcessor;
import com.finance.service.FolioService;
import com.finance.service.FundService;
import com.finance.vo.MutualFundFolioVO;
import com.finance.vo.MutualFundVO;

@Controller
@Scope("prototype")
public class FolioController {
	@Autowired
	FundService fundService;
	
	public void setFundService(FundService fundService) {
		this.fundService = fundService;
	}
	
	@Autowired
	FolioService folioService;
	
	public void setFolioService(FolioService folioService) {
		this.folioService = folioService;
	}



	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(true);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	@RequestMapping(value="/addFolio.form",method=RequestMethod.POST)
	public String addFolio(Model theModel,@Valid @ModelAttribute("fundSelection") FundSelection form,
			BindingResult bindingResult,HttpServletRequest req){
		if(bindingResult.hasErrors()) {
			List<MutualFundVO> fundList = fundService.fetchAllFunds();
			MutualFundVO vo =null;
			for(int i=0;i<fundList.size();i++) {
				vo = (MutualFundVO)fundList.get(i);
			}
			theModel.addAttribute("fundList",fundList);
			return "viewFunds";
		}
		FolioForm folioForm = FundProcessor.mapFundSelectionToFolioForm(form);
		theModel.addAttribute("folioForm",folioForm);
		return "addFolio";
	}

	@RequestMapping(value="/processAddFolio.form", method=RequestMethod.POST)
	public String processAddFolio(@Valid @ModelAttribute("folioForm") FolioForm form,
								BindingResult bindingResult, HttpServletRequest req) {
		System.out.println(form.toString());
		if(bindingResult.hasErrors()) {
			return "addFolio";
		}else {
			HttpSession session = req.getSession(false);
			SessionUser user = (SessionUser)SessionUtils.getSessionAttribute(session, Constants.SESSION_USER_KEY);
			form.setCreateDate(new java.util.Date());
			form.setCreatedBy(user.getUserId());
			//form.setFolioHolder(user.getUserId());
			MutualFundFolioVO vo = FundProcessor.mapFundFolioToVO(form);
			try {
				folioService.addFolio(vo);
			} catch (BusinessException e) {
				form.setErrorMessage(e.getExceptionMessage());
				e.printStackTrace();
				return "addFolio";
			}
			return "fundFolioAddConfirmation";
		}
	}
	
	///viewFolios.form
	@RequestMapping(value="/viewFolios.form",method=RequestMethod.GET)
	public String viewFolios(Model theModel,HttpServletRequest req){
		List<MutualFundFolioVO> folioList = folioService.fetchAllFunds();
		MutualFundFolioVO vo =null;
		for(int i=0;i<folioList.size();i++) {
			vo = (MutualFundFolioVO)folioList.get(i);
			//System.out.println(vo);
		}
		theModel.addAttribute("folioList",folioList);
		theModel.addAttribute("folioSelection",new FolioSelection());
		return "viewFolios";
	}
	

	@RequestMapping(value="/updateFolio.form",method=RequestMethod.POST)
	public String updateFolio(Model theModel,@Valid @ModelAttribute("folioSelection") FolioSelection form,
			BindingResult bindingResult,HttpServletRequest req){
		FolioForm folioForm = FundProcessor.mapFolioSelectionToFolioForm(form);
		MutualFundFolioVO vo =  FundProcessor.mapFundFolioToVO(folioForm);
		MutualFundFolioVO vofromDB = null;
		try {
			vofromDB = folioService.fetchFolio(vo);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		folioForm = FundProcessor.mapMutualFundVOToFolioForm(vofromDB);
		theModel.addAttribute("folioForm",folioForm);
		return "viewUpdateFolio";
	}
	@RequestMapping(value="/processUpdateFolio.form",method=RequestMethod.POST)
	public String processUpdateFolio(@Valid @ModelAttribute("folioForm") FolioForm form,
			BindingResult bindingResult, HttpServletRequest req){
		HttpSession session = req.getSession(false);
		SessionUser user = (SessionUser)SessionUtils.getSessionAttribute(session, Constants.SESSION_USER_KEY);
		MutualFundFolioVO vo =  FundProcessor.mapFundFolioToVO(form);
		vo.setUpdatedBy(user.getUserId());
		try {
			folioService.updateFolio(vo);
		} catch (BusinessException e) {
			form.setErrorMessage(e.getExceptionMessage());
			return "viewUpdateFolio";
		}
		return "updateFolioConfirmation";
	}
	
}
