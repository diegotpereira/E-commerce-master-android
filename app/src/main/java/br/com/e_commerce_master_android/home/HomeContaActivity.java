package br.com.e_commerce_master_android.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import br.com.e_commerce_master_android.R;
import br.com.e_commerce_master_android.auth.EmailPasswordActivity;

public class HomeContaActivity extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_home_conta, container, false);
        TextView mUsuarioNome = (TextView) view.findViewById(R.id.usuario_nome);
        mUsuarioNome.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
        Button btn_sair = (Button) view.findViewById(R.id.btn_sair_conta);

        btn_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent sairIntent = new Intent(getActivity(), EmailPasswordActivity.class);
                startActivity(sairIntent);
            }
        });
        return view;
    }
}