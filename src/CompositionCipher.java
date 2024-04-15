import java.lang.reflect.Array;
import java.util.ArrayList;

public class CompositionCipher extends Cipher{

    private ArrayList<Cipher> ciphers;

    CompositionCipher(){
        ciphers=new ArrayList<>();
    }

    CompositionCipher(CompositionCipher other){
        this.ciphers=other.getCiphers();
    }

    public ArrayList<Cipher> getCiphers(){
        ArrayList<Cipher> newComp = new ArrayList<>(ciphers);
        for(Cipher c: ciphers){
            Cipher newC = c.newCopy();
            newComp.add(newC);
        }
        return newComp;
    }


    //need to rework to do its job
    public char encrypt(char c){
        for(int i=0; i< ciphers.size();i++){
            c=ciphers.get(i).encrypt(c);
        }
        return c;
    }


    //need to rework to do its job
    public char decrypt(char c){
        for(int i=0; i< ciphers.size();i++){
            c=ciphers.get(i).decrypt(c);
        }
        return c;
    }


    public void add(Cipher theCipher){
        ciphers.add(theCipher);
    }

    @Override
    public Cipher newCopy(){
        return new CompositionCipher(this);
    }
}
