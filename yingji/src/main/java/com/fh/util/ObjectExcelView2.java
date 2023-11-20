package com.fh.util;

import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fh.entity.system.Dictionaries;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.fh.util.PageData;
import com.fh.util.Tools;
/**
 * 导入到EXCEL(隐患排查导出模板)
 * 类名称：ObjectExcelView.java
 * @author FH Q313596790
 * @version 1.0
 */
public class ObjectExcelView2 extends AbstractXlsView {

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        Date date = new Date();
        String filename = "rectifyInfo" + Tools.date2Str(date, "yyyyMMddHHmmss");
        String prefixFileName = "";
        if(model.get("prefixFileName")!=null) {
            prefixFileName = (String) model.get("prefixFileName");
        }
        if (StringUtils.isNotEmpty(prefixFileName)) {
            filename = prefixFileName + filename;
        }
        HSSFSheet sheet;
        HSSFCell cell;
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename*=UTF-8''"+URLEncoder.encode(filename, "UTF-8")+".xls");
        sheet = (HSSFSheet) workbook.createSheet("sheet1");

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

        HSSFRow row = sheet.createRow(1);
        for(int i=0; i<len; i++){ //设置标题
            String title = titles.get(i);
            cell =row.createCell(i);
            cell.setCellStyle(headerStyle);
            cell.setCellValue(title);
        }
        sheet.getRow(1).setHeight(height);

        //设置二级机构
        List<PageData> secondUnitList = (List<PageData>) model.get("secondUnitList");
        String[] secondUnitString = new String[secondUnitList.size()];
        for(int w = 0;w<secondUnitList.size();w++){
            secondUnitString[w] = secondUnitList.get(w).getString("ORG_NAME");
        }
        // 创建一个隐藏的sheet，存放下拉框选项,只有三级机构加项目是超过20个选项的
        HSSFSheet hiddenSheet4 = (HSSFSheet) workbook.createSheet("hiddenSelect4");
        //  把下拉框列表数据放进隐藏sheet
//        Cell hiddencell = null;
        for (int i = 0; i < secondUnitString.length; i++) {
            row = hiddenSheet4.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(secondUnitString[i]);
        }
        Name nameCell = workbook.createName();
        nameCell.setNameName(hiddenSheet4.getSheetName());
        nameCell.setRefersToFormula(hiddenSheet4.getSheetName() + "!$A$1:$A$" + secondUnitString.length);
        workbook.setSheetHidden(workbook.getSheetIndex(hiddenSheet4), true);
        createDropDownBoxMore(sheet,helper,secondUnitString,2,999,0,0,hiddenSheet4);

        //设置二级机构
        List<PageData> projectList = (List<PageData>) model.get("projectList");
        String[] projectString = new String[projectList.size()];
        for(int w = 0;w<projectList.size();w++){
            projectString[w] = projectList.get(w).getString("ORG_NAME");
        }
        // 创建一个隐藏的sheet，存放下拉框选项,只有三级机构加项目是超过20个选项的
        HSSFSheet hiddenSheet = (HSSFSheet) workbook.createSheet("hiddenSelect");
        //  把下拉框列表数据放进隐藏sheet
//        Cell hiddencell = null;
        for (int i = 0; i < projectString.length; i++) {
            row = hiddenSheet.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(projectString[i]);
        }
        nameCell = workbook.createName();
        nameCell.setNameName(hiddenSheet.getSheetName());
        nameCell.setRefersToFormula(hiddenSheet.getSheetName() + "!$A$1:$A$" + projectString.length);
        workbook.setSheetHidden(workbook.getSheetIndex(hiddenSheet), true);
        createDropDownBoxMore(sheet,helper,secondUnitString,2,999,2,2,hiddenSheet);

        CellStyle contentStyle = workbook.createCellStyle(); //内容样式
        //水平居中
        contentStyle.setAlignment(HorizontalAlignment.CENTER);

        //隐患类别下拉框
        Map<String, String> classifyMap = (Map<String, String>) model.get("classifyMap");
        String[] classifyString = new String[classifyMap.size()];
        int e = 0;
        for(Map.Entry<String,String> entry : classifyMap.entrySet()){
            classifyString[e] = entry.getValue();
            e++;
        }
        HSSFSheet hiddenSheet7 = (HSSFSheet) workbook.createSheet("hiddenSelect7");
        //  把下拉框列表数据放进隐藏sheet
        for (int i = 0; i < classifyString.length; i++) {
            row = hiddenSheet7.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(classifyString[i]);
        }
        nameCell = workbook.createName();
        nameCell.setNameName(hiddenSheet7.getSheetName());
        nameCell.setRefersToFormula(hiddenSheet7.getSheetName() + "!$A$1:$A$" + classifyString.length);
        workbook.setSheetHidden(workbook.getSheetIndex(hiddenSheet7), true);
        createDropDownBoxMore(sheet,helper,classifyString,2,999,4,4,hiddenSheet7);

        //隐患级别下拉框
        Map<String, String> levelMap = (Map<String, String>) model.get("levelMap");
        String[] levelString = new String[levelMap.size()];
        int r = 0;
        for(Map.Entry<String,String> entry : levelMap.entrySet()){
            levelString[r] = entry.getValue();
            r++;
        }
        HSSFSheet hiddenSheet5 = (HSSFSheet) workbook.createSheet("hiddenSelect5");
        //  把下拉框列表数据放进隐藏sheet
        for (int i = 0; i < levelString.length; i++) {
            row = hiddenSheet5.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(levelString[i]);
        }
        nameCell = workbook.createName();
        nameCell.setNameName(hiddenSheet5.getSheetName());
        nameCell.setRefersToFormula(hiddenSheet5.getSheetName() + "!$A$1:$A$" + levelString.length);
        workbook.setSheetHidden(workbook.getSheetIndex(hiddenSheet5), true);
        createDropDownBoxMore(sheet,helper,levelString,2,999,5,5,hiddenSheet5);

        //隐患级别下拉框
        Map<String, String> factorMap = (Map<String, String>) model.get("factorMap");
        String[] factorString = new String[factorMap.size()];
        int w = 0;
        for(Map.Entry<String,String> entry : factorMap.entrySet()){
            factorString[w] = (String) entry.getValue();
            w++;
        }
        HSSFSheet hiddenSheet8 = (HSSFSheet) workbook.createSheet("hiddenSelect8");
        //  把下拉框列表数据放进隐藏sheet
        for (int i = 0; i < factorString.length; i++) {
            row = hiddenSheet8.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(factorString[i]);
        }
        nameCell = workbook.createName();
        nameCell.setNameName(hiddenSheet8.getSheetName());
        nameCell.setRefersToFormula(hiddenSheet8.getSheetName() + "!$A$1:$A$" + factorString.length);
        workbook.setSheetHidden(workbook.getSheetIndex(hiddenSheet8), true);
        createDropDownBoxMore(sheet,helper,factorString,2,999,6,6,hiddenSheet8);

        //区域下拉框
        List<Dictionaries> areaList = (List<Dictionaries>) model.get("areaList");
        String[] areaString = new String[areaList.size()*50];
        int q = 0;
        for(Dictionaries dictionaries : areaList){
            areaString[q] = dictionaries.getNAME();
            q++;
            if(dictionaries.getSubDict() != null){
                for(Dictionaries subDict : dictionaries.getSubDict()){
                    areaString[q] = subDict.getNAME();
                    q++;
                    if(subDict.getSubDict() != null){
                        for(Dictionaries subSubDict : subDict.getSubDict()){
                            areaString[q] = subSubDict.getNAME();
                            q++;
                        }
                    }
                }
            }

        }
        HSSFSheet hiddenSheet2 = (HSSFSheet) workbook.createSheet("hiddenSelect2");
        for (int i = 0; i < areaString.length; i++) {
            row = hiddenSheet2.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(areaString[i]);
        }
        Name nameCell2 = workbook.createName();
        nameCell2.setNameName(hiddenSheet2.getSheetName());
        nameCell2.setRefersToFormula(hiddenSheet2.getSheetName() + "!$A$1:$A$" + areaString.length);
        workbook.setSheetHidden(workbook.getSheetIndex(hiddenSheet2), true);

        createDropDownBoxMore(sheet,helper,areaString,2,999,8,8,hiddenSheet2);

        //设置填报下拉框
        List<PageData> allUnitList = (List<PageData>) model.get("allUnitList");
        String[] allUnitString = new String[allUnitList.size()];
        for(int t = 0;t<allUnitList.size();t++){
            allUnitString[t] = allUnitList.get(t).getString("ORG_NAME");
        }
        // 创建一个隐藏的sheet，存放下拉框选项,只有三级机构加项目是超过20个选项的
        HSSFSheet hiddenSheet3 = (HSSFSheet) workbook.createSheet("hiddenSelect3");
        //  把下拉框列表数据放进隐藏sheet
        for (int i = 0; i < allUnitString.length; i++) {
            row = hiddenSheet3.createRow(i);
            cell = row.createCell(0);
            cell.setCellValue(allUnitString[i]);
        }
        nameCell = workbook.createName();
        nameCell.setNameName(hiddenSheet3.getSheetName());
        nameCell.setRefersToFormula(hiddenSheet3.getSheetName() + "!$A$1:$A$" + allUnitString.length);
        workbook.setSheetHidden(workbook.getSheetIndex(hiddenSheet3), true);
        createDropDownBoxMore(sheet,helper,allUnitString,2,999,10,10,hiddenSheet3);

        row = sheet.createRow(0);
        HSSFCell titleCell = row.createCell(0);
        titleCell.setCellValue("安全隐患导入表");
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


        // 创建批注
        CreationHelper creationHelper = workbook.getCreationHelper();
        String text1 = "仅支持上传图片。注意：当一个安全隐患需上传多张图片时，必须全部放\n" + "在该安全隐患对应的【上传图片】单元格内。";
        createComment(sheet,creationHelper,text1,11);



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
    private void createDropDownBox(HSSFSheet sheet, DataValidationHelper helper, String[] list, int firstRow, int lastRow,
                                   int firstCol, int lastCol) {
        CellRangeAddressList addressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);

        DataValidationConstraint constraint = helper.createExplicitListConstraint(list);
        DataValidation validation = helper.createValidation(constraint, addressList);
        if (validation instanceof DataValidation) {
            validation.setSuppressDropDownArrow(true);//是否显示下拉框箭头
            validation.setShowErrorBox(true);//是否显示错误提示框
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



}
