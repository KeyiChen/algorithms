/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        int base;
        int inLine;
        int result = 1;
        int n = points.length;
        HashMap<String, Integer> slopeMap = new HashMap<String, Integer>();
        for (int i = 0; i < n - 1; i++) {
            base = 1;
            inLine = 0;
            slopeMap.clear();
            for (int j = i + 1; j < n; j++)
                if (isSame(points[i], points[j])) base ++;
                else {
                    String slopeKey = normalize(getSlope(points[i], points[j]));
                    if (slopeMap.get(slopeKey) == null)
                        slopeMap.put(slopeKey, 1);
                    else
                        slopeMap.put(slopeKey, slopeMap.get(slopeKey) + 1);
                    inLine = Math.max(inLine, slopeMap.get(slopeKey));
                }
            result = Math.max(result, base + inLine);
        }
        
        return result;
    }
    
    private boolean isSame(Point p1, Point p2) {
        return (p1.x == p2.x && p1.y == p2.y);
    }
    
    private double getSlope(Point p1, Point p2) {
        double result;
        
        if (p1.x == p2.x) result = 9.99999+10e9;
        else if (p1.y == p2.y) result = 0;
        else result = 1.0 * (p2.y - p1.y) / (p2.x - p1.x);
        
        return result;
    }
    
    private java.text.DecimalFormat df=new java.text.DecimalFormat("#.0000");
    private String normalize(double slope) {
        return df.format(slope).toString();
    }
}
