package lt.techin;

import itaphones.phone.AutomaticDialer;
import itaphones.phone.MobilePhone;
import itaphones.phone.Phone;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MobilePhone mobilePhone = new MobilePhone();
        Phone adapter = new MobilePhoneAdapterToPhone(mobilePhone);

        System.out.println(AutomaticDialer.dial(adapter));



    }
}