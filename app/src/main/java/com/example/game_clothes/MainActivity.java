package com.example.game_clothes;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView ivBody, ivTshirt, ivPants, ivShoes;
    private ProgressBar progTshirt, progPants, progShoes;
    private Button btnTshirt, btnPants, btnShoes;
    private TextView tvEstadoTshirt, tvEstadoPants, tvEstadoShoes;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private boolean estadoTshirt;
    private boolean estadoPants;
    private boolean estadoShoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        ivBody = findViewById(R.id.ivBody);
        ivTshirt = findViewById(R.id.ivTshirt);
        ivPants = findViewById(R.id.ivPants);
        ivShoes = findViewById(R.id.ivShoes);

        progTshirt = findViewById(R.id.progTshirt);
        progPants = findViewById(R.id.progPants);
        progShoes = findViewById(R.id.progShoes);

        btnTshirt = findViewById(R.id.btnDescargarTshirt);
        btnPants = findViewById(R.id.btnDescargarPants);
        btnShoes = findViewById(R.id.btnDescargarShoes);
        tvEstadoTshirt = findViewById(R.id.tvEstadoTshirt);
        tvEstadoPants = findViewById(R.id.tvEstadoPants);
        tvEstadoShoes = findViewById(R.id.tvEstadoShoes);


        ivTshirt.setVisibility(View.GONE);
        ivPants.setVisibility(View.GONE);
        ivShoes.setVisibility(View.GONE);
        progTshirt.setIndeterminate(false);
        progPants.setIndeterminate(false);
        progShoes.setIndeterminate(false);
        progTshirt.setProgress(0);
        progPants.setProgress(0);
        progShoes.setProgress(0);

        tvEstadoTshirt.setText("Listo para descargar");
        tvEstadoPants.setText("Listo para descargar");
        tvEstadoShoes.setText("Listo para descargar");

        btnTshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (estadoTshirt) return;
                estadoTshirt = true;
                progTshirt.setProgress(0);
                tvEstadoTshirt.setText("Iniciando descarga");
                Thread hilo = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            for (int i = 1; i <= 100; i++) {
                                Thread.sleep(60);
                                final int progreso = i;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progTshirt.setProgress(progreso);
                                        tvEstadoTshirt.setText("Descargando... " + progreso + "%");
                                    }
                                });
                            }
                        } catch (InterruptedException e) {

                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                ivTshirt.setVisibility(View.VISIBLE);
                                tvEstadoTshirt.setText("Completado");
                                estadoTshirt = false;
                            }
                        });
                    }
                });
                hilo.start();
            }
        });

        btnPants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (estadoPants) return;
                estadoPants = true;
                progPants.setProgress(0);
                tvEstadoPants.setText("Iniciando descarga");
                Thread hilo = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            for (int i = 1; i <= 100; i++) {
                                Thread.sleep(60);
                                final int progreso = i;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progPants.setProgress(progreso);
                                        tvEstadoPants.setText("Descargando... " + progreso + "%");
                                    }
                                });
                            }
                        } catch (InterruptedException e) {

                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                ivPants.setVisibility(View.VISIBLE);
                                tvEstadoPants.setText("Completado");
                                estadoPants = false;
                            }
                        });
                    }
                });
                hilo.start();
            }
        });

        btnShoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (estadoShoes) return;
                estadoShoes = true;
                progShoes.setProgress(0);
                tvEstadoShoes.setText("Iniciando descarga");
                Thread hilo = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            for (int i = 1; i <= 100; i++) {
                                Thread.sleep(60);
                                final int progreso = i;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        progShoes.setProgress(progreso);
                                        tvEstadoShoes.setText("Descargando... " + progreso + "%");
                                    }
                                });
                            }
                        } catch (InterruptedException e) {

                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                ivShoes.setVisibility(View.VISIBLE);
                                tvEstadoShoes.setText("Completado");
                                estadoShoes = false;
                            }
                        });
                    }
                });
                hilo.start();
            }
        });
    }

}