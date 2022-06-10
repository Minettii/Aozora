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
import com.poteto.gachiapp.databinding.ActivityEstudoAdverbiosBinding;
import com.poteto.gachiapp.databinding.ActivityEstudoEstadoSerBinding;
import com.poteto.gachiapp.fragment.FirstFragment;
import com.poteto.gachiapp.fragment.SecondFragment;
import com.poteto.gachiapp.fragment.ThirdFragment;

public class EstudoEstadoSerActivity extends AppCompatActivity {

    ActivityEstudoEstadoSerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEstudoEstadoSerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle(R.string.titleEstudo8);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.textView8.setMovementMethod(LinkMovementMethod.getInstance());

        binding.webState.loadDataWithBaseURL(null, tableStateOfBeing, "text/html", "utf-8", null);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    String tableStateOfBeing =
            "<table bgcolor=#5EA6B4 border=1 bordercolor=#FFFFFF " +
                    "style=text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th></th>" +
                    "<th>Não-Passado</th>" +
                    "<th>Passado</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td rowspan=2 bgcolor=#407993 style=color:#000000;font-weight:bold>Afirmativo</td>" +
                    "<td>魚（だ）</td>" +
                    "<td>魚だった</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>É peixe</td>" +
                    "<td>Era peixe</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td rowspan=2 bgcolor=#407993 style=color:#000000;font-weight:bold>Negativo</td>" +
                    "<td>魚じゃない</td>" +
                    "<td>魚じゃなかった</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>Não é peixe</td>" +
                    "<td>Não era peixe</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";
}