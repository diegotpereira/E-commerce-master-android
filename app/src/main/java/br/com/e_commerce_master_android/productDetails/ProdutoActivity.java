package br.com.e_commerce_master_android.productDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import br.com.e_commerce_master_android.R;
import br.com.e_commerce_master_android.adapter.SliderImagemAdapter;

public class ProdutoActivity extends AppCompatActivity {

    ViewPager viewPager;
    SliderImagemAdapter adapter;
    private int addNoCarrinhoConstant;

    public int getAddNoCarrinhoConstant() {
        return addNoCarrinhoConstant;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        viewPager = (ViewPager) findViewById(R.id.image_slider_view);
        adapter = new SliderImagemAdapter(this);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager, true);

        Toolbar meuToolbar = (Toolbar) findViewById(R.id.meu_toolbar);
        setSupportActionBar(meuToolbar);

        final Button addNoCarrinho = (Button) findViewById(R.id.carrinho_produto_detalhes);
        
        addNoCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProdutoActivity.this, "Adionado no Carrinho",
                        Toast.LENGTH_SHORT).show();

                addNoCarrinhoConstant = 1;
            }
        });
    }
}