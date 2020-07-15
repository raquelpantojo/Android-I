package com.example.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

import com.example.agenda.R;
import com.example.agenda.modelo.Aluno;
import com.example.agenda.FormularioActivity;

public class FormularioHelper {

        private EditText campoNome;
        private EditText campoEndereco;
        private EditText campoTelefone;
        private EditText campoSite;
        private RatingBar campoNota;

        public FormularioHelper(FormularioActivity activity){
            this.campoNome= (EditText) activity.findViewById(R.id.formulario_nome);
            this.campoEndereco= (EditText) activity.findViewById(R.id.formulario_endereco);
            this.campoTelefone= (EditText) activity.findViewById(R.id.formulario_telefone);
            this.campoSite= (EditText) activity.findViewById(R.id.formulario_site);
            this.campoNota = (RatingBar) activity.findViewById(R.id.formulario_nota);
        }

        public Aluno pegaAluno(){
            Aluno aluno= new Aluno();

            aluno.setNome(campoNome.getText().toString());
            aluno.setEndereco(campoEndereco.getText().toString());
            aluno.setTelefone(campoTelefone.getText().toString());
            aluno.setSite(campoSite.getText().toString());
            aluno.setNota(Double.valueOf(campoNota.getProgress()));
            return aluno;
        }
}



