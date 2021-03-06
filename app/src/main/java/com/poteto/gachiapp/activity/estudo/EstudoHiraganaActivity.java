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
import com.poteto.gachiapp.databinding.ActivityEstudoEstadoSerBinding;
import com.poteto.gachiapp.databinding.ActivityHiraganaBinding;
import com.poteto.gachiapp.fragment.FirstFragment;
import com.poteto.gachiapp.fragment.SecondFragment;
import com.poteto.gachiapp.fragment.ThirdFragment;

public class EstudoHiraganaActivity extends AppCompatActivity {

    ActivityHiraganaBinding binding;
    //String tables at the bottom of this class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHiraganaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle(R.string.titleEstudo5);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.textView8.setMovementMethod(LinkMovementMethod.getInstance());
        binding.textView12.setMovementMethod(LinkMovementMethod.getInstance());
        binding.textView11.setMovementMethod(LinkMovementMethod.getInstance());

        binding.webHiraBasic.loadDataWithBaseURL(null, tableHiraganaBasic, "text/html", "utf-8", null);
        binding.webHiraDakuten.loadDataWithBaseURL(null, tableHiraganaHanDakuten, "text/html", "utf-8", null);
        binding.webHiraY.loadDataWithBaseURL(null, tableHiraganaSmallY, "text/html", "utf-8", null);
        binding.webHiraExtended.loadDataWithBaseURL(null, tableHiraganaExtended, "text/html", "utf-8", null);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    String tableHiraganaBasic =
                    "<table bgcolor=#5EA6B4 border=1 width=300 bordercolor=#FFFFFF " +
                    "style=table-layout:fixed;text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                        "<tr height=50>" +
                    "<th></th>" +
                    "<th>A</th>" +
                    "<th>I</th>" +
                    "<th>U</th>" +
                    "<th>E</th>" +
                    "<th>O</th>" +
                        "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold></td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                        "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>K</b></td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                        "</tr>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>S</b></td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???<br>(shi)</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                        "</tr>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>T</b></td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???<br>(chi)</td>" +
                    "<td class=tg-0lax>???<br>(tsu)</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                        "</tr>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>N</b></td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                        "</tr>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>H</b></td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???<br>(fu)</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                        "</tr>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>M</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "</tr>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>Y</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax></td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax></td>" +
                    "<td class=tg-0lax>???</td>" +
                    "</tr>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>R</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "</tr>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>W</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax></td>" +
                    "<td class=tg-0lax></td>" +
                    "<td class=tg-0lax></td>" +
                    "<td class=tg-0lax>???<br>(o)</td>" +
                    "</tr>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>N</td>" +
                    "<td class=tg-0lax>???<br>(n)</td>" +
                    "<td class=tg-0lax></td>" +
                    "<td class=tg-0lax></td>" +
                    "<td class=tg-0lax></td>" +
                    "<td class=tg-0lax></td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";

    String tableHiraganaHanDakuten =
            "<table bgcolor=#5EA6B4 border=1 width=300 bordercolor=#FFFFFF " +
                    "style=table-layout:fixed;text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th></th>" +
                    "<th>A</th>" +
                    "<th>I</th>" +
                    "<th>U</th>" +
                    "<th>E</th>" +
                    "<th>O</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>G</b></td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>Z</b></td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???<br>(ji)</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>D</b></td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???<br>(ji)</td>" +
                    "<td class=tg-0lax>???<br>(dsu)</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>B</b></td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>P</b></td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";

    String tableHiraganaSmallY =
            "<table bgcolor=#5EA6B4 border=1 width=300 bordercolor=#FFFFFF " +
                    "style=table-layout:fixed;text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th></th>" +
                    "<th>ya</th>" +
                    "<th>yu</th>" +
                    "<th>yo</th>" +
                    "</tr>" +

                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>K</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>S</b></td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>???</b></td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>N</b></td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>H</b></td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>M</b></td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>R</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>G</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>J</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>B</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>P</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +

                    "</tr>" +
                    "</tbody>" +
                    "</table>";

    String tableHiraganaExtended =
            "<table bgcolor=#5EA6B4 border=1 width=300 bordercolor=#FFFFFF " +
                    "style=table-layout:fixed;text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th>Som da Vogal</th>" +
                    "<th>Extendido por</th>" +

                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +

                    "<td class=tg-0lax>/a/</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "</tr>" +
                    "<tr height=50>" +

                    "<td class=tg-0lax>/i/ ou /e/</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "</tr>" +
                    "<tr height=50>" +

                    "<td class=tg-0lax>/u/ ou /o/</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "</tr>" +

                    "</tbody>" +
                    "</table>";
}