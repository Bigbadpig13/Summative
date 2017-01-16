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
public class Orc extends Mob{
    public Orc(String inputName, int inputMaxHealth, int inputAttack, int inputArmor, int inputMagicRes){
        super (inputName, inputMaxHealth, inputAttack, inputArmor, inputMagicRes);
        this.setMaxHealth(this.getMaxHealth() + 100);
        this.setAttack(this.getAttack() + 10);
        this.setArmor(-50);
        this.setMagicRes(-100);
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
        
        if(x.equals(y) == false){
            dmg = this.getAttack();
            if (this.getDamageDebuff()){
                dmg = (int)Math.ceil(dmg / 2);
            }
            if (y.getDefenseBuff()){
                dmg = (int)Math.ceil(dmg / 2);
            }
            y.setCurrentHealth(y.getCurrentHealth() - dmg);
        }
    }
}
