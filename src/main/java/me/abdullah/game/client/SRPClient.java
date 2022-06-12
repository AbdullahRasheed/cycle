package me.abdullah.game.client;

import com.nimbusds.srp6.*;

import java.math.BigInteger;

public class SRPClient {

    private SRP6CryptoParams config;
    private SRP6VerifierGenerator gen;
    private BigInteger salt;
    public SRPClient(){
        config = SRP6CryptoParams.getInstance();
        gen = new SRP6VerifierGenerator(config);
        salt = new BigInteger(gen.generateRandomSalt());
    }

    public void send(String username, String password){
        BigInteger v = gen.generateVerifier(salt, username, password);

        SRP6ClientSession client = new SRP6ClientSession();
        client.step1(username, password);

        SRP6ClientCredentials cred = null;

//        try{
//            cred = client.step2(config, salt, )
//        }catch (SRP6Exception e){
//            e.printStackTrace();
//        }
    }
}
