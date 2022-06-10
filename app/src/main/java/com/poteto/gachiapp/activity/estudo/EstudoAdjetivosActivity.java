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
import com.poteto.gachiapp.databinding.ActivityEstudoAdjetivosBinding;
import com.poteto.gachiapp.fragment.FirstFragment;
import com.poteto.gachiapp.fragment.SecondFragment;
import com.poteto.gachiapp.fragment.ThirdFragment;

public class EstudoAdjetivosActivity extends AppCompatActivity {

    ActivityEstudoAdjetivosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEstudoAdjetivosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle(R.string.titleEstudo10);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.textView8.setMovementMethod(LinkMovementMethod.getInstance());

        binding.webAdjI.loadDataWithBaseURL(null, tableAdjI, "text/html", "utf-8", null);
        binding.webConjIi.loadDataWithBaseURL(null, tableConjIi, "text/html", "utf-8", null);
        binding.webConjKakkoii.loadDataWithBaseURL(null, tableConjKakkoii, "text/html", "utf-8", null);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    String tableAdjI =
            "<table bgcolor=#5EA6B4 border=1 width=300 bordercolor=#FFFFFF " +
                    "style=table-layout:fixed;text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th></th>" +
                    "<th>Não-Passado</th>" +
                    "<th>Passado</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>Afirmativo</td>" +
                    "<td>高い</td>" +
                    "<td>高かった</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>Negativo</td>" +
                    "<td>高くない</td>" +
                    "<td>高くなかった</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";

    String tableConjIi =
            "<table bgcolor=#5EA6B4 border=1 width=300 bordercolor=#FFFFFF " +
                    "style=table-layout:fixed;text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th></th>" +
                    "<th>Não-Passado</th>" +
                    "<th>Passado</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>Afirmativo</td>" +
                    "<td>いい</td>" +
                    "<td>よかった</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>Negativo</td>" +
                    "<td>よくない</td>" +
                    "<td>よくなかった</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";

    String tableConjKakkoii =
            "<table bgcolor=#5EA6B4 border=1 width=300 bordercolor=#FFFFFF " +
                    "style=table-layout:fixed;text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th></th>" +
                    "<th>Não-Passado</th>" +
                    "<th>Passado</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>Afirmativo</td>" +
                    "<td>かっこいい</td>" +
                    "<td>かっこよかった</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>Negativo</td>" +
                    "<td>かっこよくない</td>" +
                    "<td>かっこよくなかった</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";
}