package br.com.e_commerce_master_android.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.e_commerce_master_android.R;
import br.com.e_commerce_master_android.home.HomeMainActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EmailPasswordActivity extends BaseActivity implements
        View.OnClickListener{

    private static final String TAG = "EmailPassword";

    private TextView mStatusTextView;
    private TextView mDetalheTextView;
    private EditText mEmailCampo;
    private EditText mSenhaCampo;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_password);
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

        // Iniciar Autenticação
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        atualizarUI(currentUser);
    }
    private void criarConta(String email, String password) {
        Log.d(TAG, "CriarConta:" + email);

        if (!validarForm()) {

            return;
        }
        showProgressDialog();

        // Iniciar Criação usuario com email
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Login bem-sucedido, atualiza a interface do usuário com as
                            // informações do usuário conectado
                            Log.d(TAG, "criarUsuarioComEmail:sucesso");
                            FirebaseUser user = mAuth.getCurrentUser();
                            atualizarUI(user);
                        } else {
                            // Se o login falhar, exibe uma mensagem para o usuário.
                            Log.w(TAG, "criarUsuarioComEmail:falha", task.getException());

                            Toast.makeText(EmailPasswordActivity.this,
                                    "Falha na Autenticação", Toast.LENGTH_SHORT).show();

                            atualizarUI(null);
                        }
                        // INICIAR EXCLUIR
                        hideProgressDialog();
                    }
                });
    }
    private void entrar(String email, String password) {
        Log.d(TAG, "Entrar" + email);

        if (!validarForm()) {

            return;
        }
        showProgressDialog();

        // Entrar com email
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Login bem-sucedido, atualiza a interface do usuário
                            // com as informações do usuário conectado
                            Log.d(TAG, "CadastroComEmail:sucesso");
                            FirebaseUser user = mAuth.getCurrentUser();
                            atualizarUI(user);
                        } else {
                            // Se o login falhar, exibe uma mensagem para o usuário.
                            Log.w(TAG, "CadastroComEmail:falha", task.getException());

                            Toast.makeText(EmailPasswordActivity.this,
                                    "Falha na Autenticação", Toast.LENGTH_SHORT).show();
                            atualizarUI(null);
                        }
                        // iniciar exclusão
                        if (!task.isSuccessful()) {
                            mStatusTextView.setText(R.string.auth_failed);
                        }
                        hideProgressDialog();
                    }
                });
    }
    private void sair() {
        mAuth.signOut();
        atualizarUI(null);
    }
    private void enviarEmailVerificacao() {
        // desabilitar botão
        findViewById(R.id.verificar_email_botao).setEnabled(false);

        // iniciar envio de email de verificação
        final FirebaseUser user = mAuth.getCurrentUser();
        user.sendEmailVerification()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // reabilitar botão
                        findViewById(R.id.verificar_email_botao).setEnabled(true);

                        if (task.isSuccessful()) {
                            Toast.makeText(EmailPasswordActivity.this,
                                    "Verificação de email enviada para " + user.getEmail(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Log.e(TAG, "enviarEmailVerificacao", task.getException());

                            Toast.makeText(EmailPasswordActivity.this,
                                    "Falha ao enviar email de verificação",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private boolean validarForm(){
        boolean validar = true;

        String email = mEmailCampo.getText().toString();
        if (TextUtils.isEmpty(email)) {
            mEmailCampo.setError("Obrigatório.");
            validar = false;
        } else {
            mEmailCampo.setError(null);
        }

        String password = mSenhaCampo.getText().toString();
        if (TextUtils.isEmpty(password)) {
            mSenhaCampo.setError("Obrigatório.");
            validar = false;
        } else {
            mSenhaCampo.setError(null);
        }
        return  validar;
    }
    private void atualizarUI(FirebaseUser user) {
        hideProgressDialog();
        if (user != null) {
            Intent loginIntent = new Intent(EmailPasswordActivity.this, HomeMainActivity.class);
            startActivity(loginIntent);
        } else {
            mStatusTextView.setText(R.string.signed_out);
            mDetalheTextView.setText(null);

            findViewById(R.id.email_senha_botao).setVisibility(View.VISIBLE);
            findViewById(R.id.email_senha_campos).setVisibility(View.VISIBLE);
            findViewById(R.id.signed_in_buttons).setVisibility(View.GONE);
        }
    }
    @Override
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.email_criar_conta_botao) {
            criarConta(mEmailCampo.getText().toString(), mSenhaCampo.getText().toString());
        } else if (i == R.id.email_entrar_botao) {
            entrar(mEmailCampo.getText().toString(), mSenhaCampo.getText().toString());
        } else if (i == R.id.sair_botao){
            sair();
        } else if (i == R.id.verificar_email_botao) {
            enviarEmailVerificacao();
        } else if (i == R.id.button5) {
            Intent loginGoogleIntent = new Intent(EmailPasswordActivity.this, GoogleEntrarActivity.class);
            startActivity(loginGoogleIntent);
        }
    }
}