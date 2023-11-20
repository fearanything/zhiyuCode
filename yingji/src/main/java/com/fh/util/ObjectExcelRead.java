package com.fh.util;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * 从EXCEL导入到数据库
 * 创建人：FH Q313596790
 * 创建时间：2014年12月23日
 * @version
 */
public class ObjectExcelRead {

	/**
	 * @param filepath //文件路径
	 * @param filename //文件名
	 * @param startrow //开始行号
	 * @param startcol //开始列号
	 * @param sheetnum //sheet
	 * @return list
	 */
	public static List<Object> readExcel(String filepath, String filename, int startrow, int startcol, int sheetnum) {
		List<Object> varList = new ArrayList<Object>();

		try {
			File target = new File(filepath, filename);
			FileInputStream fi = new FileInputStream(target);
			Workbook wb = WorkbookFactory.create(fi);
			Sheet sheet = wb.getSheetAt(sheetnum); 					//sheet 从0开始
			int rowNum = sheet.getLastRowNum() + 1; 					//取得最后一行的行号

			for (int i = startrow; i < rowNum; i++) {					//行循环开始
				
				PageData varpd = new PageData();
				Row row = sheet.getRow(i); 							//行
				int cellNum = row.getLastCellNum(); 					//每行的最后一个单元格位置

				for (int j = startcol; j < cellNum; j++) {				//列循环开始
					
					Cell cell = row.getCell(Short.parseShort(j + ""));
					String cellValue = null;
					if (null != cell) {
					 switch (cell.getCellType()) { 					// 判断excel单元格内容的格式，并对其进行转换，以便插入数据库
					 case NUMERIC:
							DecimalFormat df=new DecimalFormat("0");
							cellValue=df.format(cell.getNumericCellValue());
//		                    cellValue = String.valueOf(cell.getNumericCellValue());
		                    break;
					 case FORMULA:
		                    cellValue = String.valueOf(cell.getNumericCellValue());
		                  //cellValue =cell.getCellFormula() + "";
		                    break;
		                case STRING:
		                    cellValue = cell.getStringCellValue();
		                    break;
		                case BOOLEAN:
		                    cellValue = cell.getBooleanCellValue() + "";
		                    break;
		                case BLANK: //空值
		                    cellValue = "";
		                case ERROR:
		                    cellValue = "";
		                    break;
						}
					} else {
						cellValue = "";
					}
					
					varpd.put("var"+j, cellValue);
					
				}
				varList.add(varpd);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		
		return varList;
	}
}
