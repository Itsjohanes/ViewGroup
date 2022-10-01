package com.johannes2002895.mycoffeeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtNama,edtEmail,edtNoHP,edtTgl;
    private Spinner dftrminuman;
    private CheckBox chSandwich, chBakery, chCake;
    private RadioGroup rgPembayaran;
    private Button btnSimpan;

    //mendeklarasi untuk tampungan

    private String menuMakanan1, menuMakanan2,menuMakanan3,pembayaran;
    private int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNama = findViewById(R.id.edt_nama);
        edtEmail = findViewById(R.id.edt_email);
        edtNoHP = findViewById(R.id.edt_nohp);
        edtTgl = findViewById(R.id.edt_tglpemesanan);
        dftrminuman = findViewById(R.id.spnr_daftarminuman);
        chSandwich = findViewById(R.id.ch_sandwich);
        chBakery = findViewById(R.id.ch_bakery);
        chCake = findViewById(R.id.ch_cake);
        rgPembayaran = findViewById(R.id.rg_pembayaran);
        btnSimpan = findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_simpan){
            String inputNama = edtNama.getText().toString().trim();
            String inputEmail = edtEmail.getText().toString().trim();
            String inputNoHP = edtNoHP.getText().toString().trim();
            String inputTglPemesanan = edtTgl.getText().toString().trim();
            int hargaMinuman,hargaMakanan1,hargaMakanan2,hargaMakanan3;
            String InputMinuman = dftrminuman.getSelectedItem().toString().trim();
            //blok inisialisasi
            total = 0;
            hargaMinuman= 0;
            hargaMakanan1 = 0;
            hargaMakanan2 = 0;
            hargaMakanan3 = 0;
            switch(InputMinuman){
                case "Cappucino" :
                    hargaMinuman = 10000;
                    break;
                case "Caramel Macchiato" :
                    hargaMinuman = 15000;
                    break;
                case "Caffe Ammericano":
                    hargaMinuman = 12000;
                    break;
                case "Espresso Con Panna":
                    hargaMinuman = 13000;
                    break;
                case "Espresso":
                    hargaMinuman = 6000;
                    break;
                case "Misto":
                    hargaMinuman  = 17000;
                    break;
                case "Cloud Brew":
                    hargaMinuman  = 17000;
                    break;
                case "Blended Cream":
                    hargaMinuman  = 18000;
                    break;
                case "Milk and Chocolate":
                    hargaMinuman = 6000;
                    break;
                case "Thai Tea":
                    hargaMinuman = 5000;
            }


            Integer selectedId = rgPembayaran.getCheckedRadioButtonId();
            boolean isEmptyField = false;
            if(TextUtils.isEmpty(inputNama)){
                isEmptyField  = true;
                edtNama.setError("Masukan Field ini");
            }
            if(TextUtils.isEmpty(inputEmail)){
                isEmptyField  = true;
                edtEmail.setError("Masukan Field ini");
            }
            if(TextUtils.isEmpty(inputNoHP)){
                isEmptyField  = true;
                edtNoHP.setError("Masukan Field ini");
            }
            if(TextUtils.isEmpty(inputTglPemesanan)){
                isEmptyField  = true;
                edtTgl.setError("Masukan Field ini");
            }
            if(!isEmptyField){
                if(chSandwich.isChecked()){
                    menuMakanan1 = "Sandwich";
                    hargaMakanan1 = 15000;
                }else if(!chSandwich.isChecked()){
                    menuMakanan1 = "";
                }
                if(chBakery.isChecked()){
                    menuMakanan2 = "Bakery";
                    hargaMakanan1 = 25000;

                }else if(!chSandwich.isChecked()){
                    menuMakanan2 = "";
                }
                if(chCake.isChecked()){
                    menuMakanan3 = "Cake";
                    hargaMakanan1 = 35000;

                }else if(!chSandwich.isChecked()){
                    menuMakanan3 = "";
                }
            }
            total = hargaMinuman + hargaMakanan1 +hargaMakanan2 +hargaMakanan3;

            switch(selectedId){
                case R.id.rb_cash:
                    pembayaran = "Cash";
                    break;
                case R.id.rb_debet:
                    pembayaran = "Debet";
                    break;
                case R.id.rb_kredit:
                    pembayaran = "Kredit";
                    break;

            }

            Intent kirimData = new
                    Intent(MainActivity.this,DetailActivity.class);
            kirimData.putExtra(DetailActivity.EXTRA_NAMA, inputNama);
            kirimData.putExtra(DetailActivity.EXTRA_EMAIL, inputEmail);
            kirimData.putExtra(DetailActivity.EXTRA_NOHP, inputNoHP);
            kirimData.putExtra(DetailActivity.EXTRA_TGL,
                    inputTglPemesanan);
            kirimData.putExtra(DetailActivity.EXTRA_MINUMAN,
                    InputMinuman);
            kirimData.putExtra(DetailActivity.EXTRA_MAKANAN,
                    menuMakanan1+ " " +menuMakanan2+ " " +menuMakanan3);
            kirimData.putExtra(DetailActivity.EXTRA_PEMBAYARAN,
                    pembayaran);
            kirimData.putExtra(DetailActivity.EXTRA_TOTAL,total);
            startActivity(kirimData);
        }
    }
}