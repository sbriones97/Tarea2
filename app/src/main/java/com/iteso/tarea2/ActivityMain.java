package com.iteso.tarea2;

import android.os.PersistableBundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    ImageButton like;
    Button s;
    Button m;
    Button l;
    Button xl;
    Button cart;
    int button_checked=0;
    String key_checked = "keyCheck";
    String key_add = "keyAdd";
    CoordinatorLayout coordinatorLayout;
    boolean add=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        like = (ImageButton) findViewById(R.id.activity_main_imagebutton);
        s = (Button) findViewById(R.id.activity_main_button1);
        m = (Button) findViewById(R.id.activity_main_button2);
        l = (Button) findViewById(R.id.activity_main_button3);
        xl = (Button) findViewById(R.id.activity_main_button4);
        cart = (Button) findViewById(R.id.activity_main_button_cart);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.layout_main);

        setCheck(button_checked);
        if(add){
            cart.setText(R.string.button_added);
        }

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityMain.this,R.string.toast_imagebutton,Toast.LENGTH_SHORT).show();
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(add){
                    Toast.makeText(ActivityMain.this, R.string.toast_added,Toast.LENGTH_SHORT).show();
                    return;
                }
                add = true;
                cart.setText(R.string.button_added);
                Snackbar snackbar = Snackbar.make(coordinatorLayout,R.string.mssg_snackbar, Snackbar.LENGTH_INDEFINITE)
                        .setAction(R.string.mssg_button_snackbar, new View.OnClickListener(){
                            @Override
                            public void onClick(View v){
                                cart.setText(R.string.button_add);
                                add=false;
                            }
                        });
                snackbar.show();
            }
        });

        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCheck(1);
            }
        });
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCheck(2);
            }
        });
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCheck(3);
            }
        });
        xl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCheck(4);
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(key_checked,button_checked);
        outState.putBoolean(key_add,add);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        button_checked = savedInstanceState.getInt(key_checked);
        add = savedInstanceState.getBoolean(key_add);
        if(add){
            cart.setText(R.string.button_added);
        }
    }

    public void setCheck(int checked){
        button_checked = checked;
        s.setBackground(getDrawable(R.drawable.button));
        s.setTextColor(getColor(R.color.black));
        m.setBackground(getDrawable(R.drawable.button));
        m.setTextColor(getColor(R.color.black));
        l.setBackground(getDrawable(R.drawable.button));
        l.setTextColor(getColor(R.color.black));
        xl.setBackground(getDrawable(R.drawable.button));
        xl.setTextColor(getColor(R.color.black));

        switch (checked){
            case 1:
                s.setBackground(getDrawable(R.drawable.button_selected));
                s.setTextColor(getColor(android.R.color.white));
                break;
            case 2:
                m.setBackground(getDrawable(R.drawable.button_selected));
                m.setTextColor(getColor(android.R.color.white));
                break;
            case 3:
                l.setBackground(getDrawable(R.drawable.button_selected));
                l.setTextColor(getColor(android.R.color.white));
                break;
            case 4:
                xl.setBackground(getDrawable(R.drawable.button_selected));
                xl.setTextColor(getColor(android.R.color.white));
                break;
            default:
                break;
        }

    }
}
