package coding.test.programmers.Lv2;


import java.util.ArrayList;
import java.util.List;

public class Lv2교점에별만들기 {

    private static class Point{
        public final long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();

        //모든 line 들을 돌면서
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                //교차점 찾기 - 문제에서준 공식 활용
                Point intersactionPoint = getIntersections(line[i][0], line[i][1], line[i][2],
                                                        line[j][0], line[j][1], line[j][2]);

                //평행 또는 같은 선일 경우 null 리턴, null이 아닐 경우 교차점 list 에 추가
                if(intersactionPoint != null){
                    points.add(intersactionPoint);
                }
            }
        }

        //끝 점에 있는 경우를 확인하기 위해 극단에 있을 x,y 구함
        long minX = getMinX(points);
        long maxX = getMaxX(points);
        long minY = getMinY(points);
        long maxY = getMaxY(points);

        return null;


    }

    private long getMaxY(List<Point> points) {
        long maxY = 0;
        for(Point point: points){
            if(maxY < point.y) maxY = point.y;
        }
        return maxY;
    }

    private long getMinY(List<Point> points) {
        long minY = Long.MAX_VALUE;
        for(Point point: points){
            if(minY > point.y) minY = point.y;
        }
        return minY;
    }

    private long getMaxX(List<Point> points) {
        long maxX = 0;
        for(Point point: points){
            if(maxX < point.x) maxX = point.x;
        }
        return maxX;
    }

    private long getMinX(List<Point> points) {
        long minX = Long.MAX_VALUE;
        for(Point point: points){
            if(minX > point.x) minX = point.x;
        }
        return minX;
    }

    private Point getIntersections(int a1, int b1, int c1, int a2, int b2, int c2) {
        int denominator = a1*b2 - b1*a2;
        if(denominator == 0) return null;

        double x = (double) (b1*c2-c1*b2)/denominator;
        double y = (double) (a2*c1-a1*c2)/denominator;

        Point point = new Point((long)x, (long)y);

        return point;
    }
}
