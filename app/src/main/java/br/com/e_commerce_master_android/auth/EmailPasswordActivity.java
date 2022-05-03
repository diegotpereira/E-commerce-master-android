package br.com.e_commerce_master_android.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.com.e_commerce_master_android.R;

public class EmailPasswordActivity extends BaseActivity implements
        View.OnClickListener{

    private static final String TAG = "EmailPassword";

    private TextView mStatusTextView;
    private TextView mDetalheTextView;
    private EditText mEmailCampo;
    private EditText mSenhaCampo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Views
        mStatusTextView = (TextView) findViewById(R.id.status);
        mDetalheTextView = (TextView) findViewById(R.id.detalhe);
        mEmailCampo = (EditText) findViewById(R.id.campo_email);
        mSenhaCampo = (EditText) findViewById(R.id.campo_senha);

        //Botões
        findViewById(R.id.email_entrar_botao).setOnClickListener(this);
        findViewById(R.id.email_criar_conta_botao).setOnClickListener(this);
        findViewById(R.id.sair_botao).setOnClickListener(this);
        findViewById(R.id.verificar_email_botao).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

    }
}