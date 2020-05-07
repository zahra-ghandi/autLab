import javax.swing.*;
import java.awt.event.*;

/**
 * A class to save app's data and logic.
 * @author Zahra Ghandi
 * @version 2020,05,05
 */
public class Model {
    // GUI view.
    private CalculatorGUI view;

    // Save previously displayed number.
    private double number;
    // The last used operator.
    private String operator;

    // Is shift button pressed. ?? ba un yeki avaz kon
    private boolean shift;

    public Model() {
        view = new CalculatorGUI();
        number = 0;
        operator = null;
        shift = false;

        // Add clear button's action listener.
        view.getClearBtn().addActionListener(new ButtonHandler());

        // Add buttons' listeners.
        JButton[] numbers = view.getNumsSimp();
        for(JButton number : numbers) {
            number.addActionListener(new ButtonHandler());
        }
        view.getPointSimp().addActionListener(new ButtonHandler());
        view.getMultiSimp().addActionListener(new ButtonHandler());
        view.getDivideSimp().addActionListener(new ButtonHandler());
        view.getSubtractSimp().addActionListener(new ButtonHandler());
        view.getAddSimp().addActionListener(new ButtonHandler());
        view.getEqualsSimp().addActionListener(new ButtonHandler());

       numbers = view.getNumsAdv();
        for(JButton number : numbers) {
            number.addActionListener(new ButtonHandler());
        }
        view.getPointAdv().addActionListener(new ButtonHandler());
        view.getMultiAdv().addActionListener(new ButtonHandler());
        view.getDivideAdv().addActionListener(new ButtonHandler());
        view.getSubtractAdv().addActionListener(new ButtonHandler());
        view.getAddAdv().addActionListener(new ButtonHandler());
        view.getEqualsAdv().addActionListener(new ButtonHandler());
        view.getPercent().addActionListener(new ButtonHandler());
        view.getLog().addActionListener(new ButtonHandler());
        view.getPi().addActionListener(new ButtonHandler());
        view.getE().addActionListener(new ButtonHandler());
        view.getPower().addActionListener(new ButtonHandler());
        view.getTanCot().addActionListener(new ButtonHandler());
        view.getSinCos().addActionListener(new ButtonHandler());
        view.getShift().addActionListener(new ButtonHandler());

        // Add keyListener.
        view.getFrame().addKeyListener(new KeyHandler());
    }

    /**
     * Get number.
     * @return number
     */
    public double getNumber() {
        return number;
    }

    /**
     * Set number.
     * @param number
     */
    public void setNumber(double number) {
        this.number = number;
    }

    /**
     * Get operator.
     * @return operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Set operator.
     * @param operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * Operate.
     * @param fieldNum
     */
    private void operate(double fieldNum) {
        if (operator != null) {
            if (operator.equals("+")) {
                number += fieldNum;
                return;
            } else if (operator.equals("-")) {
                number -= fieldNum;
                return;
            } else if (operator.equals("*")) {
                number *= fieldNum;
                return;
            } else if (operator.equals("/")) {
                try{
                    number /= fieldNum;
                } catch (ArithmeticException exp) {
                    number = 0;
                }
                return;
            } else if (operator.equals("%")) {
                try{
                    number %= fieldNum;
                } catch (ArithmeticException exp) {
                    number = 0;
                    operator = null;
                    view.getOperatorLabel().setText("Error");
                    delay(1000);
                    view.getOperatorLabel().setText(" ");
                }
                return;
            } else if (operator.equals("^")) {
                number = Math.pow(number, fieldNum);
                return;
            }
        } else {
            number = fieldNum;
            return;
        }
    }

    /**
     * Set the calculator for the next operation.
     */
    private double setNextOperation(double fieldNum) {
        if (operator != null && (operator.equals("=") || operator.equals("e") || operator.equals("sin/cos") || operator.equals("tan/cot") || operator.equals("pi") || operator.equals("log"))) {
            view.getNumberScreen().setText("" + 0);
            view.getOperatorLabel().setText(" ");
            operator = null;
            number = 0;

            return 0;
        } else {
            return fieldNum;
        }
    }

    /**
     * Remove the ending .0 from the result.
     * @return the modified String result.
     */
    private String modifyResult() {
        String stringNum = "" + number;
        if (stringNum.endsWith(".0")) {
            stringNum = stringNum.substring(0, stringNum.length() - 2);
        }
        return stringNum;
    }

    /**
     * Delay the process in ms.
     * @param delay
     */
    private void delay(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }



    /**
     * A handler for calculator's buttons.
     */
    private class ButtonHandler implements ActionListener {

        /**
         * Manage mouse click events.
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            String btnTxt = ((JButton)e.getSource()).getText();
            String fieldTxt = view.getNumberScreen().getText();
            double fieldNum = Double.parseDouble(fieldTxt);

            // Clear button.
            if (btnTxt.equals("AC")) {
                operator = null;
                number = 0;
                shift = false;
                view.getNumberScreen().setText("0");
                view.getOperatorLabel().setText(" ");
            }

            // Shift button.
            if (btnTxt.equals("shift")) {
                shift = true;
                return;
            }

            // Numbers.
            if (btnTxt.equals("0")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 0;
                    view.getNumberScreen().setText(fieldTxt);
                }
                shift = false;
                return;
            } else if (btnTxt.equals("1")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 1;
                } else {
                    fieldTxt = "" + 1;
                }
                view.getNumberScreen().setText(fieldTxt);
                shift = false;
                return;
            } else if (btnTxt.equals("2")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 2;
                } else {
                    fieldTxt = "" + 2;
                }
                view.getNumberScreen().setText(fieldTxt);
                shift = false;
                return;
            } else if (btnTxt.equals("3")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 3;
                } else {
                    fieldTxt = "" + 3;
                }
                view.getNumberScreen().setText(fieldTxt);
                shift = false;
                return;
            } else if (btnTxt.equals("4")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 4;
                } else {
                    fieldTxt = "" + 4;
                }
                view.getNumberScreen().setText(fieldTxt);
                shift = false;
                return;
            } else if (btnTxt.equals("5")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 5;
                } else {
                    fieldTxt = "" + 5;
                }
                view.getNumberScreen().setText(fieldTxt);
                shift = false;
                return;
            } else if (btnTxt.equals("6")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 6;
                } else {
                    fieldTxt = "" + 6;
                }
                view.getNumberScreen().setText(fieldTxt);
                shift = false;
                return;
            } else if (btnTxt.equals("7")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 7;
                } else {
                    fieldTxt = "" + 7;
                }
                view.getNumberScreen().setText(fieldTxt);
                shift = false;
                return;
            } else if (btnTxt.equals("8")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 8;
                } else {
                    fieldTxt = "" + 8;
                }
                view.getNumberScreen().setText(fieldTxt);
                shift = false;
                return;
            } else if (btnTxt.equals("9")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 9;
                } else {
                    fieldTxt = "" + 9;
                }
                view.getNumberScreen().setText(fieldTxt);
                shift = false;
                return;
            } else if (btnTxt.equals(".")) {
                fieldNum = setNextOperation(fieldNum);
                if (!fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + ".";
                    view.getNumberScreen().setText(fieldTxt);
                }
                shift = false;
                return;
            }

            // Operators (simple)
            if (btnTxt.equals("+")) {
                operate(fieldNum);
                operator = "+";
                view.getNumberScreen().setText("0");
                view.getOperatorLabel().setText("     +");
                shift = false;
                return;
            } else if (btnTxt.equals("_")) {
                operate(fieldNum);
                operator = "-";
                view.getNumberScreen().setText("0");
                view.getOperatorLabel().setText("_");
                shift = false;
                return;
            } else if (btnTxt.equals("/")) {
                operate(fieldNum);
                operator = "/";
                view.getNumberScreen().setText("0");
                view.getOperatorLabel().setText("/");
                shift = false;
                return;
            } else if (btnTxt.equals("X")) {
                operate(fieldNum);
                operator = "*";
                view.getNumberScreen().setText("0");
                view.getOperatorLabel().setText("X");
                shift = false;
                return;
            } else if (btnTxt.equals("=")) {
                operate(fieldNum);
                operator = "=";
                view.getNumberScreen().setText(modifyResult());
                view.getOperatorLabel().setText("=");
                shift = false;
                return;
            }

            // Operators (advanced)
            if (btnTxt.equals("%")) {
                operate(fieldNum);
                operator = "%";
                view.getNumberScreen().setText("0");
                view.getOperatorLabel().setText("%");
                shift = false;
                return;
            } else if (btnTxt.equals("e")) {
                operate(fieldNum);
                operator = "e";
                number = Math.exp(number);
                view.getNumberScreen().setText(modifyResult());
                view.getOperatorLabel().setText("e");
                shift = false;
                return;
            } else if (btnTxt.equals("log")) {
                operate(fieldNum);
                operator = "log";
                number = Math.log(number);
                view.getNumberScreen().setText(modifyResult());
                view.getOperatorLabel().setText("log");
                shift = false;
                return;
            } else if (btnTxt.equals("^")) {
                operate(fieldNum);
                operator = "^";
                view.getNumberScreen().setText("0");
                view.getOperatorLabel().setText("^");
                shift = false;
                return;
            } else if (btnTxt.equals("sin/cos")) {
                operate(fieldNum);
                operator = "sin/cos";
                if (shift) {
                    number = Math.cos(number);
                    view.getOperatorLabel().setText("cos");
                    shift = false;
                } else {
                    number = Math.sin(number);
                    view.getOperatorLabel().setText("sin");
                }
                view.getNumberScreen().setText(modifyResult());
                return;
            } else if (btnTxt.equals("tan/cot")) {
                operate(fieldNum);
                operator = "tan/cot";
                if (shift) {
                    try{
                        number = 1/Math.tan(number);
                        view.getOperatorLabel().setText("cot");
                    } catch (ArithmeticException exp) {
                        number = 0;
                        operator = null;
                        view.getOperatorLabel().setText("Error");
                        delay(1000);
                        view.getOperatorLabel().setText(" ");
                    }
                    shift = false;
                } else {
                    try {
                        number = Math.tan(number);
                        view.getOperatorLabel().setText("tan");
                    } catch (ArithmeticException exp) {
                        number = 0;
                        operator = null;
                        view.getOperatorLabel().setText("Error");
                        delay(1000);
                        view.getOperatorLabel().setText(" ");
                    }
                }
                view.getNumberScreen().setText(modifyResult());
                return;
            } else if (btnTxt.equals("pi")) {
                if (fieldNum == 0) {
                    if (operator != null) {
                        operate(Math.PI);
                    } else {
                        number = Math.PI;
                    }
                    operator = "pi";
                    view.getNumberScreen().setText(modifyResult());
                    shift = false;
                    return;
                }
            }
        }
    }

    /**
     * A handler for keyboard button.
     */
    private class KeyHandler extends KeyAdapter {

        /**
         * Manage key pressed events.
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);

            String btnTxt = e.getKeyText(e.getKeyCode());
            String fieldTxt = view.getNumberScreen().getText();
            double fieldNum = Double.parseDouble(fieldTxt);


            if (btnTxt.equals("0")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 0;
                    view.getNumberScreen().setText(fieldTxt);
                }
                shift = false;
                return;
            } else if (btnTxt.equals("1")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 1;
                } else {
                    fieldTxt = "" + 1;
                }
                view.getNumberScreen().setText(fieldTxt);
                shift = false;
                return;
            } else if (btnTxt.equals("2")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 2;
                } else {
                    fieldTxt = "" + 2;
                }
                view.getNumberScreen().setText(fieldTxt);
                shift = false;
                return;
            } else if (btnTxt.equals("3")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 3;
                } else {
                    fieldTxt = "" + 3;
                }
                view.getNumberScreen().setText(fieldTxt);
                shift = false;
                return;
            } else if (btnTxt.equals("4")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 4;
                } else {
                    fieldTxt = "" + 4;
                }
                view.getNumberScreen().setText(fieldTxt);
                shift = false;
                return;
            } else if (btnTxt.equals("5")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 5;
                } else {
                    fieldTxt = "" + 5;
                }
                view.getNumberScreen().setText(fieldTxt);
                shift = false;
                return;
            } else if (btnTxt.equals("6")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 6;
                } else {
                    fieldTxt = "" + 6;
                }
                view.getNumberScreen().setText(fieldTxt);
                shift = false;
                return;
            } else if (btnTxt.equals("7")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 7;
                } else {
                    fieldTxt = "" + 7;
                }
                view.getNumberScreen().setText(fieldTxt);
                shift = false;
                return;
            } else if (btnTxt.equals("8")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 8;
                } else {
                    fieldTxt = "" + 8;
                }
                view.getNumberScreen().setText(fieldTxt);
                shift = false;
                return;
            } else if (btnTxt.equals("9")) {
                fieldNum = setNextOperation(fieldNum);
                if (fieldNum != 0 || fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + 9;
                } else {
                    fieldTxt = "" + 9;
                }
                view.getNumberScreen().setText(fieldTxt);
                shift = false;
                return;
            } else if (btnTxt.equals(".")) {
                fieldNum = setNextOperation(fieldNum);
                if (!fieldTxt.contains(".")) {
                    fieldTxt = fieldTxt + ".";
                    view.getNumberScreen().setText(fieldTxt);
                }
                shift = false;
                return;
            }

            // Operators (simple)
            if (btnTxt.equals("+")) {
                operate(fieldNum);
                operator = "+";
                view.getNumberScreen().setText("0");
                view.getOperatorLabel().setText("     +");
                shift = false;
                return;
            } else if (btnTxt.equals("_")) {
                operate(fieldNum);
                operator = "-";
                view.getNumberScreen().setText("0");
                view.getOperatorLabel().setText("_");
                shift = false;
                return;
            } else if (btnTxt.equals("/")) {
                operate(fieldNum);
                operator = "/";
                view.getNumberScreen().setText("0");
                view.getOperatorLabel().setText("/");
                shift = false;
                return;
            } else if (btnTxt.equals("X")) {
                operate(fieldNum);
                operator = "*";
                view.getNumberScreen().setText("0");
                view.getOperatorLabel().setText("X");
                shift = false;
                return;
            } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                operate(fieldNum);
                operator = "=";
                view.getNumberScreen().setText(modifyResult());
                view.getOperatorLabel().setText("=");
                shift = false;
                return;
            }
        }
    }
}
