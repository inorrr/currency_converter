import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView {

    JFrame j = new JFrame();

    public MainView(){
        j = getMainView();
    }
    public static JFrame getMainView(){
        JFrame frame = new JFrame("Currency Converter");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //this is the main panel
        JPanel main_panel = new JPanel();
        main_panel.setLayout(new BoxLayout(main_panel,BoxLayout.Y_AXIS));
        frame.add(main_panel);

        JPanel input_panel = new JPanel();
        main_panel.add(input_panel);

        JPanel input_value_panel = new JPanel();
        main_panel.add(input_value_panel);

        JPanel output_panel = new JPanel();
        main_panel.add(output_panel);

        JPanel convert_panel = new JPanel();
        main_panel.add(convert_panel);

        String[] currencies = {"AUD Australian dollar", "BRL Brazilian real", "CNY Chinese renminbi",
                "EUR European euro", "HKD Hong Kong dollar", "INR Indian rupee", "IDR Indonesian rupiah",
                "JPY Japanese yen", "MYR Malaysian ringgit", "M0-XN Mexican peso", "NZD New Zealand dollar",
                "NOK Norwegian krone", "RUB Russian ruble", "SAR Saudi riyal", "SGD Singapore dollar",
                "ZAR South African rand", "KRW South Korean", "SEK Swedish krona", "CHF Swiss franc",
                "TWD Taiwanese dollar", "THB Thai baht", "TRY Turkish lira", "GBP UK pound",
                "USD US dollar", "VND Vietnamese dong", "CAD Canadian dollar"};

        JComboBox<String> from_combo = new JComboBox<String>(currencies);
        JComboBox<String> to_combo = new JComboBox<String>(currencies);

        JLabel from_label = new JLabel("From");
        input_panel.add(from_label);
        input_panel.add(from_combo);

        JLabel to_label = new JLabel("To");
        input_panel.add(to_label);
        input_panel.add(to_combo);

        JLabel value_label = new JLabel("Value");
        JTextField exchange_value = new JTextField(6);
        input_value_panel.add(value_label);
        input_value_panel.add(exchange_value);

        JLabel result_label = new JLabel();

        JButton convert_button = new JButton("Convert");
        convert_panel.add(convert_button);
        convert_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                result_label.setText("");
                String input_from = from_combo.getSelectedItem().toString().substring(0, 3);
                String input_to = to_combo.getSelectedItem().toString().substring(0,3);
                double convert_value = Double.valueOf(exchange_value.getText());

                double result = Converter.convert(input_from, input_to, convert_value);

                result_label.setText(String.valueOf(result));
                output_panel.add(result_label);
                frame.setVisible(true);

            }
        });

        frame.setVisible(true);
        return frame;

    }
}
