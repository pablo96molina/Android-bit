package com.example.myapplication3;

import android.os.Bundle;
import android.os.Message;
import android.os.StrictMode;
import android.se.omapi.Session;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;

public class FormularioActivity extends AppCompatActivity {

    String correo;
    String password;
    EditText etNombre;
    EditText etMail;
    EditText etMensaje;
    Button btnEnviarComentario;
    Session session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etMail = (EditText) findViewById(R.id.etEmail);
        etMensaje = (EditText) findViewById(R.id.etMensaje);
        btnEnviarComentario = (Button) findViewById(R.id.btnEnviarComentario);

        correo = "blzzk@hotmail.com";
        password = "RuperTO2020";

        btnEnviarComentario.setOnClickListener(new View.OnClickListener() {
            class RecipientType {
                public static final Object TO = ;
            }

            @Override
            public void onClick(View v) {
                // Aviso que el correo se está procesando
                Snackbar.make(v, etNombre.getText().toString()+" "+getResources().getString(R.string.aviso_enviando_mail), Snackbar.LENGTH_SHORT).show();

                //politicas de seguridad
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                //Propiedades
                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.outlookemail.com");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "465");
                try {

                    //*** Iniciamos la sesión en gmail ****
                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo, password);
                        }
                    });

                    // *** Mintras la sesión no sea nula ****
                    if (session != null) {
                        Message message = new Message(session);
                        message.setFrom(new InternetAddress(correo)); //Correo del emisor
                        message.setSubject("Tarea 4, correo de pruebas"); //Asunto del msj
                        message.setRecipients(RecipientType.TO, InternetAddress.parse(etMail.getText().toString()));//Destinatarios
                        message.setContent(etMensaje.getText().toString(), "text/html; charset=utf-8");// Tipo de contenido que vamos a enviar

                        //Enviamos el correo
                        Transport.send(message);

                        // Aviso que el correo se ha enviado con exito
                        Snackbar.make(v, getResources().getString(R.string.aviso_mail_enviado)+" "+etMail.getText().toString(), Snackbar.LENGTH_LONG).show();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    // Aviso que el correo se ha enviado con exito
                    Snackbar.make(v, getResources().getString(R.string.aviso_faltan_datos), Snackbar.LENGTH_SHORT).show();
                }
            }

        });
    }
}
