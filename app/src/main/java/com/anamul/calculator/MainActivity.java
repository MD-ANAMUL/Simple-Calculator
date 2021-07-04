package com.anamul.calculator;

import android.annotation.SuppressLint;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnC, btnD, btn_equal,
            btn_addition, btn_multn, btn_min, btn_divided;
    public TextView txt_display, txt_s_display;
    boolean bol_add, bol_minus, bol_multi, bol_divide,del;
    int num, numS;
//    double number, numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
//        Objects.requireNonNull ( getSupportActionBar () ).hide ();
        this.getWindow ().setFlags ( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );

        setContentView ( R.layout.activity_main );


        allInit ();
        allButtonsClick ();


    }


    private void allButtonsClick() {
        btn0.setOnClickListener ( this );
        btn1.setOnClickListener ( this );
        btn2.setOnClickListener ( this );
        btn3.setOnClickListener ( this );
        btn4.setOnClickListener ( this );
        btn5.setOnClickListener ( this );
        btn6.setOnClickListener ( this );
        btn7.setOnClickListener ( this );
        btn8.setOnClickListener ( this );
        btn9.setOnClickListener ( this );

        btnC.setOnClickListener ( this );
        btnD.setOnClickListener ( this );

        btn_equal.setOnClickListener ( this );

        btn_addition.setOnClickListener ( this );
        btn_min.setOnClickListener ( this );
        btn_multn.setOnClickListener ( this );
        btn_divided.setOnClickListener ( this );
    }

    private void allInit() {
//        TextView
        txt_display = findViewById ( R.id.edt_display );
        txt_s_display = findViewById ( R.id.edt_display_demo );

//        All Buttons
        btn0 = findViewById ( R.id.btn_zero );
        btn1 = findViewById ( R.id.btn1 );
        btn2 = findViewById ( R.id.btn2 );
        btn3 = findViewById ( R.id.btn3 );
        btn4 = findViewById ( R.id.btn4 );
        btn5 = findViewById ( R.id.btn5 );
        btn6 = findViewById ( R.id.btn6 );
        btn7 = findViewById ( R.id.btn7 );
        btn8 = findViewById ( R.id.btn8 );
        btn9 = findViewById ( R.id.btn9 );

        btnC = findViewById ( R.id.btn_clear );
        btnD = findViewById ( R.id.btn_delete );

        btn_addition = findViewById ( R.id.btn_plus );
        btn_min = findViewById ( R.id.btn_minus );
        btn_multn = findViewById ( R.id.btn_multi );
        btn_divided = findViewById ( R.id.btn_divide );

        btn_equal = findViewById ( R.id.btn_equals );

    }


    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    @Override
    public void onClick(View v) {

        switch (v.getId ()) {

            case R.id.btn_clear:
                txt_display.setText ( null );
                txt_s_display.setText ( null );
                break;
            case R.id.btn_zero:
                txt_display.setText ( txt_display.getText () + "0" );
                valueStore ();
                break;
            case R.id.btn1:
                txt_display.setText ( txt_display.getText () + "1" );
                valueStore ();
                break;
            case R.id.btn2:
                txt_display.setText ( txt_display.getText () + "2" );
                valueStore ();
                break;
            case R.id.btn3:
                txt_display.setText ( txt_display.getText () + "3" );
                valueStore ();
                break;
            case R.id.btn4:
                txt_display.setText ( txt_display.getText () + "4" );
                valueStore ();
                break;
            case R.id.btn5:
                txt_display.setText ( txt_display.getText () + "5" );
                valueStore ();
                break;
            case R.id.btn6:
                txt_display.setText ( txt_display.getText () + "6" );
                valueStore ();
                break;
            case R.id.btn7:
                txt_display.setText ( txt_display.getText () + "7" );
                valueStore ();
                break;
            case R.id.btn8:
                txt_display.setText ( txt_display.getText () + "8" );
                valueStore ();
                break;

            case R.id.btn9:
                txt_display.setText ( txt_display.getText () + "9" );
                valueStore ();
                break;

            case R.id.btn_plus:
                if (txt_display.getText ().length () != -1) {
                    txt_display.setText ( txt_display.getText () + "+" );
                    bol_add = true;
                    txt_s_display.setText ( txt_display.getText ().toString () );
                    txt_display.setText ( null );
                }
                break;

            case R.id.btn_minus: {
                if (txt_display.getText ().length () != -1) {
                    txt_display.setText ( txt_display.getText () + "-" );
                    bol_minus = true;
                    txt_s_display.setText ( txt_display.getText ().toString () );
                    txt_display.setText ( null );
                }
                break;
            }

            case R.id.btn_multi: {
                if (txt_display.getText ().length () != -1) {
                    txt_display.setText ( txt_display.getText () + "x" );
                    bol_multi = true;
                    txt_s_display.setText ( txt_display.getText () );
                    txt_display.setText ( null );
                }
                break;
            }

            case R.id.btn_divide: {
                if (txt_display.getText ().length () != -1) {
                    txt_display.setText ( txt_display.getText () + "/" );
                    bol_divide = true;
                    txt_s_display.setText ( txt_display.getText () );
                    txt_display.setText ( null );
                }
                break;
            }


            case R.id.btn_equals:
                if (bol_add || bol_minus || bol_multi || bol_divide) {
                    allLogic ();
                    num = Integer.parseInt ( txt_display.getText () + "" );
//                    Toast.makeText ( this, "Dis" + num, Toast.LENGTH_SHORT ).show ();
                }

                break;

            case R.id.btn_delete: {
                String delete = txt_display.getText ().toString ();
                if ( delete.length () >=1){
                   delete = delete.substring ( -0,delete.length () -1 );
                    txt_display.setText ( delete );
                }else if (delete.length () <= 1){
                    txt_display.setText ( "" );
                }


            }


            default:
                Toast.makeText ( this, "Value not found", Toast.LENGTH_SHORT ).show ();
        }

    }





    public void valueStore() {

        if (bol_add || bol_minus || bol_multi || bol_divide) {
            numS = Integer.parseInt ( txt_display.getText ().toString () );
            //            Toast.makeText ( this, "Data founded" + numS, Toast.LENGTH_SHORT ).show ();
        } else {
            num = Integer.parseInt ( txt_display.getText ().toString () );
//            Toast.makeText ( this, "Data found" + num, Toast.LENGTH_SHORT ).show ();
        }



    }


    public void allLogic() {
        if (bol_add) {
            txt_display.setText ( String.valueOf ( num + numS ) );
            txt_s_display.setText ( null );
            bol_add = false;
        }
        if (bol_minus) {
            txt_display.setText ( String.valueOf ( num - numS ) );
            txt_s_display.setText ( null );
            bol_minus = false;
        }

        if (bol_multi) {
            txt_display.setText ( String.valueOf ( num * numS ) );
            txt_s_display.setText ( null );
            bol_multi = false;
        }
        if (bol_divide) {
            txt_display.setText ( String.valueOf ( num / numS ) );
            txt_s_display.setText ( null );
            bol_divide = false;
        }

    }
}