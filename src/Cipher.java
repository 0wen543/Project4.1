public abstract class Cipher {

    public abstract char encrypt(char c);

    public abstract char decrypt(char c);

    public String encrypt(String s){
        StringBuilder encryption = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            encryption.append(encrypt(s.charAt(i)));
        }
        return encryption.toString();
    }

    public String decrypt(String s){
        StringBuilder decryption = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            decryption.append(decrypt(s.charAt(i)));
        }
        return decryption.toString();
    }

    public abstract Cipher newCopy();
}
