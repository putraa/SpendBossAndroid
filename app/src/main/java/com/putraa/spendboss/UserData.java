package com.putraa.spendboss;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserData {

    private int _id;
    private Date _date;
    private int _daysafter;
    private float _hand;
    private float _bank;
    private float _spending;
    private float _additional;
    private float _cutters;
    private float _work;
    private boolean _skip;
    private String _notes;

    public UserData() {
    }

    public UserData(String bank, String hand, String date, String work, String additional, String cutters) {

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date startDate;
        try {
            startDate = df.parse(date);
            this._date = startDate;
        } catch (ParseException e) {
            this._date = null;
            e.printStackTrace();
        }

        this._daysafter = 1;
        this._hand = Float.parseFloat(hand);
        this._bank = Float.parseFloat(bank);
        this._spending = 1;
        this._additional = Float.parseFloat(additional);
        this._cutters = Float.parseFloat(cutters);
        this._work = Float.parseFloat(work);
        this._skip = false;
        this._notes = "test";


    }

    // Setters
    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_date(Date _date) {
        this._date = _date;
    }

    public void set_daysafter(int _daysafter) {
        this._daysafter = _daysafter;
    }

    public void set_hand(float _hand) {
        this._hand = _hand;
    }

    public void set_bank(float _bank) {
        this._bank = _bank;
    }

    public void set_spending(float _spending) {
        this._spending = _spending;
    }

    public void set_additional(float _additional) {
        this._additional = _additional;
    }

    public void set_cutters(float _cutters) {
        this._cutters = _cutters;
    }

    public void set_work(float _work) {
        this._work = _work;
    }

    public void set_skip(boolean _skip) {
        this._skip = _skip;
    }

    public void set_notes(String _notes) {
        this._notes = _notes;
    }

    // Getters
    public int get_id() {
        return _id;
    }

    public Date get_date() {
        return _date;
    }

    public int get_daysafter() {
        return _daysafter;
    }

    public float get_hand() {
        return _hand;
    }

    public float get_bank() {
        return _bank;
    }

    public float get_spending() {
        return _spending;
    }

    public float get_additional() {
        return _additional;
    }

    public float get_cutters() {
        return _cutters;
    }

    public float get_work() {
        return _work;
    }

    public boolean is_skip() {
        return _skip;
    }

    public String get_notes() {
        return _notes;
    }
}
