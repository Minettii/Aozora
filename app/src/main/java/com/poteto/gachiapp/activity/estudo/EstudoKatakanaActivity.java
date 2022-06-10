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
                    "<td class=tg-0lax>ア</td>" +
                    "<td class=tg-0lax>イ</td>" +
                    "<td class=tg-0lax>ウ</td>" +
                    "<td class=tg-0lax>エ</td>" +
                    "<td class=tg-0lax>オ</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>K</b></td>" +
                    "<td class=tg-0lax>カ</td>" +
                    "<td class=tg-0lax>キ</td>" +
                    "<td class=tg-0lax>ク</td>" +
                    "<td class=tg-0lax>ケ</td>" +
                    "<td class=tg-0lax>コ</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>S</b></td>" +
                    "<td class=tg-0lax>サ</td>" +
                    "<td class=tg-0lax>シ<br>(shi)</td>" +
                    "<td class=tg-0lax>ス</td>" +
                    "<td class=tg-0lax>セ</td>" +
                    "<td class=tg-0lax>ソ</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>T</b></td>" +
                    "<td class=tg-0lax>タ</td>" +
                    "<td class=tg-0lax>チ<br>(chi)</td>" +
                    "<td class=tg-0lax>ツ<br>(tsu)</td>" +
                    "<td class=tg-0lax>テ</td>" +
                    "<td class=tg-0lax>ト</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>N</b></td>" +
                    "<td class=tg-0lax>ナ</td>" +
                    "<td class=tg-0lax>ニ</td>" +
                    "<td class=tg-0lax>ヌ</td>" +
                    "<td class=tg-0lax>ネ</td>" +
                    "<td class=tg-0lax>ノ</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>H</b></td>" +
                    "<td class=tg-0lax>ハ</td>" +
                    "<td class=tg-0lax>ヒ</td>" +
                    "<td class=tg-0lax>フ<br>(fu)</td>" +
                    "<td class=tg-0lax>ヘ</td>" +
                    "<td class=tg-0lax>ホ</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>M</td>" +
                    "<td class=tg-0lax>マ</td>" +
                    "<td class=tg-0lax>ミ</td>" +
                    "<td class=tg-0lax>ム</td>" +
                    "<td class=tg-0lax>メ</td>" +
                    "<td class=tg-0lax>モ</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>Y</td>" +
                    "<td class=tg-0lax>ヤ</td>" +
                    "<td class=tg-0lax></td>" +
                    "<td class=tg-0lax>ユ</td>" +
                    "<td class=tg-0lax></td>" +
                    "<td class=tg-0lax>ヨ</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>R</td>" +
                    "<td class=tg-0lax>ラ</td>" +
                    "<td class=tg-0lax>リ</td>" +
                    "<td class=tg-0lax>ル</td>" +
                    "<td class=tg-0lax>レ</td>" +
                    "<td class=tg-0lax>ロ</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>W</td>" +
                    "<td class=tg-0lax>ワ</td>" +
                    "<td class=tg-0lax></td>" +
                    "<td class=tg-0lax></td>" +
                    "<td class=tg-0lax></td>" +
                    "<td class=tg-0lax>ヲ<br>(o)</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>N</td>" +
                    "<td class=tg-0lax>ン<br>(n)</td>" +
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
                    "<td class=tg-0lax>シャ</td>" +
                    "<td class=tg-0lax>シ</td>" +
                    "<td class=tg-0lax>シュ</td>" +
                    "<td style=color:#F44336>シェ</td>" +
                    "<td class=tg-0lax>ショ</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>J</b></td>" +
                    "<td class=tg-0lax>ジャ</td>" +
                    "<td class=tg-0lax>ジ<br>(shi)</td>" +
                    "<td class=tg-0lax>ジュ</td>" +
                    "<td style=color:#F44336>ジェ</td>" +
                    "<td class=tg-0lax>ジョ</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>T</b></td>" +
                    "<td class=tg-0lax>タ</td>" +
                    "<td style=color:#F44336>ティ</td>" +
                    "<td style=color:#F44336>トゥ</td>" +
                    "<td class=tg-0lax>テ</td>" +
                    "<td class=tg-0lax>ト</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>D</b></td>" +
                    "<td class=tg-0lax>ダ</td>" +
                    "<td style=color:#F44336>ディ</td>" +
                    "<td style=color:#F44336>ドゥ</td>" +
                    "<td class=tg-0lax>デ</td>" +
                    "<td class=tg-0lax>ド</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold><b>CH</b></td>" +
                    "<td class=tg-0lax>チャ</td>" +
                    "<td class=tg-0lax>チ</td>" +
                    "<td class=tg-0lax>チュ<br>(fu)</td>" +
                    "<td class=tg-0lax>チェ</td>" +
                    "<td style=color:#F44336>チョ</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>F</td>" +
                    "<td style=color:#F44336>ファ</td>" +
                    "<td style=color:#F44336>フィ</td>" +
                    "<td class=tg-0lax>フ</td>" +
                    "<td style=color:#F44336>フェ</td>" +
                    "<td style=color:#F44336>フォ</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>W</td>" +
                    "<td class=tg-0lax>ワ</td>" +
                    "<td style=color:#F44336>ウィ</td>" +
                    "<td class=tg-0lax>ウ</td>" +
                    "<td style=color:#F44336>ウェ</td>" +
                    "<td style=color:#F44336>ウォ</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>V</td>" +
                    "<td style=color:#F44336>ヴァ</td>" +
                    "<td style=color:#F44336>ヴィ</td>" +
                    "<td style=color:#F44336>ヴ</td>" +
                    "<td style=color:#F44336>ヴェ</td>" +
                    "<td style=color:#F44336>ヴォ</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";

    String tableKatakanaExamples =
            "<table bgcolor=#5EA6B4 border=1 bordercolor=#FFFFFF " +
                    "style=table-layout:fixed;text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th>Portugûes</th>" +
                    "<th>Inglês</th>" +
                    "<th>Japonês</th>" +

                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td class=tg-0lax>América</td>" +
                    "<td class=tg-0lax>America</td>" +
                    "<td class=tg-0lax>アメリカ</td>" +
                    "</tr>" +

                    "<tr height=50>" +
                    "<td>Rússia</td>" +
                    "<td>Russia</td>" +
                    "<td>ロシア</td>" +
                    "</tr>" +

                    "<tr height=50>" +
                    "<td>Trapacear</td>" +
                    "<td>Cheating</td>" +
                    "<td>カンニング<br>(cunning)</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td>Viagem</td>" +
                    "<td>Tour</td>" +
                    "<td>ツアー</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td>Funcionário</td>" +
                    "<td class=tg-0lax>Company<br>employee</td>" +
                    "<td class=tg-0lax>サラリーマン<br>(salary man)</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td>Mozart</td>" +
                    "<td class=tg-0lax>Mozart</td>" +
                    "<td class=tg-0lax>モーツアルト</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td class=tg-0lax>Buzina de<br>Carro</td>" +
                    "<td>Car Horn</td>" +
                    "<td>クラクション<br>(klaxon)</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td class=tg-0lax>Sofá</td>" +
                    "<td>sofa</td>" +
                    "<td>ソファ ou<br>ソファー</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td class=tg-0lax>Dia das<br>Bruxas</td>" +
                    "<td>Halloween</td>" +
                    "<td>ハロウィーン</td>" +

                    "</tr>" +
                    "<tr height=50>" +
                    "<td class=tg-0lax>Batatas<br>Fritas</td>" +
                    "<td>French Fries</td>" +
                    "<td>フライドポテト<br>(fried potato)</td>" +

                    "</tr>" +
                    "</tbody>" +
                    "</table>";
}