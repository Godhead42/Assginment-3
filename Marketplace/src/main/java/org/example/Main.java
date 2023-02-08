package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.format;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static final ElectronicDB ElectronicDB = new ElectronicDB();

    private static final Statement statement;

    private static User user;
    private static Cart cart;
    private static ArrayList<?> arrayList;

    static {
        try {
            statement = ElectronicDB.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        StartMarketPlace();
    }


    public static void StartMarketPlace () { //start of the marketplace where user choose what to do
        System.out.println("MarketPlace\n" +
                "1.\tSearch item by filters\n" +
                "2.\tSignin\n" +
                "3.\tShow cart!\n");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose) {
            case 1: Filters(); //call method that shows methods
            case 2: signIn();
            case 3: System.out.println(cart.toString());
        }
    }

    private static void signIn() {
        System.out.println("MarketPlace\n" +
                "1.\tRegistration\n" +
                "2.\tLogin\n" +
                "3.\tBack\n");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose) {
            case 1:
                Registration reg = new Registration();
                reg.registration();
                if(reg.user != null){
                    user = reg.user;
                    System.out.println("You have been sucsessfully registrated!");
                    StartMarketPlace();
                    cart = new Cart(user);
                }
            case 2:
                Login log = new Login();
                log.login();
                if(log.user != null){
                    System.out.println("You have been successfully login!");
                    user = log.user;
                    cart = new Cart(user);
                }else{
                    System.out.println("Try again!");
                }
            case 3: StartMarketPlace();
        }
    }

    public static void Filters () {
        System.out.println("\n" +
                "1.\tPhone\n" +
                "2.\tComputer\n" +
                "3.\tTablets\n" +
                "4.\tOther devices\n" +
                "5.\tGo back!\n" +
                "\n"); //shows all items of electronics
        int n = scanner.nextInt();
        scanner.nextLine();
        switch (n) {
            case 1: PhoneFilters();//calls method that shows users phone filters(smart or nonsmartphones)
            case 2: ComputerFilter();
            case 3:TabletFilter();
            case 4:
                ArrayList<ElectronicOtherDevices> other = new ArrayList<ElectronicOtherDevices>();
                sql("SELECT * FROM otherelectronic",other,"other");
            case 5: StartMarketPlace(); //return user to previous method
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////Phone filters////////////////////////////////////////////////////////////////
    public static void PhoneFilters () {
        System.out.println("1.\tShow Phones\n" +
                "2.\tAdd filter Smartphones\n" +
                "3.\tAdd filter Non-SmartPhones\n" +
                "4.\tGo Back\n");
        int n = scanner.nextInt();
        scanner.nextLine();
        switch (n) {
            case 1:
                ArrayList<Phone> Phones = new ArrayList<Phone>();
                sql("SELECT * FROM phones", Phones,"phone");
                BuyItem();
                //shows all phones
            case 2:
                PhoneSmartphoneFilter();//add filter of smartphones
            case 3:
                ArrayList<NonSmartphone> nonSmartphones = new ArrayList<NonSmartphone>();
                sql("SELECT * FROM phones WHERE phoneCategory = 'Non-smart phone'", nonSmartphones,"phone");//add filter of non-smartphones //do later
                BuyItem();
            case 4:
                Filters(); //return previous method
        }
    }

    public static void PhoneSmartphoneFilter () {
        System.out.println(
                "1.\tShow Phones\n" +
                        "2.\tIphone\n" +
                        "3.\tSamsung\n" +
                        "4.\tXiaomi\n" +
                        "5.\tOther Brands\n" +
                        "6.\tGo Back\n");
        int n = scanner.nextInt();
        scanner.nextLine();
        switch (n) {
            case 1:
                ArrayList<Smartphone> smartPhones = new ArrayList<Smartphone>();
                sql("SELECT * FROM phones WHERE phoneCategory = 'Smartphone'", smartPhones,"phone");//shows all phones
                BuyItem();
            case 2:
                PhoneSmartphoneIphoneFilter();//add filter Iphone
            case 3:
                PhoneSmartphoneSamsungFilter();//add filter Samsung
            case 4:
                PhoneSmartphoneXiaomiFilter(); //add filter Xiaomi
            case 5:
                ArrayList<Smartphone> otherBrands = new ArrayList<Smartphone>();
                sql("SELECT * FROM phones WHERE phoneCategory = 'Smartphone' AND not(`brandName` = 'Samsung') AND not(`brandName` = 'Iphone') AND not(`brandName` = 'Xiaomi');", otherBrands,"phone");//add filter Other Brands
                BuyItem();
            case 6:
                PhoneFilters(); //return previous method
        }
    }

    //////////////////////////////////////////////////////Samsung filters////////////////////////////////////////////////////////////
    public static void PhoneSmartphoneSamsungFilter () {
        System.out.println("\n" +
                "1.\tShow Samsungs\n" +
                "2.\tSammsung S\n" +
                "3.\tSamsung A\n" +
                "4.\tGo Back\n");
        int n = scanner.nextInt();
        scanner.nextLine();
        switch (n) {
            case 1:
                ArrayList<Samsung> samsungs = new ArrayList<Samsung>();
                sql("SELECT * FROM phones WHERE brandName = 'Samsung'", samsungs,"phone");
                BuyItem();
                //shows all Samsung
            case 2:
                PhoneSmartphoneSamsungModelFilter("S");//add filter Samsung S
            case 3:
                PhoneSmartphoneSamsungModelFilter("A");//add filter Samsung A
            case 4:
                PhoneSmartphoneFilter(); //return previous method
        }
    }

    public static void PhoneSmartphoneSamsungModelFilter (String number){
        String model;
        System.out.print("1.\tShow Samsung"+number+"\n" +
                "       2.\tSamsung " + number);
        if (number == "S") {
            System.out.println(21);
            model = "21";
        } else {
            System.out.println(53);
            model = "53";
        }
        System.out.print("3.\tSamsung " + number);
        if (number == "S") {
            System.out.println(22);
            model = "22";
        } else {
            System.out.println(53);
            model = "73";
        }
        System.out.println("4.\tGo Back\n");

        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Samsung> samsungnumber = new ArrayList<Samsung>();
        switch (n) {
            case 1:
                sql("SELECT * FROM phones WHERE brandName = 'Samsung' and brandSeries ='" + number + "'", samsungnumber,"phone");//shows all Samsung number
                BuyItem();
            case 2:
                sql("SELECT * FROM phones WHERE brandName = 'Samsung' and brandSeries ='" + number + "' and brandSeriesNumber='" + model + "'", samsungnumber,"phone");//add filter Samsung with model
                BuyItem();
            case 3:
                sql("SELECT * FROM phones WHERE brandName = 'Samsung' and brandSeries ='" + number + "' and brandSeriesNumber='" + model + "'", samsungnumber,"phone");//add filter Samsung with model
                BuyItem();
            case 4:
                PhoneSmartphoneSamsungFilter(); //return previous method
        }
    }

    //////////////////////////////////////////////////////Iphone filters////////////////////////////////////////////////////////////
    public static void PhoneSmartphoneIphoneFilter () {
        System.out.println("\n" +
                "1.\tShow Iphones\n" +
                "2.\tIphone 11\n" +
                "3.\tIphone 13\n" +
                "4.\tGo Back\n");
        int n = scanner.nextInt();
        scanner.nextLine();
        switch (n) {
            case 1:
                ArrayList<Iphone> iphones = new ArrayList<Iphone>();
                sql("SELECT * FROM phones WHERE brandName = 'Iphone'", iphones,"phone");
                BuyItem();
                //shows all Iphones
            case 2:
                PhoneSmartphoneIphoneModelFilter("11");//add filter Iphone 11
            case 3:
                PhoneSmartphoneIphoneModelFilter("13");//add filter Iphone 13
            case 4:
                PhoneSmartphoneFilter(); //return previous method
        }
    }

    public static void PhoneSmartphoneIphoneModelFilter (String number){
        System.out.println("\n" +
                "1.\tShow Iphone " + number + "\n" +
                "2.\tIphone " + number + " Pro\n" +
                "3.\tIphone " + number + " ProMax\n" +
                "4.\tGo Back\n");
        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Iphone> iphones = new ArrayList<Iphone>();
        switch (n) {
            case 1:
                sql("SELECT * FROM phones WHERE brandName = 'Samsung' and brandSeries ='" + number + "'", iphones,"phone");//shows all Samsung number
                BuyItem();//shows all Iphones number
            case 2:
                sql("SELECT * FROM phones WHERE brandName = 'Samsung' and brandSeries ='" + number + "' and brandSeriesNumber='Pro'", iphones,"phone");//add filter Samsung with model
                BuyItem();//add filter Iphone Pro
            case 3:
                sql("SELECT * FROM phones WHERE brandName = 'Samsung' and brandSeries ='" + number + "' and brandSeriesNumber='Pro Max'", iphones,"phone");//add filter Samsung with model
                BuyItem();//add filter Iphone Max
            case 4:
                PhoneSmartphoneIphoneFilter(); //return previous method
        }
    }

    //////////////////////////////////////////////////////Xiaomi filters////////////////////////////////////////////////////////////
    public static void PhoneSmartphoneXiaomiFilter () {
        System.out.println("\n" +
                "1.\tShow Xiaomis\n" +
                "2.\tXiaomi 9\n" +
                "3.\tXiaomi 10\n" +
                "4.\tGo Back\n");
        int n = scanner.nextInt();
        scanner.nextLine();
        switch (n) {
            case 1:ArrayList<Xiaomi> xiaomis = new ArrayList<Xiaomi>();
                sql("SELECT * FROM phones WHERE brandName = 'Xiaomi'", xiaomis,"phone");
                BuyItem();
                //shows all Iphones
            case 2:
                PhoneSmartphoneXiaomiModelFilter("9");//add filter Xiaomi 9
            case 3:
                PhoneSmartphoneXiaomiModelFilter("10");//add filter Xiaomi 10
            case 4:
                PhoneSmartphoneFilter(); //return previous method
        }
    }

    public static void PhoneSmartphoneXiaomiModelFilter (String number){
        System.out.println("\n" +
                "1.\tShow Xiaomis "+ number+"\n" +
                "2.\tXiaomi " + number + " A\n" +
                "3.\tXiaomi " + number + " B\n" +
                "4.\tGo Back\n");
        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Xiaomi> xiaomis = new ArrayList<Xiaomi>();
        switch (n) {
            case 1:
                sql("SELECT * FROM phones WHERE brandName = 'Xiaomi' and brandSeries ='" + number + "'", xiaomis,"phone");
                BuyItem();//shows all Xiaomi
            case 2:
                sql("SELECT * FROM phones WHERE brandName = 'Samsung' and brandSeries ='" + number + "' and brandSeriesNumber='A'", xiaomis,"phone");
                BuyItem();//add filter Xiaomi A
            case 3:
                sql("SELECT * FROM phones WHERE brandName = 'Samsung' and brandSeries ='" + number + "' and brandSeriesNumber='B'", xiaomis,"phone");
                BuyItem();//add filter Xiaomi  B
            case 4:
                PhoneSmartphoneXiaomiFilter(); //return previous method
        }
    }
    public static void BuyItem(){
        if(user != null){
            System.out.println("Input id of item to add cart! if you want to go back input 0!");
            int choose = scanner.nextInt();
            if(choose ==0){ StartMarketPlace();}
            int i = findItemById((ArrayList<Electronics>) arrayList,choose);
            cart.addCart((Electronics) arrayList.get(i));
            System.out.println("Item has been aded to cart!");
            StartMarketPlace();
        }else{
            System.out.println("You need to login!");
            signIn();
        }
    }
    public static int findItemById(ArrayList<Electronics> list, int id){
        for (int i = 0; i<list.size();i++){
            if(list.get(i).getId() == id){
                return i;
            }
        }
        return 0;
    }
    ///////////////////////////////////////////////////Computer filters////////////////////////////////////////////////////////////////
    public static void ComputerFilter() {
        System.out.println("1.\tShow Computers\n" +
                "2.\tAdd filter Personal Computer\n" +
                "3.\tAdd filter Laptops\n" +
                "4.\tGo Back\n");
        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Computer> computer = new ArrayList<Computer>();
        switch (n) {
            case 1:
                sql("SELECT * FROM computer", computer,"computer");
                BuyItem();
            case 2:
                sql("SELECT * FROM computer WHERE computerCategory = PC", computer,"computer");
                BuyItem();
            case 3:
                sql("SELECT * FROM computer WHERE computerCategory = Laptop", computer,"computer");
                BuyItem();
            case 4:
                Filters(); //return previous method
        }
    }
    public static void TabletFilter(){
        System.out.println("1.\tShow Tablets\n" +
                "2.\tAdd filter Graphical tablets\n" +
                "3.\tAdd filter tablets for kids\n" +
                "4.\tGo Back\n");
        int n = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Computer> computer = new ArrayList<Computer>();
        switch (n) {
            case 1:
                sql("SELECT * FROM tablet", computer,"tablet");
                BuyItem();
            case 2:
                sql("SELECT * FROM tablet WHERE computerCategory = Graphical", computer,"tablet");
                BuyItem();
            case 3:
                sql("SELECT * FROM tablet WHERE computerCategory = Kids", computer,"tablet");
                BuyItem();
            case 4:
                Filters(); //return previous method
        }
    }
    public static void sql(String sql, ArrayList<?> list,String type){
        Computersql computer = new Computersql();
        Phonesql phone = new Phonesql();
        Tabletsql tablet = new Tabletsql();
        Othersql other = new Othersql();
        if(type == "computer"){
            list = computer.setLists(sql);
        }
        if(type == "phone"){
            list = phone.setLists(sql);
        }
        if(type == "tablet"){
            list = tablet.setLists(sql);
        }
        if(type == "other"){
            list = other.setLists(sql);
        }
            for (int i = 0 ; i < list.size();i++){
                System.out.println(list.get(i).toString());
            }
            arrayList = list;
        }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}