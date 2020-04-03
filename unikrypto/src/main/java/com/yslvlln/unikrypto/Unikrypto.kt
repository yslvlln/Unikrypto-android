package com.yslvlln.unikrypto

import com.goterl.lazycode.lazysodium.LazySodiumAndroid
import com.goterl.lazycode.lazysodium.SodiumAndroid
import com.goterl.lazycode.lazysodium.exceptions.SodiumException
import com.goterl.lazycode.lazysodium.utils.Key
import java.lang.Exception

object Unikrypto {
    val instance = LazySodiumAndroid(SodiumAndroid())

    fun krypt(key: String, message: String): String? {
        if (instance != null)
            return "not null"
        else
            return "null"
    }

    fun dekrypt(key: String, ciphertext: String): String? {
        if (instance != null)
            return "not null"
        else
            return "null"
    }
}