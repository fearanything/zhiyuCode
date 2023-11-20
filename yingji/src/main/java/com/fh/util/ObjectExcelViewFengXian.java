package com.fh.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import net.coobird.thumbnailator.builders.BufferedImageBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractXlsView;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.fh.util.PageData;
import com.fh.util.Tools;
import javax.swing.ImageIcon;
public class ObjectExcelViewFengXian extends AbstractXlsView {

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
        response.setHeader("Content-Disposition", "attachment;filename*=UTF-8''"+URLEncoder.encode(filename, "UTF-8")+".xls");
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
        short width = 100,height=25*20;
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
        contentStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        List<PageData> varList = (List<PageData>) model.get("varList");
        int varCount = varList.size();
        for(int i=0; i<varCount; i++){
            Row row1 = sheet.createRow(i+2);

            PageData vpd = varList.get(i);
            for(int j=0;j<len;j++){

                if(j == len-1){
                    String varstr = vpd.getString("var30") != null ? vpd.getString("var30") : "";
                    cell =row1.createCell(30);
                    cell.setCellStyle(contentStyle);

                    cell.setCellValue(varstr);
                }
                else{
                    String varstr = vpd.getString("var"+(j+1)) != null ? vpd.getString("var"+(j+1)) : "";
                    cell =row1.createCell(j);
                    cell.setCellStyle(contentStyle);

                    cell.setCellValue(varstr);
                }

            }
            //导出图片
            if(vpd.getString("var13") != null && !vpd.getString("var13").equals("")){
                exportPic(workbook,sheet,vpd.getString("var13"),i+2,12);
            }
            if(vpd.getString("var21") != null && !vpd.getString("var21").equals("")){
                exportPic(workbook,sheet,vpd.getString("var21"),i+2,20);
            }
            if(i != 12 && i != 20){
                sheet.autoSizeColumn(i);
            }

        }

        row = sheet.createRow(0);
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

    }
    public void exportPic(Workbook wb,Sheet sheet,String fileName,int row,int col) throws IOException {
        String[] fileNameString = fileName.split(",");
        String filePath = PathUtil.getClasspath();								//文件上传路径

        //依次插入
        int index = 0;
        //计算长度，dx和dy最长分别是1023和255，根据图片的数量平均分割，每一层两张图片
        int picSize = fileNameString.length;
        int dySize = picSize%2 == 0 ?picSize/2:picSize/2+1;
        int dyPrv = 245/dySize;
        for(String fileStr : fileNameString){

            try{
//				InputStream inputStream = new FileInputStream(filePath+fileStr);
                ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();

                //需要导入的图片
                File file = new File(filePath+fileStr);

                Image src = Toolkit.getDefaultToolkit().getImage(file.getPath());;
                BufferedImage bufferImg = toBufferedImage(src);
                ImageIO.write(bufferImg, "jpg", byteArrayOut);

                //画图的顶级管理器，一个sheet只能获取一个
                HSSFPatriarch patriarch = (HSSFPatriarch) sheet.createDrawingPatriarch();
                //anchor主要用于设置图片的属性

                int dx1 = index%2 == 0 ? 0 : 510;
                int dy1 = dyPrv*(index/2);
                //dx最大1023，dy最大255
                int dx2 = index%2 == 0 ? 510 : 1020;
                int dy2 = dyPrv*((index/2)+1);
//				int dx1 = 512;
//				int dy1 = 0;
//				//dx最大1023，dy最大255
//				int dx2 = 1023;
//				int dy2 = 255;
                HSSFClientAnchor anchor = new HSSFClientAnchor(dx1, dy1, dx2, dy2,(short) col, row, (short) col, row);

                Row picRow = sheet.getRow(row);
                Cell cell = picRow.createCell(col);
                picRow.setHeight((short)4000);

                anchor.setAnchorType(ClientAnchor.AnchorType.MOVE_AND_RESIZE);
                //插入图片
                patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
                index++;
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }

    }

    //region Image转BufferedImage

    /**
     * Image转BufferedImage
     *
     * @param image
     * @return
     */
    public static BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }
        image = new ImageIcon(image).getImage();
        boolean hasAlpha = false;
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        try {
            int transparency = Transparency.OPAQUE;
            if (hasAlpha) {
                transparency = Transparency.BITMASK;
            }
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bimage = gc.createCompatibleImage(image.getWidth(null),
                    image.getHeight(null), transparency);
        } catch (HeadlessException e) {
        }
        if (bimage == null) {
            int type = BufferedImage.TYPE_INT_RGB;
            if (hasAlpha) {
                type = BufferedImage.TYPE_INT_ARGB;
            }
            bimage = new BufferedImage(image.getWidth(null),
                    image.getHeight(null), type);
        }
        Graphics g = bimage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return bimage;
    }
    //endregion

}
