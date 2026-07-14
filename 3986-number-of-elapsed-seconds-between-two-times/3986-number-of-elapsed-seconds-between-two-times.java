class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        
        String[] t1 = startTime.split(":");
        String[] t2 = endTime.split(":");

        int start = Integer.parseInt(t1[0]) * 3600
                  + Integer.parseInt(t1[1]) * 60
                  + Integer.parseInt(t1[2]);

        int end = Integer.parseInt(t2[0]) * 3600
                + Integer.parseInt(t2[1]) * 60
                + Integer.parseInt(t2[2]);

        return Math.abs(end - start);
    }
}