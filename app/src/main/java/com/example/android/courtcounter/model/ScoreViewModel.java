package com.example.android.courtcounter.model;

import android.arch.lifecycle.ViewModel;

import com.example.android.courtcounter.presenter.MainPresenter;

/**
 * Created by johnriggs on 8/15/17.
 */

public class ScoreViewModel extends ViewModel {
    private MainPresenter presenter;
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    public int getScoreTeamA() {
        return scoreTeamA;
    }

    public void setScoreTeamA(int scoreTeamA) {
        this.scoreTeamA = scoreTeamA;
    }

    public int getScoreTeamB() {
        return scoreTeamB;
    }

    public void setScoreTeamB(int scoreTeamB) {
        this.scoreTeamB = scoreTeamB;
    }

    public MainPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(MainPresenter presenter) {
        this.presenter = presenter;
    }


}
