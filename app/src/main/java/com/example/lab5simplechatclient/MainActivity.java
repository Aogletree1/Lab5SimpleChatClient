package com.example.lab5simplechatclient;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.beans.PropertyChangeEvent;

import com.example.lab5simplechatclient.databinding.ActivityMainBinding;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements AbstractView {

    public static final String TAG = "MainActivity";

    private ActivityMainBinding binding;

    private DefaultController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        /* Create Controller and Models */

        controller = new DefaultController();
        ExampleWebServiceModel model = new ExampleWebServiceModel();

        /* Register Activity View and Model with Controller */

        controller.addView(this);
        controller.addModel(model);

        /* Initialize Model to Default Values */

        model.initDefault();

        binding.postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = binding.inputField.getText().toString();
                //controller.setMessage(message);
                controller.sendPostRequest(message);

            }
        });

        binding.clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.sendClearRequest();
            }
        });

    }

    @Override
    public void modelPropertyChange(final PropertyChangeEvent evt) {

        String propertyName = evt.getPropertyName();
        String propertyValue = evt.getNewValue().toString();

        Log.i(TAG, "New " + propertyName + " Value from Model: " + propertyValue);

        if ( propertyName.equals(DefaultController.ELEMENT_OUTPUT_PROPERTY) ) {

            String oldPropertyValue = binding.textView.getText().toString();

            if ( !oldPropertyValue.equals(propertyValue) ) {
                String messagelog = "";
                try {
                    JSONObject json = new JSONObject(propertyValue);
                    messagelog = json.get("messages").toString();
                }
                catch (Exception e) {
                    messagelog = "ERROR!";
                }
                binding.textView.setText(messagelog);
            }

        }

    }

}