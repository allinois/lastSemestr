package com.example.converter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public CheckBox strawbery,blubery,banana,apple;
    public Button Start;
    public EditText TextStrawbery,TextBluberry,TextBananas,TextApple;
    public Random rand;
    public int kolvoApple, kolvoBlubery, kolvoStrawbery, kolvoBanana;
    public int strawberyPrice, bluberyPrice,applePrice,bananasPrice, price;
    public int priceApple, priceBlu, priceStraw, priceBana, summ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strawbery = findViewById(R.id.Strawbery);
        blubery = findViewById(R.id.Bluberry);
        banana = findViewById(R.id.Bananas);
        apple = findViewById(R.id.appleCB);

        Start = findViewById(R.id.button2);

        TextStrawbery = findViewById(R.id.editTextStrawbery);
        TextBluberry = findViewById(R.id.editTextBluberry);
        TextApple = findViewById(R.id.editTextApple);
        TextBananas = findViewById(R.id.editTextBananas);

        rand = new Random();

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(strawbery.isChecked()){
                    priceStraw = rand.nextInt(50);
                    kolvoStrawbery = Integer.parseInt(TextStrawbery.getText().toString());
                    strawberyPrice = kolvoStrawbery * priceStraw;
                }else if (!strawbery.isChecked()) {
                    priceStraw = 0;
                    kolvoStrawbery = 0;
                    strawberyPrice = 0;
                }

                if (blubery.isChecked()){
                    priceBlu = rand.nextInt(50);
                    kolvoBlubery = Integer.parseInt(TextBluberry.getText().toString());
                    bluberyPrice = kolvoBlubery * priceBlu;
                } else if (!blubery.isChecked()) {
                    priceBlu = 0;
                    kolvoBlubery = 0;
                    bluberyPrice = 0;
                }

                if (apple.isChecked()){
                    priceApple = rand.nextInt(50);
                    kolvoApple = Integer.parseInt(TextApple.getText().toString());
                    applePrice = kolvoApple * priceApple;
                }else if (!apple.isChecked()) {
                    priceApple = 0;
                    kolvoApple = 0;
                    applePrice = 0;
                }

                if (banana.isChecked()){
                    priceBana = rand.nextInt(50);
                    kolvoBanana = Integer.parseInt(TextBananas.getText().toString());
                    bananasPrice = kolvoBanana * priceBana;

                }else if (!banana.isChecked()) {
                    priceBana = 0;
                    kolvoBanana = 0;
                    bananasPrice = 0;
                }

                summ = strawberyPrice + bananasPrice + bluberyPrice + applePrice;
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setPositiveButton("OK",null);
                builder.setTitle("Чек");
                builder.setMessage("Яблоки:" + priceApple + "*" + kolvoApple + "=" + applePrice + "\n" +
                        "Клубника:" + priceStraw + "*" + kolvoStrawbery + "=" + strawberyPrice + "\n" +
                        "Бананы:" + priceBana + "*" + kolvoBanana + "=" + bananasPrice + "\n" +
                        "Черника:" + priceBlu + "*" + kolvoBlubery + "=" + bluberyPrice + "\n" +
                        "Итого:" + summ);

                builder.create();
                builder.show();




            }

        });




    }




}