/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koe_18_4;

public class Matka {
    private Integer id;
    private String mista;
    private String minne;
    private Integer paikkoja;
    
    public Matka(Integer id, String mista, String minne, Integer paikkoja) {
        this.id=id;
        this.mista=mista;
        this.minne=minne;
        this.paikkoja=paikkoja;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public Integer getPaikkoja() {
        return this.paikkoja;
    }
    
    public String getMista() {
        return this.mista;
    }
    
    public String getMinne() {
        return this.minne;
    }
    
    public void setPaikkoja() {
        this.paikkoja = this.paikkoja - 1;
    }
}
