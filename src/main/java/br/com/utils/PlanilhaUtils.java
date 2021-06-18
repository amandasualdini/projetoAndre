package br.com.utils;

import br.com.model.Estado;
import br.com.repository.EstadoRepository;
import br.com.service.EstadoService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class PlanilhaUtils {

    public static List<Estado> lerPlanilha() {
        List<Estado> listEstado = new ArrayList<Estado>();
        FileInputStream arquivo = null;
        try {
            arquivo = new FileInputStream(new File("C:\\Users\\asualdini\\IdeaProjects\\projetoAndreP2\\src\\main\\resources\\Estado.xlsx"));
            XSSFWorkbook validacaoArquivoExcel = new XSSFWorkbook(arquivo);
            XSSFSheet Estados = validacaoArquivoExcel.getSheetAt(0);
            Iterator<Row> rowIterator = Estados.iterator();

            while(rowIterator.hasNext()){
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Estado estado = new Estado();
                listEstado.add(estado);

                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()){
                        case 0:
                            estado.set_id(cell.getRowIndex());
                            break;
                        case 1:
                            estado.setNome(cell.getStringCellValue());
                            break;
                    }
                }
            }
            arquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listEstado;
    }


}