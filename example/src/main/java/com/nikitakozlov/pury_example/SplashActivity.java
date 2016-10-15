package com.nikitakozlov.pury_example;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;

import com.nikitakozlov.pury.Pury;
import com.nikitakozlov.pury.annotations.StartProfiling;
import com.nikitakozlov.pury.annotations.StopProfiling;
import com.nikitakozlov.pury.Logger;
import com.nikitakozlov.pury_example.profilers.StartApp;

public class SplashActivity extends AppCompatActivity {

    @StartProfiling(profilerName = StartApp.PROFILER_NAME, stageName = StartApp.TOP_STAGE,
            stageOrder = StartApp.TOP_STAGE_ORDER)
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @StartProfiling(profilerName = StartApp.PROFILER_NAME, stageName = StartApp.SPLASH_SCREEN,
            stageOrder = StartApp.SPLASH_SCREEN_ORDER)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        loadData();
        testPuryNoOp();
    }

    /**
     * This method does nothing. It is here to test no-op version.
     */
    private void testPuryNoOp() {
        String testNoopProfilerName = "Test noop";

        Pury.getLogger();
        Pury.isEnabled();
        Pury.setEnabled(true);
        Pury.startProfiling(testNoopProfilerName, "", 0, 1);
        Pury.stopProfiling(testNoopProfilerName, "", 1);
        Pury.setLogger(new Logger() {
            @Override
            public void result(String s, String s1) {

            }

            @Override
            public void warning(String s, String s1) {

            }

            @Override
            public void error(String s, String s1) {

            }
        });
        Pury.setLogger(null);
    }

    @StartProfiling(profilerName = StartApp.PROFILER_NAME, stageName = StartApp.SPLASH_LOAD_DATA,
            stageOrder = StartApp.SPLASH_LOAD_DATA_ORDER)
    private void loadData() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                onDataLoaded();
                startMainActivity();
            }
        }, 1000);
    }

    @StopProfiling(profilerName = StartApp.PROFILER_NAME, stageName = StartApp.SPLASH_SCREEN)
    private void onDataLoaded() {

    }

    @StartProfiling(profilerName = StartApp.PROFILER_NAME, stageName = StartApp.MAIN_ACTIVITY_LAUNCH,
            stageOrder = StartApp.MAIN_ACTIVITY_LAUNCH_ORDER)
    private void startMainActivity() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
    }
}
