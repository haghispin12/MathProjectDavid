package BugrutProject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mathprojectdavid.R;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    Spinner spinerLogin;

    private EditText Username;

    private EditText password;

    private Button Login;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
        spinerLogin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                //String item = adapterView.getItemIdAtPosition(position)+"";
                Toast.makeText(LoginActivity.this, "בחר סוג כניסה" + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        creatListOfLogin();
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putString("name", Username.getText().toString());
                myEdit.putString("password", password.getText().toString());
                myEdit.apply();
                intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("UserName", Username.getText().toString());
                intent.putExtra("password", password.getText().toString());
                startActivity(intent);
            }
        });
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s1 = sh.getString("name", "");
        String s2 = sh.getString("password", "");
        Username.setText(s1);
        password.setText(s2);
    }

    public void initView(){
        spinerLogin = findViewById(R.id.spinerLogin);
        Username = findViewById(R.id.UserNameLogin);
        password = findViewById(R.id.passwordLogin);
        Login = findViewById(R.id.submitLogin);
    }

    public void creatListOfLogin(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("משתמש רגיל");
        arrayList.add("מנהל");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinerLogin.setAdapter(adapter);
    }
}