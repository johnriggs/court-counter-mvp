package com.example.android.courtcounter.presenter;

import com.example.android.courtcounter.model.ScoreViewModel;
import com.example.android.courtcounter.repository.MainRepository;
import com.example.android.courtcounter.view.MainView;

/**
 * Created by johnriggs on 8/15/17.
 */

public class MainPresenterImpl implements MainPresenter {
    ScoreViewModel viewModel;
    MainRepository repo;
    MainView view;

    public MainPresenterImpl(MainRepository repo, ScoreViewModel viewModel){
        this.repo = repo;
        this.viewModel = viewModel;
    }

    @Override
    public void setView(MainView view){
        this.view = view;

        //First time initialization of views
        initializeViews();
    }

    @Override
    public void updateView(MainView view){
        this.view = view;

        //Update only the views we need to
        updateViews();
    }

    private void initializeViews(){
        view.displayTeamAScore(viewModel.getScoreTeamA());
        view.displayTeamBScore(viewModel.getScoreTeamB());
    }

    private void updateViews(){
        view.displayTeamAScore(viewModel.getScoreTeamA());
        view.displayTeamBScore(viewModel.getScoreTeamB());
    }

    @Override
    public void addScoreTeamA(int points) {
        viewModel.setScoreTeamA(viewModel.getScoreTeamA() + points);
        view.displayTeamAScore(viewModel.getScoreTeamA());
    }

    @Override
    public void addScoreTeamB(int points) {
        viewModel.setScoreTeamB(viewModel.getScoreTeamB() + points);
        view.displayTeamBScore(viewModel.getScoreTeamB());
    }

    @Override
    public void resetScores() {
        viewModel.setScoreTeamA(0);
        viewModel.setScoreTeamB(0);
        view.displayTeamAScore(viewModel.getScoreTeamA());
        view.displayTeamBScore(viewModel.getScoreTeamB());
    }
}
