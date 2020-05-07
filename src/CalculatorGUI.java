import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

/**
 * The calculator's interface.
 */
public class CalculatorGUI {
    // Main frame.
    private JFrame frame;

    // Menubar
    JMenuBar menuBar;

    // Numbers' field.
    private JTextArea numberScreen;
    // Operator label.
    private JLabel operatorLabel;

    // Clear button;
    private JButton clearBtn;

    // Buttons (Simple)
    // Numbers.
    private JButton[] numsSimp;
    private JButton pointSimp;
    // Operators.
    private JButton divideSimp;
    private JButton multiSimp;
    private JButton addSimp;
    private JButton subtractSimp;
    private JButton equalsSimp;

    // Buttons (Advanced)
    // Numbers.
    private JButton[] numsAdv;
    private JButton pointAdv;
    // Operators.
    private JButton divideAdv;
    private JButton multiAdv;
    private JButton addAdv;
    private JButton subtractAdv;
    private JButton equalsAdv;
    private JButton sinCos;
    private JButton tanCot;
    private JButton power;
    private JButton e;
    private JButton pi;
    private JButton log;
    private JButton percent;
    // Shift button.
    private JButton shift;


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

        JPanel topPart = new JPanel(new BorderLayout());

        operatorLabel = new JLabel("   ");
        operatorLabel.setPreferredSize(new Dimension(40, 25));
        operatorLabel.setBackground(new Color(90, 150, 200));
        operatorLabel.setForeground(Color.BLACK);
        operatorLabel.setOpaque(true);
        operatorLabel.setToolTipText("Operator");

        numberScreen = new JTextArea(3,10);
        numberScreen.setText("0");
        numberScreen.setEditable(false);
        numberScreen.setFont(new Font("Arial", 14,14));
        numberScreen.setToolTipText("Operand");

        JScrollPane scrollPane = new JScrollPane(numberScreen, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(200, 40));
        scrollPane.setWheelScrollingEnabled(true);

        // Clear bottom
        clearBtn = new JButton();
        clearBtn.setText("AC");
        clearBtn.setToolTipText("Clear");

        topPart.add(operatorLabel, BorderLayout.WEST);
        topPart.add(scrollPane, BorderLayout.CENTER);
        topPart.add(clearBtn, BorderLayout.EAST);

        JTabbedPane tabs = new JTabbedPane();

        // Simple calculator panel.
        JPanel simpleKeyboardPanel = new JPanel(new GridLayout(4, 4, 10, 10));

        numsSimp = new JButton[10];

        for (int i = 7; i <= 9; i++) {
            JButton btn = new JButton();
            btn.setText("" + i);
            btn.setToolTipText("number " + i);
            numsSimp[i] = btn;
            simpleKeyboardPanel.add(numsSimp[i]);
        }

        divideSimp = new JButton();
        divideSimp.setText("/");
        divideSimp.setToolTipText("Division");
        simpleKeyboardPanel.add(divideSimp);

        for (int i = 4; i <= 6; i++) {
            JButton btn = new JButton();
            btn.setText("" + i);
            btn.setToolTipText("number " + i);
            numsSimp[i] = btn;
            simpleKeyboardPanel.add(numsSimp[i]);
        }

        multiSimp = new JButton();
        multiSimp.setText("X");
        multiSimp.setToolTipText("Multiplication");
        simpleKeyboardPanel.add(multiSimp);

        for (int i = 1; i <= 3; i++) {
            JButton btn = new JButton();
            btn.setText("" + i);
            btn.setToolTipText("number " + i);
            numsSimp[i] = btn;
            simpleKeyboardPanel.add(numsSimp[i]);
        }

        subtractSimp = new JButton();
        subtractSimp.setText("_");
        subtractSimp.setToolTipText("Subtraction");
        simpleKeyboardPanel.add(subtractSimp);

        JButton zeroBtn = new JButton();
        zeroBtn.setText("0");
        zeroBtn.setToolTipText("number 0");
        numsSimp[0] = zeroBtn;
        simpleKeyboardPanel.add(numsSimp[0]);

        equalsSimp = new JButton();
        equalsSimp.setText("=");
        equalsSimp.setToolTipText("Equals");
        simpleKeyboardPanel.add(equalsSimp);

        pointSimp = new JButton();
        pointSimp.setText(".");
        pointSimp.setToolTipText("Point");
        simpleKeyboardPanel.add(pointSimp);

        addSimp = new JButton();
        addSimp.setText("+");
        addSimp.setToolTipText("Addition");
        simpleKeyboardPanel.add(addSimp);

        // Advanced calculator panel.
        JPanel advancedKeyboardPanel = new JPanel(new GridLayout(4, 6, 5, 5));

        numsAdv = new JButton[10];

        for (int i = 7; i <= 9; i++) {
            JButton btn = new JButton();
            btn.setText("" + i);
            btn.setToolTipText("number " + i);
            numsAdv[i] = btn;
            advancedKeyboardPanel.add(numsAdv[i]);
        }

        divideAdv = new JButton();
        divideAdv.setText("/");
        divideAdv.setToolTipText("Division");
        advancedKeyboardPanel.add(divideAdv);

        shift = new JButton();
        shift.setText("shift");
        shift.setToolTipText("Shift");
        advancedKeyboardPanel.add(shift);

        e = new JButton();
        e.setText("e");
        e.setToolTipText("e");
        advancedKeyboardPanel.add(e);

        for (int i = 4; i <= 6; i++) {
            JButton btn = new JButton();
            btn.setText("" + i);
            btn.setToolTipText("number " + i);
            numsAdv[i] = btn;
            advancedKeyboardPanel.add(numsAdv[i]);
        }

        multiAdv = new JButton();
        multiAdv.setText("X");
        multiAdv.setToolTipText("Multiplication");
        advancedKeyboardPanel.add(multiAdv);

        sinCos = new JButton();
        sinCos.setText("sin/cos");
        sinCos.setToolTipText("sin/cos");
        advancedKeyboardPanel.add(sinCos);

        pi = new JButton();
        pi.setText("pi");
        pi.setToolTipText("pi");
        advancedKeyboardPanel.add(pi);

        for (int i = 1; i <= 3; i++) {
            JButton btn = new JButton();
            btn.setText("" + i);
            btn.setToolTipText("number " + i);
            numsAdv[i] = btn;
            advancedKeyboardPanel.add(numsAdv[i]);
        }

        subtractAdv = new JButton();
        subtractAdv.setText("_");
        subtractAdv.setToolTipText("Subtraction");
        advancedKeyboardPanel.add(subtractAdv);

        tanCot = new JButton();
        tanCot.setText("tan/cot");
        tanCot.setToolTipText("tan/cot");
        advancedKeyboardPanel.add(tanCot);

        log = new JButton();
        log.setText("log");
        log.setToolTipText("log");
        advancedKeyboardPanel.add(log);

        JButton zeroBtnAd = new JButton();
        zeroBtnAd.setText("0");
        zeroBtn.setToolTipText("number 0");
        numsAdv[0] = zeroBtnAd;
        advancedKeyboardPanel.add(numsAdv[0]);

        equalsAdv = new JButton();
        equalsAdv.setText("=");
        equalsAdv.setToolTipText("Equals");
        advancedKeyboardPanel.add(equalsAdv);

        pointAdv = new JButton();
        pointAdv.setText(".");
        pointAdv.setToolTipText(".");
        advancedKeyboardPanel.add(pointAdv);

        addAdv = new JButton();
        addAdv.setText("+");
        addAdv.setToolTipText("Addition");
        advancedKeyboardPanel.add(addAdv);

        power = new JButton();
        power.setText("^");
        power.setToolTipText("Power");
        advancedKeyboardPanel.add(power);

        percent = new JButton();
        percent.setText("%");
        percent.setToolTipText("Point");
        advancedKeyboardPanel.add(percent);

        tabs.add("Simple", simpleKeyboardPanel);
        tabs.add("Advanced", advancedKeyboardPanel);


        frame.add(topPart, BorderLayout.NORTH);
        frame.add(tabs, BorderLayout.CENTER);

        setUpMenuBar();

        frame.setVisible(true);
    }

    /**
     * Set up the menubar.
     */
    private void setUpMenuBar() {
        menuBar = new JMenuBar();

        JMenu optionsMenu = new JMenu("Options");
        optionsMenu.setToolTipText("Options");

        JMenuItem copyMI = new JMenuItem("Copy");
        copyMI.setMnemonic('c');
        copyMI.setMnemonic('C');
        copyMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        copyMI.setToolTipText("Copy");
        copyMI.addItemListener(new ItemListener() {
            @Override // ?????
            public void itemStateChanged(ItemEvent itemEvent) {
                StringSelection stringSelection = new StringSelection(numberScreen.getText());
                Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
                clpbrd.setContents (stringSelection, null);
            }
        });

        JMenuItem exitMI = new JMenuItem("Exit");
        exitMI.setMnemonic('e');
        exitMI.setMnemonic('E');
        exitMI.setToolTipText("Exit");
        exitMI.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                System.exit(0);
            }
        });

        optionsMenu.add(copyMI);
        optionsMenu.add(exitMI);

        menuBar.add(optionsMenu);

        frame.setJMenuBar(menuBar);
    }

    /**
     * Get calculator's frame.
     * @return frame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Get menubar.
     * @return menuBar
     */
    public JMenuBar getMenuBar() {
        return menuBar;
    }

    /**
     * Get numberScreen.
     * @return numberScreen
     */
    public JTextArea getNumberScreen() {
        return numberScreen;
    }

    /**
     * Get operator label.
     * @return operatorLabel
     */
    public JLabel getOperatorLabel() {
        return operatorLabel;
    }

    /**
     * Get clearBtn.
     * @return clearBtn
     */
    public JButton getClearBtn() {
        return clearBtn;
    }

    /**
     * Get numSimp.
     * @return numsSimp
     */
    public JButton[] getNumsSimp() {
        return numsSimp;
    }

    /**
     * get pointSimp.
     * @return pointSimp
     */
    public JButton getPointSimp() {
        return pointSimp;
    }

    /**
     * Get divideSimp.
     * @return divideSimp
     */
    public JButton getDivideSimp() {
        return divideSimp;
    }

    /**
     * Get multiSimp.
     * @return multiSimp
     */
    public JButton getMultiSimp() {
        return multiSimp;
    }

    /**
     * Get addSimp.
     * @return addSimp
     */
    public JButton getAddSimp() {
        return addSimp;
    }

    /**
     * Get subtractSimp.
     * @return subtractSimp
     */
    public JButton getSubtractSimp() {
        return subtractSimp;
    }

    /**
     * Get equalsSimp.
     * @return equalsSimp
     */
    public JButton getEqualsSimp() {
        return equalsSimp;
    }

    /**
     * Get numsAdv.
     * @return numsAdv
     */
    public JButton[] getNumsAdv() {
        return numsAdv;
    }

    /**
     * Get pointAdv.
     * @return pointAdv
     */
    public JButton getPointAdv() {
        return pointAdv;
    }

    /**
     * Get divideAdv.
     * @return divideAdv
     */
    public JButton getDivideAdv() {
        return divideAdv;
    }

    /**
     * Get multiAdv.
     * @return multiAdv
     */
    public JButton getMultiAdv() {
        return multiAdv;
    }

    /**
     * Get addAdv.
     * @return addAdv
     */
    public JButton getAddAdv() {
        return addAdv;
    }

    /**
     * Get subtractAdv.
     * @return subtractAdv
     */
    public JButton getSubtractAdv() {
        return subtractAdv;
    }

    /**
     * Get equalsAdv.
     * @return equalsAdv
     */
    public JButton getEqualsAdv() {
        return equalsAdv;
    }

    /**
     * Get sinCos.
     * @return sinCos
     */
    public JButton getSinCos() {
        return sinCos;
    }

    /**
     * Get tanCot.
     * @return tanCot
     */
    public JButton getTanCot() {
        return tanCot;
    }

    /**
     * Get power.
     * @return power
     */
    public JButton getPower() {
        return power;
    }

    /**
     * Get e.
     * @return e
     */
    public JButton getE() {
        return e;
    }

    /**
     * Get pi.
     * @return pi
     */
    public JButton getPi() {
        return pi;
    }

    /**
     * Get log.
     * @return log
     */
    public JButton getLog() {
        return log;
    }

    /**
     * Get percent.
     * @return percent
     */
    public JButton getPercent() {
        return percent;
    }

    /**
     * Get shift.
     * @return shift
     */
    public JButton getShift() {
        return shift;
    }
}
