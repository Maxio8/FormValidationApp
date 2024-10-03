package com.example.formvalidationapp;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextLastName;
    private EditText editTextEmail;
    private EditText editTextPhone;
    private EditText editTextPassword;
    private EditText editTextPassword2;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName); // Poprawione powiązanie
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPassword = findViewById(R.id.editTextTextPassword);
        editTextPassword2 = findViewById(R.id.editTextTextPassword2);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editTextName.getText().toString().trim();
                String lastName = editTextLastName.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String password2 = editTextPassword2.getText().toString().trim();

                //Wlidacja imienia
                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić imię", Toast.LENGTH_SHORT).show();

                //Walidacja nazwiska
                } else if (lastName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić nazwisko", Toast.LENGTH_SHORT).show();

                //Walidacja e-mail
                } else if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić adres e-mail", Toast.LENGTH_SHORT).show();

                } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this, "Niepoprawny adres email", Toast.LENGTH_SHORT).show();

                //Walidacja numeru telefonu
                } else if (phone.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić numer telefonu", Toast.LENGTH_SHORT).show();

                } else if (phone.length()<9) {
                    Toast.makeText(MainActivity.this, "Numer telefonu musi zawierać conajmniej 9 znaków", Toast.LENGTH_SHORT ).show();

                //Walidacja hasła 1
                } else if (password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę wprowadzić hasło", Toast.LENGTH_SHORT).show();

                } else if (password.length()<6) {
                    Toast.makeText(MainActivity.this, "Hasło musi zawierać 6 znaków", Toast.LENGTH_SHORT ).show();

                //Walidacja hasła 2
                } else if (password2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Proszę powtórzyć hasło", Toast.LENGTH_SHORT).show();
                } else if (!(password.equals(password2))) {
                    Toast.makeText(MainActivity.this, "Hasło nie jest takie samo", Toast.LENGTH_SHORT ).show();

                } else {
                    Toast.makeText(MainActivity.this, "Formularz przesłany poprawnie", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}