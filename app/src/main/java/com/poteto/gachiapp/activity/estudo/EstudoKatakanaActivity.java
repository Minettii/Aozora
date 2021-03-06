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
import com.poteto.gachiapp.databinding.ActivityKanjiEstudoBinding;
import com.poteto.gachiapp.databinding.ActivityKatakanaBinding;
import com.poteto.gachiapp.fragment.FirstFragment;
import com.poteto.gachiapp.fragment.SecondFragment;
import com.poteto.gachiapp.fragment.ThirdFragment;

public class EstudoKatakanaActivity extends AppCompatActivity {

    ActivityKatakanaBinding binding;
    // table Strings at the bottom of this class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityKatakanaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle(R.string.titleEstudo6);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.textView80.setMovementMethod(LinkMovementMethod.getInstance());
        binding.textView8.setMovementMethod(LinkMovementMethod.getInstance());

        binding.webKataBasic.loadDataWithBaseURL(null, tableKatakanaBasic, "text/html", "utf-8", null);
        binding.webKataAdditional.loadDataWithBaseURL(null, tableKatakanaAdditional, "text/html", "utf-8", null);
        binding.webKataExamples.loadDataWithBaseURL(null, tableKatakanaExamples, "text/html", "utf-8", null);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    String tableKatakanaBasic =
            "<style type=text/css>" +
                    ".tg  {border-collapse:collapse;border-spacing:0;}" +
                    ".tg td{border-style:solid;border-width:0px;font-family:Arial, sans-serif;font-size:14px;overflow:hidden; " +
                    "padding:10px 5px;word-break:normal;}" +
                    ".tg th{border-style:solid;border-width:0px;font-family:Arial, sans-serif;font-size:14px;font-weight:normal; " +
                    "overflow:hidden;padding:10px 5px;word-break:normal;}" +
                    ".tg .tg-0lax{text-align:left;vertical-align:top}" +
                    ".tg .tg-0pky{border-color:inherit;text-align:left;vertical-align:top}" +
                    "</style>" +

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

    String tableKatakanaAdditional =
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
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>SH</b></td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td style=color:#F44336>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>J</b></td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>???<br>(shi)</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td style=color:#F44336>??????</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>T</b></td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td style=color:#F44336>??????</td>" +
                    "<td style=color:#F44336>??????</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>D</b></td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td style=color:#F44336>??????</td>" +
                    "<td style=color:#F44336>??????</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>CH</b></td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td class=tg-0lax>??????<br>(fu)</td>" +
                    "<td class=tg-0lax>??????</td>" +
                    "<td style=color:#F44336>??????</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>F</td>" +
                    "<td style=color:#F44336>??????</td>" +
                    "<td style=color:#F44336>??????</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td style=color:#F44336>??????</td>" +
                    "<td style=color:#F44336>??????</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>W</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td style=color:#F44336>??????</td>" +
                    "<td class=tg-0lax>???</td>" +
                    "<td style=color:#F44336>??????</td>" +
                    "<td style=color:#F44336>??????</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>V</td>" +
                    "<td style=color:#F44336>??????</td>" +
                    "<td style=color:#F44336>??????</td>" +
                    "<td style=color:#F44336>???</td>" +
                    "<td style=color:#F44336>??????</td>" +
                    "<td style=color:#F44336>??????</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";

    String tableKatakanaExamples =
            "<table bgcolor=#5EA6B4 border=1 bordercolor=#FFFFFF " +
                    "style=table-layout:fixed;text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th>Portug??es</th>" +
                    "<th>Ingl??s</th>" +
                    "<th>Japon??s</th>" +

                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td class=tg-0lax>Am??rica</td>" +
                    "<td class=tg-0lax>America</td>" +
                    "<td class=tg-0lax>????????????</td>" +
                    "</tr>" +

                    "<tr height=50>" +
                    "<td>R??ssia</td>" +
                    "<td>Russia</td>" +
                    "<td>?????????</td>" +
                    "</tr>" +

                    "<tr height=50>" +
                    "<td>Trapacear</td>" +
                    "<td>Cheating</td>" +
                    "<td>???????????????<br>(cunning)</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td>Viagem</td>" +
                    "<td>Tour</td>" +
                    "<td>?????????</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td>Funcion??rio</td>" +
                    "<td class=tg-0lax>Company<br>employee</td>" +
                    "<td class=tg-0lax>??????????????????<br>(salary man)</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td>Mozart</td>" +
                    "<td class=tg-0lax>Mozart</td>" +
                    "<td class=tg-0lax>??????????????????</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td class=tg-0lax>Buzina de<br>Carro</td>" +
                    "<td>Car Horn</td>" +
                    "<td>??????????????????<br>(klaxon)</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td class=tg-0lax>Sof??</td>" +
                    "<td>sofa</td>" +
                    "<td>????????? ou<br>????????????</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td class=tg-0lax>Dia das<br>Bruxas</td>" +
                    "<td>Halloween</td>" +
                    "<td>??????????????????</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td class=tg-0lax>Batatas<br>Fritas</td>" +
                    "<td>French Fries</td>" +
                    "<td>?????????????????????<br>(fried potato)</td>" +

                    "</tr>" +
                    "</tbody>" +
                    "</table>";
}