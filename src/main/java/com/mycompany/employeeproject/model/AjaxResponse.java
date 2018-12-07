package com.mycompany.employeeproject.model;

public class AjaxResponse {
    
    private int status;
    private String message;
    private int idElem;

    public AjaxResponse() {
    }

    public AjaxResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public AjaxResponse(int status, String message, int id_elem) {
        this.status = status;
        this.message = message;
        this.idElem = id_elem;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getIdElem() {
        return idElem;
    }

    public void setIdElem(int idElem) {
        this.idElem = idElem;
    }
}
