package com.example.lab5simplechatclient;

import com.example.lab5simplechatclient.AbstractController;

public class DefaultController extends AbstractController {

    public static final String ELEMENT_OUTPUT_PROPERTY = "Output";
    private String message;

    public void changeOutputText(String newText) {
        setModelProperty(ELEMENT_OUTPUT_PROPERTY, newText);
    }

    public void sendGetRequest() {
        invokeModelMethod("sendGetRequest", null);
    }

    public void sendPostRequest(String message) {
        invokeModelMethod("sendPostRequest", message);
    }

    public void sendClearRequest() {
        invokeModelMethod("sendDeleteRequest", null);

    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}