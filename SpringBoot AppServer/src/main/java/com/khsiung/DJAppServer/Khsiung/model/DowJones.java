package com.khsiung.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection="dow_jones")
public class DowJones {

    @Id
    private String id;
    private String quarter;
    private String stock;
    private String date;
    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;
    private String percent_change_price;
    private String percent_change_volume_over_last_wk;
    private String previous_weeks_volume;
    private String next_weeks_open;
    private String next_weeks_close;
    private String percent_change_next_weeks_price;
    private String days_to_next_dividend;
    private String percent_return_next_dividend;


    public DowJones(String quarter,String stock,String date,String open,String high,String low,String close,String volume,String percent_change_price,String percent_change_volume_over_last_wk,String previous_weeks_volume,String next_weeks_open,String next_weeks_close,String percent_change_next_weeks_price,String days_to_next_dividend,String percent_return_next_dividend) {
        this.quarter = quarter;
        this.stock = stock;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.percent_change_price = percent_change_price;
        this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
        this.previous_weeks_volume = previous_weeks_volume;
        this.next_weeks_open = next_weeks_open;
        this.next_weeks_close = next_weeks_close;
        this.percent_change_next_weeks_price = percent_change_next_weeks_price;
        this.days_to_next_dividend = days_to_next_dividend;
        this.percent_return_next_dividend = percent_return_next_dividend;
    }

    public String getid(){
        return id;
    }
    public String getquarter(){
        return quarter;
    }
    public String getstock(){
        return stock;
    }
    public String getdate(){
        return date;
    }
    public String getopen(){
        return open;
    }
    public String gethigh(){
        return high;
    }
    public String getlow(){
        return low;
    }
    public String getclose(){
        return close;
    }
    public String getvolume(){
        return volume;
    }
    public String getpercent_change_price(){
        return percent_change_price;
    }
    public String getpercent_change_volume_over_last_wk(){
        return percent_change_volume_over_last_wk;
    }
    public String getprevious_weeks_volume(){
        return previous_weeks_volume;
    }
    public String getnext_weeks_open(){
        return next_weeks_open;
    }
    public String getnext_weeks_close(){
        return next_weeks_close;
    }
    public String getpercent_change_next_weeks_price(){
        return percent_change_next_weeks_price;
    }
    public String getdays_to_next_dividend(){
        return days_to_next_dividend;
    }
    public String getpercent_return_next_dividend(){
        return percent_return_next_dividend;
    }


    public void setid(String id){
        this.id = id;
    }
    public void setquarter(String quarter){
        this.quarter = quarter;
    }
    public void setstock(String stock){
        this.stock = stock;
    }
    public void setdate(String date){
        this.date = date;
    }
    public void setopen(String open){
        this.open = open;
    }
    public void sethigh(String high){
        this.high = high;
    }
    public void setlow(String low){
        this.low = low;
    }
    public void setclose(String close){
        this.close = close;
    }
    public void setvolume(String volume){
        this.volume = volume;
    }
    public void setpercent_change_price(String percent_change_price){
        this.percent_change_price = percent_change_price;
    }
    public void setpercent_change_volume_over_last_wk(String percent_change_volume_over_last_wk){
        this.percent_change_volume_over_last_wk = percent_change_volume_over_last_wk;
    }
    public void setprevious_weeks_volume(String previous_weeks_volume){
        this.previous_weeks_volume = previous_weeks_volume;
    }
    public void setnext_weeks_open(String next_weeks_open){
        this.next_weeks_open = next_weeks_open;
    }
    public void setnext_weeks_close(String next_weeks_close){
        this.next_weeks_close = next_weeks_close;
    }
    public void setpercent_change_next_weeks_price(String percent_change_next_weeks_price){
        this.percent_change_next_weeks_price = percent_change_next_weeks_price;
    }
    public void setdays_to_next_dividend(String days_to_next_dividend){
        this.days_to_next_dividend = days_to_next_dividend;
    }
    public void setpercent_return_next_dividend(String percent_return_next_dividend){
        this.percent_return_next_dividend = percent_return_next_dividend;
    }


}