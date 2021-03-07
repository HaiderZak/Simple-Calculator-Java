package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {
    Button button0, button1, button2, button3, button4, button5,
            button6, button7, button8, button9, buttonAdd, buttonSub,
            buttonDivision, buttonMultiply, buttonC, buttonEqual, buttonDecimal, buttonOpen, buttonClose;
    TextView edttxt;
    Stack<String> operators = new Stack<>();
    Stack<Double> numbers = new Stack<>();
    String adder;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize buttons
        button0 = (Button) findViewById(R.id.btn_0);
        button1 = (Button) findViewById(R.id.btn_1);
        button2 = (Button) findViewById(R.id.btn_2);
        button3 = (Button) findViewById(R.id.btn_3);
        button4 = (Button) findViewById(R.id.btn_4);
        button5 = (Button) findViewById(R.id.btn_5);
        button6 = (Button) findViewById(R.id.btn_6);
        button7 = (Button) findViewById(R.id.btn_7);
        button8 = (Button) findViewById(R.id.btn_8);
        button9 = (Button) findViewById(R.id.btn_9);
        buttonAdd = (Button) findViewById(R.id.btn_Add);
        buttonSub = (Button) findViewById(R.id.btn_Sub);
        buttonMultiply = (Button) findViewById(R.id.btn_Mul);
        buttonDecimal = (Button) findViewById(R.id.btn_dec);
        buttonEqual = (Button) findViewById(R.id.btn_calc);
        buttonDivision = (Button) findViewById(R.id.btn_Div);
        buttonOpen = (Button) findViewById(R.id.btnopen);
        buttonClose = (Button) findViewById(R.id.btnclose);
        buttonC = (Button) findViewById(R.id.btn_clear);

        //Initialize TextView
        edttxt = (TextView) findViewById(R.id.edText1);

        adder = "";

        //0-9 Buttons Functionality
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "0");
                adder += 0;

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "1");
                adder += 1;

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "2");
                adder += 2;

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "3");
                adder += 3;

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "4");
                adder += 4;

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "5");
                adder += 5;

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "6");
                adder += 6;

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "7");
                adder += 7;

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "8");
                adder += 8;

            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(edttxt.getText() + "9");
                adder += 9;

            }
        });

        //Operator Buttons Functionality
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(edttxt.getText().toString())) {
                    edttxt.setText("");
                } else {
                    adder += " + ";
                    //edttxt.setText(null);
                    edttxt.setText(edttxt.getText() + " + ");
                }
            }
        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(edttxt.getText().toString())) {
                    edttxt.setText("");
                } else {
                    adder += " - ";
                    //edttxt.setText(null);
                    edttxt.setText(edttxt.getText() + " - ");
                }
            }
        });
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(edttxt.getText().toString())) {
                    edttxt.setText("");
                } else {
                    adder += " / ";
                    //edttxt.setText(null);
                    edttxt.setText(edttxt.getText() + " / ");
                }

            }
        });
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(edttxt.getText().toString())) {
                    edttxt.setText("");
                } else {
                    adder += " * ";
                    //edttxt.setText(null);
                    edttxt.setText(edttxt.getText() + " x ");
                }
            }
        });
        buttonOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adder += "( ";
                edttxt.setText(edttxt.getText() + "(");
            }
        });
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(edttxt.getText().toString())) {
                    edttxt.setText("");
                } else {
                    adder += " ) ";
                    edttxt.setText(edttxt.getText() + ")");
                }
            }
        });
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edttxt.setText(null);
                adder = "";
                operators.clear();
                numbers.clear();
            }
        });
        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("".equals(edttxt.getText().toString())) {
                    edttxt.setText("");
                } else {
                    edttxt.setText(edttxt.getText() + ".");
                    adder += ".";
                }
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() { // Using two-stack algorithm ==> Split the operators and numerical values, compute using applyOperation() method until queue is empty..
            @Override
            public void onClick(View vf) throws EmptyStackException {
                try {
                    TreeMap<String, Integer> operationOrder = new TreeMap<>(); // Creating a tree map for order of operations
                    operationOrder.put("(", 0);
                    operationOrder.put(")", 0);
                    operationOrder.put("+", 1);
                    operationOrder.put("-", 1);
                    operationOrder.put("*", 2);
                    operationOrder.put("/", 2);
                    if ("".equals(edttxt.getText().toString())) {
                        edttxt.setText("");
                    } else {
                        String[] str = adder.split("\\s+");
                        Queue<String> q = new LinkedList<>();
                        q.addAll(Arrays.asList(str));
                        while (!q.isEmpty()) {
                            String splitter = q.poll();
                            if (!operationOrder.containsKey(splitter)) {
                                numbers.push(Double.parseDouble(splitter));
                                continue;
                            }
                            while (true) {
                                if (operators.isEmpty() || splitter.equals("(") || (operationOrder.get(splitter) > operationOrder.get(operators.peek()))) {
                                    operators.push(splitter);
                                    break;
                                }
                                String op = operators.pop();
                                if (op.equals("(")) {
                                    assert splitter.equals(")");
                                    break;
                                }
                                else {
                                    double val2 = numbers.pop();
                                    double val1 = numbers.pop();
                                    numbers.push(applyOperation(op, val1, val2));
                                }
                            }
                        }
                        while (!operators.isEmpty()) {
                            String op = operators.pop();
                            double val2 = numbers.pop();
                            double val1 = numbers.pop();
                            numbers.push(applyOperation(op, val1, val2));
                        }
                        edttxt.setText(numbers.pop().toString());
                    }
                }
                catch(Exception e){ // Timer function
                    edttxt.setText("Syntax Error! Clearing board..");
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            MainActivity.this.runOnUiThread(new Runnable(){
                                @Override
                                public void run() {
                                    edttxt.setText("");
                                    adder = "";
                                    operators.clear();
                                    numbers.clear();
                                }
                            });
                        }
                    }, 2000);
                }
            }
            public double applyOperation(String ops, double val1, double val2) {
                if (ops.equals("+")) return val1 + val2;
                if (ops.equals("-")) return val1 - val2;
                if (ops.equals("/")) return val1 / val2;
                if (ops.equals("*")) return val1 * val2;
                throw new RuntimeException("Invalid operator");
            }
        });
    }
}