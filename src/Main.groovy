import Model.Record

import java.util.stream.Collectors

/**
 * Created by jmeier on 9/24/2017.
 */
class Main {

    public static void main(String[] args) {

        def book = WorkbookHelper.readWorkbook("src/Data/list.xls")

        def sheet = book.getSheetAt(0)

        List<Record> records =
                sheet.collect {row -> new Record(
                    name: row.getCell(1).stringCellValue)
                }

        WorkbookHelper.writeWorkbook(records)

    }
}
