import Model.Record
import org.apache.poi.hssf.usermodel.HSSFWorkbook

class WorkbookHelper {

    static HSSFWorkbook readWorkbook(String filename) throws IOException {
        FileInputStream input = new FileInputStream(filename)
        def book = new HSSFWorkbook(input)
        input.close()
        return book
    }

    static void writeWorkbook(List<Record> records){
        FileOutputStream output = new FileOutputStream("out.xls")
        def workbook = new HSSFWorkbook()
        def sheet = workbook.createSheet()
        records.indexed().each {recordIndex, record ->
            def row = sheet.createRow(recordIndex)
            row.createCell(0)
            row.getCell(0).setCellValue(record.first)
            row.createCell(1)
            row.getCell(1).setCellValue(record.middle)
        }
        workbook.write(output)
    }
}