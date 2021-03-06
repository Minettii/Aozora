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
import com.poteto.gachiapp.databinding.ActivityEstudoVerbosNegativoBinding;
import com.poteto.gachiapp.databinding.ActivityEstudoVerbosPassadoBinding;
import com.poteto.gachiapp.fragment.FirstFragment;
import com.poteto.gachiapp.fragment.SecondFragment;
import com.poteto.gachiapp.fragment.ThirdFragment;

public class EstudoVerbosPassadoActivity extends AppCompatActivity {

    ActivityEstudoVerbosPassadoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEstudoVerbosPassadoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle(R.string.titleEstudo13);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.textView8.setMovementMethod(LinkMovementMethod.getInstance());

        binding.webPastU.loadDataWithBaseURL(null, tablePastU, "text/html", "utf-8", null);
        binding.webPastExc.loadDataWithBaseURL(null, tablePastExc, "text/html", "utf-8", null);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    String tablePastU =
            "<table bgcolor=#5EA6B4 border=1 width=300 bordercolor=#FFFFFF " +
                    "style=table-layout:fixed;text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th>Termina????o</th>" +
                    "<th>Presente</th>" +
                    "<th>Pret??rito</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td>????????????</td>" +
                    "<td>??????</td>" +
                    "<td>?????????</td>" +
                    "</tr>" +
                    "<tr height=75>" +
                    "<td>????????????<br>????????????</td>" +
                    "<td>??????<br>??????</td>" +
                    "<td>?????????<br>?????????</td>" +
                    "</tr>" +
                    "<tr height=100>" +
                    "<td>????????????<br>????????????<br>????????????</td>" +
                    "<td>??????<br>??????<br>??????</td>" +
                    "<td>?????????<br>?????????<br>?????????</td>" +
                    "</tr>" +
                    "<tr height=100>" +
                    "<td>????????????<br>????????????<br>????????????</td>" +
                    "<td>??????<br>??????<br>??????</td>" +
                    "<td>?????????<br>?????????<br>?????????</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";

    String tablePastExc =
            "<table bgcolor=#5EA6B4 border=1 width=300 bordercolor=#FFFFFF " +
                    "style=table-layout:fixed;text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th>Presente</th>" +
                    "<th>Pret??rito</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td>??????</td>" +
                    "<td>??????</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>??????	</td>" +
                    "<td>??????</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>??????</td>" +
                    "<td>?????????*</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";
}