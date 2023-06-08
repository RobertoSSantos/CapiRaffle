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

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Define o primeiro fragmento a aparecer na tela
        replaceFragment(new HomeFragment());
        binding.bottomNavView.setBackground(null);

        binding.bottomNavView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.homeMenu:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.profileMenu:
                    //replaceFragment(new LoginFragment());
                    break;
            }
            return true;
        });

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomDialog();
            }
        });

    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    private void showBottomDialog(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet_dialog);

        LinearLayout playlistLayout = dialog.findViewById(R.id.layoutPlaylist);
        ImageView cancelButton = dialog.findViewById(R.id.cancelButton);

        playlistLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                replaceFragment(new AddRaffleFragment());
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}

/* Tabela Cria Rifa:
- id_rifa
- nome do criador
- cpf do criador
- chave pix do criador
- titulo da rifa
- data termino
- premio
- valor de cada numero
 */

/* Tabela Compra Rifa:
- id_compra
- nome comprador
- cpf comprador
- id da rifa - FK
- numeros escolhidos
 */