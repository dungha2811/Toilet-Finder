package edu.fontbonne.toiletfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

public class RegisterActivity  extends AppCompatActivity {

    private EditText userName;
    private EditText password;
    private EditText rePassword;
    private EditText email;
    private EditText reEmail;
    private Button register;

    private FirebaseFirestore mDb ;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mDb = FirebaseFirestore.getInstance();

        userName = (EditText)(findViewById(R.id.et_username));
        password = (EditText)(findViewById(R.id.et_password));
        rePassword= (EditText)(findViewById(R.id.et_reEnterPassword));
        email =(EditText)(findViewById(R.id.et_email));
        reEmail =(EditText)(findViewById(R.id.et_reEmail));
        register =(Button)(findViewById(R.id.btn_register));

        //set on click for register button
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //if no field is empty
                if(!email.getText().toString().isEmpty()&&!reEmail.getText().toString().isEmpty()
                &&!password.getText().toString().isEmpty()&&!rePassword.getText().toString().isEmpty()
                &&!userName.getText().toString().isEmpty()){
                    if(password.getText().toString().equals(rePassword.getText().toString())&&
                    email.getText().toString().equals(reEmail.getText().toString())){
                        register(email.getText().toString(),password.getText().toString(),userName.getText().toString());

                    }
                }
                else {
                    Toast.makeText(RegisterActivity.this,"Email or Password not match",Toast.LENGTH_SHORT);
                }
            }
        });


    }

    public void register(final String email, final String password, final String username){
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        //input data
                        User user = new User();
                        user.setEmailAddress(email);
                        user.setUsername(username);
                        user.setPassword(password);
                        user.setUserID(FirebaseAuth.getInstance().getUid());

                        //change the fireStore setting
                        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                                .build();
                        mDb.setFirestoreSettings(settings);

                        DocumentReference newUserRef = mDb
                                .collection(getString(R.string.collection_users))
                                .document(FirebaseAuth.getInstance().getUid());

                        newUserRef.set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(RegisterActivity.this,"Something went wrong",Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                    }

                });
    }
}
