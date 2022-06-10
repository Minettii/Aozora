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
                    "<td class=tg-0lax>あ</td>" +
                    "<td class=tg-0lax>い</td>" +
                    "<td class=tg-0lax>う</td>" +
                    "<td class=tg-0lax>え</td>" +
                    "<td class=tg-0lax>お</td>" +
                        "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>K</b></td>" +
                    "<td class=tg-0lax>か</td>" +
                    "<td class=tg-0lax>き</td>" +
                    "<td class=tg-0lax>く</td>" +
                    "<td class=tg-0lax>け</td>" +
                    "<td class=tg-0lax>こ</td>" +
                        "</tr>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>S</b></td>" +
                    "<td class=tg-0lax>さ</td>" +
                    "<td class=tg-0lax>し<br>(shi)</td>" +
                    "<td class=tg-0lax>す</td>" +
                    "<td class=tg-0lax>せ</td>" +
                    "<td class=tg-0lax>そ</td>" +
                        "</tr>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>T</b></td>" +
                    "<td class=tg-0lax>た</td>" +
                    "<td class=tg-0lax>ち<br>(chi)</td>" +
                    "<td class=tg-0lax>つ<br>(tsu)</td>" +
                    "<td class=tg-0lax>て</td>" +
                    "<td class=tg-0lax>と</td>" +
                        "</tr>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>N</b></td>" +
                    "<td class=tg-0lax>な</td>" +
                    "<td class=tg-0lax>に</td>" +
                    "<td class=tg-0lax>ぬ</td>" +
                    "<td class=tg-0lax>ね</td>" +
                    "<td class=tg-0lax>の</td>" +
                        "</tr>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>H</b></td>" +
                    "<td class=tg-0lax>は</td>" +
                    "<td class=tg-0lax>ひ</td>" +
                    "<td class=tg-0lax>ふ<br>(fu)</td>" +
                    "<td class=tg-0lax>へ</td>" +
                    "<td class=tg-0lax>ほ</td>" +
                        "</tr>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>M</td>" +
                    "<td class=tg-0lax>ま</td>" +
                    "<td class=tg-0lax>み</td>" +
                    "<td class=tg-0lax>む</td>" +
                    "<td class=tg-0lax>め</td>" +
                    "<td class=tg-0lax>も</td>" +
                    "</tr>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>Y</td>" +
                    "<td class=tg-0lax>や</td>" +
                    "<td class=tg-0lax></td>" +
                    "<td class=tg-0lax>ゆ</td>" +
                    "<td class=tg-0lax></td>" +
                    "<td class=tg-0lax>よ</td>" +
                    "</tr>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>R</td>" +
                    "<td class=tg-0lax>ら</td>" +
                    "<td class=tg-0lax>り</td>" +
                    "<td class=tg-0lax>る</td>" +
                    "<td class=tg-0lax>れ</td>" +
                    "<td class=tg-0lax>ろ</td>" +
                    "</tr>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>W</td>" +
                    "<td class=tg-0lax>わ</td>" +
                    "<td class=tg-0lax></td>" +
                    "<td class=tg-0lax></td>" +
                    "<td class=tg-0lax></td>" +
                    "<td class=tg-0lax>を<br>(o)</td>" +
                    "</tr>" +
                        "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>N</td>" +
                    "<td class=tg-0lax>ん<br>(n)</td>" +
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
                    "<td class=tg-0lax>が</td>" +
                    "<td class=tg-0lax>ぎ</td>" +
                    "<td class=tg-0lax>ぐ</td>" +
                    "<td class=tg-0lax>げ</td>" +
                    "<td class=tg-0lax>ご</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>Z</b></td>" +
                    "<td class=tg-0lax>ざ</td>" +
                    "<td class=tg-0lax>じ<br>(ji)</td>" +
                    "<td class=tg-0lax>ず</td>" +
                    "<td class=tg-0lax>ぜ</td>" +
                    "<td class=tg-0lax>ぞ</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>D</b></td>" +
                    "<td class=tg-0lax>だ</td>" +
                    "<td class=tg-0lax>ぢ<br>(ji)</td>" +
                    "<td class=tg-0lax>づ<br>(dsu)</td>" +
                    "<td class=tg-0lax>で</td>" +
                    "<td class=tg-0lax>ど</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>B</b></td>" +
                    "<td class=tg-0lax>ば</td>" +
                    "<td class=tg-0lax>び</td>" +
                    "<td class=tg-0lax>ぶ</td>" +
                    "<td class=tg-0lax>べ</td>" +
                    "<td class=tg-0lax>の</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>P</b></td>" +
                    "<td class=tg-0lax>ぱ</td>" +
                    "<td class=tg-0lax>ぴ</td>" +
                    "<td class=tg-0lax>ぷ</td>" +
                    "<td class=tg-0lax>ぺ</td>" +
                    "<td class=tg-0lax>ぽ</td>" +
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
                    "<td class=tg-0lax>きゃ</td>" +
                    "<td class=tg-0lax>きゅ</td>" +
                    "<td class=tg-0lax>きょ</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>S</b></td>" +
                    "<td class=tg-0lax>しゃ</td>" +
                    "<td class=tg-0lax>しゅ</td>" +
                    "<td class=tg-0lax>しょ</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>Ｔ</b></td>" +
                    "<td class=tg-0lax>ちゃ</td>" +
                    "<td class=tg-0lax>ちゅ</td>" +
                    "<td class=tg-0lax>ちょ</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>N</b></td>" +
                    "<td class=tg-0lax>にゃ</td>" +
                    "<td class=tg-0lax>にゅ</td>" +
                    "<td class=tg-0lax>にょ</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>H</b></td>" +
                    "<td class=tg-0lax>ひゃ</td>" +
                    "<td class=tg-0lax>ひゅ</td>" +
                    "<td class=tg-0lax>ひょ</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>M</b></td>" +
                    "<td class=tg-0lax>みゃ</td>" +
                    "<td class=tg-0lax>みゅ</td>" +
                    "<td class=tg-0lax>みょ</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>R</td>" +
                    "<td class=tg-0lax>りゃ</td>" +
                    "<td class=tg-0lax>りゅ</td>" +
                    "<td class=tg-0lax>りょ</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>G</td>" +
                    "<td class=tg-0lax>ぎゃ</td>" +
                    "<td class=tg-0lax>ぎゅ</td>" +
                    "<td class=tg-0lax>ぎょ</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>J</td>" +
                    "<td class=tg-0lax>じゃ</td>" +
                    "<td class=tg-0lax>じゅ</td>" +
                    "<td class=tg-0lax>じょ</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>B</td>" +
                    "<td class=tg-0lax>びゃ</td>" +
                    "<td class=tg-0lax>びゅ</td>" +
                    "<td class=tg-0lax>びょ</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>P</td>" +
                    "<td class=tg-0lax>ぴゃ</td>" +
                    "<td class=tg-0lax>ぴゅ</td>" +
                    "<td class=tg-0lax>ぴょ</td>" +

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
                    "<td class=tg-0lax>あ</td>" +
                    "</tr>" +
                    "<tr height=50>" +

                    "<td class=tg-0lax>/i/ ou /e/</td>" +
                    "<td class=tg-0lax>い</td>" +
                    "</tr>" +
                    "<tr height=50>" +

                    "<td class=tg-0lax>/u/ ou /o/</td>" +
                    "<td class=tg-0lax>う</td>" +
                    "</tr>" +

                    "</tbody>" +
                    "</table>";
}