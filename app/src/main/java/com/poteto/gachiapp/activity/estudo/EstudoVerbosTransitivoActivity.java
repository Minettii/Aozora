package com.poteto.gachiapp.activity.estudo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;

import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;
import com.poteto.gachiapp.R;
import com.poteto.gachiapp.databinding.ActivityEstudoVerbosPassadoBinding;
import com.poteto.gachiapp.databinding.ActivityEstudoVerbosTransitivoBinding;
import com.poteto.gachiapp.fragment.FirstFragment;
import com.poteto.gachiapp.fragment.SecondFragment;
import com.poteto.gachiapp.fragment.ThirdFragment;

public class EstudoVerbosTransitivoActivity extends AppCompatActivity {

    ActivityEstudoVerbosTransitivoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEstudoVerbosTransitivoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle(R.string.titleEstudo15);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.textView8.setMovementMethod(LinkMovementMethod.getInstance());

        binding.webTransitive.loadDataWithBaseURL(null, tableTransitive, "text/html", "utf-8", null);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    String tableTransitive =
            "<table bgcolor=#5EA6B4 border=1 width=300 bordercolor=#FFFFFF " +
                    "style=table-layout:fixed;text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th>Transitivos</th>" +
                    "<th>Intrasitivos</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=100>" +
                    "<td>?????????<br>?????????<br>derrubar</td>" +
                    "<td>?????????<br>?????????<br>cair</td>" +
                    "</tr>" +
                    "<tr height=100>" +
                    "<td>??????<br>??????<br>expulsar</td>" +
                    "<td>??????<br>??????<br>sair</td>" +
                    "</tr>" +
                    "<tr height=100>" +
                    "<td>?????????<br>?????????<br>inserir</td>" +
                    "<td>??????<br>?????????<br>entrar</td>" +
                    "</tr>" +
                    "<tr height=100>" +
                    "<td>?????????<br>?????????<br>abrir</td>" +
                    "<td>??????<br>??????<br>ser aberto</td>" +
                    "</tr>" +
                    "<tr height=100>" +
                    "<td>?????????<br>?????????<br>fechar</td>" +
                    "<td>?????????<br>?????????<br>ser fechado</td>" +
                    "</tr>" +
                    "<tr height=100>" +
                    "<td>?????????<br>?????????<br>(fixar,<br>anexar)</td>" +
                    "<td>??????<br>??????<br>(ser afixado,ser anexado)<br></td>" +
                    "</tr>" +
                    "<tr height=100>" +
                    "<td>??????<br>??????<br>apagar</td>" +
                    "<td>?????????<br>?????????<br>desaparecer</td>" +
                    "</tr>" +
                    "<tr height=100>" +
                    "<td>??????<br>??????<br>extrair</td>" +
                    "<td>?????????<br>?????????<br>ser extra??do</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";
}