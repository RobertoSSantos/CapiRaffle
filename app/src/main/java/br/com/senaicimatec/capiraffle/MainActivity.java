package br.com.senaicimatec.capiraffle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import br.com.senaicimatec.capiraffle.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}

/*
O que falta:

- A tela da rifa
- Tela de recibo

- Passar as informacoes entre as telas





- Home (id_rifa) -> tela da rifa
- tela rifa (id_rifa) e (numeros) -> tela da compra
- tela da compra (id_comprador) -> Recibo

 */