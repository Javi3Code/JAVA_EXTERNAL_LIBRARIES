package org.jeycode.datagenerator;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.jeycode.datagenerator.constants.DataFakes;
import org.jeycode.datagenerator.model.Employee;

public class FakeDataGeneratorSample
{

      private static final String SHEET_NAME = "Fake data";
      public static final File FILE_X = new File("FAKE-DATA.xls");
      public static final int DATA_SIZE = 2000;

      public static void main(String...args) throws IOException
      {
//            exportData();
            loadDataAndPrint();
      }

      private static void exportData() throws IOException
      {
            try(var workbook = new HSSFWorkbook())
            {
                  var data= DataFakes.getSetOfFakeDataoOf(DATA_SIZE);
                  
                  var sheet = workbook.createSheet(SHEET_NAME);
                  IntStream.range(0,DATA_SIZE)
                             .mapToObj(rowIndex->{
                                   var row = sheet.createRow(rowIndex);
                                   var employee= data.get(rowIndex);
                                   createAllCellsForThese(row,employee);
                                   return row;
                             })
                             .collect(toList());
                  IntStream.range(0,sheet.getRow(0).getLastCellNum())
                        .forEach(cellIndex->sheet.autoSizeColumn(cellIndex));
                  workbook.write(FILE_X);
            }
            
      }

      private static void createAllCellsForThese(HSSFRow row,Employee employee)
      {
            DataFakes.getters.entrySet()
                        .forEach(entry->{
                              var cell= row.createCell(entry.getKey());
                              var value = entry.getValue().apply(employee).toString();
                              cell.setCellValue(value);
                        });
      }

      private static void loadDataAndPrint() throws IOException
      {
            try(var workbook = HSSFWorkbookFactory.createWorkbook(new POIFSFileSystem(FILE_X)))
            {
                  var rowSpliterator=workbook.getSheet(SHEET_NAME).spliterator();
                  
                  StreamSupport.stream(rowSpliterator,true)
                        .map(row->
                              Employee.of()
                                 .name(row.getCell(0).getStringCellValue())
                                 .surnames(row.getCell(1).getStringCellValue())
                                 .age(Integer.valueOf(row.getCell(2).getStringCellValue()))
                                 .category(row.getCell(3).getStringCellValue())
                                 .birthdate(LocalDate.parse(row.getCell(4).getStringCellValue()))
                                 .employeeNumber(Integer.valueOf(row.getCell(5).getStringCellValue()))
                                 .IRPF(Float.valueOf(row.getCell(6).getStringCellValue()))
                                 .salary(Float.valueOf(row.getCell(7).getStringCellValue()))
                                 .NIF(row.getCell(8).getStringCellValue())    
                              .construct()
                         )
                        .forEach(System.out::println);
            }  
      }
      
      
      
      
      
      
      
      
      
      
      
      
      
}
