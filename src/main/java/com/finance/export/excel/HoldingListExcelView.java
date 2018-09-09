package com.finance.export.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.finance.vo.HoldingVO;

public class HoldingListExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
            Workbook workbook,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

	       // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"holding.xls\"");
        Sheet excelSheet = workbook.createSheet("Holdings");
		setExcelHeader(excelSheet); 
		List<HoldingVO> holdingList = (List<HoldingVO>) model.get("holdingList");
		setExcelRows(excelSheet,holdingList);
		
	}

	public void setExcelHeader(Sheet excelSheet) {
		Row excelHeader = excelSheet.createRow(0);
		excelHeader.createCell(0).setCellValue("Amount");
	}
	
	public void setExcelRows(Sheet excelSheet, List holdingList){
		int record = 1;
		for (int i=0;i<holdingList.size();i++) {
			HoldingVO holding = (HoldingVO)holdingList.get(i);
			Row excelRow = excelSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(holding.getCurrentAmout());
		}
	}
}
