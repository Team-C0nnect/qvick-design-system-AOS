// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsKotlinAndroid) apply false
    id("maven-publish")
}

//afterEvaluate {
//    publishing {
//        publications {
//            register<MavenPublication>("release") {
//                // Use the correct component name
//                from(components["release"])
//
//                groupId = "com.github.C0nnect"
//                artifactId = "qvick-design-system-AOS"
//                version = "1.0.0"
//
//                pom {
//                    name.set("qvick-design-system")
//                    description.set("Qvick Design System for Android")
//                }
//            }
//        }
//    }
//}

publishing {
    publications {
        create("release", MavenPublication::class) {
            groupId = "com.github.C0nnect"
            artifactId = "qvick-design-system-AOS"
            version = "1.0.1"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}