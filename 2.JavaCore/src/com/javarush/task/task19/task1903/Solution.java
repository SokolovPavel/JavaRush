package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    public static void main(String[] args) {
        Contact contact = new IncomeDataAdapter(new IncomeDataS());
        System.out.println(contact.getPhoneNumber());
    }

    public static class IncomeDataS implements IncomeData{
        public String getCountryCode(){return "UA";}       //example UA

        public String getCompany(){return " ";}            //example JavaRush Ltd.

        public String getContactFirstName(){return " ";}   //example Ivan

        public String getContactLastName(){return " ";}    //example Ivanov

        public int getCountryPhoneCode(){return 38;}      //example 38

        public int getPhoneNumber(){return 501234567;}          //example 501234567
    }

    public static class IncomeDataAdapter implements Customer,Contact{
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data){
            this.data = data;
        }

        public String getCompanyName(){
            return data.getCompany();
        }
        public String getCountryName(){
            return countries.get(data.getCountryCode());
        }

        public String getName(){
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        public String getPhoneNumber(){
            String phone = ((Integer)data.getPhoneNumber()).toString();
            for(;phone.length()<10;)phone = "0"+phone;
            phone = "(" + phone.substring(0,3) + ")" + phone.substring(3,6) + "-" + phone.substring(6,8) + "-" + phone.substring(8,10);
            return "+" + data.getCountryPhoneCode() + phone;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}