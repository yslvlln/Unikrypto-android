package com.yslvlln.unikrypto

import com.goterl.lazycode.lazysodium.LazySodiumAndroid
import com.goterl.lazycode.lazysodium.SodiumAndroid
import com.goterl.lazycode.lazysodium.exceptions.SodiumException
import com.goterl.lazycode.lazysodium.utils.Key
import java.lang.Exception

class Unikrypto {
    companion object {
        private var ls: LazySodiumAndroid
        init {
            ls = LazySodiumAndroid(SodiumAndroid())
        }
        fun krypted(secretKey: String,  message: String, nonce: ByteArray): String? {
            if (ls != null) {
                val key = Key.fromPlainString(secretKey)
                try {
                    val ciphertext = ls.cryptoSecretBoxEasy(message, nonce, key)
                    return ciphertext
                } catch (e: SodiumException) {
                    e.printStackTrace()
                    return null
                }
            } else
                throw Exception("Error initialization")

        }
        fun deckypted(secretKey: String, ciphertext: String, nonce: ByteArray): String? {
            if (ls != null) {
                val key = Key.fromPlainString(secretKey)
                try {
                    val plaintext = ls.cryptoSecretBoxOpenEasy(ciphertext, nonce, key)
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