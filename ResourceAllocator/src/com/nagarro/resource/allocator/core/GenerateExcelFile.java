/**
 * 
 */
package com.nagarro.resource.allocator.core;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nagarro.resource.allocator.vo.QueuedResourceVO;

public class GenerateExcelFile {
    public static void createWorkBook(List<QueuedResourceVO> queuedResourceVOs) throws Exception {

        XSSFWorkbook workbook = new XSSFWorkbook();
        FileOutputStream fileOuputStream = null;
        ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
        try {
            XSSFSheet sheet = workbook.createSheet("J163_Output");
            int rownum = 0;
            XSSFRow row = sheet.createRow(rownum++);
            XSSFCell cell = row.createCell(0);
            XSSFCell cell1 = row.createCell(1);
            cell.setCellValue("Request ID");
            cell1.setCellValue("Employee ID");
            for (QueuedResourceVO queuedResourceVO : queuedResourceVOs) {
                XSSFRow row1 = sheet.createRow(rownum++);
                XSSFCell cell2 = row1.createCell(0);
                XSSFCell cell3 = row1.createCell(1);
                cell2.setCellValue(queuedResourceVO.getProjectRequirementVO().getRequestID());
                cell3.setCellValue(queuedResourceVO.getResourceInformationVO().getEmployeeId());

            }
            workbook.write(outByteStream);
            fileOuputStream = new FileOutputStream("F://Resource Allocator//J163_Output.xlsx");
            fileOuputStream.write(outByteStream.toByteArray());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                outByteStream.close();
                fileOuputStream.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }
}