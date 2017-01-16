
package jackkevin_finalproject;


public class Sorcerer extends Character {
    private int magic;
    private boolean channeled = false;
    
    public Sorcerer(String inputName, int inputMaxHealth, int inputMagic){
        super(inputName, inputMaxHealth);
        magic = inputMagic + 15;
    }
    
    public int getMagic(){
        return magic;
    } public void setMagic(int newMagic){
        magic = newMagic; 
    }
    
    public boolean getChanneled(){
        return channeled;
    } public void setChanneled(boolean newChanneled){ 
        channeled = newChanneled; 
    } 
    
    public void mindCrush(Mob x){                                      
        int dmg = magic * 5;
        if (channeled){
            dmg = dmg * 3;
            this.setChanneled(false);
        }
        if (x.getDefenseDebuff()){
            dmg = dmg * 2;
        }
        x.setCurrentHealth(x.getCurrentHealth() - dmg);
    }
    
    public void shadowBolt(Mob x){                                      
        int dmg = magic;
        if (channeled){
            dmg = dmg * 3;
            this.setChanneled(false);
        }
        if (x.getDefenseDebuff()){
            dmg = dmg * 2;
        }
        dmg = (int)Math.ceil(dmg * (1.0 - x.getMagicRes() / 100));
        x.setCurrentHealth(x.getCurrentHealth() - dmg);
    }
    
    public void netherTap(){
        this.setChanneled(true);
    }
            
    public void debilitate(Mob x){
        x.setDamageDebuff(true);
        x.setDefenseDebuff(true);
        x.setDamageDebuffTick(4);
        x.setDefenseDebuffTick(4);
    } 
}
