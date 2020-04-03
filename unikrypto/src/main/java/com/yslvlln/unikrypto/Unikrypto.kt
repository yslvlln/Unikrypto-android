package com.yslvlln.unikrypto

import com.goterl.lazycode.lazysodium.LazySodiumAndroid
import com.goterl.lazycode.lazysodium.SodiumAndroid

object Unikrypto {
    private val instance = LazySodiumAndroid(SodiumAndroid())
    private val key = SecretKey.getKey()

    fun krypt(message: String, nonce: ByteArray): String? {
        return instance.cryptoSecretBoxEasy(message, nonce, key)
    }

    fun dekrypt(ciphertext: String, nonce: ByteArray): String? {
        return instance.cryptoSecretBoxOpenEasy(ciphertext, nonce, key)
    }
}