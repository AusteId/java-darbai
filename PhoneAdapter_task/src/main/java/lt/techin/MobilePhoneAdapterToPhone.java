package lt.techin;

import itaphones.phone.AutomaticDialer;
import itaphones.phone.MobilePhone;
import itaphones.phone.Phone;

public class MobilePhoneAdapterToPhone implements Phone {

    MobilePhone original;
    private String response;

    public MobilePhoneAdapterToPhone(MobilePhone mobilePhone) {
        this.original = mobilePhone;
    }

    @Override
    public void dial(String s) {
        original.dial(s);
        response = original.dial(s);
    }

    @Override
    public String getReponse() {
        return response;
    }
}
