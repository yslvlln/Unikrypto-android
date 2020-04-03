package com.yslvlln.unikrypto

import com.goterl.lazycode.lazysodium.LazySodiumAndroid
import com.goterl.lazycode.lazysodium.SodiumAndroid
import com.goterl.lazycode.lazysodium.exceptions.SodiumException
import com.goterl.lazycode.lazysodium.utils.Key
import java.lang.Exception

object Unikrypto {
    private var instance: LazySodiumAndroid? = null

    fun init() {
        instance = LazySodiumAndroid(SodiumAndroid())
    }

    fun krypt(ls: LazySodiumAndroid, secretkey: Key, message: String): String? {
        try {
            val ciphertext = ls.cryptoSecretBoxEasy(message, ByteArray(24), secretkey)
            return ciphertext
        } catch (e: SodiumException) {
            e.printStackTrace()
            return null
        }
    }

    fun dekrypt(ls: LazySodiumAndroid, secretKey: Key, ciphertext: String): String? {
        try {
            val plaintext = ls.cryptoSecretBoxOpenEasy(ciphertext, ByteArray(24), secretKey)
            return plaintext
        } catch (e: SodiumException) {
            e.printStackTrace()
            return null
        }
    }
}