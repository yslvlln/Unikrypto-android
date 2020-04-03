package com.yslvlln.unikrypto

import com.goterl.lazycode.lazysodium.LazySodiumAndroid
import com.goterl.lazycode.lazysodium.SodiumAndroid
import com.goterl.lazycode.lazysodium.exceptions.SodiumException
import com.goterl.lazycode.lazysodium.utils.Key
import java.lang.Exception

object Unikrypto {
    val instance = LazySodiumAndroid(SodiumAndroid())

    fun krypt(key: String, message: String): String? {
        val seckey = Key.fromPlainString(key)
        return instance.cryptoSecretBoxEasy(message, ByteArray(24), seckey)
    }

    fun dekrypt(key: String, ciphertext: String): String? {
        val seckey = Key.fromPlainString(key)
        return instance.cryptoSecretBoxOpenEasy(ciphertext, ByteArray(24), seckey)
    }
}