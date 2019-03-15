import org.jetbrains.kotlin.gradle.frontend.KotlinFrontendExtension
import org.jetbrains.kotlin.gradle.frontend.npm.NpmExtension
import org.jetbrains.kotlin.gradle.frontend.webpack.WebPackExtension
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

group = "com.analytics"
version = "0.0.1"
description = "analytics-frontend"

@Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
buildscript {
    var kotlinVersion: String by extra
    kotlinVersion = "1.3.20"

    repositories {
        jcenter()

        maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }

    }

    dependencies {
        classpath(kotlin("gradle-plugin", kotlinVersion))
        classpath("org.jetbrains.kotlin:kotlin-frontend-plugin:0.0.44")
    }
}

apply {
    plugin("kotlin2js")
    plugin("kotlin-dce-js")
    plugin("org.jetbrains.kotlin.frontend")
}

plugins {
    java // Not sure why this is needed, but it makes "compile(...)" lines down below work
    id("com.moowork.node") version "1.2.0"
}

val kotlinVersion: String by extra

repositories {
    jcenter()
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-dev") }
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-js-wrappers") }
    maven { setUrl("https://dl.bintray.com/cfraser/muirwik") }
    maven { setUrl("https://kotlin.bintray.com/kotlinx") }
    mavenLocal()
}

dependencies {
    implementation(kotlin("stdlib-js", kotlinVersion))
    implementation("org.jetbrains", "kotlin-react", "16.6.0-pre.67-kotlin-$kotlinVersion")
    implementation("org.jetbrains", "kotlin-react-dom", "16.6.0-pre.67-kotlin-$kotlinVersion")
    implementation("org.jetbrains:kotlin-react-router-dom:4.3.1-pre.67-kotlin-1.3.20")
    implementation("org.jetbrains", "kotlin-styled", "1.0.0-pre.67-kotlin-$kotlinVersion")
    implementation("com.ccfraser.muirwik:muirwik-components:0.2.1")
    implementation("com.analytics:analytics-core-node:0.0.1")
}

val compileKotlin2Js: Kotlin2JsCompile by tasks
compileKotlin2Js.kotlinOptions {
    sourceMap = true
    metaInfo = true
    outputFile = "${project.buildDir.path}/js/app.js"
    main = "call"
    moduleKind = "commonjs"
}

configure<KotlinFrontendExtension> {

    downloadNodeJsVersion = "latest"

    define("PRODUCTION", true)

    bundle("webpack", delegateClosureOf<WebPackExtension>{
        bundleName = "main"
        sourceMapEnabled = true
        mode = "development"
        contentPath = File("./public/")
        publicPath = "/"
        port = 9000
        bundlesDirectory = "$buildDir/resources/main/scripts/"
    })

    configure<NpmExtension> {
        dependency("@material-ui/core", "3.9.1")
        dependency("@material-ui/icons", "3.0.2")
        dependency("react", "16.6.3")
        dependency("react-dom", "16.6.3")
        dependency("react-router-dom", "4.3.1")
        dependency("styled-components", "3.4.10")
        dependency("kotlinx-coroutines-core", "1.1.1")
        dependency("node-fetch", "2.3.0")
        dependency("text-encoding", "0.7.0")
        dependency("core-js", "2.6.4")
        dependency("react-youtube", "7.9.0")

        devDependency("style-loader", "0.23.1")
        devDependency("css-loader", "2.1.0")
        devDependency("inline-style-prefixer", "5.0.3")
        devDependency("react-hot-loader", "4.7.0")
        devDependency("uglifyjs-3-webpack-plugin", "1.2.4")
    }
}
