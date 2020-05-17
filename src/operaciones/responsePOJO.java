/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

/**
 *
 * @author jeison nisperuza
 */
public class responsePOJO {

    private boolean isFraction;
    private String response;

    public responsePOJO() {
        isFraction = false;
        response = "1/1";
    }

    // ==========================================================
    // Create a Setters and Getters for all variables
    // ==========================================================
    public boolean getIsFraction() {
        return isFraction;
    }

    public void setIsFraction(boolean isFraction) {
        this.isFraction = isFraction;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
