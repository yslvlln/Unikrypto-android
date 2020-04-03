package com.yslvlln.unikrypto

import com.goterl.lazycode.lazysodium.LazySodiumAndroid
import com.goterl.lazycode.lazysodium.SodiumAndroid
import com.goterl.lazycode.lazysodium.exceptions.SodiumException
import com.goterl.lazycode.lazysodium.utils.Key
import java.lang.Exception

object Unikrypto {
    val instance = LazySodiumAndroid(SodiumAndroid())
    val key = SecretKey.mKey

    fun krypt(message: String, nonce: ByteArray): String? {
        return instance.cryptoSecretBoxEasy(message, nonce, key)
    }

    fun dekrypt(ciphertext: String, nonce: ByteArray): String? {
        return instance.cryptoSecretBoxOpenEasy(ciphertext, nonce, key)
    }
}