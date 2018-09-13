package com.finance.export.excel;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.finance.vo.HoldingVO;
import com.finance.vo.MutualFundTransactionVO;
import com.sun.prism.paint.Color;

public class TransactionListExcelView  extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
            Workbook workbook,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

	       // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"holding.xls\"");
        Sheet excelSheet = workbook.createSheet("Holdings");
		setExcelHeader(workbook,excelSheet); 
		List<HoldingVO> holdingList = (List<HoldingVO>) model.get("transactionList");
		setExcelRows(workbook,excelSheet,holdingList);
		
	}

	public void setExcelHeader(Workbook workbook,Sheet excelSheet) {
		CellStyle headerStyle = workbook.createCellStyle();
		Font font = workbook.createFont();
		font.setItalic(true);
		font.setFontName("Ariel");
		font.setBold(true);
		font.setColor(Font.COLOR_RED);
		headerStyle.setFont(font);
		Row excelHeader = excelSheet.createRow(0);
		excelHeader.createCell(0).setAsActiveCell();
		excelHeader.createCell(0).setCellValue("Sr.No");
		excelHeader.createCell(1).setCellValue("Folio");
		excelHeader.createCell(2).setCellValue("Fund Name");
		excelHeader.createCell(3).setCellValue("Scheme Name");
		excelHeader.createCell(4).setCellValue("Scheme Category");
		excelHeader.createCell(5).setCellValue("Scheme Mode");
		excelHeader.createCell(6).setCellValue("Tratsaction Type");
		excelHeader.createCell(7).setCellValue("Units");
		excelHeader.createCell(8).setCellValue("NAV");
		excelHeader.createCell(9).setCellValue("Amount");
		excelHeader.createCell(10).setCellValue("Date");
		for(int i=0;i<11;i++) {
			excelHeader.getCell(i).setCellStyle(headerStyle);
			excelSheet.autoSizeColumn(i);
		}

	}
	
	public void setExcelRows(Workbook workbook,Sheet excelSheet, List transactionList){
		int record = 1;
		for (int i=0;i<transactionList.size();i++) {
			MutualFundTransactionVO vo = (MutualFundTransactionVO)transactionList.get(i);
			Row excelRow = excelSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(i+1);
			excelRow.createCell(1).setCellType(CellType.STRING);
			excelRow.createCell(1).setCellValue(vo.getFolioNumber());
			excelRow.createCell(2).setCellValue(vo.getFundName());
			excelRow.createCell(3).setCellValue(vo.getSchemeName());
			excelRow.createCell(4).setCellValue(vo.getSchemeCategory());
			excelRow.createCell(5).setCellValue(vo.getSchemeMode());
			excelRow.createCell(6).setCellValue(vo.getTransactionType());
			excelRow.createCell(7).setCellType(CellType.NUMERIC);
			excelRow.createCell(7).setCellValue(vo.getTransactedUnits());
			excelRow.createCell(8).setCellType(CellType.NUMERIC);
			excelRow.createCell(8).setCellValue(vo.getTrasactedNav());
			excelRow.createCell(9).setCellType(CellType.NUMERIC);
			excelRow.createCell(9).setCellValue(vo.getTransactionAmount());
			excelRow.createCell(10).setCellValue(vo.getTransactionDate());
			for(int j=0;j<11;j++) {
				excelSheet.autoSizeColumn(j); 
			}
		}
	}


}
