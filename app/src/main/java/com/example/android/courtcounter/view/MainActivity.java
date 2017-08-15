/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.courtcounter.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.android.courtcounter.R;
import com.example.android.courtcounter.model.ScoreViewModel;
import com.example.android.courtcounter.presenter.MainPresenterImpl;
import com.example.android.courtcounter.repository.MainRepositoryImpl;

/**
 * This activity keeps track of the basketball score for 2 teams.
 */
public class MainActivity extends AppCompatActivity implements MainView{
    ScoreViewModel viewModel;

    TextView scoreViewA;
    TextView scoreViewB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);

        scoreViewA = (TextView) findViewById(R.id.team_a_score);
        scoreViewB = (TextView) findViewById(R.id.team_b_score);

        if (viewModel.getPresenter() == null){
            viewModel.setPresenter(new MainPresenterImpl(new MainRepositoryImpl(), viewModel));
            viewModel.getPresenter().setView(this);
        } else {
            viewModel.getPresenter().updateView(this);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimpSlifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        viewModel.getPresenter().addScoreTeamA(1);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        viewModel.getPresenter().addScoreTeamA(2);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        viewModel.getPresenter().addScoreTeamA(3);
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        viewModel.getPresenter().addScoreTeamB(1);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        viewModel.getPresenter().addScoreTeamB(2);
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        viewModel.getPresenter().addScoreTeamB(3);
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        viewModel.getPresenter().resetScores();
    }

    @Override
    public void displayTeamAScore(int score) {
        scoreViewA.setText(String.valueOf(score));
    }

    @Override
    public void displayTeamBScore(int score) {
        scoreViewB.setText(String.valueOf(score));
    }
}
