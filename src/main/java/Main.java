public class Main {
    public static void main(String[] agrs) throws Exception
    {
//        HashMap exchange_rate = DataLoader.loadExchangeRate();
//        System.out.println(exchange_rate.toString());
        System.out.println(Converter.convert("CAD", "CNY", 5));
        System.out.println(Converter.convert("CNY", "CAD", 5));
        System.out.println(Converter.convert("USD", "CNY", 5));
        System.out.println(Converter.convert("CAD", "USD", 10));
        System.out.println(Converter.convert("USD", "CAD", 10));
        System.out.println(Converter.convert("CAD", "CAD", 10));
        System.out.println(Converter.convert("USD", "USD", 15));

    }
}
