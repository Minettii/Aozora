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
import com.poteto.gachiapp.databinding.ActivityEstudoVerbosBasicoBinding;
import com.poteto.gachiapp.databinding.ActivitySistemaEscritaEstudoBinding;
import com.poteto.gachiapp.fragment.FirstFragment;
import com.poteto.gachiapp.fragment.SecondFragment;
import com.poteto.gachiapp.fragment.ThirdFragment;

public class EstudoVerbosBasicoActivity extends AppCompatActivity {

    ActivityEstudoVerbosBasicoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEstudoVerbosBasicoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle(R.string.titleEstudo11);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.textView8.setMovementMethod(LinkMovementMethod.getInstance());

        binding.webVerbsBasic.loadDataWithBaseURL(null, tableVerbsBasic, "text/html", "utf-8", null);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    String tableVerbsBasic =
            "<table bgcolor=#5EA6B4 border=1 width=300 bordercolor=#FFFFFF " +
                    "style=table-layout:fixed;text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th>Básico</th>" +
                    "<th>Intermediário</th>" +
                    "<th>Avançado</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td>要る</td>" +
                    "<td>焦る</td>" +
                    "<td>嘲る</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>帰る</td>" +
                    "<td>限る</td>" +
                    "<td>覆る</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>切る</td>" +
                    "<td>蹴る</td>" +
                    "<td>遮る</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>しゃべる</td>" +
                    "<td>滑る</td>" +
                    "<td>罵る</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>知る</td>" +
                    "<td>握る</td>" +
                    "<td>捻る</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>入る</td>" +
                    "<td>練る</td>" +
                    "<td>翻る</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>走る</td>" +
                    "<td>参る</td>" +
                    "<td>滅入る</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>減る</td>" +
                    "<td>交じる</td>" +
                    "<td>蘇る</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";
}