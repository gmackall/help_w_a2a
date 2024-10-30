package com.example.myapplication

import android.app.Application
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class MyApplicationExample : Application() {
    var flutterEngine: FlutterEngine? = null

    override fun onCreate() {
        super.onCreate()
        // Instantiate a FlutterEngine.
        flutterEngine = FlutterEngine(this)

        // Start executing Dart code to pre-warm the FlutterEngine.
        flutterEngine!!
            .dartExecutor
            .executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault())

        FlutterEngineCache
            .getInstance()
            .put("my_engine_id", flutterEngine)
    }
}
