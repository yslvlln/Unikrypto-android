package com.yslvlln.unikrypto

import com.goterl.lazycode.lazysodium.LazySodiumAndroid
import com.goterl.lazycode.lazysodium.SodiumAndroid
import com.goterl.lazycode.lazysodium.exceptions.SodiumException
import com.goterl.lazycode.lazysodium.utils.Key
import java.lang.Exception

class Unikrypto {
    companion object {
        lateinit var ls: LazySodiumAndroid
        fun init() {
            ls = LazySodiumAndroid(SodiumAndroid())
        }
        fun krypted(secretkey: Key,  message: String, nonce: ByteArray): String? {
            if (ls != null) {
                try {
                    val ciphertext = ls.cryptoSecretBoxEasy(message, nonce, secretkey)
                    return ciphertext
                } catch (e: SodiumException) {
                    e.printStackTrace()
                    return null
                }
            } else
                throw Exception("Error initialization")

        }
        fun deckypted(secretKey: Key, ciphertext: String, nonce: ByteArray): String? {
            if (ls != null) {
                try {
                    val plaintext = ls.cryptoSecretBoxOpenEasy(ciphertext, nonce, secretKey)
                    return plaintext
                } catch (e: SodiumException) {
                    e.printStackTrace()
                    return null
                }
            } else
                throw Exception("Error initialization")
        }
    }
}