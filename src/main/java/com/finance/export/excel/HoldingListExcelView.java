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
import com.sun.prism.paint.Color;

public class HoldingListExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
            Workbook workbook,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {

	       // change the file name
        response.setHeader("Content-Disposition", "attachment; filename=\"holding.xls\"");
        Sheet excelSheet = workbook.createSheet("Holdings");
		setExcelHeader(workbook,excelSheet); 
		List<HoldingVO> holdingList = (List<HoldingVO>) model.get("holdingList");
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
		excelHeader.createCell(1).setCellValue("Fund Name");
		excelHeader.createCell(2).setCellValue("Scheme Name");
		excelHeader.createCell(3).setCellValue("Folio Number");
		excelHeader.createCell(4).setCellValue("Scheme Mode");
		excelHeader.createCell(5).setCellValue("Scheme Category");
		excelHeader.createCell(6).setCellValue("Units");
		excelHeader.createCell(7).setCellValue("NAV");
		excelHeader.createCell(8).setCellValue("Amount");
		excelHeader.createCell(9).setCellValue("Purchase Cost");
		excelHeader.createCell(10).setCellValue("Base Units");
		excelHeader.createCell(11).setCellValue("Base NAV");
		excelHeader.createCell(12).setCellValue("Base NAV Date");
		for(int i=0;i<13;i++) {
			excelHeader.getCell(i).setCellStyle(headerStyle);
			excelSheet.autoSizeColumn(i);
		}

	}
	
	public void setExcelRows(Workbook workbook,Sheet excelSheet, List holdingList){
		int record = 1;
		for (int i=0;i<holdingList.size();i++) {
			HoldingVO holding = (HoldingVO)holdingList.get(i);
			Row excelRow = excelSheet.createRow(record++);
			excelRow.createCell(0).setCellValue(i+1);
			excelRow.createCell(1).setCellValue(holding.getFundName());
			excelRow.createCell(2).setCellValue(holding.getSchemeName());
			excelRow.createCell(3).setCellType(CellType.STRING);
			excelRow.createCell(3).setCellValue(holding.getFolioNumber());
			excelRow.createCell(4).setCellValue(holding.getSchemeMode());
			excelRow.createCell(5).setCellValue(holding.getSchemeCategory());
			excelRow.createCell(6).setCellType(CellType.NUMERIC);
			excelRow.createCell(6).setCellValue(holding.getTransactedUnits());
			excelRow.createCell(7).setCellType(CellType.NUMERIC);
			excelRow.createCell(7).setCellValue(holding.getLastNAV());
			excelRow.createCell(8).setCellType(CellType.NUMERIC);
			excelRow.createCell(8).setCellValue(holding.getCurrentAmout());
			excelRow.createCell(9).setCellType(CellType.NUMERIC);
			excelRow.createCell(9).setCellValue(holding.getTotalAmount());
			excelRow.createCell(10).setCellType(CellType.NUMERIC);
			excelRow.createCell(10).setCellValue(holding.getBaseUnits());
			excelRow.createCell(11).setCellType(CellType.NUMERIC);
			excelRow.createCell(11).setCellValue(holding.getBaseNAV());
			excelRow.createCell(12).setCellValue(holding.getBaseNAVDate());
			for(int j=0;j<13;j++) {
				excelSheet.autoSizeColumn(j); 
			}
		}
	}
}
