import java.util.HashMap;
import java.util.List;
import java.io.*;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class DataLoader {

    private static String path = "/Users/yinuozhao/IdeaProjects/currency_converter/src/main/Resource/FX_RATES_DAILY-sd-2017-01-03.csv";

    public DataLoader(){}

    public static HashMap loadExchangeRate(){

        HashMap exchange_rate = new HashMap<String, Double>();

        try{
            CSVReader reader = new CSVReaderBuilder(new FileReader(path)).withSkipLines(39).build();
            List<String[]> entries = reader.readAll();
            String[] names = entries.get(0);
            String[] rates = entries.get(1);
            for (int i = 1; i < names.length; i++){
                exchange_rate.put(names[i],Double.valueOf(rates[i]));
            }

        }catch(IOException | CsvException ex){
            System.out.println("File not found.");
        }
        return exchange_rate;
    }



}
