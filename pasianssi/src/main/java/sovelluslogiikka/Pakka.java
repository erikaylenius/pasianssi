package sovelluslogiikka;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eylenius
 */

import java.util.*;

public class Pakka {
    private ArrayList<Kortti> pakka;
    
    public Pakka() {
        this.pakka = new ArrayList<Kortti>();
    }
    
    public void lisaaKortti(Kortti kortti) {
        this.pakka.add(kortti);
    }
    
    public int pakanKoko() {
        return this.pakka.size();
    }
}
