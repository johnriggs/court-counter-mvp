package com.example.android.courtcounter.presenter;

import com.example.android.courtcounter.view.MainView;

/**
 * Created by johnriggs on 8/15/17.
 */

public interface MainPresenter {
    void setView(MainView view);
    void updateView(MainView view);
    void addScoreTeamA(int points);
    void addScoreTeamB(int points);
    void resetScores();
}
