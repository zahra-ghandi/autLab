import javax.swing.*;
import java.awt.*;

/**
 * The calculator's interface.
 */
public class CalculatorGUI {
    private JFrame frame;

    public CalculatorGUI() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        frame = new JFrame("Calculator");
        frame.setSize(500, 400);
        frame.setResizable(false);
        frame.setLocation(100, 200);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea display = new JTextArea(3,10);
//        display.setEditable(true);
        display.setFont(new Font("Arial", 14,14));

        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setPreferredSize(new Dimension(200, 100));
//        scrollPane.setLocation(50,20);

        // Clear bottom
        JButton clearBtn = new JButton();
        clearBtn.setText("AC");
        clearBtn.setLocation(260, 100);
        frame.getContentPane().add(clearBtn);

        JTabbedPane tabs = new JTabbedPane();

        // Simple calculator panel.
        JPanel simpleKeyboardPanel = new JPanel(new GridLayout(4, 4, 10, 10));

        for (int i = 7; i <= 9; i++) {
            JButton btn = new JButton();
            btn.setText("" + i);
            simpleKeyboardPanel.add(btn);
        }

        JButton divisionBtn = new JButton();
        divisionBtn.setText("/");
        simpleKeyboardPanel.add(divisionBtn);

        for (int i = 4; i <= 6; i++) {
            JButton btn = new JButton();
            btn.setText("" + i);
            simpleKeyboardPanel.add(btn);
        }

        JButton productBtn = new JButton();
        productBtn.setText("X");
        simpleKeyboardPanel.add(productBtn);

        for (int i = 1; i <= 3; i++) {
            JButton btn = new JButton();
            btn.setText("" + i);
            simpleKeyboardPanel.add(btn);
        }

        JButton minBtn = new JButton();
        minBtn.setText("_");
        simpleKeyboardPanel.add(minBtn);

        JButton zeroBtn = new JButton();
        zeroBtn.setText("0");
        simpleKeyboardPanel.add(zeroBtn);

        JButton doBtn = new JButton();
        doBtn.setText("=");
        simpleKeyboardPanel.add(doBtn);

        JButton pntBtn = new JButton();
        pntBtn.setText(".");
        simpleKeyboardPanel.add(pntBtn);

        JButton sumBtn = new JButton();
        sumBtn.setText("+");
        simpleKeyboardPanel.add(sumBtn);

        // Advanced calculator panel.
        JPanel advancedKeyboardPanel = new JPanel(new GridLayout(4, 6, 5, 5));

        for (int i = 7; i <= 9; i++) {
            JButton btn = new JButton();
            btn.setText("" + i);
            advancedKeyboardPanel.add(btn);
        }

        JButton divisionBtnAd = new JButton();
        divisionBtnAd.setText("/");
        advancedKeyboardPanel.add(divisionBtnAd);

        JButton shiftBtn = new JButton();
        shiftBtn.setText("shift");
        advancedKeyboardPanel.add(shiftBtn);

        JButton nepBtn = new JButton();
        nepBtn.setText("e");
        advancedKeyboardPanel.add(nepBtn);

        for (int i = 4; i <= 6; i++) {
            JButton btn = new JButton();
            btn.setText("" + i);
            advancedKeyboardPanel.add(btn);
        }

        JButton productBtnAd = new JButton();
        productBtnAd.setText("X");
        advancedKeyboardPanel.add(productBtnAd);

        JButton sinCosBtn = new JButton();
        sinCosBtn.setText("sin/cos");
        advancedKeyboardPanel.add(sinCosBtn);

        JButton piBtn = new JButton();
        piBtn.setText("pi");
        advancedKeyboardPanel.add(piBtn);

        for (int i = 1; i <= 3; i++) {
            JButton btn = new JButton();
            btn.setText("" + i);
            advancedKeyboardPanel.add(btn);
        }

        JButton minBtnAd = new JButton();
        minBtnAd.setText("_");
        advancedKeyboardPanel.add(minBtnAd);

        JButton tanCotBtn = new JButton();
        tanCotBtn.setText("tan/cot");
        advancedKeyboardPanel.add(tanCotBtn);

        JButton logBtn = new JButton();
        logBtn.setText("log");
        advancedKeyboardPanel.add(logBtn);

        JButton zeroBtnAd = new JButton();
        zeroBtnAd.setText("0");
        advancedKeyboardPanel.add(zeroBtnAd);

        JButton doBtnAd = new JButton();
        doBtnAd.setText("=");
        advancedKeyboardPanel.add(doBtnAd);

        JButton pntBtnAd = new JButton();
        pntBtnAd.setText(".");
        advancedKeyboardPanel.add(pntBtnAd);

        JButton sumBtnAd = new JButton();
        sumBtnAd.setText("+");
        advancedKeyboardPanel.add(sumBtnAd);

        JButton powBtn = new JButton();
        powBtn.setText("^");
        advancedKeyboardPanel.add(powBtn);

        JButton remainBtn = new JButton();
        remainBtn.setText("%");
        advancedKeyboardPanel.add(remainBtn);

        tabs.add("Simple", simpleKeyboardPanel);
        tabs.add("Advanced", advancedKeyboardPanel);


        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(clearBtn, BorderLayout.EAST);
        frame.add(tabs, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
