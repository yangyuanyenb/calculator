package com.company.calculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())) {
                    display.setText("");
                }
            }
        });
    }

    private void updateText(String strToAdd, int cursorPosDelta) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())) {
            display.setText(strToAdd);
        }
        else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));

        }
        display.setSelection(cursorPos + cursorPosDelta);


    }


    public void zeroBT(View view) {

        updateText("0",1);

    }

    public void oneBT(View view) {
        updateText( "1",1);

    }

    public void twoBT(View view) {
        updateText( "2",1);

    }

    public void threeBT(View view) {
        updateText( "3",1);

    }

    public void fourBT(View view) {
        updateText( "4",1);

    }

    public void fiveBT(View view) {
        updateText( "5",1);

    }

    public void sixBT(View view) {
        updateText( "6",1);

    }

    public void sevenBT(View view) {
        updateText( "7",1);

    }

    public void eightBT(View view) {
        updateText( "8",1);

    }

    public void nineBT(View view) {
        updateText( "9",1);

    }

    public void divideBT(View view) {
        updateText( "÷",1);

    }

    public void multiplyBT(View view) {
        updateText( "×",1);

    }

    public void subtractBT(View view) {
        updateText( "-",1);


    }

    public void addBT(View view) {
        updateText( "+",1);

    }

    public void equalBT(View view) {
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());


    }

    public void pointBT(View view) {
        updateText( ".",1);

    }

    public void exponentBT(View view) {
        updateText( "^",1);

    }

    public void sineBT(View view) {
        updateText( "sin()",4);


    }

    public void cosineBT(View view) {
        updateText( "cos()",4);

    }

    public void tangentBT(View view) {
        updateText( "tan()",4);

    }

    public void clearBT(View view) {
        display.setText("");

    }

    public void plusMinusBT(View view) {
        updateText( "-",1);

    }

    public void parenthesesBT(View view) {
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textLen = display.getText().length();

        for (int i = 0; i < cursorPos; i++) {
            if (display.getText().toString().substring(i, i+1).equals("(")) {
                openPar +=1;
            }

            if (display.getText().toString().substring(i, i+1).equals(")")) {
                closedPar +=1;
            }


        }

        if (openPar == closedPar || display.getText().toString().substring(textLen-1, textLen).equals("(")) {
            updateText("(",1);

        }

        else if (closedPar < openPar && !display.getText().toString().substring(textLen-1, textLen).equals("(")) {
            updateText(")",1);

        }
        display.setSelection(cursorPos + 1);





    }

    public void deleteBT(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }

    }


}