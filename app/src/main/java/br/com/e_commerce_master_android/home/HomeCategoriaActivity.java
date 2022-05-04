package br.com.e_commerce_master_android.home;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import br.com.e_commerce_master_android.R;
import br.com.e_commerce_master_android.productDetails.ProdutoActivity;

public class HomeCategoriaActivity extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_home_categoria, container, false);

        Button btn_sapatos = (Button) v.findViewById(R.id.btn_sapatos_categoria);
        Button btn_roupas = (Button) v.findViewById(R.id.botao_roupa_baixo_categoria);
        Button btn_top_roupas = (Button) v.findViewById(R.id.botao_top_roupa_categoria);

        // Define um listener de cliques nessa View
        btn_sapatos.setOnClickListener(new View.OnClickListener() {

            // O código neste método será executado quando a categoria de números for clicada.
            @Override
            public void onClick(View view) {
                // Crie um novo intent para abrir o {@link NumbersActivity}
                Intent produtoActivity = new Intent(getActivity(), ProdutoActivity.class);
                startActivity(produtoActivity);
            }
        });
        btn_roupas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Crie um novo intent para abrir o {@link NumbersActivity}
                Intent produtoActivity = new Intent(getActivity(), ProdutoActivity.class);
                startActivity(produtoActivity);
            }
        });
        btn_top_roupas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent produtoActivity = new Intent(getActivity(), ProdutoActivity.class);
                startActivity(produtoActivity);
            }
        });
        return v;
    }
}