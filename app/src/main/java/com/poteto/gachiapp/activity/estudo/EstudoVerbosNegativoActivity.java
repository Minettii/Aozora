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
                    "<td>??????<font color=#B53834>???</font></td>" +
                    "<td>??????<font color=#B53834>??????</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>???<font color=#B53834>???</font></td>" +
                    "<td>???<font color=#B53834>??????</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>??????<font color=#B53834>???</font></td>" +
                    "<td>??????<font color=#B53834>??????</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>???<font color=#B53834>???</font></td>" +
                    "<td>???<font color=#B53834>??????</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>??????<font color=#B53834>???</font></td>" +
                    "<td>??????<font color=#B53834>??????</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>???<font color=#B53834>???</font></td>" +
                    "<td>???<font color=#B53834>??????</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>??????<font color=#B53834>???</font></td>" +
                    "<td>??????<font color=#B53834>??????</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>??????<font color=#B53834>???</font></td>" +
                    "<td>??????<font color=#B53834>??????</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>??????<font color=#B53834>???</font></td>" +
                    "<td>??????<font color=#B53834>??????</font></td>" +
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
                    "<th>????????????</th>" +
                    "<th>????????????<br>(Neg)</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td>???<font color=#B53834>???</font></td>" +
                    "<td>???<font color=#B53834>?????????</font></td>" +
                    "<td>hanas<font color=#B53834>u</font></td>" +
                    "<td>hanas<font color=#B53834>anai</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>???<font color=#B53834>???</font></td>" +
                    "<td>???<font color=#B53834>?????????</font></td>" +
                    "<td>kik<font color=#B53834>u</font></td>" +
                    "<td>kik<font color=#B53834>anai</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>???<font color=#B53834>???</font></td>" +
                    "<td>???<font color=#B53834>?????????</font></td>" +
                    "<td>oyog<font color=#B53834>u</font></td>" +
                    "<td>oyog<font color=#B53834>anai</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>???<font color=#B53834>???</font></td>" +
                    "<td>???<font color=#B53834>?????????</font></td>" +
                    "<td>asob<font color=#B53834>u</font></td>" +
                    "<td>asob<font color=#B53834>anai</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>???<font color=#B53834>???</font></td>" +
                    "<td>???<font color=#B53834>?????????</font></td>" +
                    "<td>mat<font color=#B53834>u</font></td>" +
                    "<td>mat<font color=#B53834>anai</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>???<font color=#B53834>???</font></td>" +
                    "<td>???<font color=#B53834>?????????</font></td>" +
                    "<td>nom<font color=#B53834>u</font></td>" +
                    "<td>nom<font color=#B53834>anai</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>???<font color=#B53834>???</font></td>" +
                    "<td>???<font color=#B53834>?????????</font></td>" +
                    "<td>naor<font color=#B53834>u</font></td>" +
                    "<td>naor<font color=#B53834>anai</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>???<font color=#B53834>???</font></td>" +
                    "<td>???<font color=#B53834>?????????</font></td>" +
                    "<td>shin<font color=#B53834>u</font></td>" +
                    "<td>shin<font color=#B53834>anai</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>??????<font color=#B53834>???</font></td>" +
                    "<td>???<font color=#B53834>?????????</font></td>" +
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
                    "<td>??????</td>" +
                    "<td>?????????</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>??????</td>" +
                    "<td>??????</td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td>?????????</td>" +
                    "<td>??????</td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";
}