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
                    "<th>Terminação</th>" +
                    "<th>Presente</th>" +
                    "<th>Pretérito</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td>す→した</td>" +
                    "<td>話す</td>" +
                    "<td>話した</td>" +
                    "</tr>" +
                    "<tr height=75>" +
                    "<td>く→いた<br>ぐ→いだ</td>" +
                    "<td>書く<br>泳ぐ</td>" +
                    "<td>書いた<br>泳いだ</td>" +
                    "</tr>" +
                    "<tr height=100>" +
                    "<td>む→んだ<br>ぶ→んだ<br>ぬ→んだ</td>" +
                    "<td>噛む<br>遊ぶ<br>死ぬ</td>" +
                    "<td>噛んだ<br>遊んだ<br>死んだ</td>" +
                    "</tr>" +
                    "<tr height=100>" +
                    "<td>る→った<br>う→った<br>つ→った</td>" +
                    "<td>切る<br>買う<br>持つ</td>" +
                    "<td>切った<br>買った<br>持った</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";

    String tablePastExc =
            "<table bgcolor=#5EA6B4 border=1 width=300 bordercolor=#FFFFFF " +
                    "style=table-layout:fixed;text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th>Presente</th>" +
                    "<th>Pretérito</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td>する</td>" +
                    "<td>した</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>くる	</td>" +
                    "<td>きた</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>行く</td>" +
                    "<td>行った*</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";
}