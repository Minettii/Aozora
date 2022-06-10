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
                    "<td>落とす<br>おとす<br>derrubar</td>" +
                    "<td>落ちる<br>おちる<br>cair</td>" +
                    "</tr>" +
                    "<tr height=100>" +
                    "<td>出す<br>だす<br>expulsar</td>" +
                    "<td>出る<br>でる<br>sair</td>" +
                    "</tr>" +
                    "<tr height=100>" +
                    "<td>入れる<br>いれる<br>inserir</td>" +
                    "<td>入る<br>はいる<br>entrar</td>" +
                    "</tr>" +
                    "<tr height=100>" +
                    "<td>開ける<br>あける<br>abrir</td>" +
                    "<td>開く<br>あく<br>ser aberto</td>" +
                    "</tr>" +
                    "<tr height=100>" +
                    "<td>閉める<br>しめる<br>fechar</td>" +
                    "<td>閉まる<br>しまる<br>ser fechado</td>" +
                    "</tr>" +
                    "<tr height=100>" +
                    "<td>付ける<br>つける<br>(fixar,<br>anexar)</td>" +
                    "<td>付く<br>つく<br>(ser afixado,ser anexado)<br></td>" +
                    "</tr>" +
                    "<tr height=100>" +
                    "<td>消す<br>けす<br>apagar</td>" +
                    "<td>消える<br>きえる<br>desaparecer</td>" +
                    "</tr>" +
                    "<tr height=100>" +
                    "<td>抜く<br>ぬく<br>extrair</td>" +
                    "<td>抜ける<br>ぬける<br>ser extraído</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";
}