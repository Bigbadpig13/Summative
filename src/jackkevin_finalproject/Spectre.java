/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jackkevin_finalproject;

/**
 *
 * @author Kevin
 */
public class Spectre extends Mob{
    public Spectre(String inputName, int inputMaxHealth, int inputAttack, int inputArmor, int inputMagicRes){
        super (inputName, inputMaxHealth, inputAttack, inputArmor, inputMagicRes);
        this.setMaxHealth(this.getMaxHealth() + 80);
        this.setAttack(this.getAttack() + 20);
        this.setArmor(100);
        this.setMagicRes(this.getMagicRes() + 20);
    }
    
    public void attack(Character x){
        int dmg = this.getAttack();
        if (this.getDamageDebuff()){
            dmg = (int)Math.ceil(dmg / 2);
        }
        if (x.getDefenseBuff()){
            dmg = (int)Math.ceil(dmg / 2);
        }
        int strikes = (int)(Math.random() * ((3 - 1) + 1) + 1);
        for (int i = 1; i <= strikes; i++){
            x.setCurrentHealth(x.getCurrentHealth() - dmg);
        }
    }
}
