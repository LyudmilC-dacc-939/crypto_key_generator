package org.key_generator.app

import java.security.*
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import java.util.Base64
import kotlin.system.exitProcess

fun main() {
    while (true) {
        println("Select the algorithm to generate keys:")
        println("1. HMAC")
        println("2. RSA")
        println("3. EC")
        println("4. Exit")
        print("Your choice: ")
        when (readLine()) {
            "1" -> generateHmacKey()
            "2" -> generateRsaKeyPair()
            "3" -> generateEcKeyPair()
            "4" -> {
                println("Exiting...")
                exitProcess(0)
            }
            else -> println("Invalid choice. Please try again.")
        }
    }
}

private fun generateHmacKey() {
    val algorithm = selectHashAlgorithm("HMAC")
    val keyGen = KeyGenerator.getInstance(algorithm)
    val secretKey: SecretKey = keyGen.generateKey()
    println("HMAC Key (${algorithm}): ${Base64.getEncoder().encodeToString(secretKey.encoded)}")
}

private fun generateRsaKeyPair() {
    val keySize = selectKeySize()
    val keyPairGen = KeyPairGenerator.getInstance("RSA")
    keyPairGen.initialize(keySize)
    val keyPair = keyPairGen.generateKeyPair()
    println("RSA Private Key (${keySize} bits): ${Base64.getEncoder().encodeToString(keyPair.private.encoded)}")
    println("RSA Public Key (${keySize} bits): ${Base64.getEncoder().encodeToString(keyPair.public.encoded)}")
}

private fun generateEcKeyPair() {
    val algorithm = selectEcAlgorithm()
    val keyPairGen = KeyPairGenerator.getInstance(algorithm, "BC")
    keyPairGen.initialize(256)
    val keyPair = keyPairGen.generateKeyPair()
    println("EC Private Key: ${Base64.getEncoder().encodeToString(keyPair.private.encoded)}")
    println("EC Public Key: ${Base64.getEncoder().encodeToString(keyPair.public.encoded)}")
}

private fun selectHashAlgorithm(type: String): String {
    println("Select the hash algorithm:")
    println("1. ${type}SHA256")
    println("2. ${type}SHA384")
    println("3. ${type}SHA512")
    print("Your choice: ")
    return when (readLine()) {
        "1" -> "${type}SHA256"
        "2" -> "${type}SHA384"
        "3" -> "${type}SHA512"
        else -> {
            println("Invalid choice. Defaulting to ${type}SHA256.")
            "${type}SHA256"
        }
    }
}

private fun selectKeySize(): Int {
    println("Select RSA key size:")
    println("1. 2048 bits")
    println("2. 4096 bits")
    print("Your choice: ")
    return when (readLine()) {
        "1" -> 2048
        "2" -> 4096
        else -> {
            println("Invalid choice. Defaulting to 2048 bits.")
            2048
        }
    }
}

private fun selectEcAlgorithm(): String {
    println("Select EC algorithm:")
    println("1. ECDSA")
    println("2. ECIES")
    print("Your choice: ")
    return when (readLine()) {
        "1" -> "ECDSA"
        "2" -> "ECIES"
        else -> {
            println("Invalid choice. Defaulting to ECDSA.")
            "ECDSA"
        }
    }
}
