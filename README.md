# jwt_key_generator

This Kotlin-based Key Generator Utility allows users to generate cryptographic keys using various algorithms, including HMAC, RSA, and Elliptic Curve (EC). The utility provides options for different key sizes and hash algorithms, enabling secure and flexible key generation.

## Features
Algorithm Options: 

- Choose from HMAC, RSA, and EC (Elliptic Curve).
- Hash Variants: Generate HMAC keys with SHA-256, SHA-384, or SHA-512.
- RSA Key Sizes: Choose between 2048 and 4096 bits for RSA key generation.
- Elliptic Curve: Generate EC keys with ECDSA or ECIES.

### Prerequisites:
- JDK 17 or higher
- Gradle for building the project
- Bouncy Castle dependency for extended cryptographic support

## Installation
Clone the repository:

1. git clone https://github.com/LyudmilC-dacc-939/jwt_key_generator.git
cd jwt_key_generator

2. Add the following dependency to build.gradle.kts:

dependencies {
implementation("org.bouncycastle:bcprov-jdk18on:1.79")
}

3. Make sure mavenCentral() is in the repositories section:

repositories {
mavenCentral()
}

## Building the Project
To build the project, use:

- ./gradlew build

To run the application, use:

- ./gradlew run

## Usage

After starting the program, follow the on-screen prompts to select your desired cryptographic algorithm and options. The program will guide you through:

Algorithm Selection: Choose one of the following options:

1. HMAC (with SHA-256, SHA-384, SHA-512)
2. RSA (2048 or 4096 bits)
3. EC (Elliptic Curve options such as ECDSA and ECIES)
Key Generation: The program will generate the selected key and display it in Base64 format for easy copying.