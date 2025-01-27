package lt.techin;

import lt.itakademija.exam.IntegerGenerator;

public class NewGenerator implements IntegerGenerator {

    private int lastNumber;
    private Integer currentNumber;

    public NewGenerator(int from, int lastNumber) {
        this.lastNumber = lastNumber;
        this.currentNumber = from;
    }

    @Override
    public Integer getNext() {
        if (this.currentNumber > this.lastNumber) {
            return null;
        } else {
            Integer var1 = this.currentNumber;
            this.currentNumber = this.currentNumber + 1;
            return var1;
        }
    }
}
