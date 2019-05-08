/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koe_18_4;

public class Varaus {
    private String email;
    private Matka matka;
    
    public Varaus(String email, Matka matka) {
        this.email=email;
        this.matka=matka;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public Matka getMatka() {
        return this.matka;
    }
}
