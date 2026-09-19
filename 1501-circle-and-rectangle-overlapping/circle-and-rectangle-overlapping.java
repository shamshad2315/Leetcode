class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        
        int closestX = Math.max(x1,Math.min(xCenter, x2));
        int closestY = Math.max(y1,Math.min(yCenter, y2));

        int distX = xCenter - closestX;
        int distY = yCenter - closestY;
        int distanceSquared = distX * distX + distY * distY;

        return distanceSquared <= radius * radius; 

    }
}