package com.example.lab5simplechatclient;

public class DefaultController extends AbstractController {

    public static final String ELEMENT_OUTPUT_PROPERTY = "Output";
    private String message;

    public void changeOutputText(String newText) {
        setModelProperty(ELEMENT_OUTPUT_PROPERTY, newText);
    }

    public void sendGetRequest() {
        invokeModelMethod("sendGetRequest", null);
    }

    public void sendPostRequest() {
        invokeModelMethod("sendPostRequest", null);
    }

    public String getMessage() {
        return message;
    }
}