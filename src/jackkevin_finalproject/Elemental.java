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
public class Elemental extends Mob{
    public Elemental(String inputName, int inputMaxHealth, int inputAttack, int inputArmor, int inputMagicRes){
        super (inputName, inputMaxHealth, inputAttack, inputArmor, inputMagicRes);
        this.setMaxHealth(this.getMaxHealth() + 0);
        this.setAttack(this.getAttack() + 60);
        this.setArmor(-400);
        this.setMagicRes(this.getMagicRes() + 50);
        if (this.getMagicRes() >= 100){
            this.setMagicRes(99);
        }
    }
    
    public void attack(Character x){
        int dmg = this.getAttack();
        x.setCurrentHealth(x.getCurrentHealth() - dmg);
    }
}
