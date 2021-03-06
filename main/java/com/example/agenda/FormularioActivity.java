package com.example.agenda;

import android.os.Bundle;

import com.example.agenda.dao.AlunoDAO;
import com.example.agenda.modelo.Aluno;

import androidx.appcompat.app.AppCompatActivity;

import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
    helper = new FormularioHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:
                Aluno aluno = helper.pegaAluno();

     // Aqui instanciamos o DAO e inserimos o novo aluno no banco
                AlunoDAO dao= new AlunoDAO(this);

                // Inserir Alunos:
                dao.insere(aluno);

                //fechar banco de dados:
                dao.close();

                Toast.makeText(FormularioActivity.this, "Aluno" + aluno.getNome() + "salvo!", Toast.LENGTH_SHORT).show();

                finish();
            break;
        }
        return super.onOptionsItemSelected(item);
    }


}