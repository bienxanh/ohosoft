package com.oho.bean;

import java.util.logging.Logger;

import com.oho.model.Pho;

public class NhapPho {

    private Pho           data;

    private static Logger log = Logger.getLogger(NhapPho.class.getSimpleName());

    public Pho getData() {
        return data;
    }

    public void setData(Pho data) {
        this.data = data;
    }

}
