package com.example.smarthome;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnLockDoor, btnUnlockDoor;
    private TextView statusText;
    private boolean isDoorLocked = false; // Status pintu, terkunci atau terbuka

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Menghubungkan UI dengan elemen-elemen di layout
        btnLockDoor = findViewById(R.id.btnLockDoor);
        btnUnlockDoor = findViewById(R.id.btnUnlockDoor);
        statusText = findViewById(R.id.statusText);

        // Menyembunyikan tombol Unlock pada awal aplikasi
        btnUnlockDoor.setVisibility(View.INVISIBLE);

        // Tombol untuk mengunci pintu
        btnLockDoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDoorLocked = true;
                statusText.setText("Status Pintu: Terkunci");
                btnLockDoor.setVisibility(View.INVISIBLE); // Sembunyikan tombol Kunci
                btnUnlockDoor.setVisibility(View.VISIBLE); // Tampilkan tombol Buka Kunci
            }
        });

        // Tombol untuk membuka kunci pintu
        btnUnlockDoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDoorLocked = false;
                statusText.setText("Status Pintu: Terbuka");
                btnUnlockDoor.setVisibility(View.INVISIBLE); // Sembunyikan tombol Buka Kunci
                btnLockDoor.setVisibility(View.VISIBLE); // Tampilkan tombol Kunci
            }
        });
    }
}
