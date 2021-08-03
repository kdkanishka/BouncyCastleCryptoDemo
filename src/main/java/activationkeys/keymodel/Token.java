package activationkeys.keymodel;

import java.util.Base64;

public class Token {
    String id;
    long expiry;
    String owner;

    public Token(String id, long expiry, String owner) {
        this.id = id;
        this.expiry = expiry;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getExpiry() {
        return expiry;
    }

    public void setExpiry(long expiry) {
        this.expiry = expiry;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String serialize(){
        return Base64.getEncoder().encodeToString((id+";"+expiry+";"+owner).getBytes());
    }

    public static Token deserialize(String plainTextToken){
        String tokenVal = new String(Base64.getDecoder().decode(plainTextToken));
        String[] tokenAttr = tokenVal.split(";");
        String id = tokenAttr[0];
        long exp = Long.parseLong(tokenAttr[1]);
        String owner = tokenAttr[2];
        return new Token(id,exp,owner);
    }

    @Override
    public String toString() {
        return (id+";"+expiry+";"+owner);
    }
}
