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
public class ElderDragon extends Mob{
    public ElderDragon(String inputName, int inputMaxHealth, int inputAttack, int inputArmor, int inputMagicRes){
        super (inputName, inputMaxHealth, inputAttack, inputArmor, inputMagicRes);
        this.setMaxHealth(this.getMaxHealth() + 300);
        this.setAttack(this.getAttack() + 30);
        this.setArmor(this.getArmor() + 40);
        if (this.getArmor() >= 100){
            this.setArmor(99);
        }
        this.setMagicRes(this.getMagicRes()+ 30);
        if (this.getMagicRes() >= 100){
            this.setMagicRes(99);
        }
    }
    
    public void attack(Character x){
        int dmg = this.getAttack();
        if (this.getDamageDebuff()){
            dmg = (int)Math.ceil(dmg / 2);
        }
        if (x.getDefenseBuff()){
            dmg = (int)Math.ceil(dmg / 2);
        }
        x.setCurrentHealth(x.getCurrentHealth() - dmg);
                
        this.setCurrentHealth(this.getCurrentHealth() + (int)Math.ceil(this.getMaxHealth() * 0.15));
        if (this.getCurrentHealth() > this.getMaxHealth()){
            this.setCurrentHealth(this.getMaxHealth());
        }
    }
}
