import java.util.HashMap;

public class Converter {

    private static HashMap exchange_rate = DataLoader.loadExchangeRate();

    public static double convert(String from, String to, double value){


        if(from.equals("CAD")){
            Object r1 = exchange_rate.get("FX" + to + "CAD");
            Double d1 = Double.valueOf(r1.toString());
            return value * (1/d1);

        }else if (to.equals("CAD")) {
            Object r2 = exchange_rate.get("FX" + from + "CAD");
            Double d2 = Double.valueOf(r2.toString());
            return value * (d2);

        }else{
            double val = convert(from, "CAD", value);
            return convert("CAD", to, val);
        }

    }
}
