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
import com.poteto.gachiapp.databinding.ActivityEstudoVerbosNegativoBinding;
import com.poteto.gachiapp.fragment.FirstFragment;
import com.poteto.gachiapp.fragment.SecondFragment;
import com.poteto.gachiapp.fragment.ThirdFragment;

public class EstudoVerbosNegativoActivity extends AppCompatActivity {

    ActivityEstudoVerbosNegativoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEstudoVerbosNegativoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle(R.string.titleEstudo12);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.textView8.setMovementMethod(LinkMovementMethod.getInstance());

        binding.webNegRu.loadDataWithBaseURL(null, tableNegRu, "text/html", "utf-8", null);
        binding.webNegU.loadDataWithBaseURL(null, tableNegU, "text/html", "utf-8", null);
        binding.webNegExc.loadDataWithBaseURL(null, tableNegExc, "text/html", "utf-8", null);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    String tableNegRu =
            "<table bgcolor=#5EA6B4 border=1 width=300 bordercolor=#FFFFFF " +
                    "style=table-layout:fixed;text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th>Afirmativo</th>" +
                    "<th>Negativo</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td>食べ<font color=#B53834>る</font></td>" +
                    "<td>食べ<font color=#B53834>ない</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>着<font color=#B53834>る</font></td>" +
                    "<td>着<font color=#B53834>ない</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>信じ<font color=#B53834>る</font></td>" +
                    "<td>信じ<font color=#B53834>ない</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>寝<font color=#B53834>る</font></td>" +
                    "<td>寝<font color=#B53834>ない</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>起き<font color=#B53834>る</font></td>" +
                    "<td>起き<font color=#B53834>ない</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>出<font color=#B53834>る</font></td>" +
                    "<td>出<font color=#B53834>ない</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>掛け<font color=#B53834>る</font></td>" +
                    "<td>掛け<font color=#B53834>ない</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>捨て<font color=#B53834>る</font></td>" +
                    "<td>捨て<font color=#B53834>ない</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>調べ<font color=#B53834>る</font></td>" +
                    "<td>調べ<font color=#B53834>ない</font></td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";

    String tableNegU =
            "<table bgcolor=#5EA6B4 border=1 bordercolor=#FFFFFF " +
                    "style=text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th>Afirmativo</th>" +
                    "<th>Negativo</th>" +
                    "<th>ローマ字</th>" +
                    "<th>ローマ字<br>(Neg)</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td>話<font color=#B53834>す</font></td>" +
                    "<td>話<font color=#B53834>さない</font></td>" +
                    "<td>hanas<font color=#B53834>u</font></td>" +
                    "<td>hanas<font color=#B53834>anai</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>聞<font color=#B53834>く</font></td>" +
                    "<td>聞<font color=#B53834>かない</font></td>" +
                    "<td>kik<font color=#B53834>u</font></td>" +
                    "<td>kik<font color=#B53834>anai</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>泳<font color=#B53834>ぐ</font></td>" +
                    "<td>泳<font color=#B53834>がない</font></td>" +
                    "<td>oyog<font color=#B53834>u</font></td>" +
                    "<td>oyog<font color=#B53834>anai</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>遊<font color=#B53834>ぶ</font></td>" +
                    "<td>遊<font color=#B53834>ばない</font></td>" +
                    "<td>asob<font color=#B53834>u</font></td>" +
                    "<td>asob<font color=#B53834>anai</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>待<font color=#B53834>つ</font></td>" +
                    "<td>待<font color=#B53834>たない</font></td>" +
                    "<td>mat<font color=#B53834>u</font></td>" +
                    "<td>mat<font color=#B53834>anai</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>飲<font color=#B53834>む</font></td>" +
                    "<td>飲<font color=#B53834>まない</font></td>" +
                    "<td>nom<font color=#B53834>u</font></td>" +
                    "<td>nom<font color=#B53834>anai</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>直<font color=#B53834>る</font></td>" +
                    "<td>直<font color=#B53834>らない</font></td>" +
                    "<td>naor<font color=#B53834>u</font></td>" +
                    "<td>naor<font color=#B53834>anai</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>死<font color=#B53834>ぬ</font></td>" +
                    "<td>死<font color=#B53834>なない</font></td>" +
                    "<td>shin<font color=#B53834>u</font></td>" +
                    "<td>shin<font color=#B53834>anai</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>＊買<font color=#B53834>う</font></td>" +
                    "<td>買<font color=#B53834>わない</font></td>" +
                    "<td>ka<font color=#B53834>u</font></td>" +
                    "<td>ka<font color=#B53834>wanai</font></td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";

    String tableNegExc =
            "<table bgcolor=#5EA6B4 border=1 width=300 bordercolor=#FFFFFF " +
                    "style=table-layout:fixed;text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th>Afirmativo</th>" +
                    "<th>Negativo</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td>する</td>" +
                    "<td>しない</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>くる</td>" +
                    "<td>ない</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>＊ある</td>" +
                    "<td>ない</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";
}