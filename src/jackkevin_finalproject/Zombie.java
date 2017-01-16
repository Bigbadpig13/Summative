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
public class Zombie extends Mob{
    public Zombie(String inputName, int inputMaxHealth, int inputAttack, int inputArmor, int inputMagicRes){
        super (inputName, inputMaxHealth, inputAttack, inputArmor, inputMagicRes);
        this.setMaxHealth(this.getMaxHealth() + 250);
        this.setAttack(this.getAttack() + 35);
        this.setArmor(-100);
        this.setMagicRes(-200);
    }
    
    public void attack(Character x, Character y){
        int dmg = this.getAttack();
        if (this.getDamageDebuff()){
            dmg = (int)Math.ceil(dmg / 2);
        }
        if (x.getDefenseBuff()){
            dmg = (int)Math.ceil(dmg / 2);
        }
        x.setCurrentHealth(x.getCurrentHealth() - dmg);
        
        dmg = this.getAttack();
        if (this.getDamageDebuff()){
            dmg = (int)Math.ceil(dmg / 2);
        }
        if (y.getDefenseBuff()){
            dmg = (int)Math.ceil(dmg / 2);
        }
        y.setCurrentHealth(y.getCurrentHealth() - dmg);
        
        this.setCurrentHealth(this.getCurrentHealth() + dmg);
        if (this.getCurrentHealth() > this.getMaxHealth()){
            this.setCurrentHealth(this.getMaxHealth());
        }
    }
}
