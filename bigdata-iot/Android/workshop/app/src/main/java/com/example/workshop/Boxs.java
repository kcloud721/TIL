package com.example.workshop;

public class Boxs {
    int rank;
    String movieNm;

    public Boxs() {
    }

    public Boxs(int rank, String movieNm) {
        this.rank = rank;
        this.movieNm = movieNm;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getMovieNm() {
        return movieNm;
    }

    public void setMovieNm(String movieNm) {
        this.movieNm = movieNm;
    }
}

