plugins {
    id("buildlogic.kotlin-application-conventions")
}

dependencies {
    implementation("org.apache.commons:commons-text")
    implementation(project(":utilities"))
    implementation("org.bouncycastle:bcprov-jdk15on:1.70")

}

application {
    mainClass = "org.key_generator.app.AppKt"
}
