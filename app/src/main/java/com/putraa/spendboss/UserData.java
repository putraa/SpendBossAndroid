package com.putraa.spendboss;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SpendBoss Android - UserData
 * This file get the variables on user input and verify them
 * before they are stored in the database.
 *
 * ID variable is not here because it is auto increment
 *
 * Here user will be able to:
 * - overview their data in graphical format
 * - navigate to add/remove
 * - navigate to setting
 * - sign out
 *
 * @author Adrian Pratama Putra
 * @version 0.1
 * @since 2017-01-23
 */

public class UserData {

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

    public UserData(String bank, String hand, String date, String work, String additional, String cutters) {
        /* Verify the data before passing it to another method */
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

    /** Getters
     * list of methods that will be used to return specific variable
     * This will be more improved in the up-coming updates */

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
