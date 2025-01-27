package lt.techin;

import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

public class NewFilteredGenerator implements IntegerGenerator {

    private IntegerGenerator generator;
    private NumberFilter numberFilter;

    public NewFilteredGenerator(IntegerGenerator generator, NumberFilter numberFilter) {
        this.generator = generator;
        this.numberFilter = numberFilter;
    }

    @Override
    public Integer getNext() {

        Integer number = this.generator.getNext();
        if (number == null) {
            return null;
        } else {
            while(!this.numberFilter.accept(number)) {
                number = this.generator.getNext();
            }
            return number;
        }
    }
}
