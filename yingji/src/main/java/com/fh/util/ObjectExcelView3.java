package com.fh.util;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.poi.excel.style.Align;
import com.fh.entity.system.Dictionaries;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.fh.util.PageData;
import com.fh.util.Tools;
/**
 * 导入到EXCEL
 * 类名称：ObjectExcelView.java
 * @author FH Q313596790
 * @version 1.0
 */
public class ObjectExcelView3 extends AbstractXlsxView{

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        Date date = new Date();
        String filename = "fengXian"+Tools.date2Str(date, "yyyyMMddHHmmss");
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
        DataValidationHelper helper = sheet.getDataValidationHelper();

        //设置二级机构
        List<PageData> secondUnitList = (List<PageData>) model.get("secondUnitList");
        String[] secondUnitString = new String[secondUnitList.size()];
        for(int w = 0;w<secondUnitList.size();w++){
            secondUnitString[w] = secondUnitList.get(w).getString("ORG_NAME");
        }
        // 创建一个隐藏的sheet，存放下拉框选项,只有三级机构加项目是超过20个选项的
        Sheet hiddenSheet4 = workbook.createSheet("hiddenSelect4");
        //  把下拉框列表数据放进隐藏sheet
//        Cell hiddencell = null;
        for (int i = 0; i < secondUnitString.length; i++) {
            Row row = hiddenSheet4.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(secondUnitString[i]);
        }
        Name nameCell = workbook.createName();
        nameCell.setNameName(hiddenSheet4.getSheetName());
        nameCell.setRefersToFormula(hiddenSheet4.getSheetName() + "!$A$1:$A$" + secondUnitString.length);
        workbook.setSheetHidden(workbook.getSheetIndex(hiddenSheet4), true);
        createDropDownBoxMore(sheet,helper,secondUnitString,2,999,0,0,hiddenSheet4);

        //设置三级机构和项目下拉框
        List<PageData> thirdUnitList = (List<PageData>) model.get("thirdUnitList");
        String[] thirdUnitString = new String[thirdUnitList.size()];
        for(int w = 0;w<thirdUnitList.size();w++){
            thirdUnitString[w] = thirdUnitList.get(w).getString("ORG_NAME");
        }
        // 创建一个隐藏的sheet，存放下拉框选项,只有三级机构加项目是超过20个选项的
        Sheet hiddenSheet = workbook.createSheet("hiddenSelect");
        //  把下拉框列表数据放进隐藏sheet
        Cell hiddencell = null;
        for (int i = 0; i < thirdUnitString.length; i++) {
            Row row = hiddenSheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(thirdUnitString[i]);
        }
        nameCell = workbook.createName();
        nameCell.setNameName(hiddenSheet.getSheetName());
        nameCell.setRefersToFormula(hiddenSheet.getSheetName() + "!$A$1:$A$" + thirdUnitString.length);
        workbook.setSheetHidden(workbook.getSheetIndex(hiddenSheet), true);
        createDropDownBoxMore(sheet,helper,thirdUnitString,2,999,1,1,hiddenSheet);

        //区域下拉框
        List<Dictionaries> areaList = (List<Dictionaries>) model.get("areaList");
        String[] areaString = new String[areaList.size()+8];
        int w = 0;
        for(Dictionaries dictionaries : areaList){
            areaString[w] = dictionaries.getNAME();
            w++;
            if(dictionaries.getSubDict() != null){
                for(Dictionaries subDict : dictionaries.getSubDict()){
                    areaString[w] = subDict.getNAME();
                    w++;
                }
            }

        }
        Sheet hiddenSheet2 = workbook.createSheet("hiddenSelect2");
        for (int i = 0; i < areaString.length; i++) {
            Row row = hiddenSheet2.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(areaString[i]);
        }
        Name nameCell2 = workbook.createName();
        nameCell2.setNameName(hiddenSheet2.getSheetName());
        nameCell2.setRefersToFormula(hiddenSheet2.getSheetName() + "!$A$1:$A$" + areaString.length);
        workbook.setSheetHidden(workbook.getSheetIndex(hiddenSheet2), true);

        createDropDownBoxMore(sheet,helper,areaString,2,999,3,3,hiddenSheet2);

        //风险等级下拉框
        Map<String, String> riskLevelMap = (Map<String, String>) model.get("riskLevelMap");
        String[] riskLevelString = new String[riskLevelMap.size()];
        int e = 0;
        for(Map.Entry<String,String> entry : riskLevelMap.entrySet()){
            riskLevelString[e] = (String) entry.getValue();
            e++;
        }
        createDropDownBox(sheet,helper,riskLevelString,2,999,6,6);

        //事故类型下拉框
        Map<String, String> accidentTypeMap = (Map<String, String>) model.get("accidentTypeMap");
        String[] accidentTypeString = new String[accidentTypeMap.size()];
        int r = 0;
        for(Map.Entry<String,String> entry : accidentTypeMap.entrySet()){
            accidentTypeString[r] = (String) entry.getValue();
            r++;
        }
        createDropDownBox(sheet,helper,accidentTypeString,2,999,5,5);

        //事故类型下拉框
        String[] managementLevel = {"集团总部","二级单位","三级公司(项目)"};
        createDropDownBox(sheet,helper,managementLevel,2,999,10,10);

        //设置责任单位下拉框
        List<PageData> allUnitList = (List<PageData>) model.get("allUnitList");
        String[] allUnitString = new String[allUnitList.size()];
        for(int t = 0;t<allUnitList.size();t++){
            allUnitString[t] = allUnitList.get(t).getString("ORG_NAME");
        }
        // 创建一个隐藏的sheet，存放下拉框选项,只有三级机构加项目是超过20个选项的
        Sheet hiddenSheet3 = workbook.createSheet("hiddenSelect3");
        //  把下拉框列表数据放进隐藏sheet
        for (int i = 0; i < allUnitString.length; i++) {
            Row row = hiddenSheet3.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(allUnitString[i]);
        }
        nameCell = workbook.createName();
        nameCell.setNameName(hiddenSheet3.getSheetName());
        nameCell.setRefersToFormula(hiddenSheet3.getSheetName() + "!$A$1:$A$" + allUnitString.length);
        workbook.setSheetHidden(workbook.getSheetIndex(hiddenSheet3), true);
        createDropDownBoxMore(sheet,helper,allUnitString,2,999,11,11,hiddenSheet3);

        Row row = sheet.createRow(0);
        Cell titleCell = row.createCell(0);
        titleCell.setCellValue("风险点登记表");
        CellRangeAddress region = new CellRangeAddress(0,0,0,16);
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

        //设置标题
        row = sheet.createRow(1);
        for(int i=0; i<len; i++){
            String title = titles.get(i);
            cell =row.createCell(i);
            cell.setCellStyle(headerStyle);
            cell.setCellValue(title);
        }
        sheet.getRow(0).setHeight(height);

        // 创建批注
        CreationHelper creationHelper = workbook.getCreationHelper();
        String text1 = "支持下拉单选、编辑、复制粘贴。\n" + "注：编辑或粘贴的数据必须是基础信息-组织架构（二级机构），可在模板中下拉列表查看。";
        String text2 = "支持下拉单选、编辑、粘贴；\n" + "注意：若是多选，则不支持下拉选择，必须选择编辑或粘贴。以逗号(,)或斜杆（/）分开。\n" + "比如：火灾，触电\n";
        String text3 = "【责任单位】是海控集团内单位\n";
        String text4 = "时间格式支持2023/11/1或2023-11-1或2023年11月1日；但不支持2023.11.1\n";
        String text5 = "支持下拉单选、编辑、复制粘贴。\n" + "注：编辑或粘贴的数据必须是基础信息-组织架构（三级机构）和项目管理的数据，可在模板中下拉列表查看。";
        String text6 = "支持下拉单选、编辑、复制粘贴。\n" + "注：编辑或粘贴的数据必须是基础信息-区域，可在模板中下拉列表查看。";
        String text7 = "支持下拉单选、编辑、复制粘贴。\n" + "注：编辑或粘贴的数据必须是风险等级，可在模板中下拉列表查看。";
        String text8 = "支持下拉单选、编辑、复制粘贴。\n" + "注：编辑或粘贴的数据必须是管理层级，可在模板中下拉列表查看。";
        String text9 = "时间格式支持2023/11/1或2023-11-1或2023年11月1日；但不支持2023.11.1.\n" + "注意：【开始时间】可填写时间或长期";
        String text10 = "时间格式支持2023/11/1或2023-11-1或2023年11月1日；但不支持2023.11.1.\n" + "注意：【结束时间】可填写时间或长期";

        Row commentrow = sheet.getRow(1);
//        Cell commentCell = commentrow.getCell(0);
//        // 将批注附加到单元格
//        commentCell.setCellComment(comment);
        createComment(sheet,creationHelper,text1,0);
        createComment(sheet,creationHelper,text5,1);
        createComment(sheet,creationHelper,text6,3);
        createComment(sheet,creationHelper,text2,5);
        createComment(sheet,creationHelper,text7,6);
        createComment(sheet,creationHelper,text8,10);
        createComment(sheet,creationHelper,text3,11);
        createComment(sheet,creationHelper,text4,14);
        createComment(sheet,creationHelper,text9,15);
        createComment(sheet,creationHelper,text10,16);

    }

    /**
     * 给Excel的添加批注
     *
     */
    private void createComment(Sheet sheet, CreationHelper creationHelper, String commentText, int cellIndex) {
        // 创建批注
        Comment comment = sheet.createDrawingPatriarch().createCellComment(creationHelper.createClientAnchor());
        // 设置批注内容
        comment.setString(creationHelper.createRichTextString(commentText));

        Row commentrow = sheet.getRow(1);
        Cell commentCell = commentrow.getCell(cellIndex);
        // 将批注附加到单元格
        commentCell.setCellComment(comment);
    }

    /**
     * 给Excel的添加下拉框
     *
     * @param sheet
     * @param helper
     * @param list     下拉框需要的数据
     * @param firstRow 首行
     * @param lastRow  尾行
     * @param firstCol 首列
     * @param lastCol  尾列
     */
    private void createDropDownBox(Sheet sheet, DataValidationHelper helper, String[] list, int firstRow, int lastRow,
                                   int firstCol, int lastCol) {
        CellRangeAddressList addressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);

        DataValidationConstraint constraint = helper.createExplicitListConstraint(list);
        DataValidation validation = helper.createValidation(constraint, addressList);
        if (validation instanceof DataValidation) {
            validation.setSuppressDropDownArrow(true);//是否显示下拉框箭头
//            validation.setShowErrorBox(true);//是否显示错误提示框
        } else {
            validation.setSuppressDropDownArrow(false);
        }
        sheet.addValidationData(validation);//将对象添加到工作表中
    }

    /**
     * 给Excel的添加下拉框
     *
     * @param sheet
     * @param helper
     * @param list     下拉框需要的数据
     * @param firstRow 首行
     * @param lastRow  尾行
     * @param firstCol 首列
     * @param lastCol  尾列
     */
    private void createDropDownBoxMore(Sheet sheet, DataValidationHelper helper, String[] list, int firstRow, int lastRow,
                                   int firstCol, int lastCol,Sheet hiddenSheet) {
        CellRangeAddressList addressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
        DataValidationConstraint constraint = null;
        DataValidation validation = null;
        // 为了适配xls和xlsx不同版本的Excel（即2003和2007版本的）
        if (sheet instanceof XSSFSheet || sheet instanceof SXSSFSheet) {
            constraint = helper.createFormulaListConstraint(hiddenSheet.getSheetName());
            validation = helper.createValidation(constraint, addressList);
        } else {
            constraint = DVConstraint.createFormulaListConstraint(hiddenSheet.getSheetName());
            validation = new HSSFDataValidation(addressList, constraint);
        }
        if (validation instanceof XSSFDataValidation) {
            validation.setSuppressDropDownArrow(true);
//            validation.setShowErrorBox(true);
        } else {
            validation.setSuppressDropDownArrow(false);
        }
        sheet.addValidationData(validation);
    }





}
