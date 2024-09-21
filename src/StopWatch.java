public class StopWatch {
    private long startTime;
    private long endTime;

    // No-arg constructor
    public StopWatch() {
        startTime = System.currentTimeMillis();
    }

    // Getter for startTime
    public long getStartTime() {
        return startTime;
    }

    // Getter for endTime
    public long getEndTime() {
        return endTime;
    }

    // Method to start the stopwatch
    public void start() {
        startTime = System.currentTimeMillis();
    }

    // Method to stop the stopwatch
    public void stop() {
        endTime = System.currentTimeMillis();
    }

    // Method to get the elapsed time in milliseconds
    public long getElapsedTime() {
        return endTime - startTime;
    }

    public static void main(String[] args) {
        // Example usage of StopWatch
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        
        // Simulating some process with sleep
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        stopwatch.stop();
        System.out.println("Elapsed Time: " + stopwatch.getElapsedTime() + " milliseconds");
    }
}
