package me.abdullah.game.cryp;

import java.math.BigInteger;

public interface IKeyPair {

    BigInteger getPublic();

    BigInteger getPrivate();
}
