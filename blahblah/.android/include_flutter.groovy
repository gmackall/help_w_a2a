//def scriptFile = getClass().protectionDomain.codeSource.location.toURI()
//def flutterProjectRoot = new File(scriptFile).parentFile.parentFile
def flutterProjectRoot = new File(rootProject.projectDir.toString() + "/../blahblah/")

include(":flutter")
project(":flutter").projectDir = new File(flutterProjectRoot, ".android/Flutter")
println("HI GRAY, project dir is " + flutterProjectRoot)
println("HI GRAY, other dir is " + rootProject.projectDir)

def localPropertiesFile = new File(flutterProjectRoot, ".android/local.properties")
def properties = new Properties()

assert localPropertiesFile.exists(), "❗️The Flutter module doesn't have a `$localPropertiesFile` file." +
                                     "\nYou must run `flutter pub get` in `$flutterProjectRoot`."
localPropertiesFile.withReader("UTF-8") { reader -> properties.load(reader) }

def flutterSdkPath = properties.getProperty("flutter.sdk")
assert flutterSdkPath != null, "flutter.sdk not set in local.properties"
println("HI GRAY, made it here")
apply from: "$flutterSdkPath/packages/flutter_tools/gradle/module_plugin_loader.gradle"
