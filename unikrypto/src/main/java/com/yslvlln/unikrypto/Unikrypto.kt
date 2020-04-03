package com.yslvlln.unikrypto

import com.goterl.lazycode.lazysodium.LazySodiumAndroid
import com.goterl.lazycode.lazysodium.SodiumAndroid

object Unikrypto {
    private val instance = LazySodiumAndroid(SodiumAndroid())
    private val key = SecretKey.getKey()

    fun krypt(message: String): String? {
        return instance.cryptoSecretBoxEasy(message, ByteArray(24), key)
    }

    fun dekrypt(ciphertext: String): String? {
        return instance.cryptoSecretBoxOpenEasy(ciphertext, ByteArray(24), key)
    }
}