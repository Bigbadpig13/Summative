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
public class Witch extends Mob{
    public Witch(String inputName, int inputMaxHealth, int inputAttack, int inputArmor, int inputMagicRes){
        super (inputName, inputMaxHealth, inputAttack, inputArmor, inputMagicRes);
        this.setMaxHealth(this.getMaxHealth() - 30);
        this.setAttack(this.getAttack() + 15);
        this.setArmor(this.getArmor() - 40);
        if (this.getArmor() == 0){
            this.setArmor(1);
        }
        this.setMagicRes(this.getMagicRes() + 10);
    }
    
    public void attack(Character x, Character y){
        int dmg = (int)Math.ceil(this.getAttack() * 0.75);
        if (this.getDamageDebuff()){
            dmg = (int)Math.ceil(dmg / 2);
        }
        if (x.getDefenseBuff()){
            dmg = (int)Math.ceil(dmg / 2);
        }
        x.setCurrentHealth(x.getCurrentHealth() - dmg);
        
        dmg = (int)Math.ceil(this.getAttack() * 0.75);
        if (this.getDamageDebuff()){
            dmg = (int)Math.ceil(dmg / 2);
        }
        if (y.getDefenseBuff()){
            dmg = (int)Math.ceil(dmg / 2);
        }
        y.setCurrentHealth(y.getCurrentHealth() - dmg);
    }
}
