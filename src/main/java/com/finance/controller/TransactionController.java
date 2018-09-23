package com.finance.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.servlet.ModelAndView;

import com.finance.common.Constants;
import com.finance.common.exception.BusinessException;
import com.finance.common.session.SessionUser;
import com.finance.common.session.SessionUtils;
import com.finance.form.FolioForm;
import com.finance.form.FolioSelection;
import com.finance.form.FundForm;
import com.finance.form.FundSelection;
import com.finance.form.HoldingInputForm;
import com.finance.form.TransactionForm;
import com.finance.form.TransactionSelectionForm;
import com.finance.processor.FundProcessor;
import com.finance.service.FolioService;
import com.finance.service.TransactionService;
import com.finance.vo.HoldingVO;
import com.finance.vo.MutualFundFolioVO;
import com.finance.vo.MutualFundTransactionVO;
import com.finance.vo.MutualFundVO;

@Controller
@Scope("prototype")
public class TransactionController {
	@Autowired
	FolioService folioService;
	
	public void setFolioService(FolioService folioService) {
		this.folioService = folioService;
	}

	@Autowired
	TransactionService transactionService;
	
	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}


	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(true);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping(value="/addTransaction.form",method=RequestMethod.POST)
	public String addTransaction(Model theModel,@Valid @ModelAttribute("folioSelection") FolioSelection form,
			BindingResult bindingResult,HttpServletRequest req){
		if(bindingResult.hasErrors()) {
			List<MutualFundFolioVO> folioList = folioService.fetchAllFunds();
			MutualFundFolioVO vo =null;
			for(int i=0;i<folioList.size();i++) {
				vo = (MutualFundFolioVO)folioList.get(i);
			}
			theModel.addAttribute("folioList",folioList);
			return "viewFolios";
		}
		TransactionForm transactionForm = FundProcessor.mapFolioSelectionToTransactionForm(form);
		theModel.addAttribute("transactionForm",transactionForm);
		return "addTransaction";
	}

	@RequestMapping(value="/processAddTransaction.form", method=RequestMethod.POST)
	public String processAddTransaction(@Valid @ModelAttribute("transactionForm") TransactionForm form,
								BindingResult bindingResult, HttpServletRequest req) {
		System.out.println(form.toString());
		if(bindingResult.hasErrors()) {
			return "addTransaction";
		}else {
			HttpSession session = req.getSession(false);
			SessionUser user = (SessionUser)SessionUtils.getSessionAttribute(session, Constants.SESSION_USER_KEY);
			form.setCreateDate(new java.util.Date());
			form.setCreateBy(user.getUserId());
			MutualFundTransactionVO vo = FundProcessor.mapFundTransactionToVO(form);
			try {
				transactionService.addTransaction(vo);
			} catch (Exception e) {
				form.setErrorMessage(e.getMessage());
				e.printStackTrace();
				return "addTransaction";
			}
			return "transactionAddConfirmation";
		}
	}
	
	
	@ModelAttribute("transactionTypeList")
	public Map transactionTypeList() {
		Map<String,String> transactionType = new LinkedHashMap<String,String>();
		transactionType.put("PURCHASE", "PURCHASE");
		transactionType.put("SIP", "SIP");
		transactionType.put("SI", "SI");
		transactionType.put("REDEMPTION", "REDEMPTION");
		transactionType.put("SO", "SO");
		return transactionType;
	}

	@ModelAttribute("transactionModeList")
	public Map transactionModeList() {
		Map<String,String> transactionMode = new LinkedHashMap<String,String>();
		transactionMode.put("MFU", "MFU");
		transactionMode.put("ICICIDirect", "ICICIDirect");
		transactionMode.put("MFHouse", "MFHouse");
		return transactionMode;
	}
	
	
	@RequestMapping(value="/viewTransaction.form",method=RequestMethod.POST)
	public String viewTransaction(Model theModel, @Valid @ModelAttribute("folioSelection") FolioSelection form,
			BindingResult bindingResult,HttpServletRequest req) {
		if(bindingResult.hasErrors()) {
			List<MutualFundFolioVO> folioList = folioService.fetchAllFunds();
			MutualFundFolioVO vo =null;
			for(int i=0;i<folioList.size();i++) {
				vo = (MutualFundFolioVO)folioList.get(i);
			}
			theModel.addAttribute("folioList",folioList);
			return "viewFolios";
		}
		TransactionForm transactionForm = FundProcessor.mapFolioSelectionToTransactionForm(form);
		List<MutualFundTransactionVO> transactionList = transactionService.fetchTransactionsForFolio(FundProcessor.mapTransactionFormToFolioId(transactionForm));
		theModel.addAttribute("transactionList",transactionList);
		return "viewTransaction";
	}

 	@RequestMapping(value = "/exportTransactionListExcel.form", method = RequestMethod.GET)
	public ModelAndView exportHoldingListExcel(Model theModel,@Valid @ModelAttribute("holdingInput") HoldingInputForm form,
			BindingResult bindingResult, HttpServletRequest req) {
			List<MutualFundTransactionVO> transactionList = transactionService.fetchAllTransactions();
			return new ModelAndView("TransactionListExcel", "transactionList", transactionList);
	}
	
 	@RequestMapping(value = "/deleteTransaction.form", method = RequestMethod.POST)
 	public String deleteTransaction(Model theModel,@Valid @ModelAttribute("transactionSelection") TransactionSelectionForm form,
			BindingResult bindingResult, HttpServletRequest req) {
 		System.out.println(form.getTransactionKey()); 
 		transactionService.deleteTransaction(form);
 		return "deleteTransactionConfirmation";
 	}
	
}
