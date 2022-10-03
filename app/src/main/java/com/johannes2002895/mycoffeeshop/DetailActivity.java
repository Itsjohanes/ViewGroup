package com.johannes2002895.mycoffeeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_EMAIL = "extra_email";
    public static final String EXTRA_NOHP = "extra_nohp";
    public static final String EXTRA_TGL = "extra_tgl";
    public static final String EXTRA_TOTAL = "extra_total";
    public static final String EXTRA_MINUMAN = "extra_minuman";
    public static final String EXTRA_MAKANAN = "extra_makanan";
    public static final String EXTRA_PEMBAYARAN = "extra_pembayaran";
    public static final String EXTRA_SUBTOTAL = "extra_subtotal";
    public static final String EXTRA_PAJAK = "extra_pajak";
    public static final String EXTRA_DISKON = "extra_diskon";

    private TextView tvNama, tvEmail, tvNoHP, tvTgl, tvMinuman, tvMakanan,
            tvPembayaran,tvTotal,tvDiskon,tvSubtotal,tvPpn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvNama = findViewById(R.id.tv_nama);
        tvEmail = findViewById(R.id.tv_email);
        tvNoHP = findViewById(R.id.tv_nohp);
        tvTgl = findViewById(R.id.tv_tglpemesanan);
        tvTotal = findViewById(R.id.tv_total);
        tvMinuman = findViewById(R.id.tv_minuman);
        tvMakanan = findViewById(R.id.tv_makanan);
        tvPembayaran = findViewById(R.id.tv_pembayaran);
        tvSubtotal = findViewById(R.id.tv_subtotal);
        tvPpn = findViewById(R.id.tv_pajak);
        tvDiskon  = findViewById(R.id.tv_diskon);
        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        String email = getIntent().getStringExtra(EXTRA_EMAIL);
        String nohp = getIntent().getStringExtra(EXTRA_NOHP);
        String tgl = getIntent().getStringExtra(EXTRA_TGL);
        String minuman = getIntent().getStringExtra(EXTRA_MINUMAN);
        String makanan = getIntent().getStringExtra(EXTRA_MAKANAN);
        String pembayaran = getIntent().getStringExtra(EXTRA_PEMBAYARAN);
        //tambahin
        double subtotal = getIntent().getDoubleExtra(EXTRA_SUBTOTAL,0);
        double ppn = getIntent().getDoubleExtra(EXTRA_PAJAK,0);
        double discount = getIntent().getDoubleExtra(EXTRA_DISKON,0);
        double total = getIntent().getDoubleExtra(EXTRA_TOTAL,0);
        tvNama.setText(nama);
        tvEmail.setText(email);
        tvNoHP.setText(nohp);
        tvTgl.setText(tgl);
        tvMinuman.setText(minuman);
        tvMakanan.setText(makanan);
        tvSubtotal.setText("Rp." + subtotal);
        tvDiskon.setText("Rp." +  discount);
        tvPpn.setText("Rp." + ppn);
        tvPembayaran.setText(pembayaran);
        tvTotal.setText("Rp." + total);
    }
}