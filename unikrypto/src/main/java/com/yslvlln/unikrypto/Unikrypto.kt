package com.yslvlln.unikrypto

import com.goterl.lazycode.lazysodium.LazySodiumAndroid
import com.goterl.lazycode.lazysodium.SodiumAndroid
import com.goterl.lazycode.lazysodium.exceptions.SodiumException
import com.goterl.lazycode.lazysodium.utils.Key
import java.lang.Exception

class Unikrypto {
    companion object {
        fun krypted(secretkey: Key, message: String, nonce: ByteArray): String? {
            val ls = LazySodiumAndroid(SodiumAndroid())
            try {
                val ciphertext = ls.cryptoSecretBoxEasy(message, nonce, secretkey)
                return ciphertext
            } catch (e: SodiumException) {
                e.printStackTrace()
                return null
            }
        }

        fun deckypted(secretKey: Key, ciphertext: String, nonce: ByteArray): String? {
            val ls = LazySodiumAndroid(SodiumAndroid())
            try {
                val plaintext = ls.cryptoSecretBoxOpenEasy(ciphertext, nonce, secretKey)
                return plaintext
            } catch (e: SodiumException) {
                e.printStackTrace()
                return null
            }
        }
    }
}