
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * @author Arunima Mittra
 * Net ID: AXM170025
 * Course: CS 2336.502 
           Dr. Khan
 */

public class calculatorMain extends  JFrame {
	// variables
		String answerStr;
	    String equationStr;
	    boolean replace; //replaces or adds digits to number
	    String numSystem;
	    int toggleCounter;
	
//button declarations
	
	// number keys
    private JButton a;
    private JButton b;
    private JButton c;
    private JButton d;
    private JButton e;
    private JButton f;

    private JButton zero;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    
// functional operations
    // math
    private JButton add;
    private JButton sub;
    private JButton mult;
    private JButton div;
    private JButton equal;
    private JButton mod;
    private JButton negate;
    private JButton rightBrace;
    private JButton leftBrace;
    
    // I/O
    private JButton backspace;
    private JButton ce;
    private JButton clear;
    private JButton toggle; // toggle word, byte, etc

    // display
    private JTextField answer;
    private JTextField mathFull;
    
    // button groups
    private ButtonGroup buttonGroup1;
    private ButtonGroup buttonGroup2;
    private ButtonGroup buttonGroup3;    
    
    // number conversions
    private JTextField binNum;
    private JButton binRadio;
    private JTextField decNum;
    private JButton decRadio;
    private JTextField hexNum;
    private JButton hexRadio;
    private JTextField octNum;
    private JButton octRadio;

// non-functional
    private JLabel menuKey;
    private JButton and;
    private JButton lsh;
    private JButton m;
    private JButton ms;
    private JButton not;
    private JButton xor;
    private JButton second;
    private JButton period;
    private JButton or;
    private JButton rsh;
    private JButton binPad;
    private JButton numPad;
    
    private JLabel titleProgrammer;
	
    //panels
    JPanel display;
    JPanel nonFunctional;
    JPanel someFunctional;
    JPanel numberKeys;
    
    // constructor
    public calculatorMain() {
        
    	// initialize variables
    	answerStr = "0";
        initComponents();
        answer.setText(answerStr);
        mathFull.setText(null);
        replace = true;
        numSystem = "DEC";
        toggleCounter = 4;
        
        answer.setEditable(false);
        mathFull.setEditable(false);
        binNum.setEditable(false);
        hexNum.setEditable(false);
        octNum.setEditable(false);
        decNum.setEditable(false);
        
        hexNum.setText(answerStr);
        binNum.setText(answerStr);
        decNum.setText(answerStr);
        octNum.setText(answerStr);      
    }
    
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(
        UIManager.getSystemLookAndFeelClassName());
        
        // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calculatorMain().setVisible(true);
            }
        });
    }
    
    private void addToAnswer(String num) {
        if(answerStr.equals("0")) {
            replace = true;	}
        
        if (replace) {
	        answerStr = num; 
	        replace = false;    }
        else {
        	answerStr += num; }
  
        answer.setText(answerStr);   
    }
    
    public void setAnswer(String num) {
    	answer.setText(num);
    	
    	if (numSystem.equalsIgnoreCase("DEC")) {
	    	hexNum.setText(NumConversion.dec2Hex(num));
			decNum.setText(num);
			octNum.setText(NumConversion.dec2Oct(num));
			binNum.setText(NumConversion.dec2Bin(num));
    	}
    	else if (numSystem.equalsIgnoreCase("BIN")) {
    		hexNum.setText(NumConversion.dec2Hex(NumConversion.bin2Dec(num)));
    		octNum.setText(NumConversion.dec2Oct(NumConversion.bin2Dec(num)));
    		decNum.setText(NumConversion.bin2Dec(num));
    		binNum.setText(num);
    	}
    	else if (numSystem.equalsIgnoreCase("OCT")) {
    		hexNum.setText(NumConversion.dec2Hex(NumConversion.oct2Dec(num)));
    		octNum.setText(num);
    		decNum.setText(						 NumConversion.oct2Dec(num));
    		binNum.setText(NumConversion.dec2Bin(NumConversion.oct2Dec(num)));
    	}
    	else if (numSystem.equalsIgnoreCase("HEX")) {
    		hexNum.setText(num);
    		octNum.setText(NumConversion.dec2Oct(NumConversion.hex2Dec(num)));
    		decNum.setText(NumConversion.hex2Dec(num));
    		binNum.setText(NumConversion.dec2Bin(NumConversion.hex2Dec(num)));
    	}
    }

	private void ceActionPerformed(ActionEvent evt) {
		answerStr = "0";
		setAnswer(answerStr);
	}

	private void clearActionPerformed(ActionEvent evt) {
		mathFull.setText(null);
		equationStr = "";
		answerStr = "0";
		setAnswer(answerStr);
	}

	private void equalActionPerformed( ActionEvent evt) {
		answerStr = Calculate.evaluateExpression(mathFull.getText()+answerStr, numSystem);
		setAnswer(answerStr);
		mathFull.setText("");
    }
    
    private void zeroActionPerformed( ActionEvent evt) {
        addToAnswer("0");
    }
    
    private void oneActionPerformed( ActionEvent evt) {
        addToAnswer("1");
    }

    private void twoActionPerformed( ActionEvent evt) {
        addToAnswer("2");
    }
    
    private void threeActionPerformed( ActionEvent evt) {
        addToAnswer("3");
    }
    
    private void fourActionPerformed( ActionEvent evt) {
        addToAnswer("4");
    }

    private void fiveActionPerformed( ActionEvent evt) {
        addToAnswer("5");
    }
    
    private void sixActionPerformed( ActionEvent evt) {
        addToAnswer("6");
    }
    
    private void sevenActionPerformed( ActionEvent evt) {
        addToAnswer("7");
    }

    private void eightActionPerformed( ActionEvent evt) {
        addToAnswer("8");
    }
    
    private void nineActionPerformed( ActionEvent evt) {
        addToAnswer("9");
    }
    
    private void aActionPerformed( ActionEvent evt) {
        addToAnswer("A");
    }

    private void bActionPerformed( ActionEvent evt) {
        addToAnswer("B");
    }
    
    private void cActionPerformed( ActionEvent evt) {
        addToAnswer("C");
    }
    
    private void dActionPerformed( ActionEvent evt) {
        addToAnswer("D");
    }
    
    private void eActionPerformed( ActionEvent evt) {
        addToAnswer("E");
    }
    
    private void fActionPerformed( ActionEvent evt) {
        addToAnswer("F");
    }
    
    private void backspaceActionPerformed( ActionEvent evt) {
        replace = true;
        if(answerStr.length() <= 1) {
            addToAnswer("0");
        }
        else {
            addToAnswer(answerStr.substring(0, answerStr.length() - 1));
        }
    }

    private void addActionPerformed( ActionEvent evt) {
        mathFull.setText(mathFull.getText() + answerStr + "+");
        answerStr = "0";
        setAnswer("0");
    }
    
    private void subActionPerformed(ActionEvent evt) {
    	mathFull.setText(mathFull.getText() + answerStr + "-");
    	 answerStr = "0";
        setAnswer("0");
	}

    private void divActionPerformed( ActionEvent evt) {
    	 mathFull.setText(mathFull.getText() + answerStr + "/");
    	 answerStr = "0";
        setAnswer("0");
    }
    
    private void multActionPerformed( ActionEvent evt) {
    	 mathFull.setText(mathFull.getText() + answerStr + "*");
    	 answerStr = "0";
        setAnswer("0");
    }
       
    private void rightBraceActionPerformed( ActionEvent evt) {  
		mathFull.setText(mathFull.getText() + answer.getText() + ")");	
		setAnswer("0");
    }
    
    private void leftBraceActionPerformed(ActionEvent evt) {
		mathFull.setText(mathFull.getText()+"(");		
	}

    protected void modActionPerformed(ActionEvent evt) {
    	//TODO
	}
    
    protected void toggleActionPerformed(ActionEvent evt) {
    	toggleCounter++;
    	if (toggleCounter % 4 == 1) {
    		toggle.setText("QWORD");
    	}
    	else if (toggleCounter % 4 == 2) {
    		toggle.setText("DWORD");
    	}
    	else if (toggleCounter % 4 == 3) {
    		toggle.setText("WORD");
    	}
    	else if (toggleCounter % 4 == 0) {
    		toggle.setText("BYTE");
    	}
    	
	}
    
    private void decRadioActionPerformed( ActionEvent evt) {
        numSystem = "DEC";
        answer.setText(decNum.getText());
        answerStr = answer.getText();
    	zero.setEnabled(true);
        one.setEnabled(true);
        two.setEnabled(true);
        three.setEnabled(true);
        four.setEnabled(true); 
        five.setEnabled(true);
        six.setEnabled(true);
        seven.setEnabled(true);
        eight.setEnabled(true);
        nine.setEnabled(true);
        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
        d.setEnabled(false);
        e.setEnabled(false);
        f.setEnabled(false);
    }

    private void hexRadioActionPerformed( ActionEvent evt) {
        numSystem = "HEX";
        answer.setText(hexNum.getText());
        answerStr = answer.getText();
    	zero.setEnabled(true);
        one.setEnabled(true);
        two.setEnabled(true);
        three.setEnabled(true);
        four.setEnabled(true);
        five.setEnabled(true);
        six.setEnabled(true);
        seven.setEnabled(true);
        eight.setEnabled(true);
        nine.setEnabled(true);
        a.setEnabled(true);
        b.setEnabled(true);
        c.setEnabled(true);
        d.setEnabled(true);
        e.setEnabled(true);
        f.setEnabled(true);
    }

    private void octRadioActionPerformed( ActionEvent evt) {
        numSystem = "OCT";
        answer.setText(octNum.getText());
        answerStr = answer.getText();
    	zero.setEnabled(true);
        one.setEnabled(true);
        two.setEnabled(true);
        three.setEnabled(true);
        four.setEnabled(true);
        five.setEnabled(true);
        six.setEnabled(true);
        seven.setEnabled(true);
        eight.setEnabled(false);
        nine.setEnabled(false);
        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
        d.setEnabled(false);
        e.setEnabled(false);
        f.setEnabled(false);
    }

    private void binRadioActionPerformed( ActionEvent evt) {
        numSystem = "BIN";
        answer.setText(binNum.getText());
        answerStr = answer.getText();
    	
        zero.setEnabled(true);
        one.setEnabled(true);
        two.setEnabled(false);
        three.setEnabled(false);
        four.setEnabled(false);
        five.setEnabled(false);
        six.setEnabled(false);
        seven.setEnabled(false);
        eight.setEnabled(false);
        nine.setEnabled(false);
        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
        d.setEnabled(false);
        e.setEnabled(false);
        f.setEnabled(false);
    }

    protected void negateActionPerformed(ActionEvent evt) {
    }

    private void initComponents() {
        buttonGroup1 = new ButtonGroup();
        buttonGroup2 = new ButtonGroup();
        buttonGroup3 = new ButtonGroup();
        
        sub = new JButton();
        mult = new JButton();
        div = new JButton();
        equal = new JButton();
        
        a = new  JButton();
        b = new  JButton();
        c = new  JButton();
        d = new  JButton();
        e = new  JButton();
        f = new  JButton();
        
        zero = new JButton();
        one = new JButton();
        two = new JButton();
        three = new JButton();
        four = new  JButton();
        five = new JButton();
        six = new JButton();
        seven = new JButton();
        eight = new JButton();
        nine = new JButton();
        
        clear = new JButton();
        backspace = new JButton();
        xor = new JButton();
        not = new JButton();
        and = new JButton();
        period = new JButton();
        
        add = new JButton();
        lsh = new JButton();
        rsh = new JButton();
        or = new JButton();
        leftBrace = new JButton();
        rightBrace = new JButton();
        negate = new  JButton();
        
        second = new  JButton();
        mod = new  JButton();
        ce = new  JButton();
        titleProgrammer = new  JLabel();
        answer = new  JTextField();
        decRadio = new  JButton();
        hexRadio = new  JButton();
        octRadio = new  JButton();
        binRadio = new  JButton();
        menuKey = new  JLabel();
        ms = new  JButton();
        m = new  JButton();
        numPad = new  JButton();
        binPad = new  JButton();
        toggle = new  JButton();
        decNum = new  JTextField();
        hexNum = new  JTextField();
        binNum = new  JTextField();
        octNum = new  JTextField();
        mathFull = new  JTextField();
        
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        setLocationByPlatform(true);
        setTitle("Calculator");
        setName("mainFrame"); // NOI18N
        setSize(400, 600);
        setResizable(false);

        five.setBackground(new java.awt.Color(255, 255, 255));
        five.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        five.setText("5");
        five.setBorder(null);
        buttonGroup1.add(five);
        five.setMargin(new Insets(2, 2, 2, 2));
        five.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                fiveActionPerformed(evt);
            }
        });

        six.setBackground(new java.awt.Color(255, 255, 255));
        six.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        six.setText("6");
        six.setBorder(null);
        buttonGroup1.add(six);
        six.setMargin(new java.awt.Insets(2, 2, 2, 2));
        six.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                sixActionPerformed(evt);
            }
        });

        sub.setBackground(new java.awt.Color(245, 245, 245));
        sub.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        sub.setText("-");
        sub.setBorder(null);
        sub.setMargin(new java.awt.Insets(2, 2, 2, 2));
        sub.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                subActionPerformed(evt);
            }
        });

        eight.setBackground(new java.awt.Color(255, 255, 255));
        eight.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        eight.setText("8");
        eight.setBorder(null);
        buttonGroup1.add(eight);
        eight.setMargin(new java.awt.Insets(2, 2, 2, 2));
        eight.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                eightActionPerformed(evt);
            }
        });

        nine.setBackground(new java.awt.Color(255, 255, 255));
        nine.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        nine.setText("9");
        nine.setBorder(null);
        buttonGroup1.add(nine);
        nine.setMargin(new java.awt.Insets(2, 2, 2, 2));
        nine.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                nineActionPerformed(evt);
            }
        });

        mult.setBackground(new java.awt.Color(245, 245, 245));
        mult.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        mult.setText("*");
        mult.setBorder(null);
        mult.setMargin(new java.awt.Insets(2, 2, 2, 2));
        mult.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                multActionPerformed(evt);
            }
        });

        clear.setBackground(new java.awt.Color(245, 245, 245));
        clear.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        clear.setText("C");
        clear.setBorder(null);
        clear.setMargin(new java.awt.Insets(2, 2, 2, 2));
        clear.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        backspace.setBackground(new java.awt.Color(245, 245, 245));
        backspace.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        backspace.setText("<x");
        backspace.setBorder(null);
        backspace.setMargin(new java.awt.Insets(2, 2, 2, 2));
        backspace.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                backspaceActionPerformed(evt);
            }
        });

        div.setBackground(new java.awt.Color(245, 245, 245));
        div.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        div.setText("/");
        div.setBorder(null);
        div.setMargin(new java.awt.Insets(2, 2, 2, 2));
        div.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                divActionPerformed(evt);
            }
        });

        xor.setBackground(new java.awt.Color(245, 245, 245));
        xor.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        xor.setText("Xor");
        xor.setBorder(null);
        xor.setEnabled(false);
        xor.setMargin(new java.awt.Insets(2, 2, 2, 2));

        not.setBackground(new java.awt.Color(245, 245, 245));
        not.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        not.setText("Not");
        not.setBorder(null);
        not.setEnabled(false);
        not.setMargin(new java.awt.Insets(2, 2, 2, 2));       

        and.setBackground(new java.awt.Color(245, 245, 245));
        and.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        and.setText("And");
        and.setBorder(null);
        and.setEnabled(false);
        and.setMargin(new java.awt.Insets(2, 2, 2, 2));

        zero.setBackground(new java.awt.Color(255, 255, 255));
        zero.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        zero.setText("0");
        zero.setBorder(null);
        buttonGroup1.add(zero);
        zero.setMargin(new java.awt.Insets(2, 2, 2, 2));
        zero.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                zeroActionPerformed(evt);
            }
        });

        period.setBackground(new java.awt.Color(245, 245, 245));
        period.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        period.setText(".");
        period.setBorder(null);
        period.setMargin(new java.awt.Insets(2, 2, 2, 2));        

        equal.setBackground(new java.awt.Color(245, 245, 245));
        equal.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        equal.setText("=");
        equal.setBorder(null);
        equal.setMargin(new java.awt.Insets(2, 2, 2, 2));
        equal.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                equalActionPerformed(evt);
            }
        });

        two.setBackground(new java.awt.Color(255, 255, 255));
        two.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        two.setText("2");
        two.setBorder(null);
        buttonGroup1.add(two);
        two.setMargin(new java.awt.Insets(2, 2, 2, 2));
        two.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                twoActionPerformed(evt);
            }
        });

        three.setBackground(new java.awt.Color(255, 255, 255));
        three.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        three.setText("3");
        three.setBorder(null);
        buttonGroup1.add(three);
        three.setMargin(new java.awt.Insets(2, 2, 2, 2));
        three.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                threeActionPerformed(evt);
            }
        });

        add.setBackground(new java.awt.Color(245, 245, 245));
        add.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        add.setText("+");
        add.setBorder(null);
        add.setMargin(new java.awt.Insets(2, 2, 2, 2));
        add.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        lsh.setBackground(new java.awt.Color(245, 245, 245));
        lsh.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        lsh.setText("Lsh");
        lsh.setBorder(null);
        lsh.setEnabled(false);
        lsh.setMargin(new java.awt.Insets(2, 2, 2, 2));        

        rsh.setBackground(new java.awt.Color(245, 245, 245));
        rsh.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        rsh.setText("Rsh");
        rsh.setBorder(null);
        rsh.setEnabled(false);
        rsh.setMargin(new java.awt.Insets(2, 2, 2, 2));        

        or.setBackground(new java.awt.Color(245, 245, 245));
        or.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        or.setText("Or");
        or.setBorder(null);
        or.setEnabled(false);
        or.setMargin(new java.awt.Insets(2, 2, 2, 2));

        leftBrace.setBackground(new java.awt.Color(245, 245, 245));
        leftBrace.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        leftBrace.setText("(");
        leftBrace.setBorder(null);
        leftBrace.setMargin(new java.awt.Insets(2, 2, 2, 2));
        leftBrace.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                leftBraceActionPerformed(evt);
            }
        });

        rightBrace.setBackground(new java.awt.Color(245, 245, 245));
        rightBrace.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        rightBrace.setText(")");
        rightBrace.setBorder(null);
        rightBrace.setMargin(new java.awt.Insets(2, 2, 2, 2));
        rightBrace.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                rightBraceActionPerformed(evt);
            }
        });

        negate.setBackground(new java.awt.Color(245, 245, 245));
        negate.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        negate.setText("+/-");
        negate.setBorder(null);
        negate.setMargin(new java.awt.Insets(2, 2, 2, 2));
        negate.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                negateActionPerformed(evt);
            }
        });

        e.setBackground(new java.awt.Color(255, 255, 255));
        e.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        e.setText("E");
        e.setBorder(null);
        buttonGroup2.add(e);
        e.setDefaultCapable(false);
        e.setMargin(new java.awt.Insets(2, 2, 2, 2));
        e.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                eActionPerformed(evt);
            }
        });

        f.setBackground(new java.awt.Color(255, 255, 255));
        f.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        f.setText("F");
        f.setBorder(null);
        buttonGroup2.add(f);
        f.setDefaultCapable(false);
        f.setMargin(new java.awt.Insets(2, 2, 2, 2));
        f.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                fActionPerformed(evt);
            }
        });

        one.setBackground(new java.awt.Color(255, 255, 255));
        one.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        one.setText("1");
        one.setBorder(null);
        buttonGroup1.add(one);
        one.setMargin(new java.awt.Insets(2, 2, 2, 2));
        one.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                oneActionPerformed(evt);
            }
        });

        c.setBackground(new java.awt.Color(255, 255, 255));
        c.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        c.setText("C");
        c.setBorder(null);
        buttonGroup2.add(c);
        c.setDefaultCapable(false);
        c.setMargin(new java.awt.Insets(2, 2, 2, 2));
        c.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                cActionPerformed(evt);
            }
        });

        d.setBackground(new java.awt.Color(255, 255, 255));
        d.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        d.setText("D");
        d.setBorder(null);
        buttonGroup2.add(d);
        d.setDefaultCapable(false);
        d.setMargin(new java.awt.Insets(2, 2, 2, 2));
        d.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                dActionPerformed(evt);
            }
        });

        four.setBackground(new java.awt.Color(255, 255, 255));
        four.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        four.setText("4");
        four.setBorder(null);
        buttonGroup1.add(four);
        four.setMargin(new java.awt.Insets(2, 2, 2, 2));
        four.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                fourActionPerformed(evt);
            }
        });

        a.setBackground(new java.awt.Color(255, 255, 255));
        a.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        a.setText("A");
        a.setBorder(null);
        buttonGroup2.add(a);
        a.setDefaultCapable(false);
        a.setMargin(new java.awt.Insets(2, 2, 2, 2));
        a.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                aActionPerformed(evt);
            }
        });

        b.setBackground(new java.awt.Color(255, 255, 255));
        b.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        b.setText("B");
        b.setToolTipText("");
        b.setBorder(null);
        buttonGroup2.add(b);
        b.setDefaultCapable(false);
        b.setMargin(new java.awt.Insets(2, 2, 2, 2));
        b.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                bActionPerformed(evt);
            }
        });

        seven.setBackground(new java.awt.Color(255, 255, 255));
        seven.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        seven.setText("7");
        seven.setBorder(null);
        buttonGroup1.add(seven);
        seven.setMargin(new java.awt.Insets(2, 2, 2, 2));
        seven.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                sevenActionPerformed(evt);
            }
        });

        second.setBackground(new java.awt.Color(245, 245, 245));
        second.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        second.setText("2nd");
        second.setBorder(null);
        second.setMargin(new java.awt.Insets(2, 2, 2, 2));

        mod.setBackground(new java.awt.Color(245, 245, 245));
        mod.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        mod.setText("Mod");
        mod.setBorder(null);
        mod.setMargin(new java.awt.Insets(2, 2, 2, 2));        
        mod.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                modActionPerformed(evt);
            }
        });
        
        ce.setBackground(new java.awt.Color(245, 245, 245));
        ce.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        ce.setText("CE");
        ce.setBorder(null);
        ce.setMargin(new java.awt.Insets(2, 2, 2, 2));
        ce.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                ceActionPerformed(evt);
            }
        });

        titleProgrammer.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        titleProgrammer.setHorizontalAlignment( SwingConstants.CENTER);
        titleProgrammer.setText("Programmer");
        titleProgrammer.setPreferredSize(new java.awt.Dimension(60, 14));

        answer.setBackground(new java.awt.Color(240, 240, 240));
        answer.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        answer.setHorizontalAlignment( JTextField.RIGHT);
        answer.setText("Value here");
        answer.setBorder(null);        

        buttonGroup3.add(decRadio);
        decRadio.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        decRadio.setText("DEC");
        decRadio.setBorder(null);
        decRadio.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                decRadioActionPerformed(evt);
            }
        });

        buttonGroup3.add(hexRadio);
        hexRadio.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        hexRadio.setBackground(new java.awt.Color(240, 240, 240));
        hexRadio.setText("HEX");
        hexRadio.setBorder(null);
        hexRadio.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                hexRadioActionPerformed(evt);
            }
        });

        buttonGroup3.add(octRadio);
        octRadio.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        octRadio.setText("OCT");
        octRadio.setBorder(null);
        octRadio.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                octRadioActionPerformed(evt);
            }
        });

        buttonGroup3.add(binRadio);
        binRadio.setFont(new java.awt.Font("Segoe UI Historic", 1, 12)); // NOI18N
        binRadio.setText("BIN");
        binRadio.setBorder(null);
        binRadio.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                binRadioActionPerformed(evt);
            }
        });

        menuKey.setHorizontalAlignment( SwingConstants.CENTER);
        menuKey.setIcon(new  ImageIcon(getClass().getResource("/icons8-menu-30.png"))); // NOI18N
        menuKey.setAlignmentY(0.0F);
        menuKey.setEnabled(false);
        menuKey.setName("Menu"); // NOI18N
        menuKey.setRequestFocusEnabled(false);
        menuKey.setVerifyInputWhenFocusTarget(false);

        ms.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        ms.setText("MS");
        ms.setBorder(null);
        ms.setEnabled(false);
        ms.setMargin(new java.awt.Insets(2, 2, 2, 2));        

        m.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        m.setText("M");
        m.setBorder(null);
        m.setEnabled(false);
        m.setMargin(new java.awt.Insets(2, 2, 2, 2));        

        numPad.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        numPad.setIcon(new  ImageIcon(getClass().getResource("/icons8-keypad-24.png"))); // NOI18N
        numPad.setBorder(null);
        numPad.setEnabled(false);
        numPad.setMargin(new java.awt.Insets(2, 2, 2, 2));

        binPad.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        binPad.setIcon(new  ImageIcon(getClass().getResource("/icons8-data-24.png"))); // NOI18N
        binPad.setBorder(null);
        binPad.setEnabled(false);
        binPad.setMargin(new java.awt.Insets(2, 2, 2, 2));

        toggle.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        toggle.setText("WORD");
        toggle.setBorder(null);
        toggle.setMargin(new java.awt.Insets(2, 2, 2, 2));
        toggle.addActionListener(new  ActionListener() {
            public void actionPerformed( ActionEvent evt) {
                toggleActionPerformed(evt);
            }
        });
        

        decNum.setBackground(new java.awt.Color(240, 240, 240));
        decNum.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        decNum.setText("value here");
        decNum.setBorder(null);

        hexNum.setBackground(new java.awt.Color(240, 240, 240));
        hexNum.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        hexNum.setText("value here");
        hexNum.setBorder(null);

        binNum.setBackground(new java.awt.Color(240, 240, 240));
        binNum.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        binNum.setText("value here");
        binNum.setBorder(null);

        octNum.setBackground(new java.awt.Color(240, 240, 240));
        octNum.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        octNum.setText("value here");
        octNum.setBorder(null);        

        mathFull.setBackground(new java.awt.Color(240, 240, 240));
        mathFull.setFont(new java.awt.Font("Segoe UI Historic", 0, 12)); // NOI18N
        mathFull.setHorizontalAlignment( JTextField.TRAILING);
        mathFull.setText("value here");
        mathFull.setBorder(null);        
        
        GroupLayout layout = new  GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
          layout.setHorizontalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(numPad,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(binPad,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(toggle,  GroupLayout.PREFERRED_SIZE, 96,  GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ms,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(m,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(e,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(f,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(one,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(leftBrace,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(rightBrace,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(negate,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lsh,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(rsh,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(or,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(second,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(mod,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ce,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(a,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(b,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(seven,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(c,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(d,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(four,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(two,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(three,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(add,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(zero,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(period,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(equal,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(xor,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(not,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(and,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(clear,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(backspace,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(div,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(eight,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(nine,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(mult,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(five,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(six,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(sub,  GroupLayout.PREFERRED_SIZE, 45,  GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(binRadio,  GroupLayout.Alignment.LEADING,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(octRadio,  GroupLayout.Alignment.LEADING,  GroupLayout.PREFERRED_SIZE, 60,  GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING, false)
                                    .addComponent(octNum,  GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                    .addComponent(binNum)))
                            .addGroup(layout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.TRAILING, false)
                                    .addGroup( GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(decRadio,  GroupLayout.PREFERRED_SIZE, 60,  GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(decNum))
                                    .addGroup( GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(hexRadio,  GroupLayout.PREFERRED_SIZE, 60,  GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(hexNum,  GroupLayout.PREFERRED_SIZE, 232,  GroupLayout.PREFERRED_SIZE)))
                                .addGroup( GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(menuKey,  GroupLayout.PREFERRED_SIZE, 30,  GroupLayout.PREFERRED_SIZE)
                                    .addGap(22, 22, 22)
                                    .addComponent(titleProgrammer,  GroupLayout.PREFERRED_SIZE, 179,  GroupLayout.PREFERRED_SIZE))
                                .addComponent(mathFull,  GroupLayout.PREFERRED_SIZE, 290,  GroupLayout.PREFERRED_SIZE))))
                    .addComponent(answer))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup( GroupLayout.Alignment.LEADING)
            .addGroup( GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.TRAILING, false)
                    .addComponent(menuKey,  GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(titleProgrammer,  GroupLayout.DEFAULT_SIZE,  GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addComponent(mathFull,  GroupLayout.PREFERRED_SIZE, 34,  GroupLayout.PREFERRED_SIZE)
                .addPreferredGap( LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(answer,  GroupLayout.PREFERRED_SIZE, 39,  GroupLayout.PREFERRED_SIZE)
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(hexRadio)
                    .addComponent(hexNum,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(decRadio)
                    .addComponent(decNum,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(octRadio)
                    .addComponent(octNum,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                    .addComponent(binRadio)
                    .addComponent(binNum,  GroupLayout.PREFERRED_SIZE,  GroupLayout.DEFAULT_SIZE,  GroupLayout.PREFERRED_SIZE))
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.LEADING)
                    .addComponent(numPad,  GroupLayout.Alignment.TRAILING,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                    .addGroup( GroupLayout.Alignment.TRAILING, layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                        .addComponent(ms,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                        .addComponent(m,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE))
                    .addComponent(binPad,  GroupLayout.Alignment.TRAILING,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                    .addComponent(toggle,  GroupLayout.Alignment.TRAILING,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE))
                .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup( GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(lsh,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(rsh,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(or,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(second,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(mod,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(ce,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(a,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(b,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(seven,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(c,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(d,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(four,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(e,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(f,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(one,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(leftBrace,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(rightBrace,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(negate,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(xor,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(not,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(and,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(clear,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(backspace,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(div,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(eight,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(nine,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(mult,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(five,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(six,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(sub,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(two,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(three,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(add,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap( LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup( GroupLayout.Alignment.BASELINE)
                            .addComponent(zero,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(period,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE)
                            .addComponent(equal,  GroupLayout.PREFERRED_SIZE, 35,  GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );    
        pack();
    }
}
