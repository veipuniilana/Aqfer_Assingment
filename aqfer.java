import java.util.*;

public class VeipuniiLanaNg_1905057 {
    static int year1=0,year2,month1,month2,day1,day2,time1,time2;
    static List<Integer> month31 = new ArrayList<>();
    static boolean checkLeapYear(int year)
    {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        return year % 4 == 0;
    }
    static void printOutput(int year,int month, int day, int hour){
        String yr;
        String mn;
        String dy;
        String hr;
        yr = String.format("%04d",year);
        mn = String.format("%02d",month);
        dy = String.format("%02d",day);
        hr = String.format("%02d",hour);
        System.out.println(yr+mn+dy+" "+hr);
    }
    static void printOutput(int year,int month, int day){
        String yr;
        String mn;
        String dy;
        yr = String.format("%04d",year);
        mn = String.format("%02d",month);
        dy = String.format("%02d",day);
        System.out.println(yr+mn+dy);
    }
    static int countMaxdays(){
        if(month1==2 && checkLeapYear(year1)){
            return 29;
        }
        else if(month1==2 && !checkLeapYear(year1)){
            return 28;
        }
        else if(month31.contains(month1)){
            return 31;
        }
        else{
            return 30;
        }
    }
    static boolean convertStringToTimeDate(String str,int i){
        if(i==1){
            try{
                year1 = Integer.parseInt(str.substring(0,4));
                month1 = Integer.parseInt(str.substring(4,6));
                day1 = Integer.parseInt(str.substring(6,8));
                time1 = Integer.parseInt(str.substring(9,11));
            }
            catch(NumberFormatException ex){
                return false;
            }
        }
        else if(i==2){
            try {
                year2 = Integer.parseInt(str.substring(0,4));
                month2 = Integer.parseInt(str.substring(4,6));
                day2 = Integer.parseInt(str.substring(6,8));
                time2 = Integer.parseInt(str.substring(9,11));
            }
            catch(NumberFormatException ex){
                return false;
            }
        }
        return true;
    }
    static boolean onlyDigits(String str){
        int n =str.length();
        for (int i = 0; i < n; i++) {
            if (i!=8 && (str.charAt(i) < '0' || str.charAt(i) > '9')){
                return false;
            }
        }
        return true;
    }
    static boolean checkStringOneGreaterThanTwo(){
        if(year1>year2) return false;
        else if(year1==year2 && month1>month2) return false;
        else  if(year1==year2 && month1==month2 && day1>day2) return false;
        else return year1 != year2 || month1 != month2 || day1 != day2 || time1 <= time2;
    }
    static boolean validMonthDayHour(){
        if(month1>12 || month2>12){
            System.out.println("month cannot be greater than 12");
            return false;
        }
        if((month31.contains(month1) && day1>31) || (month31.contains(month2) && day2>31)){
            System.out.println("Invalid date(>31)");
            return false;
        }
        else if((month1==2 && checkLeapYear(year1) && day1>29) || (month1==2 && checkLeapYear(year2) && day2>29)){
            System.out.println("Invalid date(>29)");
            return false;
        }
        else if((month1==2 && !checkLeapYear(year1) && day1>28) || (month1==2 && !checkLeapYear(year2) && day2>28)){
            System.out.println("Invalid date(>28)");
            return false;
        }
        else if((day1>30 && !month31.contains(month1)) || (day2>30 && !month31.contains(month2))){
            System.out.println("Invalid date(>30)");
            return false;
        }
        return true;
    }
    boolean inputvalidation(String str1,String str2){
        if(str1.length()!=11 || str2.length()!=11){   //If the two string length are not equal and if one of them is !=11
            System.out.println("incorrect input format");
            return false;
        }
        if(str1.charAt(8)!=' '|| str2.charAt(8)!=' '){
            System.out.println("incorrect input format");
            return false;
        }
        if(!onlyDigits(str1)){
            System.out.println("String should contain only number");
            return false;
        }
        if(!onlyDigits(str2)){
            System.out.println("String should contain only number");
            return false;
        }
        if(!convertStringToTimeDate(str1,1)){
            System.out.println("You have Enter values other than numbers:");
            return false;
        }
        if(!convertStringToTimeDate(str2,2)){
            System.out.println("You have Enter values other than numbers:");
            return false;
        }
        if(!checkStringOneGreaterThanTwo()){
            System.out.println("String 1 cannot be greater than String 2");
            return false;
        }
        return validMonthDayHour();
    }
    static boolean mainFunctionForPrinting(){
        if(year2>year1 || month2>month1 || day2>day1){
            while(time1<=23){                                //for first day
                printOutput(year1,month1,day1,time1);
                time1++;
            }
            time1=0;
            day1++;
        }
        if(year1==year2 && month1==month2 && day1==day2 && time1<=time2){
            while(time1<=time2){
                printOutput(year1,month1,day1,time1);
                time1++;
            }
            return true;
        }

        while(year1<year2){
            while(month1<=12){
                int maxdays = countMaxdays();
                while(day1<=maxdays){
                    printOutput(year1,month1,day1);
                    day1++;
                }
                day1=1;
                month1++;
            }
            month1=1;
            year1++;
        }

        while(month1<month2){
            int maxday = countMaxdays();
            while(day1<=maxday){
                printOutput(year1,month1,day1);
                day1++;
            }
            day1=1;
            month1++;
        }
        while(day1<day2){
            printOutput(year1,month1,day1);
            day1++;
        }

        if(year1==year2 && month1==month2 && day1==day2 && time1<=time2){
            while(time1<=time2){
                printOutput(year1,month1,day1,time1);
                time1++;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        month31.addAll(Arrays.asList(1,3,5,7,8,10,12));
        VeipuniiLanaNg_1905057 ob = new VeipuniiLanaNg_1905057();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("Enter the string 1 in the format of 'yyyymmdd hh' : ");
            String str1 = sc.nextLine();
            System.out.print("Enter the string 2 in the format of 'yyyymmdd hh' : ");
            String str2 = sc.nextLine();
            if(ob.inputvalidation(str1,str2)){
                break;
            }
        }
        mainFunctionForPrinting();
    }
}



