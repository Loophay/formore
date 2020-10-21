package com.loock.thinkmore.operatexcel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author loock
 * @date 2020.10.21 16:42
 */
public class Operatexcell {
    public static void main(String[] args) {
        //配置文件读取路径,读取文件
        File file = new File("/home/wjht/JavaDevelopmentInfo/export_test.xls");
        try {
            //获取第一行的每列数据
            //将其结果与准备好的标题数据一一进行比较
            //符合条件的就获取到这一列数据
            //输出到新的excel文件中

            //定义一个用于存储标题的容器
            ArrayList<String> bts = new ArrayList<>();
            bts.add("病历号");
            bts.add(" ID号");
            bts.add("性别");
            //读取已有表的第一行数据
            Map<Integer, String> colNumWithContents = readRow(file, 0);

            //用来存放每列标题以及这个标题所对应的列数据的容器
            Map<String, ArrayList<String>> contentResultMap = new HashMap<>();
            for (Map.Entry<Integer,String> entry: colNumWithContents.entrySet()) {
                //System.out.println(entry.getKey()+"列："+entry.getValue());
                for (String bt: bts ) {

                    if(!StringUtils.isEmpty(entry.getValue()) && entry.getValue().equals(bt)){
                        ArrayList<String> contents = readColum(file, entry.getKey());

                        //讲结果以key-->列标题,value-->列内容保存在map容器中
                        contentResultMap.put(bt,contents);
                    }
                }
            }
            /*for (Map.Entry<String,ArrayList<String>> entry : contentResultMap.entrySet()) {
                //遍历获取每一个单元格的数据
                for (String content : entry.getValue()) {
                    System.out.println("列标题:"+entry.getKey() + "; 包含的内容:"+content);
                }
            }*/

            //将每列的数据输出到新的excel文件中
            writeToExcel(bts,contentResultMap);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 将结果按列写入新的文件中
     * @param bts
     * @param contentResultMap
     */
    private static void writeToExcel(ArrayList<String> bts, Map<String, ArrayList<String>> contentResultMap) {
        //设置导出路径
        String filePath = "";
        //设置到处表sheet名称
        String sheet = "";
        //使用jxl的导出
        WritableWorkbook wwb = null;

        try {
            wwb = Workbook.createWorkbook(new File(filePath));
            WritableSheet sheet1 = wwb.createSheet(sheet, 0);
            //表头导航
            for(int j=0;j<bts.size();j++){
                Label label = new Label(j, 0, bts.get(j));
                sheet1.addCell(label);
            }



        } catch (IOException | WriteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取行数据
     * @param file
     * @param index
     * @exception Exception
     * @return
     */
    private static Map<Integer, String> readRow(File file, int index) throws Exception {
        Map<Integer,String> colNumWithContents = new HashMap<>();

        InputStream is = new FileInputStream(file.getAbsoluteFile());
        Workbook wb = Workbook.getWorkbook(is);
        Sheet sheet = wb.getSheet(0);

        int columns = sheet.getColumns();

        for (int i = 0;i<columns;i++){
            Cell cell = sheet.getCell(i, index);
            colNumWithContents.put(cell.getColumn(),cell.getContents());
            //System.out.println(cell.getContents()+":位于第"+ cell.getColumn() +"　列");
        }
        return colNumWithContents;
    }

    /**
     * 读取列数据
     * @param file
     * @param index
     * @throws Exception
     * @return
     */
    private static ArrayList<String> readColum(File file, int index) throws Exception {
        InputStream is = new FileInputStream(file.getAbsoluteFile());
        //通过jxl读取excel文件
        Workbook wb = Workbook.getWorkbook(is);
        Sheet sheet = wb.getSheet(0);
        int rows = sheet.getRows();
        int columns = sheet.getColumns();

        ArrayList<String> contents = new ArrayList<>();
        for (int i = 1; i < rows; i++) {
            Cell cell = sheet.getCell(index, i);
            //将每个单元格数据放到列容器中
            contents.add(cell.getContents());
            //System.out.println(cell.getContents());
        }
        return contents;
    }
}
