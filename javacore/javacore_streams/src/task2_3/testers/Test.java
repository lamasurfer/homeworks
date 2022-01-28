package task2_3.testers;

class Test {


    private final int testId;
    private final int sampleSize;
    private final double sequentialTime;
    private final double parallelTime;
    private final double difference;
    private final double percentage;


    public Test(int testId, int sampleSize, double sequentialTime, double parallelTime) {
        this.testId = testId;
        this.sampleSize = sampleSize;
        this.sequentialTime = sequentialTime;
        this.parallelTime = parallelTime;
        this.difference = difference(sequentialTime, parallelTime);
        this.percentage = percentage(sequentialTime, parallelTime);
    }


    public int getSampleSize() {
        return sampleSize;
    }

    public double getSequentialTime() {
        return sequentialTime;
    }

    public double getParallelTime() {
        return parallelTime;
    }

    public double getDifference() {
        return difference;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public String toString() {
        return String.format
                (" %-4s| %-12s | %-15.7f | %-13.7f | %-13.7f | %4.1f %n",
                testId, sampleSize, sequentialTime, parallelTime, difference, percentage);
    }

    private double difference(double sequentialTime, double parallelTime) {
        return sequentialTime - parallelTime;
    }

    private double percentage(double sequentialTime, double parallelTime) {
        return (parallelTime - sequentialTime) / sequentialTime * 100;
    }


}
