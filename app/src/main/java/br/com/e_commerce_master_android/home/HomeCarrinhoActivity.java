package br.com.e_commerce_master_android.home;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

import br.com.e_commerce_master_android.R;
import br.com.e_commerce_master_android.productDetails.ProdutoActivity;


public class HomeCarrinhoActivity extends Fragment {

    /*private String comercianteChave;
    private String usuarioCredencial;

    // Estes conterão todos os parâmetros de pagamento
    private PaymentParams mPaymentParams;
    private int CONSTANTE_VISIBILIDADE;

    // Isso define a configuração
    private PayuConfig payuConfig;

    // Usado ao gerar hash do SDK
    private PayUChecksum checksum;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Boolean ehVisivel = false;
        View v = inflater.inflate(R.layout.activity_home_carrinho, container, false);
        Payu.setInstance(getActivity());

        final Button verificar = (Button) v.findViewById(R.id.verificar_botao);
        final ImageView img = (ImageView) v.findViewById(R.id.img_carrinho);
        final ImageView img_atualizar = (ImageView) v.findViewById(R.id.carrinho_atualizar);
        final TextView txt = (TextView) v.findViewById(R.id.texto_carrinho);
        final ImageView img_deletar = v.findViewById(R.id.carrinho_deletar);
        final LinearLayout produto_info = (LinearLayout) v.findViewById(R.id.produto_info);

        ProdutoActivity pa = new ProdutoActivity();

        img_atualizar.setOnClickListener(new View.OnClickListener() {
            // O código neste método será executado quando a categoria de números for clicada.
            @Override
            public void onClick(View view) {
                img.setVisibility(View.VISIBLE);
                verificar.setVisibility(View.VISIBLE);
                txt.setVisibility(View.INVISIBLE);
                produto_info.setVisibility(View.VISIBLE);
                img_atualizar.setVisibility(View.GONE);
            }
        });
        img_deletar.setOnClickListener(new View.OnClickListener() {
            // O código neste método será executado quando a categoria de números for clicada.
            @Override
            public void onClick(View view) {
                img.setVisibility(View.VISIBLE);
                verificar.setVisibility(View.GONE);
                txt.setVisibility(View.VISIBLE);
                produto_info.setVisibility(View.GONE);
                img_atualizar.setVisibility(View.VISIBLE);
            }
        });
        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navegarParaBaseActivity(view);
            }
        });
        return v;
    }
    public void navegarParaBaseActivity(View view) {
        // Este método prepara todos os parâmetros de pagamento a serem enviados
        // para PayuBaseActivity.java
        comercianteChave = "gtKFFx";
        String contia = "3000";
        String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        int ambiente;
        String valor = "teste";
        String TESTE_AMBIENTE = getResources().getString(R.string.test);
        ambiente = PayuConstants.STAGING_ENV;

        //TODO Abaixo estão os parâmetros obrigatórios para geração de hash
        usuarioCredencial = new PaymentParams();

        // Para ambiente de teste, comercianteKey = "gtKFFx"
        // Para o ambiente de produção, o comercianteKey deve ser sua chave ativa ou para
        // testar ao vivo, você pode usar "0MQaQP"
        mPaymentParams.setKey(comercianteChave);
        mPaymentParams.setQuantia(quantia);
        mPaymentParams.setPrimeiroNome("nome");
        mPaymentParams.setEmail(email);

        // O ID da transação deve ser mantido exclusivo para cada transação.
        public void gerarHasDoServidor(PaymentParams mPaymentParams) {

        }
    }*/
}