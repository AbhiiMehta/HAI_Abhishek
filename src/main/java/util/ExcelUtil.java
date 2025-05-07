package util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.Test;

import java.io.*;

public class ExcelUtil {

    static FileInputStream fis;
    static XSSFWorkbook wb;
    static XSSFSheet sheet;
    static XSSFCell cell;
    static XSSFRow row;
    static FileOutputStream fos;
    static int rowNum;

    public static int getRow(String fileName, String sheetName) {
        int rowNum = 0;
        try {
            File file = new File(fileName);
            fis = new FileInputStream(file);
            rowNum = sheet.getLastRowNum();
        } catch (Exception e) {
            System.out.println(e);
        }
        return rowNum;
    }

    public static int getColoumnNum(String fileName, String sheetName, int rowNum) {
        int rowN = 0;
        try {
            File file = new File(fileName);
            fis = new FileInputStream(file);
            rowN = sheet.getRow(rowNum).getLastCellNum();
        } catch (Exception e) {
            System.out.println(e);
        }
        return rowN;
    }

    public static String getCellValue(Cell cell) {
        String cellValue = "";
        try {
            switch (cell.getCellType()) {
                case STRING:
                    cellValue = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        cellValue = cell.getDateCellValue().toString();
                    } else {
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    cellValue = String.valueOf(cell.getBooleanCellValue());
                    break;
                case FORMULA:
                    cellValue = cell.getCellFormula();
                    break;
                case BLANK:
                    cellValue = "";
                    break;
                default:
                    cellValue = "Unsupported Cell Type";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellValue;
    }

//    public static String getCellValueByRowAndColumnName(String filePath, String sheetName,
//                                                        String rowName, String columnName) {
//        int rowNum;
//        int cellNum;
//        String finalVal = "";
//        try {
//            fis = new FileInputStream(new File(filePath));
//            wb = new XSSFWorkbook(fis);
//            sheet = wb.getSheet(sheetName);
//            rowNum = getRow(filePath, sheetName);
//            cellNum = getColoumnNum(filePath, sheetName, rowNum);
//            for (int i = 0; i < rowNum; i++) {
//
//                Object colValue = getCellValue();
//                if (colValue.equals(columnName)) {
//                    for (int j = 0; j < cellNum; j++) {
//                        Object rowValue = getCellValue();
//                        if (rowValue.equals(columnName)) {
//                            getCellValue();
//                        }
//                    }
//                }
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return finalVal;
//    }

    
    @Test
    public static void getMyValue() {
        String path = "C:\\Users\\abhishek.mehta\\Desktop\\pnl-LL5292.xlsx";
     //   getCellValueByRowAndColumnName(path, "Equity", "Quantity", "BPCL");
    }
}