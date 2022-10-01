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
    private TextView tvNama, tvEmail, tvNoHP, tvTgl, tvMinuman, tvMakanan,
            tvPembayaran,tvTotal;
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
        String nama = getIntent().getStringExtra(EXTRA_NAMA);
        String email = getIntent().getStringExtra(EXTRA_EMAIL);
        String nohp = getIntent().getStringExtra(EXTRA_NOHP);
        String tgl = getIntent().getStringExtra(EXTRA_TGL);
        String minuman = getIntent().getStringExtra(EXTRA_MINUMAN);
        String makanan = getIntent().getStringExtra(EXTRA_MAKANAN);
        String pembayaran = getIntent().getStringExtra(EXTRA_PEMBAYARAN);
        int subTotal = getIntent().getIntExtra(EXTRA_TOTAL,0);
        tvNama.setText(nama);
        tvEmail.setText(email);
        tvNoHP.setText(nohp);
        tvTgl.setText(tgl);
        tvMinuman.setText(minuman);
        tvMakanan.setText(makanan);
        tvPembayaran.setText(pembayaran);
        tvTotal.setText("Rp." + subTotal);
    }
}