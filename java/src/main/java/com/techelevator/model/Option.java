package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class Option {
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String optionE;
    private String optionF;
    private String optionG;
    private String optionH;
    private List<Option> optionList = new ArrayList<>();

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }

    public String getOptionA(String option_a) {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB(String option_b) {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC(String option_c) {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD(String option_d) {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getOptionE(String option_e) {
        return optionE;
    }

    public void setOptionE(String optionE) {
        this.optionE = optionE;
    }

    public String getOptionF(String option_f) {
        return optionF;
    }

    public void setOptionF(String optionF) {
        this.optionF = optionF;
    }

    public String getOptionG(String option_g) {
        return optionG;
    }

    public void setOptionG(String optionG) {
        this.optionG = optionG;
    }

    public String getOptionH(String option_h) {
        return optionH;
    }

    public void setOptionH(String optionH) {
        this.optionH = optionH;
    }
}
