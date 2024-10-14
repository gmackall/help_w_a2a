pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        val flutterStorageUrl = System.getenv("FLUTTER_STORAGE_BASE_URL") ?: "https://storage.googleapis.com"
        maven("$flutterStorageUrl/download.flutter.io")
    }
}

rootProject.name = "My Application"
include(":app") // new
// println(rootProject.projectDir)
apply(from = File(settingsDir.parentFile.toString() + "/blahblah/.android/include_flutter.groovy"))

// apply from: settingsDir.parentFile.toString() + "/blahblah/.android/include_flutter.groovy"

// setBinding(new Binding([gradle: this]))
// evaluate(new File(                                                     // new
//    settingsDir.parentFile,                                            // new
// 'blahblah/.android/include_flutter.groovy'                   // new
// ))

// evalFile(File(settingsDir.parentFile.toString() + "/blahblah/.android/include_flutter.groovy"))

// getExtensions().findByName("ext").setProperty("gradles", this)
// apply(from = File(settingsDir.parentFile.toString() + "/blahblah/.android/include_flutter.groovy"))
