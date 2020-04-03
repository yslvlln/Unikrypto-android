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

    fun krypted(secretkey: Key, message: String, nonce: ByteArray): String? {
        try {
            val ciphertext = instance!!.cryptoSecretBoxEasy(message, nonce, secretkey)
            return ciphertext
        } catch (e: SodiumException) {
            e.printStackTrace()
            return null
        }
    }

    fun deckypted(secretKey: Key, ciphertext: String, nonce: ByteArray): String? {
        try {
            val plaintext = instance!!.cryptoSecretBoxOpenEasy(ciphertext, nonce, secretKey)
            return plaintext
        } catch (e: SodiumException) {
            e.printStackTrace()
            return null
        }
    }
}