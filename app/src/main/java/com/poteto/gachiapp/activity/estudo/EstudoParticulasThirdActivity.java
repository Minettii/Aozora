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
import com.poteto.gachiapp.databinding.ActivityEstudoParticulasSecondBinding;
import com.poteto.gachiapp.databinding.ActivityEstudoParticulasThirdBinding;
import com.poteto.gachiapp.fragment.FirstFragment;
import com.poteto.gachiapp.fragment.SecondFragment;
import com.poteto.gachiapp.fragment.ThirdFragment;

public class EstudoParticulasThirdActivity extends AppCompatActivity {

    ActivityEstudoParticulasThirdBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEstudoParticulasThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle(R.string.titleEstudo18);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        binding.textView8.setMovementMethod(LinkMovementMethod.getInstance());

        binding.web1.loadDataWithBaseURL(null, tableNda1, "text/html", "utf-8", null);
        binding.web2.loadDataWithBaseURL(null, tableNda２, "text/html", "utf-8", null);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    String tableNda1 =
            "<table bgcolor=#5EA6B4 border=1 width=300 bordercolor=#FFFFFF " +
                    "style=table-layout:fixed;text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th></th>" +
                    "<th>Substantivo/<br>Adjetivo-na</th>" +
                    "<th>Verbo/<br>Adjetivo-i</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>Plano</td>" +
                    "<td>学生<font color=#B53834>なんだ</font></td></td>" +
                    "<td>飲む<font color=#B53834>んだ</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>Negativo</td>" +
                    "<td>学生じゃない<font color=#B53834>んだ</font></td>" +
                    "<td>飲まない<font color=#B53834>んだ</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>Passado</td>" +
                    "<td>学生だった<font color=#B53834>んだ</font></td>" +
                    "<td>飲んだ<font color=#B53834>んだ</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>Passado-Negativo</td>" +
                    "<td>学生じゃなかった<font color=#B53834>んだ</font></td>" +
                    "<td>飲なかった<font color=#B53834>んだ</font></td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";

    String tableNda２ =
            "<table bgcolor=#5EA6B4 border=1 width=300 bordercolor=#FFFFFF " +
                    "style=table-layout:fixed;text-align:center;border-radius:10px;border-collapse:collapse;border-spacing:0;color:#FFFFFF>" +
                    "<thead bgcolor=#407993 style=color:#000000;font-weight:bold;>" +
                    "<tr height=50>" +
                    "<th></th>" +
                    "<th>Substantivo/<br>Adjetivo-na</th>" +
                    "<th>Verbo/<br>Adjetivo-i</th>" +
                    "</tr>" +
                    "</thead>" +
                    "<tbody>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>Plano</td>" +
                    "<td>学生<font color=#B53834>なんだ</font></td></td>" +
                    "<td>飲む<font color=#B53834>んだ</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>Negativo</td>" +
                    "<td>学生<font color=#B53834>なんじゃないな</font></td>" +
                    "<td>飲む<font color=#B53834>んじゃない</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>Passado</td>" +
                    "<td>学生<font color=#B53834>なんだった</font></td>" +
                    "<td>飲む<font color=#B53834>んだった</font></td>" +
                    "</tr>" +
                    "<tr height=50>" +
                    "<td bgcolor=#407993 style=color:#000000;font-weight:bold>Passado-Negativo</td>" +
                    "<td>学生<font color=#B53834>なんじゃなかった</font></td>" +
                    "<td>飲む<font color=#B53834>んじゃなかった</font></td>" +
                    "</tr>" +
                    "</tbody>" +
                    "</table>";
}