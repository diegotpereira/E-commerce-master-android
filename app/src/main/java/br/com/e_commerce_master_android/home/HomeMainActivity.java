package br.com.e_commerce_master_android.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import br.com.e_commerce_master_android.R;

public class HomeMainActivity extends AppCompatActivity {

    private SecaoPagerAdapter mSecaoPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);

        // Cria o adaptador que retornará um fragmento para cada um dos três
        // seções primárias da atividade.
        mSecaoPagerAdapter = new SecaoPagerAdapter(getSupportFragmentManager());

        // Configure o ViewPager com o adaptador de seções.
        mViewPager = (ViewPager) findViewById(R.id.container_home);
        mViewPager.setAdapter(mSecaoPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Infla o menu; isso adiciona itens à barra de ação, se estiver presente.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Manipula os cliques do item da barra de ação aqui. A barra de ação irá
        // trata automaticamente os cliques no botão Home/Up, tanto tempo
        // conforme você especifica uma atividade pai em AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    public class SecaoPagerAdapter extends FragmentPagerAdapter {

        public SecaoPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    HomeCategoriaActivity tab1 = new HomeCategoriaActivity();
                    return tab1;

                case 1:
                    HomeCarrinhoActivity tab2 = new HomeCarrinhoActivity();
                    return tab2;

                case 2:
                    HomeContaActivity tab3 = new HomeContaActivity();
                    return tab3;

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Home";

                case 1:
                    return "Carrinho";

                case 2:
                    return "Conta";
            }
            return null;
        }
    }
}