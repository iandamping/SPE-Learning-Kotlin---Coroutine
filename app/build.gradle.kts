import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.android.build.gradle.internal.dsl.BuildType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.application")
    id("androidx.navigation.safeargs")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(28)
    buildToolsVersion("29.0.1")
    defaultConfig {
        applicationId = "com.ian.junemon.spe_learning_mvvm"
        minSdkVersion(16)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        initDebug(this@android)
        initRelease(this@android)
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_1_10
        targetCompatibility = JavaVersion.VERSION_1_10
    }
    dataBinding {
        isEnabled = true
    }

}
tasks.withType <KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(CoreLibraries.kotlinStdLib)
    implementation(CoreLibraries.appCompatStdLib)
    implementation(CoreLibraries.androidXCoreStdLib)
    implementation(CoreLibraries.constraintLayoutStdLib)
    implementation(CoreLibraries.materialDesignStdLib)
    implementation(CoreLibraries.multidexStdLib)
    testImplementation(TestLibraries.jUnit4StdLib)
    testImplementation(TestLibraries.mockitoCoreStdLib)
    androidTestImplementation(TestLibraries.testRunnerStdLib)
    androidTestImplementation(TestLibraries.espressoCoreStdLib)
    implementation(CustomLibraries.commonHelperStdLib)
    implementation(NavigationLibraies.navigationStdLib)
    implementation(NavigationLibraies.navigationUiStdLib)
    implementation(WorkerLibrary.workManagerStdLib)
    implementation(KoinLibraries.koinStdLib)
    implementation(project(":movie"))
    implementation(project(":tvshow"))
    implementation(project(":data"))
}

fun NamedDomainObjectContainer<BuildType>.initDebug(proguard: BaseAppModuleExtension) {
    this.getByName("debug") {
        isMinifyEnabled = false
        isShrinkResources = false
        proguardFiles(proguard.getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
}

fun NamedDomainObjectContainer<BuildType>.initRelease(proguard: BaseAppModuleExtension) {
    this.getByName("release") {
        isMinifyEnabled = false
        isShrinkResources = false
        proguardFiles(proguard.getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
}
