package com.fh.util;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.fh.util.PageData;
import com.fh.util.Tools;
/**
 * 导入到EXCEL
 * 类名称：ObjectExcelView.java
 * @author FH Q313596790
 * @version 1.0
 */
public class ObjectExcelViewProjectExport extends AbstractXlsxView{

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        Date date = new Date();
        String filename = Tools.date2Str(date, "yyyyMMddHHmmss");
        String prefixFileName = "";
        if(model.get("prefixFileName")!=null) {
            prefixFileName = (String) model.get("prefixFileName");
        }
        if (StringUtils.isNotEmpty(prefixFileName)) {
            filename = prefixFileName + filename;
        }
        Sheet sheet;
        Cell cell;
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename*=UTF-8''"+URLEncoder.encode(filename, "UTF-8")+".xlsx");
        sheet = workbook.createSheet("sheet1");

        List<String> titles = (List<String>) model.get("titles");
        int len = titles.size();
        CellStyle headerStyle = workbook.createCellStyle(); //标题样式
        //水平居中
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        Font headerFont = workbook.createFont();	//标题字体
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short)11);
        headerStyle.setFont(headerFont);
        short width = 20,height=25*20;
        sheet.setDefaultColumnWidth(width);
        Row row = sheet.createRow(1);
        for(int i=0; i<len; i++){ //设置标题
            String title = titles.get(i);
            cell =row.createCell(i);
            cell.setCellStyle(headerStyle);
            cell.setCellValue(title);
        }
        sheet.getRow(1).setHeight(height);

        CellStyle contentStyle = workbook.createCellStyle(); //内容样式
        //水平居中
        contentStyle.setAlignment(HorizontalAlignment.CENTER);

        List<PageData> varList = (List<PageData>) model.get("varList");
        int varCount = varList.size();

        for(int i=0; i<varCount; i++){
            Row row1 = sheet.createRow(i+2);
            PageData vpd = varList.get(i);
            for(int j=0;j<len;j++){
                String varstr = vpd.getString("var"+(j+1)) != null ? vpd.getString("var"+(j+1)) : "";
                cell =row1.createCell(j);
                cell.setCellStyle(contentStyle);

                cell.setCellValue(varstr);
            }

        }

        Row titlerow = sheet.createRow(0);
        Cell titleCell = titlerow.createCell(0);
        titleCell.setCellValue("项目信息表");
        CellRangeAddress region = new CellRangeAddress(0,0,0,5);
        sheet.addMergedRegion(region);
        // 显示文件标题
        CellStyle titleStyle = workbook.createCellStyle(); //标题样式
        titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        Font titleFont =  workbook.createFont();	//标题字体
        titleFont.setBold(true);
        titleFont.setFontHeightInPoints((short)18);
        titleStyle.setAlignment(HorizontalAlignment.CENTER);
        titleFont.setFontName("宋体"); //什么字体
        titleStyle.setFont(titleFont);
        titleCell.setCellStyle(titleStyle);

    }



}
