package illich.so;

import java.math.BigDecimal;

import static illich.so.Math.divide;

public class AntiPrimeNumberSearcher {
    private long number;
    private long deviserCount;
    private long nanosecondsTimeSearch;

    public AntiPrimeNumberSearcher(long number, long deviserCount, long nanosecondsTimeSearch) {
        this.number = number;
        this.deviserCount = deviserCount;
        this.nanosecondsTimeSearch = nanosecondsTimeSearch;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getDeviserCount() {
        return deviserCount;
    }

    public void setDeviserCount(long deviserCount) {
        this.deviserCount = deviserCount;
    }

    public long getNanosecondsTimeSearch() {
        return nanosecondsTimeSearch;
    }

    public void setNanosecondsTimeSearch(long nanosecondsTimeSearch) {
        this.nanosecondsTimeSearch = nanosecondsTimeSearch;
    }

    private BigDecimal getMilliSeconds() {
        return divide(nanosecondsTimeSearch, 1000000);
    }

    private BigDecimal getSeconds() {
        return divide(getMilliSeconds(), 1000);
    }

    private BigDecimal getMinutes() {
        return divide(getSeconds(), 60);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AntiPrimeNumberSearcher that = (AntiPrimeNumberSearcher) o;

        if (number != that.number) return false;
        if (deviserCount != that.deviserCount) return false;
        return nanosecondsTimeSearch == that.nanosecondsTimeSearch;

    }

    public int hashCode() {
        int result = (int) (number ^ (number >>> 32));
        result = 31 * result + (int) (deviserCount ^ (deviserCount >>> 32));
        result = 31 * result + (int) (nanosecondsTimeSearch ^ (nanosecondsTimeSearch >>> 32));
        return result;
    }

    public String toString() {
        return "Number[" + number +
                "] has [" + deviserCount +
                "] devisers; search took [" + nanosecondsTimeSearch + "] nanoseconds"
                + ", or [" + getMilliSeconds().toPlainString() + "] milliseconds"
                + ", or [" + getSeconds().toPlainString() + "] seconds"
                + ", or [" + getMinutes().toPlainString() + "] minutes.";
    }

    public void print() {
        System.out.println(toString());
    }
}
